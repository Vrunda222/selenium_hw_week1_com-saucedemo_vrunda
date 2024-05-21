package com_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-4 - ProjectName : com-saucedemo
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class SauceDemoMultiBrowser {
    static String browser = "edge";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;
    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else{
            System.out.println("Wrong browser name");
        }
        //Open URL.
        driver.get(baseUrl);
        // Maximise the browser window
        driver.manage().window().maximize();
        // We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Print the title of the page.
        String getTitle = driver.getTitle();
        System.out.println("Page Title: " +getTitle);
        //Print the current url.
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Page Current URL: " +currentUrl);
        //Print the page source.
        String pageSource = driver.getPageSource();
        System.out.println("Page Page Source: " +pageSource);
        //Enter the email to email field.
        WebElement emailID = driver.findElement(By.id("user-name"));
        emailID.sendKeys("standard_user");
        //Enter the password to password field.
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        //Click on Login Button.
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        loginButton.click();
        //Print the current url.
        String printCurrentUrl = driver.getCurrentUrl();
        System.out.println("Page Current URL: " +printCurrentUrl);
        //Navigate to baseUrl
        driver.navigate().to(baseUrl);
        //Refresh the page.
        driver.navigate().refresh();
        //Close the browser.
        driver.quit();
    }
}
