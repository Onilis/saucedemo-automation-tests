# Contributing to SauceDemo Automation Tests

Thank you for your interest in contributing! This document provides guidelines for contributing to the project.

## Code of Conduct

Be respectful, inclusive, and professional in all interactions.

## How to Contribute

### 1. Fork the Repository

```bash
git clone https://github.com/Onilis/saucedemo-automation-tests.git
cd saucedemo-automation-tests
```

### 2. Create a Feature Branch

```bash
git checkout -b feature/your-feature-name
# or for bugfixes:
git checkout -b bugfix/your-bugfix-name
```

### 3. Make Your Changes

- Follow the existing code style and patterns
- Use meaningful variable and method names
- Add comments for complex logic
- Keep methods focused and single-responsibility

### 4. Commit Your Changes

```bash
git commit -m "Type: Brief description"
```

**Commit types:**
- `feat:` New feature
- `fix:` Bug fix
- `test:` Test additions/updates
- `docs:` Documentation changes
- `refactor:` Code refactoring
- `chore:` Build/config changes

**Example:**
```bash
git commit -m "test: Add new assertion for successful login test"
```

### 5. Push to Your Fork

```bash
git push origin feature/your-feature-name
```

### 6. Create a Pull Request

1. Go to the original repository
2. Click "New Pull Request"
3. Select your fork and branch
4. Add detailed description
5. Reference any related issues

## Pull Request Guidelines

### PR Title Format

```
[Type] Brief Description

Examples:
[Feature] Add API authentication tests
[Fix] Fix login page timeout issue
[Docs] Update README with new instructions
```

### PR Description Template

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] New feature
- [ ] Bug fix
- [ ] Documentation update
- [ ] Code refactoring

## Testing
Describe testing performed:
- [ ] All tests pass locally
- [ ] New tests added
- [ ] Existing tests still work

## Checklist
- [ ] Code follows style guidelines
- [ ] Comments added for complex logic
- [ ] Documentation updated
- [ ] No new warnings generated
- [ ] Tests pass locally
```

## Code Style Guidelines

### Java Code Style

```java
// Class and method names
public class LoginPage extends BasePage {
    public void login(String username, String password) {
        // Implementation
    }
}

// Variable names (camelCase)
private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
private WebDriver driver;
int testCount = 0;

// Constants (UPPER_CASE)
private static final String LOGIN_URL = "https://www.saucedemo.com/";
private static final int TIMEOUT_SECONDS = 10;

// Indentation (4 spaces)
if (condition) {
    doSomething();
}

// Documentation
/**
 * Method description
 * @param parameter description
 * @return description
 */
public String getData(String parameter) {
    return "result";
}
```

### Logging Best Practices

```java
// Use appropriate log levels
logger.debug("Detailed information for debugging");
logger.info("General information about execution");
logger.warn("Warning about potential issues");
logger.error("Error details", exception);

// Include context in log messages
logger.info("Logging in user: {}", username);
logger.debug("Element located: {}", locator);
```

### Test Naming Convention

```java
// Format: test<Action><ExpectedResult>
@Test
public void testLoginWithValidCredentials() {
    // Test implementation
}

@Test
public void testErrorMessageDisplayedWithInvalidPassword() {
    // Test implementation
}
```

## Adding New Tests

### Test Structure

```java
@Test
@DisplayName("Descriptive test name")
@Description("Detailed description of what is tested")
@Severity(SeverityLevel.CRITICAL)
public void testSomething() {
    // ARRANGE
    assertTrue(loginPage.isLoginPageDisplayed());
    
    // ACT
    loginPage.login(username, password);
    
    // ASSERT
    assertTrue(loginPage.isLoggedInSuccessfully());
}
```

### Test Independence

- Each test must be independent
- Don't rely on execution order
- Clean up resources in `@AfterEach`
- Use `@BeforeEach` for setup

### Assertions

Use JUnit assertions:
```java
assertTrue(condition, "message");
assertFalse(condition, "message");
assertEquals(expected, actual, "message");
assertNotNull(object, "message");
```

## Bug Reports

When reporting bugs:

1. **Title:** Clear, concise description
2. **Environment:** Java version, OS, browser
3. **Steps to Reproduce:** Detailed steps
4. **Expected Behavior:** What should happen
5. **Actual Behavior:** What actually happened
6. **Screenshots/Logs:** If applicable

## Feature Requests

When requesting features:

1. **Title:** Clear description of feature
2. **Motivation:** Why is this needed?
3. **Proposed Solution:** How should it work?
4. **Alternative Solutions:** Other approaches considered

## Review Process

1. Code review by maintainer
2. Automated tests must pass
3. No merge conflicts
4. Documentation updated
5. Approval and merge

## Questions?

Feel free to open an issue or contact the maintainer.

---

**Thank you for contributing!** 🎉
