package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class HomePage extends AbstractBasePage{

        private final By signInLink = By.linkText("Sign In");

        public HomePage(WebDriver driver) {
            super(driver);
        }

        @Override
        public String getPagePart() {
            return "";
        }

        public LoginPage clickSignInLink(){
            driver.findElement(signInLink).click();
            return new LoginPage(driver);
        }
}
