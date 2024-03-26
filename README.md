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