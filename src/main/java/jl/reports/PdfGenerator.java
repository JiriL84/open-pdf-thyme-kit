package jl.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import jl.util.FileData;
import jl.util.FileData.FileDataBuilder;
import jl.util.LocaleUtil;
import jl.util.SupportedLanguage;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PdfGenerator {

  private static final Logger LOGGER = LoggerFactory.getLogger(PdfGenerator.class);
  private static final String CONTENT_TYPE = "application/pdf";

  private static final String AUTHOR_FILE = "AeroTech Solutions Ltd";

  private static final ThymeleafProcessor thymeleafProcessor = new ThymeleafProcessor();

  private PdfGenerator() {
  }

  public static FileData generatePdfReport(
      PdfReportTemplate reportType, Object reportData, SupportedLanguage language) {
    try {
      return PdfGenerator.runTemplate(
          reportType.getTemplate(),
          Collections.singletonMap("reportData", reportData),
          LocaleUtil.getForSupportedLanguage(language));
    } catch (Exception e) {
      handleGenerateFilesError(reportType.getTemplate(), e);
      throw new RuntimeException("Error while generating PDF template", e);
    }
  }

  private static FileData runTemplate(
      String template, Map<String, Object> provider, Locale locale) {
    String html = thymeleafProcessor.processTemplate(template, provider, locale);
    byte[] pdfBytes = HtmlToPdfConverter.convertHtmlToPdfBytes(html, "/templates/");

    return createFileData(template, pdfBytes);
  }

  public static FileData mergeFiles(List<InputStream> pdfStreams, String template) {
    try (ByteArrayOutputStream destination = new ByteArrayOutputStream()) {
      mergePdfStreams(pdfStreams, destination);
      return createFileData(template, destination.toByteArray());
    } catch (IOException e) {
      handleMergeFilesError(template, e);
    }
    return FileDataBuilder.builder().build();
  }

  private static FileData createFileData(String template, byte[] pdfBytes) {
    return FileDataBuilder.builder().stream(
            new ByteArrayInputStream(insertAdditionalInfoToPdf(pdfBytes, template)))
        .contentType(CONTENT_TYPE)
        .fileName(template + ".pdf")
        .build();
  }

  private static void mergePdfStreams(
      List<InputStream> pdfStreams, ByteArrayOutputStream destination) throws IOException {
    PDFMergerUtility pdfMerger = new PDFMergerUtility();
    pdfMerger.setDestinationStream(destination);
    pdfStreams.forEach(pdfMerger::addSource);
    pdfMerger.mergeDocuments(null);
  }

  private static void handleMergeFilesError(String template, IOException e) {
    LOGGER.error("Error occurred while merging PDF files for template: {}", template, e);
  }

  private static void handleGenerateFilesError(String template, Exception e) {
    LOGGER.error("Error occurred while generating PDF files for template: {}", template, e);
  }

  private static byte[] insertAdditionalInfoToPdf(byte[] documentBytes, String title) {
    try (PDDocument document = PDDocument.load(documentBytes)) {
      String tmpTitle = title.replace("_", " ").replace("notification", "report");

      document.getDocumentInformation().setAuthor(PdfGenerator.AUTHOR_FILE);
      document
          .getDocumentInformation()
          .setTitle(tmpTitle.substring(0, 1).toUpperCase() + tmpTitle.substring(1));

      ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
      document.save(pdfOutputStream);

      return pdfOutputStream.toByteArray();
    } catch (IOException e) {
      throw new RuntimeException("Exception while adding additional information into pdf ", e);
    }
  }
}
