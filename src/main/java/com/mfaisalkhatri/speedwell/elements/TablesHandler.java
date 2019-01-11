package com.mfaisalkhatri.speedwell.elements;

import org.openqa.selenium.By;

/**
 * @author Faisal Khatri Handling tables in Website.
 *
 */
public interface TablesHandler {

	/**
	 * @param mainTableLocator
	 */
	public void getAllRowsValueFromTable(By mainTableLocator);

	/**
	 * @param mainTableLocator
	 * @param colIndex
	 * @param rowIndex
	 */
	public void getSpecificRowValue(By mainTableLocator, int colIndex, int rowIndex, String expectedValue);
	/**
	 * @param mainTableLocator
	 * @param colIndex
	 * @param rowIndex
	 */
	public void getSpecificRowValue(By mainTableLocator, int colIndex, int rowIndex);
}