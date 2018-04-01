package com.saurabh.automation.flipkart;

import com.saurabh.automation.flipkart.constants.AutomationConstants;
import com.saurabh.automation.flipkart.service.AutomationService;

/**
 * Created by saurabhagrawal on 29/03/18.
 */
public class FlipkartAutomationMain {
    public static void main(String[] args) throws Exception {

        AutomationService automationService=new AutomationService();
        automationService.initWebDriver(AutomationConstants.TAG_FLIPKART);
        automationService.productBuy(AutomationConstants.TAG_FLIPKART);

    }
}
