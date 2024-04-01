package jl.reports;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public abstract class BasePDFReportTest {
  protected File pdfFile;

  @Before
  public void setUp() {
    initializeData();
    generatePDFReport();
  }

  @Test
  public void testPDFFileExist() {
    assertTrue("PDF file doesn't exist", pdfFile.exists());
  }

  @Test
  public void testCheckContentInPDF() {
    assertTrue(
        "PDF doesn't contain the expected text",
        TestUtils.containTextInPDF(createExpectedText(), pdfFile));
  }

  /** sample file deletion check */
  //  @After
  //  public void testDeletePDF() {
  //    TestUtils.deleteFile(pdfFile);
  //    assertFalse("PDF file still exists", pdfFile.exists());
  //  }

  protected abstract void initializeData();

  protected abstract String createExpectedText();

  protected abstract void generatePDFReport();
}
