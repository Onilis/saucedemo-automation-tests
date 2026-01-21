package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoginPage represents the login page of SauceDemo.
 * Implements Page Object Model pattern with locators and actions.
 */
public class LoginPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private static final String LOGIN_URL = "https://www.saucedemo.com/";

    // Locators
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.xpath("//div[@class='error-message-container']//h3");
    private static final By PAGE_TITLE = By.xpath("//div[@class='login_logo']");
    private static final By INVENTORY_CONTAINER = By.className("inventory_container");
    private static final By PRODUCTS_TITLE = By.xpath("//span[@class='title'][contains(text(), 'Products')]");

    /**
     * Constructor
     */
    public LoginPage() {
        super();
        logger.debug("LoginPage instance created");
    }

    /**
     * Open login page
     */
    public void openLoginPage() {
        logger.info("Opening login page: {}", LOGIN_URL);
        navigateTo(LOGIN_URL);
        waitForElementVisible(USERNAME_INPUT);
        logger.info("Login page opened successfully");
    }

    /**
     * Enter username
     *
     * @param username the username to enter
     */
    public void enterUsername(String username) {
        logger.info("Entering username: {}", username);
        typeText(USERNAME_INPUT, username);
    }

    /**
     * Enter password
     *
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        logger.info("Entering password");
        typeText(PASSWORD_INPUT, password);
    }

    /**
     * Click login button
     */
    public void clickLoginButton() {
        logger.info("Clicking login button");
        clickElement(LOGIN_BUTTON);
    }

    /**
     * Perform login with username and password
     *
     * @param username the username
     * @param password the password
     */
    public void login(String username, String password) {
        logger.info("Performing login with username: {}", username);
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Get error message text
     *
     * @return error message
     */
    public String getErrorMessage() {
        logger.info("Getting error message");
        return getText(ERROR_MESSAGE);
    }

    /**
     * Check if error message is displayed
     *
     * @return true if error message is visible
     */
    public boolean isErrorMessageDisplayed() {
        logger.info("Checking if error message is displayed");
        return isElementDisplayed(ERROR_MESSAGE);
    }

    /**
     * Check if login page is displayed
     *
     * @return true if login page is visible
     */
    public boolean isLoginPageDisplayed() {
        logger.info("Checking if login page is displayed");
        return isElementDisplayed(PAGE_TITLE);
    }

    /**
     * Check if logged in successfully (products page is displayed)
     *
     * @return true if products inventory is visible
     */
    public boolean isLoggedInSuccessfully() {
        logger.info("Checking if user is logged in successfully");
        try {
            return isElementDisplayed(PRODUCTS_TITLE);
        } catch (Exception e) {
            logger.debug("User not logged in: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Get username input field value
     *
     * @return username field value
     */
    public String getUsernameValue() {
        logger.debug("Getting username field value");
        return getAttribute(USERNAME_INPUT, "value");
    }

    /**
     * Get password input field value
     *
     * @return password field value
     */
    public String getPasswordValue() {
        logger.debug("Getting password field value");
        return getAttribute(PASSWORD_INPUT, "value");
    }

    /**
     * Clear all input fields
     */
    public void clearAllFields() {
        logger.info("Clearing all input fields");
        waitForElementVisible(USERNAME_INPUT).clear();
        waitForElementVisible(PASSWORD_INPUT).clear();
    }
}
