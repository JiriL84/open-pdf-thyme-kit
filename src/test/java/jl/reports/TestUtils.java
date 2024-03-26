package jl.reports;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import jl.util.FileData;
import jl.util.SupportedLanguage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileSystemUtils;

public class TestUtils {

  public static final String EXPECTED_PRODUCER = "openhtmltopdf.com";

  public static void makeFolderWithReport(PdfReportTemplate reportType, Object reportData) {
    if (reportData == null) {
      throw new IllegalArgumentException("Object report data is null");
    }

    File _websiteBase = new File("./target/pdfs/");
    FileData fileData = PdfGenerator.generatePdfReport(reportType, reportData,
        SupportedLanguage.getByLanguageCodeOrDefault("en"));
    _websiteBase.mkdirs();
    File webTemplateBase = new File(_websiteBase, reportType.getTemplate());
    webTemplateBase.mkdirs();

    try {
      Files.write(
          new File(webTemplateBase, fileData.getFileName()).toPath(),
          IOUtils.toByteArray(fileData.getStream()));

    } catch (Exception e) {
      System.out.println("Exception while generating templates...");
      e.printStackTrace();
    }
  }

  protected static String encodeImageToBase64(String path) {
    if (path == null || path.isEmpty()) {
      throw new IllegalArgumentException("Value path is null or empty");
    }

    byte[] fileContent;
    try {
      File inputFile = new ClassPathResource(path).getFile();
      fileContent = FileUtils.readFileToByteArray(inputFile);
    } catch (IOException e) {
      throw new IllegalArgumentException("file not found!");
    }
    return Base64.getEncoder().encodeToString(fileContent);
  }

  protected static void deleteFile(File pdfFile) {
    if (pdfFile == null) {
      throw new IllegalArgumentException("Value pdfFile is null");
    }

    if (pdfFile.exists()) {
      if (!pdfFile.delete()) {
        throw new RuntimeException("File cannot be deleted");
      }
    } else {
      throw new IllegalArgumentException("File not found!");
    }
  }

  protected static boolean deleteDirectory(String directoryPath) {
    File directory = new File(directoryPath);

    if (!directory.exists()) {
      throw new RuntimeException("Directory does not exist");
    }

    if (directory.isDirectory()) {
      return FileSystemUtils.deleteRecursively(directory);
    }

    return false;
  }

  protected static boolean containTextInPDF(String expectedText, File pdfFile) {
    if (pdfFile == null) {
      throw new IllegalArgumentException("Value pdfFile is null");
    }

    try {
      PDDocument document = PDDocument.load(pdfFile);
      PDFTextStripper pdfTextStripper = new PDFTextStripper();
      String pdfText = pdfTextStripper.getText(document);

      document.close();

      return (pdfText.contains(expectedText));

    } catch (Exception e) {
      throw new RuntimeException("Failed to check PDF content: " + e.getMessage());
    }
  }
}
