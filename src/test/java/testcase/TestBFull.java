package testcase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import page.BuscarSuportesPage;
import page.MenuPage;
import page.PendenciasPage;
import page.TreinamentosPage;

import common.TestCaseCommon;
//import org.openqa.selenium.By;

public class TestBFull {


	private StringBuffer verificationErrors = new StringBuffer();


	@Before
	public void setUp() throws Exception {
			TestCaseCommon.getDriver().get(TestCaseCommon.URL_BASE + "/");
	}
	
  	
	

	@Test
	public void buscarTreinamentoDeUsuarios()  {//throws Exception {
				
		MenuPage AbreTela = new MenuPage();
		AbreTela.AbreTelaTreinamento();
		
		TreinamentosPage NovaBusca = new TreinamentosPage(); 
		Boolean retorno = NovaBusca.BuscarTreinamento("Roberto");
	    assertTrue(retorno);
	}
	
		
	  @Test
	  public void expandirSuportePendente() throws Exception {
		  
			PendenciasPage ExpandirSuporte = new PendenciasPage();
			boolean RetornoDeClick = ExpandirSuporte.ExpandirTreinamentoPendente();
			assertTrue(RetornoDeClick );
	  }
	  
	  @Test
	  public void verificaCalendarioTreinamentos() throws Exception {
		  
		  MenuPage Calendario = new MenuPage();
		  Boolean retornoCalendario = Calendario.ChamaCalendario();	 
		  assertTrue (retornoCalendario);
	  }
	
	  
	  
		@Test
		public void buscaSuporteSemFiltro()  {//throws Exception {
			
			MenuPage TelaMenu = new MenuPage();
			TelaMenu.AbreTelaBuscarSuportes();
			
			BuscarSuportesPage BuscarSuporte = new BuscarSuportesPage();
			String retorno = BuscarSuporte.BuscarTreinamentoPorNome();
			assertThat("0", is(not(retorno))); 
			
			//TelaMenu.FecharBrowser();
			//TestCaseCommon.getDriver().quit();
		}
			
		 @Test
		  public void testVerificaElementosAoIniciar() throws Exception {
			  
				MenuPage VerificarElementos = new MenuPage();
				VerificarElementos.setObjetos();

				ArrayList<String> RetornoDeObjetos = VerificarElementos.getObjetos();

				assertEquals("Sair", RetornoDeObjetos.get(0));
				assertEquals("Elipse Care", RetornoDeObjetos.get(1));
				assertEquals("Treinamentos", RetornoDeObjetos.get(2));
				assertEquals("E-mails Treinamento", RetornoDeObjetos.get(3));
}	

		  @Test
		  public void verificaAcessoMenuDisponibilidadeDeUsuario() throws Exception {
			  

				MenuPage AdminPage = new MenuPage();
				AdminPage.AbreTelaConfiguracoes();
				assertEquals("Admin", AdminPage.verificaAcessoAdmin());
				System.out.println(AdminPage.verificaAcessoAdmin());
				AdminPage.AbreTelaAdmin();
				
			
		  }
		  
		  @Test
		  public void verificaAcessoMenuBotaoSair() throws Exception {
			
			 
			 
				MenuPage SairApp = new MenuPage();
				SairApp.setObjetos();
				//ArrayList<String> RetornoDeObjetos = SairApp.getObjetos();
				//System.out.println(RetornoDeObjetos.get(0));
			    //assertEquals("Sair", RetornoDeObjetos.get(0));
			    assertEquals("Sair", SairApp.getObjetoSair());
			   // SairApp.FecharBrowser();
		  }
//		  
		  @After
			public void tearDown() throws Exception {
				

				String verificationErrorString = verificationErrors.toString();
				if (!"".equals(verificationErrorString)) {
					fail(verificationErrorString);
				}
				//TestCaseCommon.getDriver().close();
			}
		 
}
