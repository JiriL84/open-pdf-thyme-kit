package jl.reports.atsservice;

public class AtsServiceReportAircraftAssetsData {

  private final String make;
  private final String model;
  private final String tailNumber;
  private final String serialNumber;
  private final String registration;
  private final Integer hoursFlown;

  public AtsServiceReportAircraftAssetsData(AtsServiceReportAircraftAssetsDataBuilder builder) {
    this.make = builder.make;
    this.model = builder.model;
    this.tailNumber = builder.tailNumber;
    this.serialNumber = builder.serialNumber;
    this.registration = builder.registration;
    this.hoursFlown = builder.hoursFlown;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getTailNumber() {
    return tailNumber;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public String getRegistration() {
    return registration;
  }

  public Integer getHoursFlown() {
    return hoursFlown;
  }

  @Override
  public String toString() {
    return "AtsServiceReportAircraftAssetsData{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", tailNumber='" + tailNumber + '\'' +
        ", serialNumber='" + serialNumber + '\'' +
        ", registration='" + registration + '\'' +
        ", hoursFlown=" + hoursFlown +
        '}';
  }


  public static final class AtsServiceReportAircraftAssetsDataBuilder {

    private String make;
    private String model;
    private String tailNumber;
    private String serialNumber;
    private String registration;
    private Integer hoursFlown;

    private AtsServiceReportAircraftAssetsDataBuilder() {
    }

    public static AtsServiceReportAircraftAssetsDataBuilder builder() {
      return new AtsServiceReportAircraftAssetsDataBuilder();
    }

    public AtsServiceReportAircraftAssetsDataBuilder make(String make) {
      this.make = make;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder model(String model) {
      this.model = model;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder tailNumber(String tailNumber) {
      this.tailNumber = tailNumber;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder serialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder registration(String registration) {
      this.registration = registration;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder hoursFlown(Integer hoursFlown) {
      this.hoursFlown = hoursFlown;
      return this;
    }

    public AtsServiceReportAircraftAssetsData build() {
      return new AtsServiceReportAircraftAssetsData(this);
    }
  }
}
