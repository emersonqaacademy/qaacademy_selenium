import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDropElementUploadFoto {
    static WebDriver driver;
    static ChromeOptions options;

    @Before
    public void iniciaBrowser(){
        setupChrome();
        driver.get("https://demo.automationtesting.in/Static.html");
    }

    @Test
    public void testeDragAndDrop(){
        WebElement elementoInicial = driver.findElement(By.xpath("//img[@id='node']")); //Elemento inicial
        WebElement areaDestino = driver.findElement(By.xpath("//div[@id='droparea']")); //Area destino do elemento
        Actions acaoResponsavel = new Actions(driver); //Cria instancia do navegador que vai receber a acao
        acaoResponsavel.dragAndDrop(elementoInicial, areaDestino).build().perform();
    }

    @Test
    public void testeUploadFoto() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        driver.findElement(By.xpath("//input[@id='imagesrc']"))
                .sendKeys("/Users/emersonrodrigues/Desktop/QA Academy/projects_aulas/qaacademy_selenium/src/test/java/fototeste.jpeg");
        Thread.sleep(2000);
    }

    public void setupChrome(){
        options = new ChromeOptions();
        options.setHeadless(false);
        options.setAcceptInsecureCerts(true);
        options.addArguments("disable-popup-blocking");
        options.addArguments("--window-size=1810,1000");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
