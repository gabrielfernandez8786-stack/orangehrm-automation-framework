public void searchEmployeeById(String employeeId) {
    // Esperar tabla
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-table")));
    
    // Buscar el campo "Employee Id" (texto en inglés)
    By employeeIdField = By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
    
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(employeeIdField));
    element.sendKeys(employeeId);
    
    // Click en Search
    driver.findElement(By.xpath("//button[contains(@class, 'oxd-button') and text()=' Search ']")).click();
    Thread.sleep(2000);
}
