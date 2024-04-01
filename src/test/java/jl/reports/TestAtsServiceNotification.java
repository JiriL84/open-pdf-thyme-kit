package jl.reports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import jl.reports.atsservice.AtsServiceReportData;
import jl.reports.dto.atsservice.AtsServiceReportAxDTO;
import jl.reports.mapper.AtsServiceReportDataMapperTest;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

public class TestAtsServiceNotification extends BasePDFReportTest {

  private static final String PDF_PATH =
      "./target/pdfs/ats_service_notification/ats_service_notification.pdf";
  private static final String JSON_FILE_NAME = "ats-service-report.json";
  private AtsServiceReportData reportData;

  @Override
  protected void initializeData() {
    AtsServiceReportAxDTO ri;
    try {
      ri =
          new ObjectMapper()
              .readValue(
                  new ClassPathResource(JSON_FILE_NAME).getFile(), AtsServiceReportAxDTO.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    AtsServiceReportDataMapperTest AtsServiceReportDataMapperTest =
        new AtsServiceReportDataMapperTest();
    reportData = AtsServiceReportDataMapperTest.apply(ri);
  }

  @Override
  protected void generatePDFReport() {
    TestUtils.makeFolderWithReport(PdfReportTemplate.ATS_SERVICE_NOTIFICATION, reportData);
    pdfFile = new File(PDF_PATH);
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

  @Override
  protected String createExpectedText() {
    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    // TODO add expected text

    // String expectedText = "??";

    return " ";
  }
}
