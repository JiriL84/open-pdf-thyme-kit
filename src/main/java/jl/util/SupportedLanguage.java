package jl.util;

import java.util.HashMap;
import java.util.Map;

public enum SupportedLanguage {
  CZECH("cz", "language.czech"),
  ENGLISH("en", "language.english");

  private static final Map<String, SupportedLanguage> LANG_CODE_TO_SUPPORTED_LANGUAGE = new HashMap<>();
  private static final SupportedLanguage DEFAULT_LANGUAGE = SupportedLanguage.CZECH;

  static {
    for (SupportedLanguage supportedLanguage : values()) {
      LANG_CODE_TO_SUPPORTED_LANGUAGE.put(supportedLanguage.getLanguageCode(),
          supportedLanguage);
    }
  }

  private final String languageCode;
  private final String translationId;

  SupportedLanguage(String languageCode, String translationId) {
    this.languageCode = languageCode;
    this.translationId = translationId;
  }

  public static SupportedLanguage getByLanguageCode(String languageCode) {
    return LANG_CODE_TO_SUPPORTED_LANGUAGE.get(languageCode);
  }

  public static SupportedLanguage getByLanguageCodeOrDefault(String languageCode) {
    if (languageCode == null) {
      return DEFAULT_LANGUAGE;
    }
    SupportedLanguage supportedLanguage = LANG_CODE_TO_SUPPORTED_LANGUAGE
        .get(languageCode.toLowerCase());
    if (supportedLanguage == null) {
      return DEFAULT_LANGUAGE;
    }
    return supportedLanguage;
  }

  public static SupportedLanguage getDefaultLanguage() {
    return DEFAULT_LANGUAGE;
  }

  public String getLanguageCode() {
    return languageCode;
  }
}
