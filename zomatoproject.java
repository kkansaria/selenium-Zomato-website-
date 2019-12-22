package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.*;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class zomatoproject {
	static WebDriver driver;

	@BeforeTest
	public void openbrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium New\\firefox driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.zomato.com/mumbai");
		System.out.println("Browser opened");
	}

	/*@Test(priority = 1)
	public void accountcreation() throws InterruptedException, BiffException, IOException

	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"signup-link\"]")).click();
		Thread.sleep(4000);
		System.out.println("hi");
		driver.findElement(By.id("signup-email")).click();
		;
//driver.close();	
		FileInputStream fileInput = new FileInputStream("D:\\Book2.xls");
		Workbook wbk = Workbook.getWorkbook(fileInput);
		Sheet sh = wbk.getSheet(0);

		String Testdata[][] = new String[sh.getColumns()][sh.getRows()];
		for (int i = 0; i < sh.getRows(); i++) {
			for (int j = 0; j < sh.getColumns(); j++) {

				Testdata[i]	[j] = sh.getCell(j, i).getContents();

				if (j % 2 == 0) {
					driver.findElement(By.id("sd-fullname")).sendKeys(Testdata[i][j]);
				} else {
					driver.findElement(By.id("sd-email")).sendKeys(Testdata[i][j]);

				}
			}
		}
		driver.findElement(By.id("sd-newsletter")).click();
		driver.findElement(By.id("sd-submit")).click();
		driver.findElement(By.xpath("/html/body/div[14]/div/i")).click();
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("signin-link")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-email")).click();
		driver.findElement(By.id("ld-email")).sendKeys("kansariakartik77@gmail.com");
		driver.findElement(By.id("ld-submit-global")).click();
        Thread.sleep(30000);
		driver.findElement(By.xpath("/html/body/div[14]/div/div[2]/div/div[4]/div[2]/a")).click();

		Thread.sleep(5000);
	}

		@Test(priority = 3)
		public void orderfood() throws InterruptedException {
	
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"header-order-food-btn\"]")).click();
			driver.findElement(By.xpath("/html/body/section[1]/div/form/div[1]/div/div[1]/input")).click();
			Thread.sleep(4000);
	
			driver.findElement(By.xpath("/html/body/section[1]/div/form/div[1]/div/div[1]/input")).sendKeys("mahalaxmi");
			driver.findElement(By.xpath("/html/body/section[1]/div/form/div[2]/button")).click();
			Thread.sleep(4000);
	
			driver.findElement(By.xpath("/html/body/section[1]/div/form/div[1]/div/div[2]/div/a[2]/div/div[1]")).click();
	Thread.sleep(7000);
			driver.findElement(By.xpath("/html/body/section[1]/div/form/div[2]/button")).click();
	
		}
		

	@Test(priority = 4)
	public void filterfororderfood() throws InterruptedException {

	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.xpath("//*[@id=\"veg-filter\"]")).click();
		Thread.sleep(2000);
		

		//driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div/div[3]/button")).click();
		Thread.sleep(2000);
System.out.println("kartik");
		driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[10]/div[2]/a[2]/div")).click();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);

		driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[11]/div[2]/a[2]/div")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[12]/div[2]/a[2]/div")).click();
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);

		
		String Expectedtitle="Mahalaxmi Nagar, Ambernath, Maharashtra Restaurants, Restaurants in Mahalaxmi Nagar, Ambernath, Maharashtra - Zomato";
		String ActualTitle= driver.getTitle();
		Assert.assertEquals(Expectedtitle,ActualTitle);
		System.out.println("title for filterfororder food is right ");
		js.executeScript("window.scrollBy(0,-600)");

	}

	@Test(priority =5)
	public void selectinghotel() throws InterruptedException
	{
		
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[3]/div[2]/div/div[5]/div/div[1]/section/div[1]/div[3]/div[3]/div[2]/a")).click(); //hotel mammas food 
Thread.sleep(7000);
System.out.println("done");
ArrayList <String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

driver.switchTo().window(tabs2.get(1));
driver.close();
Thread.sleep(2000);
driver.switchTo().window(tabs2.get(0));
Thread.sleep(2000);
driver.get("https://www.zomato.com/mumbai/mammas-food-ambernath-thane/order");
Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div/div[3]")).click();
		Thread.sleep(5000);
		
		
		
	}
	
	@Test(priority=6)
	
	public void checkout() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/div[2]/div[2]/textarea")).sendKeys("all items should be non spicy ");
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/div[2]/button")).click();
		driver.findElement(By.name("address")).sendKeys("mahalxmi area ,424 lane");
		driver.findElement(By.name("instructions")).sendKeys("opposite hotel marine plaza");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[13]/div/form/div[8]/div/div/a[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[13]/div/div[2]/button")).click();
		Thread.sleep(12000);

		driver.findElement(By.xpath("/html/body/div[13]/div/div[5]/button[2]")).click();
		Thread.sleep(10000);

		driver.findElement(By.id("name-input")).sendKeys("Kartik kansaria");
		Thread.sleep(12000);

		driver.findElement(By.xpath("/html/body/div[13]/div/div[2]/div/form/div[2]/input[2]")).sendKeys("9029296549");
		Thread.sleep(12000);

		driver.findElement(By.xpath("/html/body/div[13]/div/div[3]/div")).click();
		Thread.sleep(12000);

	}
	
	@Test(priority=7)
	public void payment() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"card\"]")).click();
		Thread.sleep(4000);
	driver.findElement(By.name("number")).sendKeys("4343 4343 4343 4343");
	Thread.sleep(5000);

	driver.findElement(By.name("month")).sendKeys("10");
	Thread.sleep(5000);

	driver.findElement(By.name("year")).sendKeys("2022");
	Thread.sleep(5000);

	driver.findElement(By.name("verification_value")).sendKeys("000");
	Thread.sleep(5000);

	driver.findElement(By.name("first_name")).sendKeys("rohit ");
	Thread.sleep(5000);

	driver.findElement(By.name("last_name")).sendKeys("sharma");
	Thread.sleep(5000);

	driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[1]/div/div/div[1]/div[1]/div[2]/div/div/div/div/div/form/a")).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("/html/body/div[13]/div/i")).click();

	driver.findElement(By.name("payment_method")).click();
	Thread.sleep(5000);

	driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div/div[1]/ul/li[5]/div")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div[3]/button")).click();
	Thread.sleep(5000);

	}
	
	@Test(priority=8)
	public void GettheApp() throws BiffException, IOException, InterruptedException
	{
		//driver.findElement(By.xpath("/html/body/div[4]/header/div/div/a")).click();   //goes to main zomato page
		driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/header/div[1]/div/div[1]/a/img")).click();
Thread.sleep(8000);
		FileInputStream file=new FileInputStream("D:\\Book4.xls");
		Workbook wbk = Workbook.getWorkbook(file);
		Sheet sh=wbk.getSheet(0);
		String TestData[][]= new String[sh.getRows()][sh.getColumns()];
		for(int i=0;i<sh.getRows();i++)
		{
			for(int j=0;j<sh.getColumns();j++)
			{
				TestData[i][j]=sh.getCell(j,i).getContents();
				
				System.out.println("TestData[i][j] is :"+TestData[i][j]);
			if(j%2==0)
			{
				driver.findElement(By.id("phone-no")).sendKeys(TestData[i][j]);
				
			}
			else
			{
				driver.findElement(By.id("email-id")).sendKeys(TestData[i][j]);
			}
		}
		
		}
		
		
		
		driver.findElement(By.xpath("//*[@id=\"app-download-sms\"]")).click();
		Thread.sleep(8000);
		driver.get("https://www.zomato.com/mumbai");
	}
	
@Test(priority=9)
	public void bookatable() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/header/div[1]/div/div[2]/a[2]/img")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div/div[1]/div/div/div/div[1]/div/div[1]/div[1]/span[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("location_input")).sendKeys("mahalaxmi");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div/div[1]/div/div/div/div[1]/div/div[2]/ul[3]/div[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div/div[1]/div/div/div/div[2]/div/div[2]/div[2]/ul[2]/li[11]/div")).click();
		Thread.sleep(5000);

		
	}
	
	@Test(priority=10)
	public void filterforbookaTable() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(5000);

	driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/a/span")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[7]/a[4]/div/span")).click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,600)");

	driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[8]/a[1]/div")).click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,600)");

	driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[10]/div[2]/a[5]/div")).click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,700)");

	driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[11]/div[2]/a[1]/div")).click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,700)");

	driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[13]/div[2]/a[4]/div")).click();
			Thread.sleep(5000);

	driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[6]/div/div[1]/section/div[1]/div[3]/div/div[2]/a[3]/span")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id=\"date-picker\"]")).click();   ////

Thread.sleep(5000);
	
	System.out.println("hi");
	driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/section[2]/form/div[1]/div[1]/div[2]/div[2]/div[7]")).click();
	Thread.sleep(3000);
	System.out.println("bye");


	driver.findElement(By.xpath("//*[@id=\"number-picker\"]")).click();
	Thread.sleep(4000);
//
	driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/section[2]/form/div[2]/div[1]/div[2]/div[2]/div[7]")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[@id=\"time-picker\"]")).click();
	driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/section[2]/form/div[3]/div[1]/div[2]/div[2]/div[15]")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.id("firstname")).sendKeys("Kartik ");
	driver.findElement(By.id("lastname")).sendKeys("kansaria");
	driver.findElement(By.id("email")).sendKeys("kansariakartik77@gmail.com");
	driver.findElement(By.id("phone")).sendKeys("544545454");
	driver.findElement(By.id("confirm-booking")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[12]/div[2]/i")).click();
	Thread.sleep(3000);
	}
	
	@Test(priority=11)
		public void ViewMenu() throws InterruptedException
		{
		    JavascriptExecutor js = (JavascriptExecutor) driver;
	
			driver.navigate().back();
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[6]/div/div[1]/section/div[1]/div[3]/div/div[2]/a[2]")).click();
			js.executeScript("window.scrollBy(0,100)");
	Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,900)");
	Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,-1000)");
	driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[3]/div/div[2]/div[3]/div[2]/div[2]")).click();
	js.executeScript("window.scrollBy(0,700)");
	Thread.sleep(2000);
	driver.findElement(By.id("menu-next-page")).click();
	Thread.sleep(6000);
	driver.findElement(By.id("menu-next-page")).click();
	Thread.sleep(6000);
	
	driver.findElement(By.id("menu-next-page")).click();
	Thread.sleep(6000);
	 
	driver.findElement(By.id("menu-next-page")).click();
	Thread.sleep(6000);
		
	js.executeScript("window.scrollBy(0,-900)");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[3]/div/div[2]/div[3]/div[2]/div[3]")).click();
	js.executeScript("window.scrollBy(0,700)");
	
	
	driver.findElement(By.id("menu-next-page")).click();
	Thread.sleep(6000);
	driver.findElement(By.id("menu-next-page")).click();
	Thread.sleep(6000);
	driver.findElement(By.id("menu-next-page")).click();
	Thread.sleep(6000);
	js.executeScript("window.scrollBy(0,-900)");
	
	
		}
	
	@Test(priority =12)
	public void HotelReview() throws InterruptedException
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[2]/div[1]/div/a[5]")).click();
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-email")).click();   //login 
		Thread.sleep(2000);
		driver.findElement(By.id("ld-email")).sendKeys("kansariakartik77@gmail.com");
		Thread.sleep(4000);
		driver.findElement(By.id("")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ld-submit-reload")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div/div[4]/div[2]/a")).click();
		
		Thread.sleep(5000);//
		
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/a[5]")).click();

		driver.findElement(By.id("review-form-textarea-id")).sendKeys("Very good food, nice ambience");
driver.findElement(By.id("review-submit")).click();
js.executeScript("window.scrollBy(0,600)");
driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[3]/div/div[3]/div[1]/div[1]/div[1]/div/div[3]/a[3]")).click();
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,700)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,-1200)");

	}
	
	@Test(priority=13)
	public void hotelPhotos() throws InterruptedException
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://www.zomato.com/mumbai/the-cafe-by-foodhall-lower-parel/reviews");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,700)");

		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[2]/div[1]/div/a[6]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[3]/div/div/div[3]/div/div[1]/a/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/i")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[3]/div/div/div[2]/div/a[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[3]/div/div/div[3]/div/div[1]/a/img")).click();
		Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div[1]/div[4]/i")).click();
        Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/i")).click();
driver.get("https://www.zomato.com/mumbai");
	
	}
	
	
	@Test(priority =14)
	public void Zomatogold() throws InterruptedException
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(5000);
		driver.findElement(By.id("gold_entry_point_header")).click();
		Thread.sleep(6000);
		js.executeScript("window.scrollBy(0,1400)");
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/div[10]/div/div/img[2]")).click();
		Thread.sleep(6000);

		js.executeScript("window.scrollBy(0,1400)");
		Thread.sleep(6000);
driver.findElement(By.xpath("/html/body/div[13]/a/div")).click();
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,900)");
Thread.sleep(6000);
js.executeScript("window.scrollBy(0,-900)");

//driver.findElement(By.xpath("/html/body/div[6]/div[1]/a")).click();   // unable to click the back button 

	}
	
	@Test(priority =15)                                              //not working filter marked down
	public void filterforZomatoGold() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(5000);
		driver.findElement(By.id("gold_entry_point_header")).click();
		Thread.sleep(6000);
		js.executeScript("window.scrollBy(0,1700)");
		Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[10]/div/div/div[3]/a/div")).click();
Thread.sleep(5000);

//driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[11]/a[2]/div")).click();   
//js.executeScript("window.scrollBy(0,700)");

	//Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[12]/a[3]/div/div[2]")).click();
	js.executeScript("window.scrollBy(0,700)");

	Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[13]/div[2]/a[1]/div")).click();
js.executeScript("window.scrollBy(0,700)");

Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[14]/div[2]/a[1]/div")).click();
js.executeScript("window.scrollBy(0,700)");

Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[16]/div[2]/a[3]/div")).click();
Thread.sleep(5000);   

	
	}

@Test(priority =16)
public void quicksearch() throws InterruptedException, IOException
{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,900)");
	//	Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section[2]/div/a[4]")).click();
Thread.sleep(5000);

driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[11]/a[1]/div")).click();
js.executeScript("window.scrollBy(0,600)");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[12]/a[4]/div")).click();
js.executeScript("window.scrollBy(0,600)");

Thread.sleep(5000);

driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[13]/div[2]/a[3]/div")).click();
js.executeScript("window.scrollBy(0,700)");

Thread.sleep(5000);

driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[14]/div[2]/a[1]/div")).click();
js.executeScript("window.scrollBy(0,800)");

Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[16]/div[2]/a[2]/div")).click();
js.executeScript("window.scrollBy(0,900)");

Thread.sleep(5000);
driver.findElement(By.id("veg-filter")).click();
js.executeScript("window.scrollBy(0,900)");

Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[18]/div[2]/div/div/div[2]/form/div/div[2]/a")).click();
js.executeScript("window.scrollBy(0,900)");

Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/section/div/div[2]/div[3]/div[2]/div/div[6]/div/div[1]/section/div[1]/div[3]/div[1]/div[1]/div/article/div[1]/div/div[2]/div[1]/div[1]/a[1]")).click();
String expectedtitle="Geeta Bhavan, Mumbai Central, Mumbai - Zomato";
String actualtitle= driver.getTitle();
Assert.assertEquals(expectedtitle,actualtitle);

System.out.println("title matching");

//takeScreenShot("quickSearchFile.jpg");

}
@Test(priority=17)
public void AddaRestaurant() throws InterruptedException
{
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,3000)");
Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/footer/div/div[3]/div[3]/div/div[1]/ul/li[1]/a")).click();
Thread.sleep(7000);
	driver.findElement(By.xpath("/html/body/div[13]/div/i")).click();
	driver.findElement(By.id("restaurant_name")).sendKeys("Hotel Delight");
	Thread.sleep(5000);
	driver.findElement(By.id("restaurant_city")).sendKeys("mumbai");
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[1]/div/div[2]/div/div/div[2]/a[3]/div/div")).click();
Thread.sleep(4000);
driver.findElement(By.id("restaurant_owner_flag[Yes]")).click();
Thread.sleep(4000);
driver.findElement(By.id("owner_phone")).sendKeys("4746566448");;
Thread.sleep(4000);
driver.findElement(By.id("owner_email")).sendKeys("xyz@jj.com");
Thread.sleep(4000);
driver.findElement(By.id("restaurant_std_no")).sendKeys("441");
Thread.sleep(2000);
driver.findElement(By.id("restaurant_phone_no")).sendKeys("6424628467");
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,600)");

driver.findElement(By.id("restaurant_opening_status[opening_soon]")).click();
}

@Test(priority =18)
public void AdditionalinfoinadddaRestaurant() throws InterruptedException
{
	 JavascriptExecutor js = (JavascriptExecutor) driver;

	Thread.sleep(5000);
	driver.findElement(By.id("show_restaurant_additional_information")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("restaurant_address")).sendKeys("mahalaxmi");
	Thread.sleep(4000);
	driver.findElement(By.id("restaurant_serves_alcohol[Yes]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("alcohol_178")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("alcohol_219")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("attr_1")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("attr_2")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("attr_3")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("attr_7")).click();
	Thread.sleep(4000);
	//driver.findElement(By.xpath("restaurant_seating_status[Yes]")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("Indoor Seating")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("Outdoor")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("restaurant_payment_type[cards_and_cash]")).click();
	
	Thread.sleep(4000);
	js.executeScript("window.scrollBy(0,600)");

	driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[1]/div/div/i")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[1]/div/div/div[2]/div[50]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[1]/div/div/div[2]/div[19]")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[1]/div/div/div[2]/div[17]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[2]/div/div/i")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[2]/div/div/div[2]/div[4]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[2]/div/div/div[2]/div[2]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[2]/div/div/div[2]/div[12]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[2]/div/div/div[2]/div[18]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[2]/div/div/div[2]/div[22]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[2]/div/div/div[2]/div[38]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[2]/div[6]/div[2]/div/div/div[2]/div[74]")).click();
Thread.sleep(4000);
driver.findElement(By.id("mon")).click();
Thread.sleep(4000);
driver.findElement(By.id("tue")).click();
Thread.sleep(4000);
driver.findElement(By.id("wed")).click();
Thread.sleep(4000);
driver.findElement(By.id("thu")).click();
Thread.sleep(4000);
driver.findElement(By.id("fri")).click();
Thread.sleep(4000);
driver.findElement(By.id("sat")).click();
Thread.sleep(4000);
driver.findElement(By.id("sun")).click();
Thread.sleep(4000);

driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[3]/div[1]/div[2]/div/div[1]/div/i")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[3]/div[1]/div[2]/div/div[1]/div/ul/li[37]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[3]/div[1]/div[2]/div/div[2]/div/i")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[3]/div[1]/div[2]/div/div[2]/div/ul/li[97]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/form/div/div[3]/div[3]/div[1]/div[2]/div/div[3]/button")).click();
Thread.sleep(4000);

driver.findElement(By.id("restaurant_email")).sendKeys("abc@gmail.com");
Thread.sleep(4000);
driver.findElement(By.id("restaurant_url")).sendKeys("www.abc.com");
Thread.sleep(3000);
driver.findElement(By.id("submit")).click();
driver.get("https://www.zomato.com/mumbai");
}
	
@Test(priority=19)
public void claimyourListing() throws InterruptedException
{
	 JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("window.scrollBy(0,3000)");
Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/footer/div/div[3]/div[3]/div/div[1]/ul/li[2]/a")).click();
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(8000);
		driver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div/div/div[2]/div/a/p/button")).click();
		Thread.sleep(5000);
		 ArrayList <String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		   
		 driver.switchTo().window(tabs2.get(1));
		 driver.close();
		 Thread.sleep(2000);
		 driver.switchTo().window(tabs2.get(0));
		 Thread.sleep(5000);
	   driver.get("https://www.zomato.com/business/advertise");
	   Thread.sleep(6000);
driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/button")).click();
	   Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[9]/div[2]/div/div[2]/div/form/section[1]/section/input")).sendKeys("abc city");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[9]/div[2]/div/div[2]/div/form/section[2]/section/input")).sendKeys("hotel retreat");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[9]/div[2]/div/div[2]/div/form/section[3]/section/input")).sendKeys("kartik");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[9]/div[2]/div/div[2]/div/form/section[4]/section/input")).sendKeys("kartik@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[9]/div[2]/div/div[2]/div/form/section[5]/section/input")).sendKeys("5252522552");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[9]/div[2]/div/div[2]/div/form/button")).click();
		Thread.sleep(6000);
		//driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/p")).click();
		//Thread.sleep(5000);
		driver.navigate().back();
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,400)");
Thread.sleep(5000);
}

@Test(priority =20)
public void RestaurantWidgets() throws InterruptedException
{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	driver.findElement(By.xpath("/html/body/div[5]/div[6]/div/div/div/div/div[2]/div/a/p/button")).click();
	Thread.sleep(4000);
	ArrayList <String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	   
	 driver.switchTo().window(tabs2.get(1));
	 driver.close();
	 Thread.sleep(5000);
	 driver.switchTo().window(tabs2.get(0));
	 Thread.sleep(5000);
  driver.get("https://www.zomato.com/business/widgets");
  Thread.sleep(6000);
	js.executeScript("window.scrollBy(0,300)");
driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[1]/div/div[2]/a")).click();
Thread.sleep(5000);
driver.findElement(By.id("search_input")).sendKeys("hotel retreat");
Thread.sleep(5000);
driver.findElement(By.id("42426")).click();
Thread.sleep(5000);
//driver.findElement(By.name("o2-widget-color")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/i")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[2]/div/div[2]/a")).click();
Thread.sleep(5000);
driver.findElement(By.id("search_input")).sendKeys("hotel reteat");
Thread.sleep(5000);
driver.findElement(By.id("42426")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/input[2]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/input[2]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/i")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[3]/div/div[2]/a")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[1]/div[2]/select")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[1]/div[2]/select/option[4]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/input[2]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/i")).click();
js.executeScript("window.scrollBy(0,300)");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[4]/div/div[2]/a")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[1]/div[2]/select")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[1]/div[2]/select/option[4]")).click();
Thread.sleep(4000);
driver.findElement(By.id("custom_widget_btn_text")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[5]/div[1]/div[2]/select/option[3]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/i")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[5]/div/div[2]/a")).click();
Thread.sleep(6000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[1]/div[2]/select/option[4]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("//*[@id=\"res_widget_btn_text\"]")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/form/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/select/option[4]")).click();
Thread.sleep(5000);
driver.findElement(By.id("show_reviews")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/i")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[6]/div/div[2]/a")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/i")).click();
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,300)");
driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[7]/div/div[2]/a")).click();
Thread.sleep(5000);
driver.findElement(By.id("search_input")).sendKeys("hotel retreat");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[12]/div/i")).click();
driver.close();
}*/

@Test(priority=21)
public void carrer() throws InterruptedException
{
	 JavascriptExecutor js = (JavascriptExecutor) driver;

	driver.get("https://www.zomato.com/business/widgets");
	js.executeScript("window.scrollBy(0,1000)");

	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,-1000)");
	driver.get("https://www.zomato.com/mumbai");
Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,3000)");
Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/footer/div/div[3]/div[1]/ul/li[4]/a")).click();
Thread.sleep(5000);
Thread.sleep(4000);
ArrayList <String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
   
 driver.switchTo().window(tabs2.get(1));
 driver.close();
 Thread.sleep(5000);
 driver.switchTo().window(tabs2.get(0));
 Thread.sleep(2000);
driver.get("https://www.zomato.com/careers");
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,800)");
driver.findElement(By.xpath("/html/body/div[1]/div[5]/section/section/div[1]/div")).click();
js.executeScript("window.scrollBy(0,200)");
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/div[5]/section/section/div[2]/div")).click();
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,200)");
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/div[5]/section/section/div[3]/div")).click();
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/div[5]/section/section/div[4]/div")).click();
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/div[5]/section/section/div[5]/div")).click();
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/div[5]/section/section/div[6]/div")).click();
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div[1]/a/div/img")).click();
Thread.sleep(4000);

}

@Test(priority=22)
public void TechandEngineerringinZomato() throws InterruptedException
{
	 JavascriptExecutor js = (JavascriptExecutor) driver;

	ArrayList <String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(tabs2.get(1));
driver.close();
Thread.sleep(3000);
driver.switchTo().window(tabs2.get(0));
Thread.sleep(2000);
driver.get("https://www.zomato.com/careers/tech-and-engineering");
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/input")).sendKeys("india");;
Thread.sleep(6000);
//driver.findElement(By.xpath("").click();
//Thread.sleep(4000);
js.executeScript("window.scrollBy(0,300)");
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div[2]/div[1]/section/div[1]/div")).click();
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div[2]/div[1]/section/div[1]/section[2]/button[2]")).click();
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,-800)");
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/section[1]/i")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div[2]/div[2]/button")).click(); 
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,-300)");
Thread.sleep(4000);
driver.navigate().back();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div[1]/div/form/section/section[7]/label/input")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div[2]/div[1]/section/div/div/section")).click();
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,200)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,200)");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div[2]/div[1]/section/div/section[2]/button[2]/span")).click();
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,-900)");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/section[1]/i")).click();
}

@Test(priority=23)
public void contactUs() throws InterruptedException
{
	driver.get("https://www.zomato.com/careers/tech-and-engineering");  //fordemo to redirect to contact us page 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,3000)");
	 Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/footer/div/div/div[1]/div[1]/nav/a[4]/p")).click();
Thread.sleep(5000);
driver.findElement(By.id("name")).sendKeys("kartik kansaria");;
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,200)");

driver.findElement(By.id("email")).sendKeys("kk@gmail.com");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,200)");

driver.findElement(By.id("phone")).sendKeys("4444156735");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,200)");

driver.findElement(By.xpath("/html/body/div[7]/section/div[1]/div/div[1]/div/form/div[4]/div")).click();
Thread.sleep(5000);

driver.findElement(By.xpath("/html/body/div[7]/section/div[1]/div/div[1]/div/form/div[4]/div/div[2]/div[6]")).click();
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,200)");

driver.findElement(By.id("message")).sendKeys("Design of UI is good and simple ");
Thread.sleep(5000);
js.executeScript("window.scrollBy(0,200)");

driver.findElement(By.id("contact-form-submit")).click();
driver.close();

}
}

