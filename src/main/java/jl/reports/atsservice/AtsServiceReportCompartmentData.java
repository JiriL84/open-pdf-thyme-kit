package jl.reports.atsservice;

public class AtsServiceReportCompartmentData {

  private final String compartmentId;
  private final Double forestArea;
  private final String compartmentNumber;
  private final Long gisId;

  public AtsServiceReportCompartmentData(AtsServiceReportCompartmentDataBuilder builder) {
    this.compartmentId = builder.compartmentId;
    this.forestArea = builder.forestArea;
    this.compartmentNumber = builder.compartmentNumber;
    this.gisId = builder.gisId;
  }

  public String getCompartmentId() {
    return compartmentId;
  }

  public Double getForestArea() {
    return forestArea;
  }

  public String getCompartmentNumber() {
    return compartmentNumber;
  }

  public Long getGisId() {
    return gisId;
  }

  @Override
  public String toString() {
    return "ForestServiceReportCompartmentData{" + "compartmentId='" + compartmentId + '\''
        + ", forestArea="
        + forestArea + ", compartmentNumber='" + compartmentNumber + '\'' + ", gisId=" + gisId
        + '}';
  }

  public static final class AtsServiceReportCompartmentDataBuilder {

    private String compartmentId;
    private Double forestArea;
    private String compartmentNumber;
    private Long gisId;

    private AtsServiceReportCompartmentDataBuilder() {
    }

    public static AtsServiceReportCompartmentDataBuilder builder() {
      return new AtsServiceReportCompartmentDataBuilder();
    }

    public AtsServiceReportCompartmentDataBuilder compartmentId(String compartmentId) {
      this.compartmentId = compartmentId;
      return this;
    }

    public AtsServiceReportCompartmentDataBuilder compartmentNumber(String compartmentNumber) {
      this.compartmentNumber = compartmentNumber;
      return this;
    }

    public AtsServiceReportCompartmentDataBuilder gisId(Long gisId) {
      this.gisId = gisId;
      return this;
    }

    public AtsServiceReportCompartmentDataBuilder forestArea(Double forestArea) {
      this.forestArea = forestArea;
      return this;
    }

    public AtsServiceReportCompartmentData build() {
      return new AtsServiceReportCompartmentData(this);
    }
  }
}
