package jl.reports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import jl.reports.atsservice.AtsServiceReportData;
import jl.reports.dto.atsservice.AtsServiceReportAxDTO;
import jl.reports.mapper.AtsServiceReportDataMapperTest;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

public class TestForestServiceReport {

  private static final String PDF_PATH =
      "./target/pdfs/ats_service_notification/ats_service_notification.pdf";
  private static final String JSON_FILE_NAME = "ats-service-report.json";

  private File pdfFile;
  private AtsServiceReportData reportData;

  @Before
  public void initPDFAndReportGeneration() throws IOException {
    AtsServiceReportAxDTO ri =
        new ObjectMapper()
            .readValue(
                new ClassPathResource(JSON_FILE_NAME).getFile(), AtsServiceReportAxDTO.class);
    AtsServiceReportDataMapperTest forestServiceReportDataMapperTest =
        new AtsServiceReportDataMapperTest();
    reportData = forestServiceReportDataMapperTest.apply(ri);

    TestUtils.makeFolderWithReport(PdfReportTemplate.ATS_SERVICE_NOTIFICATION, reportData);
    pdfFile = new File(PDF_PATH);
  }

  @Test
  public void testPDFFileExist() {
    assertTrue("PDF file doesn't exist", pdfFile.exists());
  }

  @Test
  public void testCheckMetaDataInPDF() {
    String expectedTitle = "Ats service report";
    String expectedAuthor = "AeroTech Solutions Ltd";
    int expectedPages = 3;

    try (PDDocument document = PDDocument.load(pdfFile)) {
      if (document.getDocumentInformation() != null) {
        assertEquals(
            "Document doesn't have expected Title",
            expectedTitle,
            document.getDocumentInformation().getTitle());
        assertEquals(
            "Document doesn't have expected Author",
            expectedAuthor,
            document.getDocumentInformation().getAuthor());
        assertEquals(
            "Document doesn't have expected Producer",
            TestUtils.EXPECTED_PRODUCER,
            document.getDocumentInformation().getProducer());
        assertEquals(
            "Document doesn't have expected pages", expectedPages, document.getPages().getCount());

      } else {
        fail("Document doesn't have Metadata");
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to check PDF MetaData: " + e.getMessage());
    }
  }

  @Test
  public void testCheckContentInPDF() {
    /*assertTrue(
        "PDF doesn't contain the expected text",
        TestUtils.containTextInPDF(createExpectedText(reportData), pdfFile));*/
  }

  @After
  public void testDeletePDF() {
    //  TestUtils.deleteFile(pdfFile);
    //  assertFalse("PDF file still exists", pdfFile.exists());
  }

  private String createExpectedText(AtsServiceReportData reportData) {
    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    StringBuilder expectedText = new StringBuilder();
    expectedText.append(reportData.getReportType());
    expectedText.append("");
    expectedText.append(reportData.getBegins().format(dTF));
    expectedText.append(" ");
    expectedText.append(reportData.getEnds().format(dTF));
    expectedText.append("");
    expectedText.append(reportData.getContractId());
    expectedText.append("");
    expectedText.append(reportData.getServiceProvider().getAddress());
    expectedText.append("");
    expectedText.append("");
    expectedText.append("");

    return expectedText.toString();
  }
}
