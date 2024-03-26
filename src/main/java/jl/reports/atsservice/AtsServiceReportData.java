package jl.reports.atsservice;

import java.time.LocalDateTime;
import java.util.List;
import jl.reports.common.PdfBasicInfoReportData;

public final class AtsServiceReportData {

  private String reportType;
  private final LocalDateTime begins;
  private final LocalDateTime ends;
  private final String contractId;
  private final PdfBasicInfoReportData aircraftOwner;
  private final PdfBasicInfoReportData contactPerson;
  private final PdfBasicInfoReportData serviceProvider;
  private final List<AtsServiceReportAircraftAssetsData> aircraftAssets;
  private final Double realizedCosts;

  private AtsServiceReportData(AtsServiceReportDataBuilder builder) {
    this.reportType = builder.reportType;
    this.begins = builder.begins;
    this.ends = builder.ends;
    this.contractId = builder.contractId;
    this.aircraftOwner = builder.aircraftOwner;
    this.contactPerson = builder.contactPerson;
    this.serviceProvider = builder.serviceProvider;
    this.aircraftAssets = builder.aircraftAssets;
    this.realizedCosts = builder.realizedCosts;
  }

  public String getReportType() {
    return reportType;
  }

  public void setReportType(String reportType) {
    this.reportType = reportType;
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

  public PdfBasicInfoReportData getAircraftOwner() {
    return aircraftOwner;
  }

  public PdfBasicInfoReportData getContactPerson() {
    return contactPerson;
  }

  public PdfBasicInfoReportData getServiceProvider() {
    return serviceProvider;
  }

  public List<AtsServiceReportAircraftAssetsData> getAircraftAssets() {
    return aircraftAssets;
  }

  public Double getRealizedCosts() {
    return realizedCosts;
  }


  public static final class AtsServiceReportDataBuilder {

    private String reportType;
    private LocalDateTime begins;
    private LocalDateTime ends;
    private String contractId;
    private PdfBasicInfoReportData aircraftOwner;
    private PdfBasicInfoReportData contactPerson;
    private PdfBasicInfoReportData serviceProvider;
    private List<AtsServiceReportAircraftAssetsData> aircraftAssets;
    private Double realizedCosts;

    private AtsServiceReportDataBuilder() {
    }

    public static AtsServiceReportDataBuilder builder() {
      return new AtsServiceReportDataBuilder();
    }

    public AtsServiceReportDataBuilder reportType(String reportType) {
      this.reportType = reportType;
      return this;
    }

    public AtsServiceReportDataBuilder begins(LocalDateTime begins) {
      this.begins = begins;
      return this;
    }

    public AtsServiceReportDataBuilder ends(LocalDateTime ends) {
      this.ends = ends;
      return this;
    }

    public AtsServiceReportDataBuilder contractId(String contractId) {
      this.contractId = contractId;
      return this;
    }

    public AtsServiceReportDataBuilder aircraftOwner(PdfBasicInfoReportData aircraftOwner) {
      this.aircraftOwner = aircraftOwner;
      return this;
    }

    public AtsServiceReportDataBuilder contactPerson(
        PdfBasicInfoReportData contactPerson) {
      this.contactPerson = contactPerson;
      return this;
    }

    public AtsServiceReportDataBuilder serviceProvider(
        PdfBasicInfoReportData serviceProvider) {
      this.serviceProvider = serviceProvider;
      return this;
    }

    public AtsServiceReportDataBuilder aircraftAssets(
        List<AtsServiceReportAircraftAssetsData> aircraftAssets) {
      this.aircraftAssets = aircraftAssets;
      return this;
    }

    public AtsServiceReportDataBuilder realizedCosts(Double realizedCosts) {
      this.realizedCosts = realizedCosts;
      return this;
    }

    public AtsServiceReportData build() {
      return new AtsServiceReportData(this);
    }
  }
}
