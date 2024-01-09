package EcoProyecto;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//Prueba de Funcionamiento del proyecto 1

public class Laboratorio1 {
	@Test @Ignore
	public void lab1_test() {
		System.out.println("Hola mundo de automatizacion");
	}
	
	@Test 
	public void lab1_e1() {
		System.setProperty("webdriver.chrome.driver", "..\\EcoProyecto\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//driver.get("http://www.automationpractice.pl/index.php");
		driver.navigate().to("https://www.saucedemo.com/");
		driver.close();
	}
	
	//Prueba de diver FireFox
	@Test @Ignore  
	public void lab1_e2() {
	//	System.setProperty("webdriver.gecko.driver", "C:\\ruta\\completa\\hacia\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "..\\EcoProyecto\\Drivers\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		//driver.get("http://www.automationpractice.pl/index.php");
		driver.navigate().to("http://www.automationpractice.pl/index.php");
		driver.close();
	}
}

