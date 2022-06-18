package com.links;

import java.io.IOException;
import java.net.*;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\FARHANA\\eclipse-workspace\\Links\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		List<WebElement> li = driver.findElements(By.tagName("a"));
		
		for (WebElement x : li) {
			String att = x.getAttribute("href");
			if (att!=null) {
				URL u =new URL(att);
				URLConnection op = u.openConnection();
				HttpsURLConnection hp= (HttpsURLConnection)op;
				int res = hp.getResponseCode();
			if (res>=400) {
				System.out.println(att);
			}
				
			}
		}
		
	}
}
