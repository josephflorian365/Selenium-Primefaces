/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author jesus
 */
public class ClienteCIT {

    @Test
    public void testSimple() throws Exception {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new ChromeDriver();

        // And now use this to visit NetBeans
        driver.get("http://localhost:8080/SeleniumPrimefaces/faces/Cliente.xhtml");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.netbeans.org");

        // Check the title of the page
        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().contains("Cliente");
//            }
//        });
        //declare variables 
        WebElement code;
        WebElement first_name;
        WebElement last_name;
        WebElement dni;
        WebElement mobile;
        WebElement address;
        WebElement location;

        //search id or name
        code = driver.findElement(By.xpath("//*[@id='form:codecli']"));
        first_name = driver.findElement(By.xpath("//*[@id='form:firstcli']"));
        last_name = driver.findElement(By.xpath("//*[@id='form:lastcli']"));
        dni = driver.findElement(By.xpath("//*[@id='form:dnicli']"));
        mobile = driver.findElement(By.xpath("//*[@id='form:mobilecli']"));
        address = driver.findElement(By.xpath("//*[@id='form:addresscli']"));
        location = driver.findElement(By.xpath("//*[@id='form:locationcli']"));
        //driver.findElement(By.id("form:locationcli_label")).click();
        //driver.findElement(By.xpath("//div[@id='form:locationcli_label']/ul/li[text()='item value']")).click();

        //send
        code.sendKeys("12");
        first_name.sendKeys("Jesus");
        last_name.sendKeys("Florian");
        dni.sendKeys("75365805");
        mobile.sendKeys("933495871");
        address.sendKeys("Miguel Grau");
        location.sendKeys("150101");
        
        //Close the browser
        //driver.quit();
    }

}
