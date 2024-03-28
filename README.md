# HTML to PDF Report Generator for Java

## Overview

This project demonstrates how to generate PDF reports from HTML templates in Java applications. It serves as an example of leveraging various libraries within the JVM ecosystem to create detailed and styled PDF documents. The project showcases three primary examples:

1. **Simple PDF Generation**: Creating a basic PDF report with plain text.
2. **PDF Merging**: Demonstrating how to merge your report with another PDF document.
3. **Complex Report Generation**: Advanced example including headers, footers, and data parsing from JSON into Java objects to be displayed in the PDF report.

## Technologies Used

- `org.junit.jupiter` for unit testing.
- `com.openhtmltopdf` for converting HTML to PDF.
- `org.apache.pdfbox` for working with PDF documents, including merging.
- `org.thymeleaf` for HTML template processing.
- `org.springframework` for overall application framework.
- `jasckon` for JSON processing into Java objects.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java JDK 11 or higher installed.
- Maven for managing dependencies and building the project.

## Installation

Clone this repository to your local machine:

```sh
git clone https://github.com/yourusername/html-to-pdf-java-example.git
cd html-to-pdf-java-example
```
Install dependencies
```sh
mvn install
```

## Issues detected during implementation
1. While searching for the root cause of the **letter spacing** CSS, we found an error – explanation available [here](https://github.com/danfickle/openhtmltopdf/issues/228#issuecomment-408588612)
2. We had to update to the latest version of the pdfbox library, because the OpenToHtmlPdf library that was used contained an old version of pdfbox library containing critical errors. An example of such an error:
   [here](https://devhub.checkmarx.com/cve-details/CVE-2018-8036/?utm_source=jetbrains&utm_medium=referral&utm_campaign=idea)

    This is why we had to add the following code into dependencies:
```xml
<dependency>
    <groupId>org.apache.pdfbox</groupId>
    <artifactId>pdfbox</artifactId>
    <version>2.0.6</version>
</dependency>
```
3. To avoid long words overlapping page margins, the following style for table cells should be used to justify the words: **word-wrap: break-word;**
  
   An example of use:
```css
.table td {
   min-width: 30px;
   max-width: 60px;
   word-wrap: break-word;
}
```   
4. Among other detected issues was the font used in the **```<b></b>```**  tag. To avoid this, font must be used for bold text. This solution proved to fix the issue with rendering of bold text in various types of browsers.

5. To prevent the expansion of a table row and table cell deformation over multiple pages, the following solution was found:
   Wrap the section with the ```<div></div>``` tag and use the following style:
```css
.page-break-inside {
   page-break-inside: avoid;
   display: block;
   width: 100%;
}
``` 
6. Another issue occurred with Footnote section placement (footnotes are notes placed at the bottom of the page) – the following solution was found:
   Add the below style into the **@Page** section
```css
@footnote {
   padding-bottom: 1px;
}
```
   For section ```<div class=footnote>Example text in footnote</div>``` , use the style below
```css
.footnote {
   float: footnote;
   text-align: left;
}
``` 
7. When trying to set a different style for a different first page, the @Page rule for different style was used. Those different styles were then linked into the file as another .css file
```css
@page :first {
   .header {
      display: none;
   }
} 
``` 
8. The library supports using only CSS 2.1 and later standards for layout, formatting, and outputting to PDF or images.

9. The project allows you to localize the HTML templates in any language variant
   

## Contributing
Contributions to this project are welcome! Here are a few ways you can help:

    Report bugs.
    Add or suggest new features.
    Improve documentation.
    Submit pull requests with fixes or enhancements.

## Acknowledgments
This project utilizes several open-source libraries and owes its gratitude to the developers and contributors of:

    JUnit
    OpenHTMLtoPDF
    Apache PDFBox
    Thymeleaf
    Spring Framework
    Jackson