package jl.reports.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;
import jl.reports.atsservice.AtsServiceReportAircraftAssetsData;
import jl.reports.atsservice.AtsServiceReportAircraftAssetsData.AtsServiceReportAircraftAssetsDataBuilder;
import jl.reports.atsservice.AtsServiceReportData;
import jl.reports.atsservice.AtsServiceReportData.AtsServiceReportDataBuilder;
import jl.reports.common.PdfBasicInfoReportData;
import jl.reports.common.PdfBasicInfoReportData.PdfBasicInfoReportDataBuilder;
import jl.reports.dto.atsservice.AtsServiceReportAircraftAssetsAxDTO;
import jl.reports.dto.atsservice.AtsServiceReportAircraftOwnerAxDTO;
import jl.reports.dto.atsservice.AtsServiceReportAxDTO;
import jl.reports.dto.atsservice.AtsServiceReportContactPersonAxDTO;
import jl.reports.dto.atsservice.AtsServiceReportServiceProviderAxDTO;

public class AtsServiceReportDataMapperTest {

  public static final Function<AtsServiceReportAircraftOwnerAxDTO, PdfBasicInfoReportData>
      TO_AIRCRAFT_OWNER = aircraftOwnerAxDTO -> PdfBasicInfoReportDataBuilder.builder()
      .accountName(aircraftOwnerAxDTO.getAccountName())
      .customerId(aircraftOwnerAxDTO.getCustomerId())
      .address(aircraftOwnerAxDTO.getAddress())
      .phoneNumber(aircraftOwnerAxDTO.getPhoneNumber())
      .vatId(aircraftOwnerAxDTO.getVatId())
      .build();

  public static final Function<AtsServiceReportContactPersonAxDTO, PdfBasicInfoReportData>
      TO_CONTACT_PERSON = contactPersonAxDTO ->
      contactPersonAxDTO == null ? null :
          PdfBasicInfoReportDataBuilder.builder()
              .name(contactPersonAxDTO.getName())
              .address(contactPersonAxDTO.getAddress())
              .phoneNumber(contactPersonAxDTO.getPhoneNumber())
              .email(contactPersonAxDTO.getEmail())
              .build();

  public static final Function<AtsServiceReportServiceProviderAxDTO, PdfBasicInfoReportData>
      TO_SERVICE_PROVIDER = serviceProviderAxDTO -> PdfBasicInfoReportDataBuilder.builder()
      .name(serviceProviderAxDTO.getName())
      .address(serviceProviderAxDTO.getAddress())
      .phoneNumber(serviceProviderAxDTO.getPhoneNumber())
      .companyId(serviceProviderAxDTO.getOrganizationId())
      .vatId(serviceProviderAxDTO.getVatId())
      .homeLocation(serviceProviderAxDTO.getHomeLocation())
      .build();

  public static final Function<AtsServiceReportAircraftAssetsAxDTO, AtsServiceReportAircraftAssetsData>
          TO_AIRCRAFT_ASSETS = aircraftAssetsAxDTO -> AtsServiceReportAircraftAssetsDataBuilder.builder()
          .make(aircraftAssetsAxDTO.getMake())
          .model(aircraftAssetsAxDTO.getModel())
          .tailNumber(aircraftAssetsAxDTO.getTailNumber())
          .serialNumber(aircraftAssetsAxDTO.getSerialNumber())
          .registration(aircraftAssetsAxDTO.getRegistration())
          .yearOfManufacture(aircraftAssetsAxDTO.getYearOfManufacture())
          .lastMaintenance(aircraftAssetsAxDTO.getLastMaintenance())
          .status(aircraftAssetsAxDTO.getStatus())
          .maintenanceDue(aircraftAssetsAxDTO.getMaintenanceDue())
          .location(aircraftAssetsAxDTO.getLocation())
          .garageNumber(aircraftAssetsAxDTO.getGarageNumber())
          .hoursFlown(aircraftAssetsAxDTO.getHoursFlown())
          .build();

  public AtsServiceReportData apply(AtsServiceReportAxDTO reportAxDTO) {
    return AtsServiceReportDataBuilder.builder()
        .reportType(reportAxDTO.getAtsContractType())
        .contractId(reportAxDTO.getContractId())
        .ends(reportAxDTO.getEnds())
        .begins(reportAxDTO.getBegins())
        .realizedCosts(reportAxDTO.getRealizedCosts())
        .aircraftOwner(
            TO_AIRCRAFT_OWNER.apply(reportAxDTO.getAircraftOwner()))
        .contactPerson(
            TO_CONTACT_PERSON.apply(reportAxDTO.getContactPerson()))
        .serviceProvider(TO_SERVICE_PROVIDER.apply(
            reportAxDTO.getServiceProvider()))
        .aircraftAssets(
            reportAxDTO.getAircraftAssets().stream().map(TO_AIRCRAFT_ASSETS)
                .collect(Collectors.toList()))
        .build();
  }
}