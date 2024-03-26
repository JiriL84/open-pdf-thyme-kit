package jl.reports.dto.atsservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AtsServiceReportAircraftAssetsAxDTO {

  private final String make;
  private final String model;
  private final String tailNumber;
  private final String serialNumber;
  private final String registration;
  private final Integer hoursFlown;

  @JsonCreator
  public AtsServiceReportAircraftAssetsAxDTO(
      @JsonProperty("make") String make,
      @JsonProperty("model") String model,
      @JsonProperty("tailNumber") String tailNumber,
      @JsonProperty("serialNumber") String serialNumber,
      @JsonProperty("registration") String registration,
      @JsonProperty("salesInvoiceLines") Integer hoursFlown) {
    this.make = make;
    this.model = model;
    this.tailNumber = tailNumber;
    this.serialNumber = serialNumber;
    this.registration = registration;
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

  public Integer getHoursFlown() {
    return hoursFlown;
  }

  @Override
  public String toString() {
    return "AtsServiceReportRealEstateAxDTO{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", tailNumber='" + tailNumber + '\'' +
        ", serialNumber='" + serialNumber + '\'' +
        ", registration='" + registration + '\'' +
        ", hoursFlown=" + hoursFlown +
        '}';
  }
}
