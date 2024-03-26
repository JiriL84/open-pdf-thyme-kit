package jl.reports;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HtmlToPdfConverter {

  private static final Logger LOGGER = LoggerFactory.getLogger(HtmlToPdfConverter.class);

  private HtmlToPdfConverter() {
  }

  public static byte[] convertHtmlToPdfBytes(String html, String resourcePath) {
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      renderPdf(html, resourcePath, outputStream);
      return outputStream.toByteArray();
    } catch (IOException e) {
      LOGGER.error("Error rendering PDF bytes: {}", e.getMessage(), e);
      return new byte[0];
    } catch (Exception e) {
      LOGGER.error("Error during PDF generation: {}", e.getMessage(), e);
      return new byte[0];
    }
  }


  private static void renderPdf(String html, String resourcePath,
      ByteArrayOutputStream outputStream) throws IOException {
    PdfRendererBuilder builder = new PdfRendererBuilder();
    builder.useFastMode();
    builder.withHtmlContent(html, HtmlToPdfConverter.class.getResource(resourcePath).toString());
    builder.toStream(outputStream);
    builder.run();
  }
}
