import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	@Test
    public void teste() {
		  // Configurar o ChromeDriver para aceitar conexões de qualquer endereço IP
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=");
        // Correção na definição da propriedade do sistema
       // System.setProperty("webdriver.gecko.driver", "C:/Users/maris/Documents/geckodriver.exe");
       System.setProperty("webdriver.chrome.driver", "C:/Users/maris/Documents/chromedriver.exe");
        // Inicialize o FirefoxDriver
       // WebDriver driver = new FirefoxDriver();
       // Inicializar o ChromeDriver
       // Inicializar o ChromeDriver com as opções configuradas
       WebDriver driver = new ChromeDriver(options);
         
      driver.manage().window().setSize(new Dimension(1200 ,765));
        // Abra o site do Google
        driver.get("https://www.google.com");

        // Verificar se o título da página é "Google"
        Assert.assertEquals("Google", driver.getTitle());

        // Feche o navegador
     //   driver.quit();
    }
}