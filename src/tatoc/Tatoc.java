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
			
			WebElement source=driver.findElement(By.id("dragbox"));
			WebElement dest=driver.findElement(By.id("dropbox"));
			
			Actions a=new Actions(driver);
				
			a.dragAndDrop(source,dest).build().perform();
			
			WebElement proceedd = driver.findElement(By.xpath("//a[text()='Proceed']"));
			proceedd.click();
			
			String parentWindow = driver.getWindowHandle();
			
			WebElement launch=driver.findElement(By.xpath("//a[text()='Launch Popup Window']"));
			launch.click();
			
			Set<String> windowHandles = driver.getWindowHandles();
			
			windowHandles.remove(parentWindow);
			
			driver.switchTo().window((String)(windowHandles.toArray())[0]);
			 
			System.out.println("Switched to New Window");
			
			
			WebElement nameTextBox=driver.findElement(By.id("name"));
			nameTextBox.sendKeys("shubhi");
			
			WebElement submitButton=driver.findElement(By.id("submit"));
			submitButton.click();
			
			
			driver.switchTo().window(parentWindow);
			
			System.out.println("Switched back to Original Window");
			
			WebElement proceedfurther=driver.findElement(By.xpath("//a[text()='Proceed']"));
			proceedfurther.click();
			
			WebElement generatetoken=driver.findElement(By.xpath("//a[text()='Generate Token']"));
			generatetoken.click();
			
			
			WebElement token = driver.findElement(By.id("token"));
			
			String tokenValue = token.getText().substring(7);
			System.out.println("Token Value: " + tokenValue);
			
			Cookie name = new Cookie("Token", tokenValue);//adding cookies using function
			driver.manage().addCookie(name);
			
			WebElement proceed2=driver.findElement(By.xpath("//a[text()='Proceed']"));
			proceed2.click();
			
			

	}

}

				
				
			
			
			
			
	
