# SauceDemo Automation Tests

Automated testing framework for SauceDemo login page using Selenium WebDriver, JUnit 5, Maven with Page Object Model pattern and Allure Reports.

## Project Structure

```
saucedemo-automation-tests/
├── src/
│   ├── main/java/com/saucedemo/
│   │   ├── config/
│   │   │   ├── BrowserConfig.java
│   │   │   └── DriverManager.java
│   │   ├── pages/
│   │   │   ├── BasePage.java
│   │   │   └── LoginPage.java
│   │   └── utils/
│   │       └── Logger.java
│   └── test/java/com/saucedemo/
│       └── LoginTests.java
├── src/main/resources/
│   └── logback.xml
├── pom.xml
└── README.md
```

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Chrome browser (latest version)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/Onilis/saucedemo-automation-tests.git
cd saucedemo-automation-tests
```

2. Install dependencies:
```bash
mvn clean install
```

## Running Tests

### Run all tests:
```bash
mvn test
```

### Run specific test class:
```bash
mvn test -Dtest=LoginTests
```

### Run tests with specific tag:
```bash
mvn test -Dgroups=login
```

## Generating Allure Reports

### Generate report:
```bash
mvn allure:report
```

### Open report in browser:
```bash
mvn allure:serve
```

## Test Cases

1. **Successful Login** - standard_user with correct password
2. **Invalid Password** - standard_user with wrong password
3. **Locked Out User** - locked_out_user login attempt
4. **Empty Fields** - login without credentials
5. **Performance Glitch User** - performance_glitch_user with page load verification

## Technologies Used

- **Selenium WebDriver** 4.15.0 - Web automation
- **JUnit 5** - Testing framework
- **Maven** - Build tool
- **Allure Reports** - Test reporting
- **WebDriverManager** - Automatic driver management
- **SLF4J + Logback** - Logging framework

## Design Patterns

- **Page Object Model (POM)** - Separating page elements and interactions from test logic
- **Singleton Pattern** - WebDriver management
- **Factory Pattern** - WebDriver initialization

## CI/CD Integration

Tests can be integrated with CI/CD pipelines. Reports are generated in `target/allure-results/` directory.

## Branching Strategy

- `master` - Production-ready code
- `dev` - Development branch with new features and fixes

## Author

Onilis - QA Engineer/Developer

## License

MIT License
