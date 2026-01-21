package com.saucedemo.pages;

import com.saucedemo.config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * BasePage contains common methods and elements for all pages.
 * Implements base functionality for page interactions and waits.
 */
public class BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final long TIMEOUT_SECONDS = 10;

    /**
     * Constructor initializing WebDriver and WebDriverWait
     */
    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        logger.debug("BasePage initialized");
    }

    /**
     * Navigate to URL
     *
     * @param url the URL to navigate to
     */
    public void navigateTo(String url) {
        logger.info("Navigating to URL: {}", url);
        driver.navigate().to(url);
        logger.debug("Page loaded: {}", driver.getTitle());
    }

    /**
     * Wait for element to be visible
     *
     * @param locator the element locator
     * @return WebElement once visible
     */
    protected WebElement waitForElementVisible(By locator) {
        logger.debug("Waiting for element to be visible: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for element to be clickable
     *
     * @param locator the element locator
     * @return WebElement once clickable
     */
    protected WebElement waitForElementClickable(By locator) {
        logger.debug("Waiting for element to be clickable: {}", locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait for element to be present in DOM
     *
     * @param locator the element locator
     * @return WebElement once present
     */
    protected WebElement waitForElementPresent(By locator) {
        logger.debug("Waiting for element to be present: {}", locator);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Type text into an element
     *
     * @param locator the element locator
     * @param text    the text to type
     */
    protected void typeText(By locator, String text) {
        logger.debug("Typing text into element: {} with text: {}", locator, text);
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Click on an element
     *
     * @param locator the element locator
     */
    protected void clickElement(By locator) {
        logger.debug("Clicking on element: {}", locator);
        WebElement element = waitForElementClickable(locator);
        element.click();
    }

    /**
     * Get text from element
     *
     * @param locator the element locator
     * @return the element text
     */
    protected String getText(By locator) {
        logger.debug("Getting text from element: {}", locator);
        WebElement element = waitForElementVisible(locator);
        return element.getText();
    }

    /**
     * Get element attribute value
     *
     * @param locator the element locator
     * @param attributeName the attribute name
     * @return the attribute value
     */
    protected String getAttribute(By locator, String attributeName) {
        logger.debug("Getting attribute '{}' from element: {}", attributeName, locator);
        WebElement element = waitForElementVisible(locator);
        return element.getAttribute(attributeName);
    }

    /**
     * Check if element is displayed
     *
     * @param locator the element locator
     * @return true if element is displayed, false otherwise
     */
    protected boolean isElementDisplayed(By locator) {
        logger.debug("Checking if element is displayed: {}", locator);
        try {
            return waitForElementVisible(locator).isDisplayed();
        } catch (Exception e) {
            logger.debug("Element not displayed: {}", locator);
            return false;
        }
    }

    /**
     * Get current page title
     *
     * @return page title
     */
    public String getPageTitle() {
        logger.debug("Getting page title");
        return driver.getTitle();
    }

    /**
     * Get current page URL
     *
     * @return current URL
     */
    public String getCurrentUrl() {
        logger.debug("Getting current URL");
        return driver.getCurrentUrl();
    }
}
