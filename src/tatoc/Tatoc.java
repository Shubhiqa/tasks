package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tatoc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

			WebDriver driver;
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubhinigam\\eclipse-workspace\\TATOC\\drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			driver.get("http://10.0.1.86/tatoc"); // Passing TATOC url
			
			Thread.sleep(1000);
			
			WebElement basicCourseLink = driver.findElement(By.xpath("//a[contains(text(),'Basic Course' )]"));
			basicCourseLink.click();
			WebElement greenbox = driver.findElement(By.xpath("//div[@class='greenbox']"));
			greenbox.click();
			
			
			
			
			WebElement mainframe = driver.findElement(By.id("main"));
			
			driver.switchTo().frame(mainframe);
			
			WebElement box1 = driver.findElement(By.xpath("//div[text()='Box 1']")); // Box 1 Identified
			
			String box1Color = box1.getAttribute("class"); // Storing Box1 color in a variable
			
			
			WebElement childframe = driver.findElement(By.id("child"));
		
			driver.switchTo().frame(childframe); // Switching to Child Frame
			

			while(true) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(mainframe);
				WebElement childframe2 = driver.findElement(By.id("child"));
				driver.switchTo().frame(childframe2); // Switching to Child Frame
				WebElement box2 = driver.findElement(By.xpath("//div[text()='Box 2']")); // Box 2 Identified

				String box2Color = box2.getAttribute("class");
				
				if(box2Color.equalsIgnoreCase(box1Color)) {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(mainframe); // Switching to Main Frame
					break;
				}
				else {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(mainframe); // Switching to Main Frame
					WebElement repaintLink = driver.findElement(By.xpath("//a[text()='Repaint Box 2']"));
					repaintLink.click();
				}
			}
			
			WebElement proceedLink = driver.findElement(By.xpath("//a[text()='Proceed']"));
			proceedLink.click();
			
			
				
				
			
			
			
			//driver.quit();
			
	}

}
