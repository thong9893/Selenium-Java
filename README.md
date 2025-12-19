# Selenium Java Demo Project (OrangeHRM)

## Overview

This is a sample automated testing project using Selenium WebDriver with Java and Maven, targeting the OrangeHRM application. The codebase follows the Page Object Model and includes UI locators, test specifications, utility classes, and configuration files needed to run the test suite.

## Prerequisites

- Java JDK 8 or 11+
- Maven 3.6+
- A supported browser (Chrome or Firefox) and the corresponding WebDriver (chromedriver/geckodriver) available in `PATH` or configured in your setup

## Installation

1. Clone the repository:

```bash
git clone <repo-url>
cd selenium-java
```

2. Download dependencies (first run):

```bash
mvn clean verify -DskipTests
```

## Running tests

- Run the full test suite:

```bash
mvn test
```

- Run a single test class (example: `PIM_01_Employee` in `specs` package):

```bash
mvn -Dtest=specs.PIM_01_Employee test
```

## Project structure (high level)

- `src/test/java/pages` — Page Object classes (e.g. `LoginPO.java`, `DashboardPO.java`)
- `src/test/java/pageUIs` — UI locator definitions
- `src/test/java/specs` — Test specifications / test cases
- `src/test/java/support` — Base utilities and helpers (e.g. `BasePage.java`, `GlobalConstance.java`)
- `src/test/resources` — Configuration and test data (e.g. `orangeHRM.xml`)
- `src/test/java/pojoData` — POJO classes for test data

Notable folders:

- `pages/pim/employee` — PIM / Employee related page objects (Add, Personal, Contact, etc.)

## Configuration

- Update `src/test/resources/orangeHRM.xml` to set test URL, credentials, and any environment-specific settings.
- You can also configure WebDriver paths or system properties in the Maven command or CI pipeline.

## Test reports

- Maven Surefire / Failsafe reports appear under `target/surefire-reports` after running tests.

## Contributing

- Fork the repository, create a feature branch, add tests (if applicable), and open a Pull Request with a description of changes and how to run them.








