public void searchEmployeeById(String employeeId) {
    // Esperar a que la página de lista de empleados cargue
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-table")));
    
    // Hacer clic en el botón de búsqueda para abrir el filtro (si es necesario)
    WebElement toggleButton = driver.findElement(By.className("oxd-icon-button"));
    if (toggleButton.isDisplayed()) {
        toggleButton.click();
        Thread.sleep(1000);
    }
    
    // Buscar el campo "Employee Id" (selector corregido)
    By employeeIdField = By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdField));
    driver.findElement(employeeIdField).sendKeys(employeeId);
    
    // Hacer clic en el botón "Search"
    driver.findElement(By.xpath("//button[contains(@class, 'oxd-button') and contains(., 'Search')]")).click();
    
    // Esperar resultados
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-table")));
}
