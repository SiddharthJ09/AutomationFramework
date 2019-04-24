package ServiceNow.com.servicenow.java;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TEstScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp-pc\\Desktop\\ServiceStack\\ServiceNow_V2\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 Date date = new Date();
		 String strDataTime = formatter.format(date).toString();
		// System.out.println( ((strDataTime.replaceAll("","")).replaceAll("/","")).replaceAll(":","") );
		 String FileName = "ScreenShot"+((strDataTime.replaceAll(" ","")).replaceAll("/","")).replaceAll(":","");
		 System.out.println( FileName );

		System.out.println(System.getProperty("user.dir"));

	
		
		String strScreenshotpath = System.getProperty("user.dir") + "\\test-output\\Screenshot\\"+FileName+".png";
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);;
		FileUtils.copyFile(src, new File(strScreenshotpath));
		driver.quit();
	}

}
