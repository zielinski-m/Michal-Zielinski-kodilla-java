package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String XPATH_COOKIE_BUTTON = "/html/body/div[3]/div[2]/div/div/div/div/div[4]/button[2]";
    public static final String XPATH_CREATE_NEW_ACCOUNT = "/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a";
    public static final String XPATH_DAY_SELECT = "//select[@id='day']";
    public static final String XPATH_MONTH_SELECT = "//*[@id='month']";
    public static final String XPATH_YEAR_SELECT = "//*[@id='year']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://facebook.com/");

        //1. Cookies accepted
        WebElement cookiesButton = driver.findElement(By.xpath(XPATH_COOKIE_BUTTON));
        cookiesButton.click();

        //2. New account
        WebElement createAccountButton = driver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT));
        createAccountButton.click();

        //3. Day select
        WebElement selectBirthDay = driver.findElement(By.xpath(XPATH_DAY_SELECT));
        Select selectDay = new Select(selectBirthDay);
        selectDay.selectByIndex(10);

        //4. Month select
        WebElement selectBirthMonth = driver.findElement(By.xpath(XPATH_MONTH_SELECT));
        Select selectMonth = new Select(selectBirthMonth);
        selectMonth.selectByIndex(10);

        //5. Year select
        WebElement selectBirthYear = driver.findElement(By.xpath(XPATH_YEAR_SELECT));
        Select selectYear = new Select(selectBirthYear);
        selectYear.selectByValue("1911");
        }
}
