package org.example;

import org.openqa.selenium.WebDriver;

public abstract class AbstractBasePage {

    protected WebDriver driver;

    public AbstractBasePage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get("https://magento.softwaretestingboard.com" + getPagePart());
    }

    public abstract String getPagePart();
}
