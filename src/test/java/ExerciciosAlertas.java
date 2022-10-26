import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExerciciosAlertas {

    static WebDriver driver;
    static WebDriverWait wait;
    static ChromeOptions options;

    @Before
    public void iniciaTeste(){
        options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    @Test
    public void testAlertaSimples() {
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemEsperada = "I am an alert box!";
        String mensagemAlerta = alert.getText();
        alert.accept();
        Assert.assertEquals("Elemento nao localizado", mensagemEsperada, mensagemAlerta);
    }

    @Test
    public void testAlertaOkeCancela() {
        driver.findElement(By.xpath("//a[contains(text(), 'Alert with OK & Cancel ')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemEsperada = "Press a Button !";
        String mensagemAlerta = alert.getText();
        alert.dismiss();
        Assert.assertEquals("Mensagem nao localizada", mensagemEsperada, mensagemAlerta);
    }

    @Test
    public void testAlertaComPrompt(){
        driver.findElement(By.xpath("//a[contains(text(), 'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("QA Academy");
        alert.accept();
        String mensagemAtual = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        String mensagemEsperada = "Hello QA Academy How are you today";
        Assert.assertEquals("Mensagem nao localizada", mensagemEsperada, mensagemAtual);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
