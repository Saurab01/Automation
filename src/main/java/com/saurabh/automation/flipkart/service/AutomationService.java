package com.saurabh.automation.flipkart.service;

import com.saurabh.automation.flipkart.constants.AutomationConstants;
import com.saurabh.automation.flipkart.dao.WebsiteSpecificOperations;
import com.saurabh.automation.flipkart.factory.OpertaionsTypeFactory;
import com.saurabh.automation.flipkart.utils.PropertiesReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Collections;

/**
 * Created by saurabhagrawal on 29/03/18.
 */
public class AutomationService {

    private static Logger logger =Logger.getLogger(AutomationService.class);
    private WebDriver driver;


    public void initWebDriver(String tag) throws Exception {

        // Setting up Chrome driver path.
        System.setProperty("webdriver.chrome.driver", "libs"+ File.separator+"chromedriver");
        // Launching Chrome browser.
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        if (tag.equalsIgnoreCase(AutomationConstants.TAG_FLIPKART))
            PropertiesReader.initialize(Collections.singletonList("src" + File.separator + "main" + File.separator + "resources" + File.separator + "file_" + AutomationConstants.TAG_FLIPKART + ".properties"));
        else if (tag.equalsIgnoreCase(AutomationConstants.TAG_MI))
            PropertiesReader.initialize(Collections.singletonList("src" + File.separator + "main" + File.separator + "resources" + File.separator + "file_" + AutomationConstants.TAG_MI + ".properties"));
        else throw new Exception("invalid option , only flipkart or MI is allowed");


    }

    public void productBuy(String tag) throws Exception {
        WebsiteSpecificOperations specificOpertation = OpertaionsTypeFactory.getObjectType(tag, this.driver);
        if (specificOpertation !=null) {
            specificOpertation.productBuy();
        }
    }
}
