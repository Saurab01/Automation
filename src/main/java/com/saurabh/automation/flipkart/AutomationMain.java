package com.saurabh.automation.flipkart;

import com.saurabh.automation.flipkart.service.AutomationService;

/**
 * Created by saurabhagrawal on 01/04/18.
 */
public class AutomationMain {

    public static void main(String[] args) throws Exception {

        AutomationService automationService=new AutomationService();
        automationService.initWebDriver(args[0]);
        automationService.productBuy(args[0]);

    }
}
