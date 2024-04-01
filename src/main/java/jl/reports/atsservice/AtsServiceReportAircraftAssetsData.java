package jl.reports.atsservice;

import java.time.LocalDate;

public class AtsServiceReportAircraftAssetsData {

  private final String make;
  private final String model;
  private final String tailNumber;
  private final String serialNumber;
  private final String registration;
  private final Integer yearOfManufacture;
  private final LocalDate lastMaintenance;
  private final String status;
  private final LocalDate maintenanceDue;
  private final String location;
  private final String garageNumber;
  private final Integer hoursFlown;

  public AtsServiceReportAircraftAssetsData(AtsServiceReportAircraftAssetsDataBuilder builder) {
    this.make = builder.make;
    this.model = builder.model;
    this.tailNumber = builder.tailNumber;
    this.serialNumber = builder.serialNumber;
    this.registration = builder.registration;
    this.yearOfManufacture = builder.yearOfManufacture;
    this.lastMaintenance = builder.lastMaintenance;
    this.status = builder.status;
    this.maintenanceDue = builder.maintenanceDue;
    this.location = builder.location;
    this.garageNumber = builder.garageNumber;
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

  public Integer getYearOfManufacture() {
    return yearOfManufacture;
  }

  public LocalDate getLastMaintenance() {
    return lastMaintenance;
  }

  public String getStatus() {
    return status;
  }

  public LocalDate getMaintenanceDue() {
    return maintenanceDue;
  }

  public String getLocation() {
    return location;
  }

  public String getGarageNumber() {
    return garageNumber;
  }

  @Override
  public String toString() {
    return "AtsServiceReportAircraftAssetsData{"
        + "make='"
        + make
        + '\''
        + ", model='"
        + model
        + '\''
        + ", tailNumber='"
        + tailNumber
        + '\''
        + ", serialNumber='"
        + serialNumber
        + '\''
        + ", registration='"
        + registration
        + '\''
        + ", yearOfManufacture="
        + yearOfManufacture
        + ", lastMaintenance="
        + lastMaintenance
        + ", status='"
        + status
        + '\''
        + ", maintenanceDue="
        + maintenanceDue
        + ", location='"
        + location
        + '\''
        + ", garageNumber='"
        + garageNumber
        + '\''
        + ", hoursFlown="
        + hoursFlown
        + '}';
  }

  public static final class AtsServiceReportAircraftAssetsDataBuilder {

    private String make;
    private String model;
    private String tailNumber;
    private String serialNumber;
    private String registration;
    private Integer yearOfManufacture;
    private LocalDate lastMaintenance;
    private String status;
    private LocalDate maintenanceDue;
    private String location;
    private String garageNumber;
    private Integer hoursFlown;

    private AtsServiceReportAircraftAssetsDataBuilder() {}

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

    public AtsServiceReportAircraftAssetsDataBuilder yearOfManufacture(Integer yearOfManufacture) {
      this.yearOfManufacture = yearOfManufacture;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder lastMaintenance(LocalDate lastMaintenance) {
      this.lastMaintenance = lastMaintenance;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder status(String status) {
      this.status = status;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder maintenanceDue(LocalDate maintenanceDue) {
      this.maintenanceDue = maintenanceDue;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder location(String location) {
      this.location = location;
      return this;
    }

    public AtsServiceReportAircraftAssetsDataBuilder garageNumber(String garageNumber) {
      this.garageNumber = garageNumber;
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
