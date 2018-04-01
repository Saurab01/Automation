package com.saurabh.automation.flipkart;

import com.saurabh.automation.flipkart.constants.AutomationConstants;
import com.saurabh.automation.flipkart.service.AutomationService;

/**
 * Created by saurabhagrawal on 01/04/18.
 */
public class MiAutomationMain {
    public static void main(String[] args) throws Exception {

        AutomationService automationService=new AutomationService();
        automationService.initWebDriver(AutomationConstants.TAG_MI);
        automationService.productBuy(AutomationConstants.TAG_MI);
    }
}
