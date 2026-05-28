package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void testInvalidLogin() {
        test = extent.createTest("Invalid Login Test");
        test.info("Iniciando prueba de login con credenciales inválidas");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("WrongUser", "WrongPass");
        test.info("Credenciales inválidas ingresadas: WrongUser / WrongPass");

        String errorMessage = loginPage.getErrorMessage();
        test.info("Mensaje de error recibido: " + errorMessage);

        Assert.assertEquals(errorMessage, "Invalid credentials", "Unexpected error message!");

        test.pass("Login inválido correctamente validado - Mensaje de error: " + errorMessage);
    }
}
