package jl.reports.dto.atsservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class AtsServiceReportAircraftAssetsAxDTO {

  private final String make;
  private final String model;
  private final String tailNumber;
  private final String serialNumber;
  private final String registration;
  private final int yearOfManufacture;
  private final LocalDate lastMaintenance;
  private final String status;
  private final LocalDate maintenanceDue;
  private final String location;
  private final String garageNumber;
  private final int hoursFlown;

  @JsonCreator
  public AtsServiceReportAircraftAssetsAxDTO(
      @JsonProperty("make") String make,
      @JsonProperty("model") String model,
      @JsonProperty("tailNumber") String tailNumber,
      @JsonProperty("serialNumber") String serialNumber,
      @JsonProperty("registration") String registration,
      @JsonProperty("yearOfManufacture") int yearOfManufacture,
      @JsonDeserialize(using = LocalDateDeserializer.class)
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
      @JsonProperty("lastMaintenance") LocalDate lastMaintenance,
      @JsonProperty("status") String status,
      @JsonDeserialize(using = LocalDateDeserializer.class)
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
      @JsonProperty("maintenanceDue") LocalDate maintenanceDue,
      @JsonProperty("location") String location,
      @JsonProperty("garageNumber") String garageNumber,
      @JsonProperty("hoursFlown") int hoursFlown) {
    this.make = make;
    this.model = model;
    this.tailNumber = tailNumber;
    this.serialNumber = serialNumber;
    this.registration = registration;
    this.yearOfManufacture = yearOfManufacture;
    this.lastMaintenance = lastMaintenance;
    this.status = status;
    this.maintenanceDue = maintenanceDue;
    this.location = location;
    this.garageNumber = garageNumber;
    this.hoursFlown = hoursFlown;
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

  public int getYearOfManufacture() {
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

  public int getHoursFlown() {
    return hoursFlown;
  }

  @Override
  public String toString() {
    return "AtsServiceReportAircraftAssetsAxDTO{"
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
}
