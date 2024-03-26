package jl.reports.common;

import java.time.LocalDateTime;

public class SimpleReportData {
  private final String text;
  private final String reportType;
  private final LocalDateTime begins;
  private final LocalDateTime ends;
  private final String contractId;
  private final PdfBasicInfoReportData serviceProvider;

  public SimpleReportData(SimpleReportDataBuilder builder) {
    this.text = builder.text;
    this.reportType = builder.reportType;
    this.begins = builder.begins;
    this.ends = builder.ends;
    this.contractId = builder.contractId;
    this.serviceProvider = builder.serviceProvider;
  }

  public String getText() {
    return text;
  }

  public String getReportType() {
    return reportType;
  }

  public LocalDateTime getBegins() {
    return begins;
  }

  public LocalDateTime getEnds() {
    return ends;
  }

  public String getContractId() {
    return contractId;
  }

  public PdfBasicInfoReportData getServiceProvider() {
    return serviceProvider;
  }

  @Override
  public String toString() {
    return "SimpleReportData{" +
        "text='" + text + '\'' +
        ", reportType='" + reportType + '\'' +
        ", begins=" + begins +
        ", ends=" + ends +
        ", contractId='" + contractId + '\'' +
        ", serviceProvider=" + serviceProvider +
        '}';
  }

  public static final class SimpleReportDataBuilder {

    private String text;
    private String reportType;
    private LocalDateTime begins;
    private LocalDateTime ends;
    private String contractId;
    private PdfBasicInfoReportData serviceProvider;

    private SimpleReportDataBuilder() {
    }

    public static SimpleReportDataBuilder builder() {
      return new SimpleReportDataBuilder();
    }

    public SimpleReportDataBuilder text(String text) {
      this.text = text;
      return this;
    }

    public SimpleReportDataBuilder reportType(String reportType) {
      this.reportType = reportType;
      return this;
    }

    public SimpleReportDataBuilder begins(LocalDateTime begins) {
      this.begins = begins;
      return this;
    }

    public SimpleReportDataBuilder ends(LocalDateTime ends) {
      this.ends = ends;
      return this;
    }

    public SimpleReportDataBuilder contractId(String contractId) {
      this.contractId = contractId;
      return this;
    }

    public SimpleReportDataBuilder pdfBasicInfoReportData(
        PdfBasicInfoReportData serviceProvider) {
      this.serviceProvider = serviceProvider;
      return this;
    }

    public SimpleReportData build() {
      return new SimpleReportData(this);
    }
  }
}
