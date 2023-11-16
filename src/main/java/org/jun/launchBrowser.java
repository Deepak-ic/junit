package org.jun;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class launchBrowser extends baseClass{


//	@BeforeClass
//	public static void launchTheBrowser() {
//		launchBrowser();
//		WindowsMaximazer();
//	}
	
	@Before
	public void newWindow() {
		launchBrowser();
		WindowsMaximazer();
	}
	
	@Test
	public void gmail() {
		launchUrl("https://mail.google.com/");
		System.out.println("gmail");
	}
	
	@Test
	public void faceBook() {
		launchUrl("https://en-gb.facebook.com/");
		System.out.println("Facebook");
	}
	
	@Test
	public void InmakesInfoTech() {
		launchUrl("https://www.inmakes.com/");
		System.out.println("Inmakes Info Tech");
	}
	
	@Test
	public void youTube() {
		launchUrl("https://www.youtube.com/");
		System.out.println("YouTube");
	}
}
