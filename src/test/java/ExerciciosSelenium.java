import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExerciciosSelenium {

    @Test
    public void testesFormularioSelenium() throws InterruptedException {
        String generoFemale = "//section[@id='section']//form[1]/div[5]/div[1]/label[2]/input[1]";


        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

        //Close Toolbar
        WebElement adToolbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ins[2]/div[1]")));
        if (adToolbar.isDisplayed()){
            adToolbar.click();
        }
        else {
            System.out.println("Elemento não localizado");
        }

        //FirstName
        driver.findElement(By.xpath("//form[1]/div[1]/div[1]/input[1]")).sendKeys("Emerson");
        //LastName
        driver.findElement(By.xpath("//form[1]/div[1]/div[2]/input[1]")).sendKeys("Rodrigues");
        //Endereco
        driver.findElement(By.xpath("//form[1]//textarea[1]")).sendKeys("Rua dos Sonhos");
        //Email
        driver.findElement(By.xpath("//*/form[1]/div[3]//input[1]")).sendKeys("teste@teste.com");
        //Telefone
        driver.findElement(By.xpath("//section[1]//form[1]/div[4]//input[1]")).sendKeys("16996212196");
        //Genero
        driver.findElement(By.xpath(generoFemale)).click();
        Assert.assertTrue("Elemento nao localizado", driver.findElement(By.xpath(generoFemale)).isSelected());
        //Hobbies
        driver.findElement(By.xpath("//input[@value='Movies']")).click();
        Assert.assertTrue("Elemento nao selecionado", driver.findElement(By.xpath("//section[1]//div[6]//div[2]/input[1]")).isSelected());


        Thread.sleep(2000);
        driver.quit();

    }
}
