package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;//log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Baseclass {
	public static WebDriver driver;//we make it satic because (in utility we created object of base class new Base class()),
	//it will create two drivers . so we make it as static
	
	public Logger logger;//for logging from Apache log4j
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"regression", "master","sanity"})
	@Parameters("browser")
	public void setUp(String br) {
		
		rb=ResourceBundle.getBundle("config");//load config.properties file
		
		
		logger=LogManager.getLogger(this.getClass());
		
		if(br.equals("chrome")) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		}
		
		else if (br.equals("edge")) {
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(options);
			}
		else if (br.equals("firefox")) {
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new FirefoxDriver(options);
			}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get("https://demo.opencart.com/index.php?route=common/home&language=en-gb");
		driver.get(rb.getString("appURl"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"regression", "master","sanity"})
	public void tearDown() throws InterruptedException {
		
		driver.quit();
	}
	
	public String randomString() {
		String generatestring=RandomStringUtils.randomAlphabetic(5);
		return(generatestring);
	}
	public String randomNumber() {
		String generateNumber=RandomStringUtils.randomNumeric(3);
		return(generateNumber);
	}
	public String randomAlphanumberic() {
		String generatestring=RandomStringUtils.randomAlphabetic(5);
		String generateNumber=RandomStringUtils.randomNumeric(3);;
		return(generatestring+"@"+generateNumber);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
}
