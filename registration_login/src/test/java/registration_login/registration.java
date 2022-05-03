package registration_login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
   
public class registration {
	WebDriver chd;
  @Test(dataProvider ="test_data" )
  public void sign_in(String firstname, String lastname,String Email,String password ) {
	  chd.findElement(By.linkText("register")).click();   
	  chd.manage().window().maximize();
      chd.findElement(By.id("firstname")).sendKeys(firstname);
	  chd.findElement(By.id("lastname")).sendKeys(lastname);
	  chd.findElement(By.id("Email")).sendKeys(Email);
	  chd.findElement(By.name("password")).sendKeys(password); 
	  
	  
	  WebElement submit_btn=chd.findElement(By.xpath("//*[@id=\"EMAIL_REG_FORM_SUBMIT\"]"));
	  JavascriptExecutor js=(JavascriptExecutor)chd;
	  js.executeScript("arguments[0].scrollIntoView(true);", submit_btn);
	  WebDriverWait wait=new WebDriverWait(chd, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"EMAIL_REG_FORM_SUBMIT\"]")));
	  submit_btn.click();
	  chd.findElement(By.linkText("Sign out")).click();  
  
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	  chd=new ChromeDriver();
	  chd.get("https://www.ebay.com/");  
  }

  @AfterClass
  public void afterClass() {
	 // chd.quit();
  }
  @DataProvider
  public String[][] test_data() throws InvalidFormatException, IOException {
	  
	  Read_excel_data obj=new Read_excel_data();
	  return obj.read_sheet();
	  
	  
  }

}
