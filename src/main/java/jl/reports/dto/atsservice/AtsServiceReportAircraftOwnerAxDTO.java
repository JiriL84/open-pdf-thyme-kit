package jl.reports.dto.atsservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AtsServiceReportAircraftOwnerAxDTO {

    private final String accountName;
    private final String customerId;
    private final String phoneNumber;
    private final String vatId;
    private final String address;

    @JsonCreator
    public AtsServiceReportAircraftOwnerAxDTO(
            @JsonProperty("accountName") String accountName,
            @JsonProperty("customerId") String customerId,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("vatId") String vatId,
            @JsonProperty("address") String address) {
        this.accountName = accountName;
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
        this.vatId = vatId;
        this.address = address;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getVatId() {
        return vatId;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "AtsServiceReportAircraftOwnerAxDTO{" +
            "accountName='" + accountName + '\'' +
            ", customerId='" + customerId + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", vatId='" + vatId + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
