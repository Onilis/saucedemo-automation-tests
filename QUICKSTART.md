# Quick Start Guide

Get started with SauceDemo automation tests in 5 minutes!

## 📧 Prerequisites

```bash
# Check Java version (11+)
java -version

# Check Maven version (3.6.0+)
mvn -version
```

## 🚀 Installation & Running Tests

### 1. Clone Repository

```bash
git clone https://github.com/Onilis/saucedemo-automation-tests.git
cd saucedemo-automation-tests
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Run Tests

```bash
mvn test
```

### 4. Generate Allure Report

```bash
mvn allure:report
mvn allure:serve
```

The report will automatically open in your browser at `http://localhost:4040`

## 🕀 Common Commands

### Run with Different Options

```bash
# Headless mode (no browser window)
mvn test -Dheadless=true

# Incognito mode
mvn test -Dincognito=true

# Custom window size
mvn test -Dwindow.size=1366x768

# Combined options
mvn test -Dheadless=true -Dwindow.size=1920x1080
```

### Run Specific Test

```bash
mvn test -Dtest=LoginTests#testSuccessfulLogin
```

### Skip Tests During Build

```bash
mvn clean install -DskipTests
```

### View Logs

```bash
# Real-time logs during test execution
cat logs/automation-tests-rolling.log

# Follow log file
tail -f logs/automation-tests-rolling.log
```

## 🌟 Test Accounts (SauceDemo)

| Username | Password | Status |
|----------|----------|--------|
| standard_user | secret_sauce | ✅ Valid |
| locked_out_user | secret_sauce | 🔒 Locked |
| performance_glitch_user | secret_sauce | ⚡ Slow loading |

## 📊 Reports Location

- **Test Results:** `target/allure-results/`
- **HTML Report:** `target/site/allure-report/`
- **Logs:** `logs/`

## 🔧 Troubleshooting

**Q: Tests running slow?**
A: Use headless mode: `mvn test -Dheadless=true`

**Q: Chrome driver not found?**
A: WebDriverManager downloads it automatically. Check internet connection.

**Q: Element not found?**
A: Increase wait timeout: `mvn test -Dexplicit.wait=15`

**Q: Allure report not generating?**
A: Run: `rm -rf target/allure-results && mvn clean test && mvn allure:report`

## 📚 Project Structure

```
saucedemo-automation-tests/
├── src/main/java/com/saucedemo/
│   ├── config/          # WebDriver and browser configuration
│   └── pages/           # Page Object Model classes
├── src/test/java/com/saucedemo/
│   └── LoginTests.java  # Test cases
├── src/main/resources/
│   └── logback.xml      # Logging configuration
├── pom.xml           # Maven configuration
└── logs/             # Test execution logs
```

## 🎄 5 Test Cases

1. ✅ **Successful Login** - Standard user with correct password
2. ❌ **Invalid Password** - Error handling for wrong password  
3. 🔒 **Locked User** - Account lockout verification
4. 📝 **Empty Fields** - Form validation
5. ⚡ **Performance Glitch** - Page load under stress

## 🚀 Next Steps

1. Check [README.md](README.md) for detailed documentation
2. Review [CONTRIBUTING.md](CONTRIBUTING.md) for code standards
3. Explore the [Pull Request](https://github.com/Onilis/saucedemo-automation-tests/pull/1) for implementation details

## 📃 Useful Links

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [JUnit 5 Guide](https://junit.org/junit5/)
- [Allure Reports](https://docs.qameta.io/allure/)
- [SauceDemo App](https://www.saucedemo.com/)

---

**Happy Testing!** 🥳
