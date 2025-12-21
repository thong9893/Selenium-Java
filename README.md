# Selenium Java — OrangeHRM Demo

Lightweight Selenium + TestNG project (Page Object Model) for OrangeHRM UI tests. Includes Allure reporting configuration.

## Quick start

Prerequisites:
- Java 11+ (project uses modern Java features)
- Maven 3.6+
- Browser driver (Chrome/Firefox) available on `PATH` or provided via system property

Clone and download dependencies:

```bash
git clone <repo-url>
cd selenium-java
mvn clean verify -DskipTests
```

Run tests (examples):

- Run full suite:

```bash
mvn test
```

- Run a single test class (example):

```bash
mvn -Dtest=specs.PIM_01_Employee test
```

- Run with browser property (if supported by `DriverFactory` / `BaseTest`):

```bash
mvn test -Dbrowser=chrome
```

Set explicit WebDriver binary path (Windows example):

```bash
mvn test -Dwebdriver.chrome.driver=C:/drivers/chromedriver.exe
```

Important: run tests with Maven (not only from IDE) to ensure Surefire `argLine` and Allure AspectJ agent (if configured) are applied.

## Allure reporting

This project writes Allure results to `allure-results` at the project root.

- After a test run, generate/serve the report with the Allure CLI:

```bash
mvn test
allure serve allure-results
```

Or open an already generated report:

```bash
allure open allure-results
```

If you don't have Allure CLI installed, see https://docs.qameta.io/allure/

## Project layout (selected)

- `pom.xml` — Maven build, dependencies (Selenium, TestNG, Allure) and Surefire configuration
- `src/test/java/pages` — Page Objects
- `src/test/java/pageUIs` — locators/constants for pages
- `src/test/java/specs` — Test classes (TestNG)
- `src/test/java/support` — base classes and test utilities (`BasePage`, `BaseTest`, `DriverFactory`)
- `src/test/resources` — test configuration and test data

## Conventions & notes

- Tests use the Page Object Model; prefer adding `@Step` annotations on page methods to generate clear Allure steps.
- Assertions have been consolidated into page-level verification methods where appropriate.
- To change test data, update `src/test/java/testData/pojoData/EmployeeInfo.java` or the test's data-builder.
- Running from IDE may skip Surefire `argLine` settings — prefer `mvn test` for consistent Allure behavior.





















