package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.TestCaseCommon;



public class BuscarSuportesPage {  
	private WebElement buttonPesquisar;
	private WebElement ResultadoBusca;
	
	public BuscarSuportesPage() {
		
	
//		buttonPesquisar = TestCaseCommon.getDriver().findElement(By.cssSelector("input.botao.submit"));
		buttonPesquisar = TestCaseCommon.getDriver().findElement(By.xpath("(//a[@id='suporteA']/div)[3]"));
		ResultadoBusca = TestCaseCommon.getDriver().findElement(By.cssSelector("b"));
		
	}
	
	public String BuscarTreinamentoPorNome() {
		System.out.println("EntrouBuscarTreinamento");
		    new Select(TestCaseCommon.getDriver().findElement(By.id("usuario"))).selectByVisibleText("Daniel Link de Rosso");
		    buttonPesquisar.click();
		    return  ResultadoBusca.getText();
	}
}
