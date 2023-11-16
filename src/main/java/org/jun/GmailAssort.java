package org.jun;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GmailAssort extends baseClass{
	@BeforeClass
	public static void launchTheBrowser() {
		launchBrowser();
		WindowsMaximazer();
	}
	
	@Test
	public void gmail() {
		launchUrl("https://mail.google.com/");
		String url = pageUrl();
		System.out.println(url);
		String title = pageTitle();
		Assert.assertTrue("Chech the Url", url.contains("google"));
		Assert.assertEquals("Check the Url", title , title.contains("Gamil"));
		System.out.println(title);
		
	}
}
