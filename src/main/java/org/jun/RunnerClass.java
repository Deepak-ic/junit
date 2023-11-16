package org.jun;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunnerClass {
	
	@Test
	public void testCase() {
		Result rc = JUnitCore.runClasses(GmailAssort.class, junit_testing.class, launchBrowser.class);
		
		System.out.println("Run Time : " + rc.getRunTime());
		System.out.println("Run Count : " + rc.getRunCount());
		System.out.println("Failure Count : " + rc.getFailureCount());
		System.out.println("Ignore Count : " + rc.getIgnoreCount());
		List<Failure> failures = rc.getFailures();
		for (Failure failed : failures) {
			System.out.println(failed);
		}
	}

}
