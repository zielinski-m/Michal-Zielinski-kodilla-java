package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CrudAppTestingApp{
    public static final String XPATH_INPUT = "/html/body/main/section[1]/form/fieldset[1]/label[2]";
    public static final String XPATH_TEXTAREA = "/html/body/main/section[1]/form/fieldset[2]/label[2]/textarea";
    public static final String XPATH_WAIT_FOR = "/select[1]";
    public static final String XPATH_SELECT = "/html/body/main/section[2]/div/form/div/fieldset[2]/select[1]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://zielinski-m.github.io/");

        WebElement searchField = driver.findElement(By.xpath(XPATH_INPUT));
        searchField.sendKeys("New robotic task");

        WebElement textareaField = driver.findElement(By.xpath(XPATH_TEXTAREA));
        textareaField.sendKeys("The robotic content");

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);
    }
}