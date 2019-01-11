package com.mfaisalkhatri.speedwell.elements;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author Faisal Khatri
 *
 */
public class TableSelector implements TablesHandler {

	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(ElementSelectors.class.getName());

	/**
	 * @param driver
	 */
	public TableSelector(WebDriver driver) {
		this.driver = driver;
	}

	public void getAllRowsValueFromTable(By mainTableLocator) {
		try {
			WebElement mainTable = driver.findElement(mainTableLocator);

			List<WebElement> rows = mainTable.findElements(By.tagName("tr"));

			int rowCount = rows.size();

			for (int i = 0; i < rowCount; i++) {
				List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
				int colCount = columns.size();

				for (int j = 0; j < colCount; j++) {
					String colText = columns.get(j).getText();
					System.out.println("Value in row " + j + "is " + colText);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error in getting all row values" + e.getMessage());
		}
	}

	/**
	 * @param mainTableLocator
	 * @param colIndex
	 * @param rowIndex
	 * @param expectedValue
	 */
	public void getSpecificRowValue(By mainTableLocator, int colIndex, int rowIndex, String expectedValue) {
		try {
			WebElement mainTable = driver.findElement(mainTableLocator);

			List<WebElement> rowData = mainTable.findElements(By.tagName("tr"));
			List<WebElement> columnData = rowData.get(colIndex).findElements(By.tagName("td"));

			String text = columnData.get(rowIndex).getText();

			Assert.assertEquals(text, expectedValue);
		} catch (Exception e) {
			LOGGER.error("Error in getting specific row value" + e.getMessage());
		}

	}

	@Override
	public void getSpecificRowValue(By mainTableLocator, int colIndex, int rowIndex) {
		try {
			WebElement mainTable = driver.findElement(mainTableLocator);

			List<WebElement> rowData = mainTable.findElements(By.tagName("tr"));
			List<WebElement> columnData = rowData.get(colIndex).findElements(By.tagName("td"));

			String text = columnData.get(rowIndex).getText();

			System.out.println("Data in row: " + rowIndex + "and column: " + colIndex +  "is " + text);

		} catch (Exception e) {
			LOGGER.error("Error in getting specific row value" + e.getMessage());
		}

	}

}
