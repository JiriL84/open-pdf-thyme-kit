package jl.reports.dto.atsservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AtsServiceReportServiceProviderAxDTO {

  private final String name;
  private final String organizationId;
  private final String vatId;
  private final String homeLocation;
  private final String phoneNumber;
  private final String address;

  @JsonCreator
  public AtsServiceReportServiceProviderAxDTO(
      @JsonProperty("name") String name,
      @JsonProperty("organizationId") String organizationId,
      @JsonProperty("vatId") String vatId,
      @JsonProperty("phoneNumber") String phoneNumber,
      @JsonProperty("homeLocation") String homeLocation,
      @JsonProperty("address") String address) {
    this.name = name;
    this.organizationId = organizationId;
    this.vatId = vatId;
    this.phoneNumber = phoneNumber;
    this.homeLocation = homeLocation;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public String getOrganizationId() {
    return organizationId;
  }

  public String getVatId() {
    return vatId;
  }

  public String getHomeLocation() {
    return homeLocation;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "ForestServiceReportServiceProviderAxDTO{" + "name='" + name + '\''
        + ", organizationId='"
        + organizationId + '\'' + ", vatId='" + vatId + '\'' + ", homeLocation='" + homeLocation
        + '\''
        + ", phoneNumber='" + phoneNumber + '\'' + ", address='" + address + '\'' + '}';
  }
}
