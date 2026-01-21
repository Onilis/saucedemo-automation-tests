package com.saucedemo;

import com.saucedemo.config.DriverManager;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LoginTests contains test cases for SauceDemo login functionality.
 * Tests cover various authentication scenarios including successful login,
 * invalid credentials, locked users, and empty fields.
 */
@Feature("Authentication")
@DisplayName("Login Tests for SauceDemo")
public class LoginTests {

    private static final Logger logger = LoggerFactory.getLogger(LoginTests.class);
    private LoginPage loginPage;

    /**
     * Setup before each test - initialize LoginPage
     */
    @BeforeEach
    public void setUp() {
        logger.info("========== Test Setup Started ==========");
        loginPage = new LoginPage();
        loginPage.openLoginPage();
        logger.info("LoginPage opened successfully");
    }

    /**
     * Cleanup after each test - quit WebDriver
     */
    @AfterEach
    public void tearDown() {
        logger.info("========== Test Cleanup Started ==========");
        DriverManager.quitDriver();
        logger.info("WebDriver closed successfully");
    }

    /**
     * Test 1: Successful login with standard user
     * Expected: User is logged in and products page is displayed
     */
    @Test
    @DisplayName("Test 1: Successful Login with Standard User")
    @Description("Verify that standard_user can successfully login with correct credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLogin() {
        logger.info("========== Test 1: Successful Login Started ==========");

        // Verify login page is displayed
        assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");
        logger.debug("Login page verification passed");

        // Perform login
        loginPage.login("standard_user", "secret_sauce");
        logger.info("Login action completed");

        // Verify successful login
        assertTrue(loginPage.isLoggedInSuccessfully(), "User should be logged in successfully");
        logger.info("Login verification passed");
        logger.info("========== Test 1: PASSED ==========");
    }

    /**
     * Test 2: Login with invalid password
     * Expected: Error message is displayed
     */
    @Test
    @DisplayName("Test 2: Login with Invalid Password")
    @Description("Verify that login fails when incorrect password is provided")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithInvalidPassword() {
        logger.info("========== Test 2: Login with Invalid Password Started ==========");

        // Verify login page is displayed
        assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");
        logger.debug("Login page verification passed");

        // Perform login with wrong password
        loginPage.login("standard_user", "wrong_password");
        logger.info("Login attempt with invalid password completed");

        // Verify error message is displayed
        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        logger.debug("Error message displayed: {}", loginPage.getErrorMessage());
        
        // Verify specific error message
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Username and password do not match any user in this service"),
                "Error message should match username/password mismatch");
        logger.info("Error message verification passed");
        logger.info("========== Test 2: PASSED ==========");
    }

    /**
     * Test 3: Login with locked out user
     * Expected: Error message indicates user is locked out
     */
    @Test
    @DisplayName("Test 3: Login with Locked Out User")
    @Description("Verify that locked_out_user cannot login and receives appropriate error message")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithLockedOutUser() {
        logger.info("========== Test 3: Login with Locked Out User Started ==========");

        // Verify login page is displayed
        assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");
        logger.debug("Login page verification passed");

        // Perform login with locked out user
        loginPage.login("locked_out_user", "secret_sauce");
        logger.info("Login attempt with locked_out_user completed");

        // Verify error message is displayed
        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        logger.debug("Error message displayed: {}", loginPage.getErrorMessage());
        
        // Verify specific error message
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Sorry, this user has been locked out"),
                "Error message should indicate user is locked out");
        logger.info("Locked out user error verification passed");
        logger.info("========== Test 3: PASSED ==========");
    }

    /**
     * Test 4: Login with empty fields
     * Expected: Error message is displayed for empty username
     */
    @Test
    @DisplayName("Test 4: Login with Empty Fields")
    @Description("Verify that login fails when credentials fields are empty")
    @Severity(SeverityLevel.HIGH)
    public void testLoginWithEmptyFields() {
        logger.info("========== Test 4: Login with Empty Fields Started ==========");

        // Verify login page is displayed
        assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");
        logger.debug("Login page verification passed");

        // Verify fields are empty
        assertEquals("", loginPage.getUsernameValue(), "Username field should be empty");
        assertEquals("", loginPage.getPasswordValue(), "Password field should be empty");
        logger.debug("Empty fields verification passed");

        // Click login button without entering credentials
        loginPage.clickLoginButton();
        logger.info("Login attempt with empty fields completed");

        // Verify error message is displayed
        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        logger.debug("Error message displayed: {}", loginPage.getErrorMessage());
        
        // Verify specific error message
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Username is required"),
                "Error message should indicate username is required");
        logger.info("Empty fields error verification passed");
        logger.info("========== Test 4: PASSED ==========");
    }

    /**
     * Test 5: Login with performance glitch user
     * Expected: User is logged in despite potential page load delays
     */
    @Test
    @DisplayName("Test 5: Login with Performance Glitch User")
    @Description("Verify that performance_glitch_user can login and page loads despite potential delays")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithPerformanceGlitchUser() {
        logger.info("========== Test 5: Login with Performance Glitch User Started ==========");

        // Verify login page is displayed
        assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");
        logger.debug("Login page verification passed");

        // Record start time
        long startTime = System.currentTimeMillis();
        logger.info("Login attempt start time: {}", startTime);

        // Perform login with performance glitch user
        loginPage.login("performance_glitch_user", "secret_sauce");
        logger.info("Login action completed");

        // Record end time
        long endTime = System.currentTimeMillis();
        long loginDuration = endTime - startTime;
        logger.info("Login attempt end time: {}, Duration: {} ms", endTime, loginDuration);

        // Verify successful login (page loaded despite delays)
        assertTrue(loginPage.isLoggedInSuccessfully(),
                "User should be logged in successfully despite potential delays");
        logger.info("User logged in successfully after {} ms", loginDuration);

        // Verify current URL contains products or inventory
        String currentUrl = loginPage.getCurrentUrl();
        assertTrue(currentUrl.contains("inventory") || currentUrl.contains("saucedemo.com"),
                "Current URL should indicate successful login");
        logger.info("Current URL verification passed: {}", currentUrl);
        logger.info("========== Test 5: PASSED ==========");
    }
}
