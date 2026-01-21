# SauceDemo Automation Tests

[![Maven Build](https://img.shields.io/badge/Build-Maven-blue)](https://maven.apache.org/)
[![Java Version](https://img.shields.io/badge/Java-11-brightgreen)](https://www.oracle.com/java/)
[![Selenium Version](https://img.shields.io/badge/Selenium-4.15.0-brightgreen)](https://www.selenium.dev/)
[![JUnit Version](https://img.shields.io/badge/JUnit-5-brightgreen)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

Automated testing framework for SauceDemo login page using Selenium WebDriver, JUnit 5, Maven with Page Object Model pattern and Allure Reports.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Test Cases](#test-cases)
- [Allure Reports](#allure-reports)
- [Configuration](#configuration)
- [Design Patterns](#design-patterns)
- [Logging](#logging)
- [Branching Strategy](#branching-strategy)
- [Troubleshooting](#troubleshooting)
- [Author](#author)

## 🎯 Project Overview

This project automates login testing for the SauceDemo application with comprehensive test coverage including:
- Successful authentication scenarios
- Error handling and validation
- Edge cases and special user accounts
- Performance monitoring

## ✨ Features

✅ **Page Object Model (POM)** - Clean separation of page elements and test logic  
✅ **5 Comprehensive Test Cases** - Covering all login scenarios  
✅ **Allure Reports** - Beautiful HTML test reports with metrics  
✅ **Detailed Logging** - SLF4J + Logback integration  
✅ **WebDriver Management** - Automatic driver lifecycle and thread safety  
✅ **Flexible Configuration** - Headless mode, incognito, window size options  
✅ **Independent Tests** - Each test is self-contained with setup/teardown  
✅ **Maven Integration** - Easy build and dependency management  

## 🛠 Technology Stack

| Technology | Version | Purpose |
|-----------|---------|----------|
| Java | 11 | Programming language |
| Maven | 3.6.0+ | Build tool |
| Selenium WebDriver | 4.15.0 | Web automation |
| JUnit 5 | 5.10.1 | Testing framework |
| Allure Reports | 2.21.0 | Test reporting |
| WebDriverManager | 5.7.3 | Driver management |
| SLF4J | 2.0.9 | Logging facade |
| Logback | 1.4.14 | Logging implementation |

## 📁 Project Structure

```
saucedemo-automation-tests/
├── src/
│   ├── main/
│   │   ├── java/com/saucedemo/
│   │   │   ├── config/
│   │   │   │   ├── BrowserConfig.java      # Browser configuration options
│   │   │   │   └── DriverManager.java      # WebDriver singleton management
│   │   │   └── pages/
│   │   │       ├── BasePage.java           # Base class with common methods
│   │   │       └── LoginPage.java          # Login page object model
│   │   └── resources/
│   │       └── logback.xml                 # Logging configuration
│   └── test/
│       └── java/com/saucedemo/
│           └── LoginTests.java             # Test cases
├── pom.xml                                 # Maven configuration
├── .gitignore                              # Git ignore patterns
└── README.md                               # This file
```

## 📦 Prerequisites

- **Java Development Kit (JDK)** 11 or higher
  ```bash
  java -version
  ```

- **Maven** 3.6.0 or higher
  ```bash
  mvn -version
  ```

- **Google Chrome** (latest version) - Required for tests

- **Git** for cloning and version control

## 📥 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Onilis/saucedemo-automation-tests.git
cd saucedemo-automation-tests
```

### 2. Checkout Development Branch (Optional)

```bash
git checkout dev
```

### 3. Install Dependencies

```bash
mvn clean install
```

This command will:
- Clean previous builds
- Download all dependencies
- Compile the project
- Run all tests

## 🧪 Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Test Class

```bash
mvn test -Dtest=LoginTests
```

### Run Tests with Headless Mode

```bash
mvn test -Dheadless=true
```

### Run Tests with Incognito Mode

```bash
mvn test -Dincognito=true
```

### Run Tests with Custom Window Size

```bash
mvn test -Dwindow.size=1366x768
```

### Skip Tests During Build

```bash
mvn clean install -DskipTests
```

## 📊 Test Cases

### Test 1: Successful Login ✅
```
Scenario: Valid user credentials
Username: standard_user
Password: secret_sauce
Expected: User is logged in and products page is displayed
Severity: CRITICAL
```

### Test 2: Invalid Password ❌
```
Scenario: Correct username with wrong password
Username: standard_user
Password: wrong_password
Expected: Error message "Username and password do not match any user in this service"
Severity: CRITICAL
```

### Test 3: Locked Out User 🔒
```
Scenario: Login attempt with locked account
Username: locked_out_user
Password: secret_sauce
Expected: Error message "Sorry, this user has been locked out"
Severity: CRITICAL
```

### Test 4: Empty Fields 📝
```
Scenario: Login without entering credentials
Username: (empty)
Password: (empty)
Expected: Error message "Username is required"
Severity: HIGH
```

### Test 5: Performance Glitch User ⚡
```
Scenario: Login with performance_glitch_user (potential page load delays)
Username: performance_glitch_user
Password: secret_sauce
Expected: User is logged in and products page is displayed despite delays
Severity: NORMAL
```

## 📈 Allure Reports

### Generate Allure Report

```bash
mvn allure:report
```

### View Report in Browser

```bash
mvn allure:serve
```

This will start a local server and automatically open the Allure report in your default browser.

### Report Locations

- **Results:** `target/allure-results/`
- **Report:** `target/site/allure-report/`

## ⚙️ Configuration

### JVM System Properties

You can configure tests using JVM system properties:

```bash
mvn test -Dheadless=true -Dincognito=true -Dwindow.size=1920x1080
```

### Available Properties

| Property | Default | Purpose |
|----------|---------|----------|
| `headless` | false | Run tests in headless mode |
| `incognito` | false | Run tests in incognito mode |
| `window.size` | 1920x1080 | Set browser window size |
| `implicit.wait` | 10 | Implicit wait timeout (seconds) |
| `explicit.wait` | 10 | Explicit wait timeout (seconds) |
| `page.load.wait` | 30 | Page load timeout (seconds) |

### Logback Configuration

Edit `src/main/resources/logback.xml` to customize logging:
- Change log level (DEBUG, INFO, WARN, ERROR)
- Configure file output paths
- Adjust log format
- Set up rolling file policies

## 🏗️ Design Patterns

### Page Object Model (POM)

```
LoginPage extends BasePage
├── Locators (By selectors)
├── Actions (login, enterUsername, etc.)
└── Verifications (isLoggedIn, isErrorDisplayed, etc.)
```

### Singleton Pattern

WebDriver instance is managed as singleton to ensure single driver per test session:

```java
WebDriver driver = DriverManager.getDriver(); // Same instance
```

### Factory Pattern

Driver initialization is encapsulated in DriverManager factory:

```java
private static WebDriver initializeDriver() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver(options);
}
```

## 📝 Logging

### Log Levels

- **DEBUG** - Detailed information for troubleshooting
- **INFO** - General information about test execution
- **WARN** - Warning messages for potential issues
- **ERROR** - Error messages for failures

### Log Output

Logs are written to:
1. **Console** - Real-time test execution feedback
2. **File** - `logs/automation-tests-rolling.log` (persistent)

### Example Log Output

```
[2026-01-21 20:19:04] [main] INFO  LoginTests - ========== Test 1: Successful Login Started ==========
[2026-01-21 20:19:04] [main] INFO  DriverManager - Initializing WebDriver...
[2026-01-21 20:19:05] [main] INFO  LoginPage - Opening login page: https://www.saucedemo.com/
[2026-01-21 20:19:06] [main] DEBUG BasePage - Waiting for element to be visible: By.id: user-name
```

## 🌿 Branching Strategy

Project uses Git Flow branching strategy:

```
master (production)
  ↑
  ├── Pull Request (dev → master)
  │
  └── dev (development)
      ├── feature/new-tests
      ├── bugfix/login-page
      └── hotfix/urgent-fix
```

### Branch Description

- **master** - Production-ready, tested code
- **dev** - Development branch with new features and fixes

### Creating Pull Request

1. Push changes to `dev` branch
2. Go to [Pull Requests](https://github.com/Onilis/saucedemo-automation-tests/pulls)
3. Click "New Pull Request"
4. Select `dev` as source, `master` as target
5. Add description and create PR

## 🔧 Troubleshooting

### Issue: "Chrome driver not found"

**Solution:** WebDriverManager downloads driver automatically. Check:
```bash
# Ensure internet connection
# Check Chrome installation
google-chrome --version
```

### Issue: "Tests run very slowly"

**Solution:** Use headless mode:
```bash
mvn test -Dheadless=true
```

### Issue: "Element not found" errors

**Solution:** 
1. Check website hasn't changed: https://www.saucedemo.com/
2. Increase wait timeout: `-Dexplicit.wait=15`
3. Review logs in `logs/` directory

### Issue: "Allure report not generating"

**Solution:**
```bash
# Clear previous results
rm -rf target/allure-results
# Run tests again
mvn clean test
# Generate report
mvn allure:report
```

## 📚 Additional Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [JUnit 5 Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Allure Reports](https://docs.qameta.io/allure/)
- [SauceDemo](https://www.saucedemo.com/) - Test application

## 👤 Author

**Onilis** - QA Engineer / Java Developer  
GitHub: [@Onilis](https://github.com/Onilis)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

**Last Updated:** January 21, 2026  
**Version:** 1.0.0
