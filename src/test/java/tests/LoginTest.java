package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        test = extent.createTest("Login Test");
        test.info("Iniciando prueba de login con credenciales válidas");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        test.info("Credenciales ingresadas");

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Login Failed - Dashboard not visible!");

        test.pass("Login exitoso - Dashboard visible");
    }
}