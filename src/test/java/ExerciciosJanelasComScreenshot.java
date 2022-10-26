import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExerciciosJanelasComScreenshot {

    static WebDriver driver;
    static ChromeOptions options;

    @Before
    public void iniciaBrowser(){
        options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Windows.html");
    }

    public void screenShot(String nomeScreenShot) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("output" + File.separator + nomeScreenShot + "_screenshot.jpg"));
    }

    @Test
    public void abrirNovaTab() throws IOException {
        driver.findElement(By.linkText("click")).click();
        Object[] janelas = driver.getWindowHandles().toArray(); //mapeando janelas
        driver.switchTo().window(janelas[1].toString());
        Assert.assertTrue(driver.getPageSource().contains("Selenium automates"));
        screenShot("abrirnovatab");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/"));
    }

    @Test
    public void abrirNovaJanela() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//div[1]/ul/li[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Object[] janelas = driver.getWindowHandles().toArray(); //mapeando janelas
        driver.switchTo().window(janelas[1].toString());
        Assert.assertTrue(driver.getPageSource().contains("Selenium automates"));
        screenShot("abrirnovajanela");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/"));
    }

    @After
    public void fecharBrowser(){
        driver.quit();
    }
}
