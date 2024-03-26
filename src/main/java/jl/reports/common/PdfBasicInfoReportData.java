package jl.reports.common;

public final class PdfBasicInfoReportData {

  private final String accountName;
  private final String name;
  private final String customerId;
  private final String companyId;
  private final String vatId;
  private final String homeLocation;
  private final String email;
  private final String phoneNumber;
  private final String address;

  public PdfBasicInfoReportData(PdfBasicInfoReportDataBuilder builder) {
    this.accountName = builder.accountName;
    this.name = builder.name;
    this.customerId = builder.customerId;
    this.companyId = builder.companyId;
    this.vatId = builder.vatId;
    this.homeLocation = builder.homeLocation;
    this.email = builder.email;
    this.phoneNumber = builder.phoneNumber;
    this.address = builder.address;
  }

  public String getAccountName() {
    return accountName;
  }

  public String getName() {
    return name;
  }

  public String getCustomerId() {
    return customerId;
  }

  public String getCompanyId() {
    return companyId;
  }

  public String getVatId() {
    return vatId;
  }

  public String getHomeLocation() {
    return homeLocation;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "ContactInfoReportData{" +
        "accountName='" + accountName + '\'' +
        ", name='" + name + '\'' +
        ", customerId='" + customerId + '\'' +
        ", companyId='" + companyId + '\'' +
        ", vatId='" + vatId + '\'' +
        ", homeLocation='" + homeLocation + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", address='" + address + '\'' +
        '}';
  }


  public static final class PdfBasicInfoReportDataBuilder {

    private String accountName;
    private String name;
    private String customerId;
    private String companyId;
    private String vatId;
    private String homeLocation;
    private String email;
    private String phoneNumber;
    private String address;

    private PdfBasicInfoReportDataBuilder() {
    }

    public static PdfBasicInfoReportDataBuilder builder() {
      return new PdfBasicInfoReportDataBuilder();
    }

    public PdfBasicInfoReportDataBuilder accountName(String accountName) {
      this.accountName = accountName;
      return this;
    }

    public PdfBasicInfoReportDataBuilder name(String name) {
      this.name = name;
      return this;
    }

    public PdfBasicInfoReportDataBuilder customerId(String customerId) {
      this.customerId = customerId;
      return this;
    }

    public PdfBasicInfoReportDataBuilder companyId(String companyId) {
      this.companyId = companyId;
      return this;
    }

    public PdfBasicInfoReportDataBuilder vatId(String vatId) {
      this.vatId = vatId;
      return this;
    }

    public PdfBasicInfoReportDataBuilder homeLocation(String homeLocation) {
      this.homeLocation = homeLocation;
      return this;
    }

    public PdfBasicInfoReportDataBuilder email(String email) {
      this.email = email;
      return this;
    }

    public PdfBasicInfoReportDataBuilder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public PdfBasicInfoReportDataBuilder address(String address) {
      this.address = address;
      return this;
    }

    public PdfBasicInfoReportData build() {
      return new PdfBasicInfoReportData(this);
    }
  }
}
