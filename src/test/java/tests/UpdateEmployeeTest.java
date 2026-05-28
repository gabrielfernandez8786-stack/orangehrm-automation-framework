package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.EmployeePage;
import utils.BaseTest;
import utils.TestData;
import java.time.Duration;

public class UpdateEmployeeTest extends BaseTest {

    @Test
    public void testUpdateEmployee() throws InterruptedException {
        test = extent.createTest("Update Employee Test");
        test.info("Iniciando prueba de actualización de empleado");

        new LoginPage(driver).login("Admin", "admin123");
        test.info("Login completado");

        new DashboardPage(driver).goToPIM();
        test.info("Navegación a PIM completada");

        EmployeePage empPage = new EmployeePage(driver);

        if (TestData.employeeId == null || TestData.employeeId.isEmpty()) {
            test.warning("No hay ID de empleado disponible");
        } else {
            test.info("Buscando empleado con ID: " + TestData.employeeId);
        }

        // Search using employee id
        Thread.sleep(2000);
        empPage.searchEmployeeById(TestData.employeeId);
        test.info("Búsqueda de empleado ejecutada");

        // ESPERAR A QUE EL LOADER DESAPAREZCA
        Thread.sleep(3000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));

        Thread.sleep(2000);
        empPage.updateEmployee(TestData.updatedFirstName);
        test.info("Empleado actualizado - Nuevo nombre: " + TestData.updatedFirstName);

        test.pass("Actualización de empleado completada exitosamente");
    }
}