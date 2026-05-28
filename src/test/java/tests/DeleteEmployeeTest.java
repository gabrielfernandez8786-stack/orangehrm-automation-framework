package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.EmployeePage;
import utils.BaseTest;
import utils.TestData;

public class DeleteEmployeeTest extends BaseTest {

    @Test
    public void testDeleteEmployee() {
        test = extent.createTest("Delete Employee Test");
        test.info("Iniciando prueba de eliminación de empleado");

        // Login
        new LoginPage(driver).login("Admin", "admin123");
        test.info("Login completado");

        // Go to PIM
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.goToPIM();
        test.info("Navegación a PIM completada");

        EmployeePage empPage = new EmployeePage(driver);

        // Verificar si hay un employeeId
        if (TestData.employeeId == null || TestData.employeeId.isEmpty()) {
            System.out.println("No employee ID found. Creating a new employee first...");
            test.info("No hay ID de empleado, creando uno nuevo");

            // Crear empleado
            empPage.addEmployee("TestDelete", "User");

            // Guardar el ID generado
            TestData.employeeId = EmployeePage.generatedEmpId;
            System.out.println("Created new employee with ID: " + TestData.employeeId);
            test.info("Empleado creado con ID: " + TestData.employeeId);
        }

        // Ahora buscar y eliminar (solo si hay ID)
        if (TestData.employeeId != null && !TestData.employeeId.isEmpty()) {
            empPage.searchEmployeeById(TestData.employeeId);
            empPage.deleteEmployee();
            System.out.println("Employee with ID " + TestData.employeeId + " deleted successfully!");
            test.pass("Empleado eliminado exitosamente - ID: " + TestData.employeeId);
        } else {
            System.out.println("ERROR: Could not create or find employee ID");
            test.fail("No se pudo crear o encontrar ID de empleado");
        }
    }
}