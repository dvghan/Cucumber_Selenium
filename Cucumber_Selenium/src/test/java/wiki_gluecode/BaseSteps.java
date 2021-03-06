package wiki_gluecode;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSteps {

    private static final String WEB_DRIVER_FOLDER = "webdrivers";

    protected WebDriver driver;

    protected void startWebDriver() {
    	/*
        Properties props = System.getProperties();
        props.setProperty("webdriver.gecko.driver",
            driversFolder(new File("").getAbsolutePath()) + "geckodriver-64-win.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("http://en.wikipedia.org");
        */
    	
  		final String binaryPath = "C:\\Users\\dnghan\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
 		System.setProperty("webdriver.chrome.driver","C:\\Users\\dnghan\\Libs\\Selenium-Java\\chromedriver.exe");   
 		ChromeOptions chromeOpt= new ChromeOptions();
		chromeOpt.setBinary(binaryPath);
		
		driver = new ChromeDriver (chromeOpt);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://automationpractice.com/index.php");         
        driver.get("http://en.wikipedia.org");         
    }

    protected void stopWebDriver() {
        driver.quit();
    }

    protected void wait(int timeOutInSeconds) {
        try {
            Thread.sleep(timeOutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String driversFolder(String path) {
        File file = new File(path);
        for (String item : file.list()) {
            if (WEB_DRIVER_FOLDER.equals(item)) {
                return file.getAbsolutePath() + "/" + WEB_DRIVER_FOLDER + "/";
            }
        }
        return driversFolder(file.getParent());
    }
}