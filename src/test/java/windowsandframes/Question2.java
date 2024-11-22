package windowsandframes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args)
	{
		try {

			WebDriver driver = new ChromeDriver();
			driver.get("http://the-internet.herokuapp.com/nested_frames");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
			List<WebElement> frames = driver.findElements(By.tagName("frame"));
			if (frames.size() == 3) {
				System.out.println("There are 3 frames on the page.");
			} else {
				System.out.println("No 3 frames are there on the page.");
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));
			String leftFrameText = driver.findElement(By.tagName("body")).getText();
			if (leftFrameText.contains("LEFT")) {
				System.out.println("The left frame has the text 'LEFT'.");
			} else {
				System.out.println("The left frame does NOT have the text 'LEFT'.");
			}
			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
			String middleFrameText = driver.findElement(By.tagName("body")).getText();
			if (middleFrameText.contains("MIDDLE")) {
				System.out.println("The middle frame has the text 'MIDDLE'.");
			} else {
				System.out.println("The middle frame does NOT have the text 'MIDDLE'.");
			}
			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
			String rightFrameText = driver.findElement(By.tagName("body")).getText();
			if (rightFrameText.contains("RIGHT")) {
				System.out.println("The right frame has the text 'RIGHT'.");
			} else {
				System.out.println("The right frame does NOT have the text 'RIGHT'.");
			}
			driver.switchTo().parentFrame();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
			String bottomFrameText = driver.findElement(By.tagName("body")).getText();
			if (bottomFrameText.contains("BOTTOM")) {
				System.out.println("The bottom frame has the text 'BOTTOM'.");
			} else {
				System.out.println("The bottom frame does NOT have the text 'BOTTOM'.");
			}
			driver.switchTo().parentFrame();
		} finally {
			System.out.println("Mission completed");

		}


	}

}
