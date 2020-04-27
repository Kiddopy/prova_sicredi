package org.dbserver.sicredi.provaSicredi.auxi;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.dbserver.sicredi.provaSicredi.auxi.Browsers;
import org.dbserver.sicredi.provaSicredi.auxi.Auxi;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	protected WebDriver driver;
	public Properties informacoes;
	
	@BeforeClass
	public void setUp() throws IOException {
		Auxi auxi = new Auxi();
		informacoes = auxi.getProperties("config.properties");
		
        this.driver = Browsers.carregaDriver("chrome");
        this.driver.get(informacoes.getProperty("linkAplicacao"));
	    this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    this.driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
