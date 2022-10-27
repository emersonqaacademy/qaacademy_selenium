import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ExercicioNovaFrame {

    static WebDriver driver;
    static ChromeOptions options;

    @Before
    public void iniciarBrowser(){
        options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Frames.html");
    }

    @Test
    public void testeIframe(){
        driver.switchTo().frame("singleframe"); //muda o contexto e seleciona o frame desejado
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Teste QA Academy");
        driver.switchTo().defaultContent(); //volta para o contexto anterior
    }

    @After
    public void closeTeste() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
