package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends AbstractBasePage {

    private final By emailFieldLocator = By.id("email");
    private final By passwordFieldLocator = By.id("pass");
    private final By signInButton = By.id("send2");


    public LoginPage(WebDriver driver){
        super(driver);
        if (!driver.getTitle().equals("Customer Login")) {
            throw new IllegalStateException("This is not the customer login page," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    @Override
    public String getPagePart() {
        return "";
    }

    public void login(String userName, String password){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(e->e.findElement(emailFieldLocator).isDisplayed());

        WebElement userNameField = driver.findElement(emailFieldLocator);
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        WebElement submitButton = driver.findElement(signInButton);

        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();

    }
}
