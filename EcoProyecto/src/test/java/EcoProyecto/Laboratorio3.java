package EcoProyecto;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Proyecto 10 casos de prueba automatizados 

public class Laboratorio3 {

    private WebDriver driver;

    @Before 
    public void setUp() {
        // Configuracion del controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "..\\EcoProyecto\\Drivers\\chromedriver.exe");
        // Inicializar el WebDriver
        driver = new ChromeDriver();
    }

    @Test @Ignore
    //CP001
    public void lab1_e1() {
        try {
            //URL de inicio de sesion	 
            driver.get("https://www.saucedemo.com/");

            // Realiza el login
            login("standard_user", "secret_sauce");

            // Espera hasta que se complete el inicio de sesion
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_container")));
            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test @Ignore
    //CP002
    public void pruebaBotonesMenu() {
        try {
            // Realiza el login antes de la prueba del menu
        	driver.get("https://www.saucedemo.com/");
            login("standard_user", "secret_sauce");
            
            WebElement primerBotonMenu = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
            primerBotonMenu.click();
            Thread.sleep(1000);
            WebElement menu = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[1]/div"));
            menu.click();
            Thread.sleep(1000);
            WebElement allItem = driver.findElement(By.xpath("//*[@id=\"inventory_sidebar_link\"]"));
            allItem.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   /* @Test @Ignore
   //CP003 Sin el ciclo for
    public void pruebaBotonesFiltro() {
        try {
            // Realiza el login antes de la prueba del menu
        	driver.get("https://www.saucedemo.com/");
            login("standard_user", "secret_sauce");
            
            WebElement botonFiltro = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
            botonFiltro.click();
            Thread.sleep(2000);
            WebElement opcion1 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]"));
            opcion1.click();
            Thread.sleep(2000);
            WebElement opcion2 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]"));
            opcion2.click();
            Thread.sleep(2000);
            WebElement opcion3 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]"));
            opcion3.click();
            Thread.sleep(2000);
            WebElement opcion4 = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]"));
            opcion4.click();
            Thread.sleep(2000);
                 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
    @Test @Ignore
    //CP003 con el ciclo for
    public void pruebaBotonesFiltro() {
        try {
            // Realiza el login antes de la prueba del menú
            driver.get("https://www.saucedemo.com/");
            login("standard_user", "secret_sauce");

            WebElement botonFiltro = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
            botonFiltro.click();
            Thread.sleep(2000);

            // Número total de opciones en el filtro
            int totalOpciones = 4;

            for (int i = 1; i <= totalOpciones; i++) {
                String opcionXPath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[" + i + "]";
                WebElement opcion = driver.findElement(By.xpath(opcionXPath));
                opcion.click();
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    @Test @Ignore
    //CP006 @Ignore
    public void pruebaCarrito() {
        try {
            // Realiza el login antes de la prueba del menú
            driver.get("https://www.saucedemo.com/");
            login("standard_user", "secret_sauce");

            WebElement primerBotonMenu = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
            primerBotonMenu.click();

            // Utilizar WebDriverWait para esperar a que la página cargue completamente
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

      
            wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/inventory-item.html?id=8")); //No encuentra el id8 
         

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test @Ignore
    //CP007
    public void pruebaProducto() {
        try {
            // Realiza el login antes de la prueba del menú
            driver.get("https://www.saucedemo.com/");
            login("standard_user", "secret_sauce");
            
            // Seleccionar Producto del inventario 
            WebElement botonAddtoCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
            botonAddtoCart.click();
            Thread.sleep(2000);

            //Click en el carrito 
            WebElement botonShoppingCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
            botonShoppingCart.click();
            Thread.sleep(2000);

            //Click en el Remove del carrito 
            WebElement botonCartRemove = driver.findElement(By.xpath("  //*[@id=\"remove-sauce-labs-backpack\"]"));
            botonCartRemove.click();
            Thread.sleep(2000);
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test @Ignore
    //CP008
    public void pruebaCierreDeSesion() {
        try {
            // Realiza el login antes de la prueba del menú
            driver.get("https://www.saucedemo.com/");
            login("standard_user", "secret_sauce");
            
            // Seleccionar el menu
            WebElement menu = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[1]/div"));
            menu.click();
            Thread.sleep(2000);
      
            // Seleccionar Logout
            WebElement menuLogout = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
            menuLogout.click();
            Thread.sleep(2000);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test @Ignore
    //CP009
    public void pruebaFormDeCompra() {
        try {
            // Realiza el login antes de la prueba del menú
            driver.get("https://www.saucedemo.com/");
            login("standard_user", "secret_sauce");
            
            agregarProductoAlCarrito();
            Thread.sleep(1000);
            
           //Click en el boton Continue para probar las validaciones
            WebElement botonCheckoutContinue = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
            botonCheckoutContinue.click();
            Thread.sleep(2000);
     
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test @Ignore
    //CP010
    public void ProcesodeCheckout () {
        try {
            // Realiza el login antes de la prueba del menú
            driver.get("https://www.saucedemo.com/");
            login("standard_user", "secret_sauce");
            
            Thread.sleep(1000);
            agregarProductoAlCarrito();
            Thread.sleep(1000);
            // Click en el botón Checkout

            // Completar el formulario
            WebElement campoFirstName = driver.findElement(By.id("first-name"));
            campoFirstName.sendKeys("NombreEjemlo");

            WebElement campoLastName = driver.findElement(By.id("last-name"));
            campoLastName.sendKeys("ApellidoEjemplo");

            WebElement campoPostalCode = driver.findElement(By.id("postal-code"));
            campoPostalCode.sendKeys("12345");
            Thread.sleep(1000);
            
            // Click en el boton Continue
            WebElement botonContinue = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
            botonContinue.click();
            Thread.sleep(1000);
            
            //Click en el boton Finish
            WebElement botonFinish = driver.findElement(By.xpath("//button[@id='finish']"));
            botonFinish.click();
            Thread.sleep(1000);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test 
    //CP011
    public void ProcesodeCheckoutSinProductos () {
        try {
            // Realiza el login antes de la prueba del menú
            driver.get("https://www.saucedemo.com/");
            login("standard_user", "secret_sauce");
            
            //Click en el carrito 
            WebElement botonShoppingCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
            botonShoppingCart.click();
         
          //Click en el boton Checkout
            WebElement botonCheckout = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
            botonCheckout.click();
            
            // Completar el formulario
            WebElement campoFirstName = driver.findElement(By.id("first-name"));
            campoFirstName.sendKeys("NombreEjemlo");

            WebElement campoLastName = driver.findElement(By.id("last-name"));
            campoLastName.sendKeys("ApellidoEjemplo");

            WebElement campoPostalCode = driver.findElement(By.id("postal-code"));
            campoPostalCode.sendKeys("12345");
            Thread.sleep(1000);
            
            // Click en el boton Continue
            WebElement botonContinue = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
            botonContinue.click();
            Thread.sleep(1000);
            
            //Click en el boton Finish
            WebElement botonFinish = driver.findElement(By.xpath("//button[@id='finish']"));
            botonFinish.click();
            Thread.sleep(1000);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
    @After
    public void tearDown() {
        // Cierra el navegador al finalizar la prueba
        if (driver != null) {
            driver.quit();
        }
    }

    private void login(String username, String password) {
        WebElement campoUsuario = driver.findElement(By.id("user-name"));
        campoUsuario.sendKeys(username);

        WebElement campoContrasenia = driver.findElement(By.id("password"));
        campoContrasenia.sendKeys(password);

        WebElement botonInicioSesion = driver.findElement(By.id("login-button"));
        botonInicioSesion.click();
    }
    
    private void agregarProductoAlCarrito() {
    	// Seleccionar Producto del inventario 
        WebElement botonAddtoCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        botonAddtoCart.click();
        
        //Click en el carrito 
        WebElement botonShoppingCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        botonShoppingCart.click();
     
      //Click en el boton Checkout
        WebElement botonCheckout = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
        botonCheckout.click();
    	
    }
}

