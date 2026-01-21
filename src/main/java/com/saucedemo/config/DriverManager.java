package com.saucedemo.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DriverManager handles WebDriver lifecycle management.
 * Implements Singleton pattern for ensuring single WebDriver instance.
 */
public class DriverManager {

    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);
    private static WebDriver driver;
    private static final Object lock = new Object();

    /**
     * Private constructor to prevent instantiation
     */
    private DriverManager() {
    }

    /**
     * Get or create WebDriver instance (thread-safe singleton)
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (lock) {
                if (driver == null) {
                    logger.info("Initializing WebDriver...");
                    driver = initializeDriver();
                    logger.info("WebDriver initialized successfully");
                }
            }
        }
        return driver;
    }

    /**
     * Initialize Chrome WebDriver with options
     *
     * @return WebDriver instance
     */
    private static WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--start-maximized",
                "--disable-blink-features=AutomationControlled",
                "--disable-extensions",
                "--disable-plugins"
        );
        logger.debug("Chrome options configured");
        return new ChromeDriver(options);
    }

    /**
     * Quit WebDriver and clean up resources
     */
    public static void quitDriver() {
        if (driver != null) {
            logger.info("Closing WebDriver...");
            driver.quit();
            driver = null;
            logger.info("WebDriver closed successfully");
        }
    }

    /**
     * Check if driver is initialized
     *
     * @return true if driver is not null, false otherwise
     */
    public static boolean isDriverInitialized() {
        return driver != null;
    }
}
