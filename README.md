Selenium Test Framework for Entrata Website
Overview
This repository contains a Selenium-based test automation framework for testing functionalities on the entrata.com website. The framework is implemented in Java using TestNG, Maven, Log4j for logging, and Extent Reports for reporting with screenshot capture on test failures. The Page Object Model (POM) design pattern is used to ensure maintainability and scalability.
Prerequisites
To run the tests, ensure the following are installed on your system:

Java: JDK 17 or higher
Maven: Version 3.6.3 or higher
Web Browser: Google Chrome (latest stable version)
ChromeDriver: Compatible with the installed Chrome version (automatically managed via WebDriverManager)
Git: [To clone the repository](https://github.com/gadekarsachin/Entra.git)

Setup Instructions

Clone the Repository:
git clone https://github.com/your-username/entrata-selenium-tests.git
cd test (if need)


Install Dependencies:Run the following command to download all required Maven dependencies:
mvn clean test


Configure ChromeDriver:The project uses WebDriverManager to automatically manage ChromeDriver. No manual configuration is needed.

Directory Structure:

src/test/java/pages/: Contains Page Object Model classes for different pages of the Entrata website.
src/main/java/com/pages: Contains utility classes for file fetch from property file for dynamic data .
testoutput/test-report/: Directory where Extent Reports  after test execution.



Running the Tests
To execute the test suite, run the following command from the project root:
mvn verify

This will:

Execute all test cases defined in the runner file.
Generate an Extent Report in the reports/ directory.  

Test Cases
The framework includes the following test cases to cover a range of functionalities on the Entrata website:

Navigation Test: Verifies navigation between the home page, product page, and resources page.
Form Interaction Test: Interacts with the demo request form (without submission) and validates field inputs.
Dynamic Content Test: Verifies the presence and correctness of dynamic content on the home page (e.g., banner text).
Feature Validation Test: Checks the functionality of interactive elements like buttons or links.
Error Handling Test: Validates behavior when incorrect inputs are provided to a form field.

Each test case includes:

Clear comments explaining the purpose and logic.
Explicit waits to handle dynamic or asynchronous behavior.
Assertions to validate expected outcomes.
 
Framework Features

Page Object Model (POM): Organizes page elements and actions into separate classes for better maintainability.
Junit: Used for test execution, setup, and teardown lifecycle hooks.
Reports: Generates detailed HTML reports with test results and attached screenshots for failed tests.
Explicit Waits: Ensures reliable handling of dynamic content, avoiding Thread.sleep().
Exception Handling: Gracefully handles exceptions during test execution.
WebDriverManager: Automatically manages browser drivers, eliminating manual setup.

Dependencies
The project uses the following Maven dependencies (defined in pom.xml):

selenium-java: For browser automation.
Junit: For test execution and management.
webdrivermanager: For automatic driver management.
reports: For generating test reports.

Notes

The tests are designed to interact with the Entrata website without submitting any forms, as per the instructions.
All tests are expected to pass when executed against the live entrata.com site.
The framework avoids hard-coded waits (Thread.sleep()) and uses explicit waits for reliability.
Screenshots are captured automatically for failed tests and attached to the Extent Report.

Troubleshooting

Tests Fail Due to Browser Incompatibility: Ensure the latest version of Chrome is installed, and WebDriverManager will handle the correct ChromeDriver version.
Dependencies Not Resolved: Run mvn clean install to refresh dependencies.
Dynamic Content Issues: The tests use explicit waits, but if the website's structure changes significantly, update the locators in the POM classes.

Contact
For any questions or issues, please contact gadekar9503@gmail.com.
