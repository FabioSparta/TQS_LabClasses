package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.seljup.SeleniumJupiter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@ExtendWith(SeleniumJupiter.class)
class TqsP3Test {

    @Test
    void testWithOneChrome(ChromeDriver chromeDriver) {
        chromeDriver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(chromeDriver.getTitle(),
                containsString("JUnit 5 extension for Selenium"));
    }

    @Test
    void testWithFirefox(FirefoxDriver firefoxDriver) {
        firefoxDriver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(firefoxDriver.getTitle(),
                containsString("JUnit 5 extension for Selenium"));
    }

    @Test
    void testWithChromeAndFirefox(ChromeDriver chromeDriver,
                                  FirefoxDriver firefoxDriver) {
        chromeDriver.get("https://bonigarcia.github.io/selenium-jupiter/");
        firefoxDriver.get("https://bonigarcia.github.io/selenium-jupiter/");


        assertThat(firefoxDriver.getTitle(),
                containsString("JUnit 5 extension for Selenium"));

        assertThat(chromeDriver.getTitle(),
                containsString("JUnit 5 extension for Selenium"));

    }



    @Test
    public void tQSP2(ChromeDriver driver) {
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(674, 690));
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Mexico City']")).click();
        }
        driver.findElement(By.name("fromPort")).click();
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'Berlin']")).click();
        }
        driver.findElement(By.name("toPort")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        Assert.assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Flights from Mexico City to Berlin:"));
        driver.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Fabio");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("feafae");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Washington");
        driver.findElement(By.cssSelector(".checkbox")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        Assert.assertThat(driver.getTitle(), is("BlazeDemo Confirmation"));
    }

}