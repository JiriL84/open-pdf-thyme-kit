package jl.reports.dto.atsservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AtsServiceReportCompartmentAxDTO {

  private final String compartmentId;
  private final Double forestArea;
  private final String compartmentNumber;
  private final Long gisId;

  @JsonCreator
  public AtsServiceReportCompartmentAxDTO(@JsonProperty("compartmentId") String compartmentId,
      @JsonProperty("forestArea") Double forestArea,
      @JsonProperty("compartmentNumber") String compartmentNumber,
      @JsonProperty("gisId") Long gisId) {
    this.compartmentId = compartmentId;
    this.forestArea = forestArea;
    this.compartmentNumber = compartmentNumber;
    this.gisId = gisId;
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
    return "ForestServiceReportCompartmentAxDTO{" + "compartmentId='" + compartmentId + '\''
        + ", forestArea="
        + forestArea + ", compartmentNumber='" + compartmentNumber + '\'' + ", gisId=" + gisId
        + '}';
  }
}
