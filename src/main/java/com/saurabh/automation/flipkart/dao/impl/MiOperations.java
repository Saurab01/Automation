package com.saurabh.automation.flipkart.dao.impl;

import com.saurabh.automation.flipkart.dao.WebsiteSpecificOperations;
import com.saurabh.automation.flipkart.utils.PropertiesReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by saurabhagrawal on 01/04/18.
 */
public class MiOperations extends WebsiteSpecificOperations {
    private static Logger logger =Logger.getLogger(MiOperations.class);

    public MiOperations(WebDriver driver) {
        this.driver=driver;
    }

    @Override
    protected void login() {
        getElement(By.xpath("//input[@class='item_account' and @type='text' and @name='user' and" +
                " @placeholder='Email/Phone/Mi Account']")).sendKeys(PropertiesReader.getProperty("userName"));
        getElement(By.xpath("//input[@class='item_account' and @id='pwd' and @type='password' and" +
                " @placeholder='Password']")).sendKeys(PropertiesReader.getProperty("password"));

        getElement(By.xpath("//input[@value='Sign in' and @type='submit' and @id='login-button']")).click();

    }

    @Override
    public void productBuy() {
        driver.get(PropertiesReader.getProperty("productUrl"));
        pause(3);
        getElement(By.xpath("//div[@data-step='result']/descendant::a[text()='Buy now' and @id='J_nextBtn']")).click();
        getElement(By.xpath("//a[text()='Next']")).click();
        getElement(By.xpath("//a[text()='Checkout']")).click();
        //pause();
        login();
        addnewAddress();
        pause(1);
        confimBooking();

    }

    @Override
    protected void addnewAddress() {
        getElement(By.xpath("//div[@id='J_useNewAdd']")).click();
        pause(1);
        getElement(By.xpath("//label[.='Name']/../parent::*//input[@type='text' and @id='name']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_NAME"));
        getElement(By.xpath("//label[.='Pin-code']/../parent::*//input[@type='text' and @id='pinCode']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_PINCODE"));
        getElement(By.xpath("//label[.='Address']/../parent::*//textarea[@id='userAddress1']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_ADDRESS"));
        getElement(By.xpath("//label[.='Landmark']/../parent::*//input[@type='text' and @id='landmark']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_LANDMARK"));
        getElement(By.xpath("//label[.='City']/../parent::*//input[@type='text' and @id='city']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_CITY"));
        //getElement(By.xpath("//select[@id='UserAddressCity']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_STATE"));
        getElement(By.xpath("//label[.='Email']/../parent::*//input[@type='text' and @id='email']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_EMAIL_ADDRESS"));
        getElement(By.xpath("//label[.='Phone']/../parent::*//input[@type='text' and @id='Telephone']")).sendKeys(PropertiesReader.getProperty("CUSTOMER_PHONE_NUMBER"));

        pause(1);
        clickWhenReady(By.xpath("//div[@class='ft']/descendant::button[text()='Confirm' and @type='button']"));

    }

    @Override
    protected void confimBooking() {
        clickWhenReady(By.xpath("//input[@value='Place order' and @type='submit'and @name='Checkout[submit]']"));
    }
}
