package net.javaguides.springboot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestNG {
    
    @Test
    public void sampleTestMethod() throws InterruptedException{
       
        System.setProperty("webdriver.firefox.bin",
                    "C:\\Users\\just-\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:3000");
        driver.findElement(By.id("addemployee")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("firstname")).sendKeys("SeleniumFirstname");
        driver.findElement(By.id("lastname")).sendKeys("SeleniumLastname");
        driver.findElement(By.id("email")).sendKeys("selmail@gmailcom");
        Thread.sleep(1000);
        driver.findElement(By.id("saveButton")).click();

        Thread.sleep(5000);
        driver.quit();
    }
    
}
