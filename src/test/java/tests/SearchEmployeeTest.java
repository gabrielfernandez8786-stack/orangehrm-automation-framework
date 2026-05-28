package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.EmployeePage;
import utils.BaseTest;
import utils.TestData;

public class SearchEmployeeTest extends BaseTest {

    @Test
    public void testSearchEmployee() {
        test = extent.createTest("Search Employee Test");
        test.info("Iniciando prueba de búsqueda de empleado");

        new LoginPage(driver).login("Admin", "admin123");
        test.info("Login completado");

        new DashboardPage(driver).goToPIM();
        test.info("Navegación a PIM completada");

        EmployeePage empPage = new EmployeePage(driver);

        if (TestData.employeeId == null || TestData.employeeId.isEmpty()) {
            test.info("No hay ID de empleado disponible, la búsqueda se realizará vacía");
        } else {
            test.info("Buscando empleado con ID: " + TestData.employeeId);
        }

        // Search using employee id
        empPage.searchEmployeeById(TestData.employeeId);
        test.info("Búsqueda ejecutada");

        test.pass("Búsqueda de empleado completada exitosamente");
    }
}
