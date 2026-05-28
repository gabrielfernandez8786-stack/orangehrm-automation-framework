package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import utils.BaseTest;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        test = extent.createTest("Logout Test");
        test.info("Iniciando prueba de cierre de sesión");

        new LoginPage(driver).login("Admin", "admin123");
        test.info("Login completado con credenciales válidas");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.logout();
        test.info("Cierre de sesión ejecutado");

        boolean isLoginPage = driver.getCurrentUrl().contains("login");
        Assert.assertTrue(isLoginPage, "Logout failed!");

        test.pass("Cierre de sesión exitoso - Redirigido a página de login");
    }
}