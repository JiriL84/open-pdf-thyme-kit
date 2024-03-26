package jl.util;

import java.util.Locale;

public class LocaleUtil {
  private static final String DEFAULT_COUNTRY = "EN";

  private LocaleUtil() {}

  public static Locale getDefaultLocale() {
    return getForSupportedLanguage(SupportedLanguage.getDefaultLanguage());
  }

  public static Locale getForSupportedLanguage(SupportedLanguage supportedLanguage) {
    return getForLanguageCode(supportedLanguage.getLanguageCode());
  }

  public static Locale getForLanguageCode(String languageCode) {
    return new Locale(languageCode, DEFAULT_COUNTRY);
  }

}
