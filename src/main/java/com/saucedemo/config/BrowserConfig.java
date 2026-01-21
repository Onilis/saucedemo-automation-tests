package com.saucedemo.config;

import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BrowserConfig provides configuration options for different browsers and modes.
 * Supports Chrome, Firefox, Safari with headless and other options.
 */
public class BrowserConfig {

    private static final Logger logger = LoggerFactory.getLogger(BrowserConfig.class);

    private static final boolean HEADLESS_MODE = Boolean.parseBoolean(
            System.getProperty("headless", "false"));
    private static final boolean INCOGNITO_MODE = Boolean.parseBoolean(
            System.getProperty("incognito", "false"));
    private static final String WINDOW_SIZE = System.getProperty("window.size", "1920x1080");

    /**
     * Get Chrome options based on configuration
     *
     * @return configured ChromeOptions
     */
    public static ChromeOptions getChromeOptions() {
        logger.info("Configuring Chrome options");
        ChromeOptions options = new ChromeOptions();

        // Basic options
        options.addArguments(
                "--start-maximized",
                "--disable-blink-features=AutomationControlled",
                "--disable-extensions",
                "--disable-plugins",
                "--disable-notifications",
                "--disable-popup-blocking",
                "--no-default-browser-check",
                "--window-size=" + WINDOW_SIZE
        );

        // Headless mode if enabled
        if (HEADLESS_MODE) {
            logger.info("Headless mode enabled");
            options.addArguments("--headless=new");
        }

        // Incognito mode if enabled
        if (INCOGNITO_MODE) {
            logger.info("Incognito mode enabled");
            options.addArguments("--incognito");
        }

        // Disable images to improve performance
        options.setExperimentalOption("perfLoggingPrefs", null);

        logger.debug("Chrome options configured successfully");
        return options;
    }

    /**
     * Get implicit wait timeout
     *
     * @return timeout in seconds
     */
    public static long getImplicitWaitTimeout() {
        return Long.parseLong(System.getProperty("implicit.wait", "10"));
    }

    /**
     * Get explicit wait timeout
     *
     * @return timeout in seconds
     */
    public static long getExplicitWaitTimeout() {
        return Long.parseLong(System.getProperty("explicit.wait", "10"));
    }

    /**
     * Get page load timeout
     *
     * @return timeout in seconds
     */
    public static long getPageLoadTimeout() {
        return Long.parseLong(System.getProperty("page.load.wait", "30"));
    }

    /**
     * Check if headless mode is enabled
     *
     * @return true if headless mode is on
     */
    public static boolean isHeadlessMode() {
        return HEADLESS_MODE;
    }

    /**
     * Check if incognito mode is enabled
     *
     * @return true if incognito mode is on
     */
    public static boolean isIncognitoMode() {
        return INCOGNITO_MODE;
    }
}
