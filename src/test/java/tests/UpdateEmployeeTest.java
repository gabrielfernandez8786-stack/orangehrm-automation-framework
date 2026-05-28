public void updateEmployee(String newFirstName) {
    // Hacer clic en el botón de edición del primer resultado
    driver.findElement(By.xpath("//i[contains(@class, 'oxd-icon-button') and contains(@class, 'bi-pencil')]")).click();
    
    // Esperar que cargue el formulario
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
    
    // Limpiar y escribir nuevo nombre
    WebElement firstNameField = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
    firstNameField.clear();
    firstNameField.sendKeys(newFirstName);
    
    // Guardar
    driver.findElement(By.xpath("//button[contains(@class, 'oxd-button') and contains(., 'Save')]")).click();
}
