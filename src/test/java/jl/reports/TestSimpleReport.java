package jl.reports;

import java.time.LocalDateTime;
import jl.reports.common.PdfBasicInfoReportData;
import jl.reports.common.PdfBasicInfoReportData.PdfBasicInfoReportDataBuilder;
import jl.reports.common.SimpleReportData;
import jl.reports.common.SimpleReportData.SimpleReportDataBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestSimpleReport {
  private SimpleReportData reportData;
  @Before
  public void setUp() {

    PdfBasicInfoReportData pdfBasicInfoReportData = PdfBasicInfoReportDataBuilder.builder()
        .address("123 Aviation Avenue\nKarvina, Czech Republic")
        .build();
    reportData = SimpleReportDataBuilder.builder()
        .text("Lorem Ipsum is simply dummy text of the printing and typesetting industry")
        .pdfBasicInfoReportData(pdfBasicInfoReportData)
        .build();
  }

  @Test
  public void initPDFAndReportGeneration() {
    TestUtils.makeFolderWithReport(PdfReportTemplate.SIMPLE, reportData);
  }

}
