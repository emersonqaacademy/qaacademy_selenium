import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosSelenium {

    @Test
    public void testesFormularioSelenium() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//form[1]/div[1]/div[1]/input[1]")).sendKeys("Emerson");
        driver.findElement(By.xpath("//form[1]/div[1]/div[2]/input[1]")).sendKeys("Rodrigues");
        driver.findElement(By.xpath("//form[1]//textarea[1]")).sendKeys("Rua dos Sonhos");
        driver.findElement(By.xpath("//*/form[1]/div[3]//input[1]")).sendKeys("teste@teste.com");
        driver.findElement(By.xpath("//section[1]//form[1]/div[4]//input[1]")).sendKeys("16996212196");

        Thread.sleep(5000);
        driver.quit();

    }
}
