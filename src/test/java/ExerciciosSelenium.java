import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        driver.manage().window().maximize();

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
        //Languages
        /*Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='msdd']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Norwegian')]")).click();
        boolean idiomaSelecionado = driver.findElement(By.xpath("//div[contains(text(),'Norwegian')]")).isDisplayed();
        Assert.assertTrue(idiomaSelecionado);*/

        //Skills lista tipo OPTION
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='Skills']"));
        Select selectObjeto = new Select(selectElement);
        selectObjeto.selectByVisibleText("Java");

        //Paises lista tipo LI
        driver.findElement(By.xpath("//section[1]//div[10]/div[1]/span[1]/span[1]/span[1]")).click();
        driver.findElement(By.xpath("//li[contains(text(),'New Zealand')]")).click();
        Assert.assertTrue("elemento nao localizado", driver.findElement(By.xpath("//*[@id='select2-country-container']")).isDisplayed());

        //Select ano aniversario
        WebElement selectAnoAniversario = driver.findElement(By.xpath("//select[@id='yearbox']"));
        Select anoAniversario = new Select(selectAnoAniversario);
        anoAniversario.selectByVisibleText("1992");
        //Select mes
        WebElement selectMesAniversario = driver.findElement(By.xpath("//select[@placeholder='Month']"));
        Select mesAniversario = new Select(selectMesAniversario);
        mesAniversario.selectByVisibleText("December");
        //Select dia
        WebElement selectDiaAniversario = driver.findElement(By.xpath("//select[@id='daybox']"));
        Select diaAniversario = new Select(selectDiaAniversario);
        diaAniversario.selectByVisibleText("22");

        //First password
        driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("123456");
        //Second password
        driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("123456");

        //Submit buttom
        driver.findElement(By.xpath("//button[@id='submitbtn']")).click();

        Thread.sleep(2000);
        driver.quit();

    }
}
