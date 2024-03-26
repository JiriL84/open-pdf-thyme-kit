package jl.reports;

public enum PdfReportTemplate {
  SIMPLE("simple_report"),
  MERGE_WITH_OTHER_PDF("merge_with_other_pdf"),
  ATS_SERVICE_NOTIFICATION("ats_service_notification");

  private final String template;

  PdfReportTemplate(String template) {
    this.template = template;
  }

  public String getTemplate() {
    return template;
  }
}
