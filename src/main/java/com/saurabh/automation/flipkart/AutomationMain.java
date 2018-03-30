package com.saurabh.automation.flipkart;

import com.saurabh.automation.flipkart.service.AutomationService;

/**
 * Created by saurabhagrawal on 29/03/18.
 */
public class AutomationMain {
    public static void main(String[] args) throws InterruptedException {

        AutomationService automationService=new AutomationService();
        automationService.initWebDriver("http://www.flipkart.com");
        //automationService.flipkartLogin();
        automationService.productBuy();




    }
}
