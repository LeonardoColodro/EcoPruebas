package EcoProyecto;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

//Prueba de Funcionamiento del proyecto 1

public class Laboratorio2 {
	
    @Test
    public void lab1_e1() {
        //Controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "..\\EcoProyecto\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Inicializa el WebDriver
     
        try {
            // Navega a la URL de inicio de sesión	 
            driver.get("https://www.saucedemo.com/");

            // Localiza y completa el campo de usuario
            WebElement campoUsuario = driver.findElement(By.id("user-name"));
            campoUsuario.sendKeys("standard_user");
            //*[@id="user-name"]

            // Localiza y completa el campo de contrasenia
            WebElement campoContrasenia = driver.findElement(By.id("password"));
            campoContrasenia.sendKeys("secret_sauce");
            //*[@id="password"]
            
            // Localiza y hace clic en el boton de inicio de sesion
            WebElement botonInicioSesion = driver.findElement(By.id("login-button"));
            botonInicioSesion.click();
            //*[@id="login-button"]

            //Thread.sleep(4000);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_container")));
            Thread.sleep(4000);         
          
        } catch (Exception e) {
            // Manejo de excepciones si algo sale mal durante la ejecucion
            e.printStackTrace();
        } finally {
            // Cierra el navegador al finalizar
            driver.quit();
        }
    }
    
}

