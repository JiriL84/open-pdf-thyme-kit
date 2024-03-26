package jl.reports.dto.atsservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class AtsServiceReportAxDTO {

  private final String forestContractType;
  private final String contractId;
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private final LocalDateTime begins;
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private final LocalDateTime ends;
  private final AtsServiceReportServiceProviderAxDTO serviceProvider;
  private final AtsServiceReportAircraftOwnerAxDTO aircraftOwner;
  private final AtsServiceReportContactPersonAxDTO contactPerson;
  private final List<AtsServiceReportAircraftAssetsAxDTO> aircraftAssets;
  private final Double realizedCosts;

  @JsonCreator
  public AtsServiceReportAxDTO(
      @JsonProperty("forestContractType") String forestContractType,
      @JsonProperty("contractId") String contractId,
      @JsonProperty("begins") LocalDateTime begins,
      @JsonProperty("ends") LocalDateTime ends,
      @JsonProperty("serviceProvider") AtsServiceReportServiceProviderAxDTO serviceProvider,
      @JsonProperty("aircraftOwner") AtsServiceReportAircraftOwnerAxDTO aircraftOwner,
      @JsonProperty("contactPerson") AtsServiceReportContactPersonAxDTO contactPerson,
      @JsonProperty("aircraftAssets") List<AtsServiceReportAircraftAssetsAxDTO> aircraftAssets,
      @JsonProperty("realizedCosts") Double realizedCosts) {
    this.forestContractType = forestContractType;
    this.contractId = contractId;
    this.begins = begins;
    this.ends = ends;
    this.serviceProvider = serviceProvider;
    this.aircraftOwner = aircraftOwner;
    this.contactPerson = contactPerson;
    this.aircraftAssets = aircraftAssets;
    this.realizedCosts = realizedCosts;
  }

  public String getForestContractType() {
    return forestContractType;
  }

  public String getContractId() {
    return contractId;
  }

  public LocalDateTime getBegins() {
    return begins;
  }

  public LocalDateTime getEnds() {
    return ends;
  }

  public AtsServiceReportServiceProviderAxDTO getServiceProvider() {
    return serviceProvider;
  }

  public AtsServiceReportAircraftOwnerAxDTO getAircraftOwner() {
    return aircraftOwner;
  }

  public AtsServiceReportContactPersonAxDTO getContactPerson() {
    return contactPerson;
  }

  public List<AtsServiceReportAircraftAssetsAxDTO> getAircraftAssets() {
    return aircraftAssets;
  }

  public Double getRealizedCosts() {
    return realizedCosts;
  }

  @Override
  public String toString() {
    return "ForestServiceReportAxDTO{" +
        "forestContractType='" + forestContractType + '\'' +
        ", contractId='" + contractId + '\'' +
        ", begins=" + begins +
        ", ends=" + ends +
        ", serviceProvider=" + serviceProvider +
        ", aircraftOwner=" + aircraftOwner +
        ", contactPerson=" + contactPerson +
        ", aircraftAssets=" + aircraftAssets +
        ", realizedCosts=" + realizedCosts +
        '}';
  }
}
