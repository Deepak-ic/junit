package org.jun;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class junit_testing {
	
	
	@BeforeClass
	public static void beginning() {
		System.out.println("Launch Browser.....");
	}
	
	@Test
	public void helloworld1() {
		System.out.println("Hello World 1");
	}
	@Test
	public void helloworld2() {
		System.out.println("Hello World 2");
	}
	
	@After
	public void endDate() {
		System.out.println("Ending Date and time");
	}
	
	@AfterClass
	public static void closeTheBrowser() {
		System.out.println("Closing the browser");
	}
	
	@Before
	public void startingDate() {
		System.out.println("Starting Date and time");
	}
	
	
}
