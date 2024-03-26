package jl.util;

import java.io.InputStream;

public final class FileData {

  private final InputStream stream;
  private final String fileName;
  private final String contentType;

  private FileData(FileDataBuilder builder) {
    this.stream = builder.stream;
    this.fileName = builder.fileName;
    this.contentType = builder.contentType;
  }

  public InputStream getStream() {
    return stream;
  }

  public String getFileName() {
    return fileName;
  }

  public String getContentType() {
    return contentType;
  }

  public static final class FileDataBuilder {

    private InputStream stream;
    private String fileName;
    private String contentType;

    private FileDataBuilder() {}

    public static FileDataBuilder builder() {
      return new FileDataBuilder();
    }

    public FileDataBuilder stream(InputStream stream) {
      this.stream = stream;
      return this;
    }

    public FileDataBuilder fileName(String fileName) {
      this.fileName = fileName;
      return this;
    }

    public FileDataBuilder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    public FileData build() {
      return new FileData(this);
    }
  }
}

