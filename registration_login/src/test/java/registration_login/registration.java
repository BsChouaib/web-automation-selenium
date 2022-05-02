package registration_login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
  @Test
  public void sign_in() {
	  
	  
	  chd.findElement(By.linkText("Signup")).click();  
      chd.findElement(By.name("first_name")).sendKeys("zalbouka");
	  chd.findElement(By.name("last_name")).sendKeys("bouka");
	  chd.findElement(By.name("phone")).sendKeys("27823600");
	  chd.findElement(By.name("email")).sendKeys("zalbouka@gmail.com");
	  chd.findElement(By.name("password")).sendKeys("zalbouka"); 
	  
	  
	  WebElement submit_btn=chd.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[7]/button"));
	  JavascriptExecutor js=(JavascriptExecutor)chd;
	  js.executeScript("arguments[0].scrollIntoView(true);", submit_btn);
	  WebDriverWait wait=new WebDriverWait(chd, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[7]/button")));
	  submit_btn.click();
  
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	  chd=new ChromeDriver();
	  chd.get("https://phptravels.net/");  
  }

  @AfterClass
  public void afterClass() {
	 // chd.quit();
  }

}
