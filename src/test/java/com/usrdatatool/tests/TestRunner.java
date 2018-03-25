package com.usrdatatool.tests;

import static com.usrdatatool.utilities.Driver.getDriver;
import static com.usrdatatool.utilities.PageActions.*;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;
import com.usrdatatool.utilities.Config;
import com.usrdatatool.utilities.Driver;
import com.usrdatatool.utilities.PageActions;
import com.usrdatatool.utilities.TestBase;



public class TestRunner extends TestBase {

  //@Test
  public void test1() {
	  getDriver().get(Config.getProperty("baseUrl"));
	  homePage.selectStateOrStatesByIndex(6);
	  homePage.selectOneOrMoreVariableGroupsByIndex(1);
	  homePage.selectStartYear("2013");
	  homePage.selectEndYear("2014");
	  click(homePage.getGetTableButton());
	  Assert.assertEquals("Colorado", homePage.getStateFromEstimatedCrimeLabelText());
	  Assert.assertEquals("bulgarly coloumn is not present",IsElementPresent(homePage.getBulgarlyColumnLabel()));
	  Assert.assertEquals("larceny coloumn is not present",IsElementPresent(homePage.getLarcenyColumnLabel()));
	  Assert.assertEquals("motor vehicle coloumn is not present",IsElementPresent(homePage.getMvtTherfColumnLabel()));
  }
  
  
 // @Test
  public void test2() {
	  getDriver().get(Config.getProperty("baseUrl"));
	  homePage.selectStateOrStatesByIndex(6,1,15,20,44);
	  homePage.selectOneOrMoreVariableGroupsByIndex(1);
	  homePage.selectStartYear("2009");
	  homePage.selectEndYear("2014");
	  
	  if(isAlertPresent()) {
		  Alert alert = getDriver().switchTo().alert();
		  alert.dismiss();
	  }
	  
	  click(homePage.getGetTableButton());
	  Assert.assertEquals("Alabama", homePage.getStateNameTexts().get(0));
	  Assert.assertEquals("Colorado", homePage.getStateNameTexts().get(1));
	  Assert.assertEquals("Indiana", homePage.getStateNameTexts().get(2));
	  Assert.assertEquals("Maine", homePage.getStateNameTexts().get(3));
	  Assert.assertEquals("Texas", homePage.getStateNameTexts().get(4));
  }
  
  
 // @Test
  public void test3() {
	  getDriver().get(Config.getProperty("baseUrl"));
	  if(isAlertPresent()) {
		  Alert alert = getDriver().switchTo().alert();
		  alert.dismiss();
	  }
	  homePage.selectAllStates();
	  int i = homePage.statesSelectBox.getAllSelectedOptions().size();
	  homePage.statesSelectBox.deselectByIndex(0);

	  boolean sorted = Ordering.natural().isOrdered(homePage.convertWebElementsToString());
	  Assert.assertEquals(52, i);
	  Assert.assertTrue(sorted);
	  
  }
  
 // @Test
  public void test4() {
	  getDriver().get(Config.getProperty("Url"));
	  if(isAlertPresent()) {
		  Alert alert = getDriver().switchTo().alert();
		  alert.dismiss();
	  }
		  assertTrue(homePage.isLogoDisplayed(),"HomePage Logo is not displayed");
		  System.out.println("aa");
		  click(homePage.getBuildingToolLink());
		  System.out.println("bb");
          click(homePage.getAllStatesLink());
		  Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.ucrdatatool.gov/Search/Crime/State/StateCrime.cfm");
          Assert.assertEquals(getDriver().getTitle(), "Uniform Crime Reporting Statistics");
          click(homePage.oneYearDataLink());
    	      System.out.println("One year of data");
    	      Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.ucrdatatool.gov/Search/Crime/State/OneYearofData.cfm");
          Assert.assertEquals(getDriver().getTitle(),"Uniform Crime Reporting Statistics");
    	      homePage.selectStateOrStatesByIndex(1,3);
    	      homePage.selectOneOrMoreVariableGroupsByIndex(0,2);
    	      homePage.selectStartYear(50);
    	      click(homePage.getGetTableButton());
    	      
	  
	
  

  }
  
  @Test
  public void test_TC110(){
	  getDriver().get(Config.getProperty("Url"));
	  reportedCrimePage.handlepopUp();	  	  	  
	  Assert.assertEquals(homePage.gethomePageHeader().getText(), "Welcome to a new way to access UCR statistics");
	  Assert.assertTrue(homePage.getBuildingToolLink().isDisplayed(), "Go to the table-building tool is not displayed");
	  click(homePage.getBuildingToolLink());
	  reportedCrimePage.handlepopUp();
	  Assert.assertTrue(reportedCrimePage.getReportedCrimePageHeader().isDisplayed(), "Go to the table-building tool is not displayed");
	  Assert.assertTrue(homePage.areReportLinksDisplayed(), "Not all report link are displayed on HomePage");
	  click(homePage.getAllStatesLink());
	  reportedCrimePage.handlepopUp();	  
	  Assert.assertTrue(PageActions.IsElementPresent((homePage.getStateByStateLink())), "State by state and national estimates table is not dsplayed");
	  Assert.assertTrue(PageActions.IsElementPresent((homePage.getDataVariableLink())),"Data with one variable table is not dsplayed");
	  Assert.assertTrue(PageActions.IsElementPresent((homePage.getOneYearDataLink())), "One year of data table is not dsplayed");
	  click(homePage.getDataVariableLink());
	  reportedCrimePage.handlepopUp(); 	  
	  Assert.assertTrue(PageActions.IsElementPresent((reportedCrimePage.getDataWithOneVariableHeader())), "Data with One Variable is not displayed");
	  //System.out.println(homePage.convertWebElementsToString());
	  homePage.selectStateOrStatesByIndex(6);
	  homePage.selectOneOrMoreVariableGroupsByIndex(1);
	  homePage.selectStartYear("2013");		  
	  //Assert.assertTrue(homePage.selectEndYear("2016"), "Year 2016 is not found" );
	  click(homePage.getGetTableButton());
	  
	  
  }
  
 // @Test
  public void test_TC111(){
	  getDriver().get(Config.getProperty("Url"));  	  
	  Assert.assertEquals(homePage.gethomePageHeader().getText(), "Welcome to a new way to access UCR statistics");
	  Assert.assertTrue(homePage.getBuildingToolLink().isDisplayed(), "Go to the table-building tool is not displayed");
	  click(homePage.getBuildingToolLink());
	  Assert.assertTrue(reportedCrimePage.getReportedCrimePageHeader().isDisplayed(), "Go to the table-building tool is not displayed");
	  Assert.assertTrue(homePage.areReportLinksDisplayed(), "Not all report link are displayed on HomePage");
	  click(homePage.getLargerAgenciesLink());
	  Assert.assertTrue(PageActions.IsElementPresent((homePage.getStateByStateLink())), "State by state and national estimates table is not dsplayed");
	  Assert.assertTrue(PageActions.IsElementPresent((homePage.getDataVariableLink())),"Data with one variable table is not dsplayed");
	  Assert.assertTrue(PageActions.IsElementPresent((homePage.getOneYearDataLink())), "One year of data table is not dsplayed");
  }
  
  

}
