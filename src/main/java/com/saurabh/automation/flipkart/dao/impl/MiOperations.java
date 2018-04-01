package com.saurabh.automation.flipkart.dao.impl;

import com.saurabh.automation.flipkart.dao.WebsiteSpecificOperations;
import org.apache.log4j.Logger;
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

    }

    @Override
    public void productBuy() {

    }

    @Override
    protected void addnewAddress() {

    }

    @Override
    protected void confimBooking() {

    }
}
