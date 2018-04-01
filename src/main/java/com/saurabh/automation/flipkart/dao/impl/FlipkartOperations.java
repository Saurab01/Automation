package com.saurabh.automation.flipkart.dao.impl;

import com.saurabh.automation.flipkart.dao.WebsiteSpecificOperations;
import com.saurabh.automation.flipkart.utils.PropertiesReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by saurabhagrawal on 01/04/18.
 */
public class FlipkartOperations extends WebsiteSpecificOperations {
    private static Logger logger =Logger.getLogger(FlipkartOperations.class);

    public FlipkartOperations(WebDriver driver) {
        this.driver=driver;
    }

    @Override
    public void login() {
        getElement(By.xpath("//span[.='Enter Email/Mobile number']/../../parent::*//input[@type='text']")).sendKeys(PropertiesReader.getProperty("userName"));
        getElement(By.xpath("//span[.='Enter Password']/../../parent::*//input[@type='password']")).sendKeys(PropertiesReader.getProperty("password"));
        getElement(By.xpath("//button[@type='submit' and ./span/text()='Login']")).click();
    }

    @Override
    public void productBuy() {
        driver.get(PropertiesReader.getProperty("productUrl"));
        getElement(By.xpath("//a[text()='Login & Signup']")).click();
        pause(1);
        login();
        pause(1);
        getElement(By.xpath("//button[@type='button' and text()='BUY NOW']")).click();
        pause(1);
        addnewAddress();
        confimBooking();

    }

    @Override
    protected void addnewAddress() {
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

    @Override
    protected void confimBooking() {
        getElement(By.xpath("//button[.='CONTINUE']")).click();
        driver.findElement(By.xpath("//button[.='Confirm']"));

    }
}
