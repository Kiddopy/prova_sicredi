package org.dbserver.sicredi.provaSicredi.auxi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Browsers {

    public static WebDriver carregaDriver(String browser) {

        final ChromeOptions optionsChrome = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser.toLowerCase()) {
            case "chrome":
                optionsChrome.addArguments("--start-maximized");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "ie":
                WebDriverManager.iedriver().setup();
                capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
                return new InternetExplorerDriver(capabilities);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                return new FirefoxDriver(capabilities);
            case "grid":
                try {
                    capabilities.setBrowserName("chrome");
                    return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            default:
                return null;
        }
    }
}
