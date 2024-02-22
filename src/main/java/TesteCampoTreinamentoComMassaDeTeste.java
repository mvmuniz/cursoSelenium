import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class TesteCampoTreinamentoComMassaDeTeste {

    private WebDriver driver;
    private String filePath = "./src/main/resources/massa.xls";

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/maris/Documents/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///C:/Users/maris/Documents/componentes.html");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void preencherCamposComMassaDeTeste() throws IOException {
        // Ler dados da planilha Excel
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0); // Supondo que os dados estão na primeira planilha

        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);

            // Obtém dados da célula da coluna 'Nome' (supondo que a coluna 'Nome' está na coluna 0)
            String nome = row.getCell(0).getStringCellValue();

            // Preenche o campo de Nome
            driver.findElement(By.id("elementosForm:nome")).sendKeys(nome);

            // Obtém dados da célula da coluna 'Sugestoes' (supondo que a coluna 'Sugestoes' está na coluna 1)
            String sugestoes = row.getCell(1).getStringCellValue();

            // Preenche o campo de Sugestoes
            driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(sugestoes);

            // Realize outras ações com base nos dados da planilha

            // Exemplo de verificação se o campo de Nome foi preenchido corretamente
            Assert.assertEquals(nome, driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

            // Exemplo de verificação se o campo de Sugestoes foi preenchido corretamente
            Assert.assertEquals(sugestoes, driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

            // Feche o navegador após cada iteração
            driver.quit();

            // Configure o navegador novamente para a próxima iteração
            driver = new FirefoxDriver();
            driver.manage().window().setSize(new Dimension(1200, 765));
            driver.get("file:///C:/Users/maris/Documents/componentes.html");
        }

        // Feche o arquivo Excel após o uso
        workbook.close();
        fileInputStream.close();
    }
}