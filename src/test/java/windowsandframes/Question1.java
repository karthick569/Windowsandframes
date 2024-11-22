package windowsandframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement clicktheButton = driver.findElement(By.linkText("Click Here"));
		clicktheButton.click();
		String originalWindow = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		String pageSource = driver.getPageSource();
		if (pageSource.contains("New Window")) {
			System.out.println("The text 'New Window' is present on the page.");
		} else {
			System.out.println("The text 'New Window' is not present on the page.");
		}

		driver.close();

		driver.switchTo().window(originalWindow);

		if (driver.getWindowHandle().equals(originalWindow)) {
			System.out.println("Switching back to original window is success");
		} else {
			System.out.println("Switching back to original window is failed");
		}

		driver.quit();

	}

}
