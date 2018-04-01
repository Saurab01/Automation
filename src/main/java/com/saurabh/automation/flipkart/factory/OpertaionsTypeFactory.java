package com.saurabh.automation.flipkart.factory;

import com.saurabh.automation.flipkart.constants.AutomationConstants;
import com.saurabh.automation.flipkart.dao.WebsiteSpecificOperations;
import com.saurabh.automation.flipkart.dao.impl.FlipkartOperations;
import com.saurabh.automation.flipkart.dao.impl.MiOperations;
import org.openqa.selenium.WebDriver;

/**
 * Created by saurabhagrawal on 01/04/18.
 */
public class OpertaionsTypeFactory {
    private static WebsiteSpecificOperations specificOpertation;

    public static WebsiteSpecificOperations getObjectType(String tag, WebDriver driver) throws Exception {

        if (tag.equalsIgnoreCase(AutomationConstants.TAG_FLIPKART)) {
            specificOpertation=new FlipkartOperations(driver);
        }
        else if (tag.equalsIgnoreCase(AutomationConstants.TAG_MI)) {
            specificOpertation=new MiOperations(driver);
        }
        else
            throw new Exception("invalid option , only flipkart or MI is allowed");
        return specificOpertation;
    }
}
