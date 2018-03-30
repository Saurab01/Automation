package com.saurabh.automation.flipkart.service;

import com.saurabh.automation.flipkart.utils.PropertiesReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by saurabhagrawal on 29/03/18.
 */
public class AutomationService {

    private static Logger logger =Logger.getLogger(AutomationService.class);

    private WebDriver driver;

    public void initWebDriver(String URL) throws InterruptedException {

        // Setting up Chrome driver path.
        System.setProperty("webdriver.chrome.driver", "libs"+ File.separator+"chromedriver");
        // Launching Chrome browser.
        driver = new ChromeDriver();
        PropertiesReader.initialize(Arrays.asList("src"+File.separator+"main"+File.separator+"resources"+File.separator+"file.properties"));
        //driver.get(URL);
        //driver.manage().window().maximize();
    }

    public void flipkartLogin() {
        //driver.findElement(By.linkText("Login & Signup")).click();

        getElement(By.xpath("//span[.='Enter Email/Mobile number']/../../parent::*//input[@type='text']")).sendKeys(PropertiesReader.getProperty("userName"));
        getElement(By.xpath("//span[.='Enter Password']/../../parent::*//input[@type='password']")).sendKeys(PropertiesReader.getProperty("password"));
        getElement(By.xpath("//button[@type='submit' and ./span/text()='Login']")).click();
    }

    private WebElement getElement(final By locator) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver arg0) {
                return arg0.findElement(locator);
            }

        });

        return element;
    }

    public void productBuy() {
        driver.get(PropertiesReader.getProperty("productUrl"));
        getElement(By.xpath("//a[text()='Login & Signup']")).click();
        pause();
        flipkartLogin();
        pause();
        getElement(By.xpath("//button[@type='button' and text()='BUY NOW']")).click();
        pause();
        addnewAddress();
        confimBooking();

    }

    private void addnewAddress() {
        getElement(By.xpath("//div[text()='Add a new address']")).click();
        getElement(By.xpath("//label[.='Name']/../parent::*//input[@type='text' and @name='name']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_NAME"));
        getElement(By.xpath("//label[.='Phone Number']/../parent::*//input[@type='text' and @name='phone']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_PHONE_NUMBER"));
        getElement(By.xpath("//label[.='Pincode']/../parent::*//input[@type='text' and @name='pincode']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_PINCODE"));
        getElement(By.xpath("//label[.='Locality']/../parent::*//input[@type='text' and @name='addressLine2']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_LOCALITY"));
        getElement(By.xpath("//label[.='Address (Area and Street)']/../parent::*//textarea[@name='addressLine1']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_ADDRESS"));
        getElement(By.xpath("//label[.='City/District/Town']/../parent::*//input[@type='text' and @name='city']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_CITY"));
        getElement(By.xpath("//select[@name='state']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_STATE"));
        getElement(By.xpath("//label[.='Landmark (Optional)']/../parent::*//input[@type='text' and @name='landmark']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_LANDMARK"));
        getElement(By.xpath("//button[@type='button' and .='Save and Deliver Here']")).click();
        getElement(By.xpath("//button[.='Confirm']")).click();

    }

    private void confimBooking() {
        getElement(By.xpath("//button[.='CONTINUE']")).click();
        driver.findElement(By.xpath("//button[.='Confirm']"));

    }

    private void pause(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TBD: Auto-generated catch block.
            e.printStackTrace();
        }
    }
}
