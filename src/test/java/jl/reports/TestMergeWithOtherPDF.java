package jl.reports;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import jl.reports.common.PdfBasicInfoReportData;
import jl.reports.common.PdfBasicInfoReportData.PdfBasicInfoReportDataBuilder;
import jl.reports.common.SimpleReportData;
import jl.reports.common.SimpleReportData.SimpleReportDataBuilder;
import jl.util.FileData;
import jl.util.SupportedLanguage;
import org.apache.pdfbox.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

public class TestMergeWithOtherPDF {
  private SimpleReportData reportData;

  @Before
  public void setUp() {

    PdfBasicInfoReportData pdfBasicInfoReportData = PdfBasicInfoReportDataBuilder.builder()
        .address("123 Aviation Avenue\nKarvina, Czech Republic")
        .build();
    reportData = SimpleReportDataBuilder.builder()
        .text("Lorem Ipsum is simply dummy text")
        .reportType("Test")
        .begins(LocalDateTime.now())
        .ends(LocalDateTime.now())
        .contractId("2116487")
        .pdfBasicInfoReportData(pdfBasicInfoReportData)
        .build();
  }

  @Test
  public void testPdfGenerationAndMergeWithStaticPdfFile() throws IOException {
    FileData fileData = PdfGenerator.generatePdfReport(
        PdfReportTemplate.MERGE_WITH_OTHER_PDF, reportData,
        SupportedLanguage.getByLanguageCodeOrDefault("en"));
    InputStream staticFile = new ClassPathResource("static_file.pdf").getInputStream();
    String template = PdfReportTemplate.MERGE_WITH_OTHER_PDF.getTemplate();
    FileData mergedFileData = PdfGenerator.mergeFiles(List.of(fileData.getStream(), staticFile),
        template);
    saveToFile(mergedFileData, template);

    assertTrue(Files.exists(createFilePath(template)));
  }

  private void saveToFile(FileData fileData, String template) {
    try {
      Path pdfFilePath = createFilePath(template);
      Files.write(pdfFilePath, IOUtils.toByteArray(fileData.getStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Path createFilePath(String template) throws IOException {
    Path baseFolderPath = Path.of("./target/pdfs/");
    Files.createDirectories(baseFolderPath);

    Path templateFolderPath = baseFolderPath.resolve(template);
    Files.createDirectories(templateFolderPath);

    return templateFolderPath.resolve(template + ".pdf");
  }
}
