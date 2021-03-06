package com.saurabh.automation.flipkart.dao;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by saurabhagrawal on 01/04/18.
 */
public abstract class WebsiteSpecificOperations {

    protected WebDriver driver;

    protected abstract void login();
    public abstract void productBuy();

    protected WebElement getElement(final By locator) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver arg0) {
                return arg0.findElement(locator);
            }

        });

        return element;
    }

    protected void pause(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            // TBD: Auto-generated catch block.
            e.printStackTrace();
        }
    }
    protected void clickWhenReady(final By locator) {

        WebElement element=getElement(locator);
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Actions act=new Actions(driver);
        act.moveToElement(element).click().build().perform();
       // element.click();
    }

    protected abstract void addnewAddress();

    protected abstract void confimBooking();
}
