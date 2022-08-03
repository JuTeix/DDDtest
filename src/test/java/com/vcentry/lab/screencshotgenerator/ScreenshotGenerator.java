package com.vcentry.lab.screencshotgenerator;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.lab.initializer.Initializer;

public class ScreenshotGenerator extends Initializer{

	public static void generateScreenshot(ITestResult r) throws IOException{
		
		if(r.isSuccess()){
			System.out.println("Your current test case is passed - "+ r.getParameters()[0]);
			String path=takeScreenshot(r.getParameters()[0].toString());
	    	 
	    	 log.log(LogStatus.PASS, r.getName()+" test case pass", log.addScreenCapture(path));
			
		} else {
			System.out.println("Your current test case is failed - "+ r.getParameters()[0]);
			String path=takeScreenshot(r.getParameters()[0].toString());
	    	 
	    	 log.log(LogStatus.PASS, r.getName()+"test case failed", log.addScreenCapture(path));
				
		
		}
		reports.endTest(log);
   	 	reports.flush();
		
	}
	
	public static String takeScreenshot(String name) throws IOException{
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		File dst=new File("C:/Users/RISEHEART/workspace/H2_DDDTest/screenshot/"+name+".png");
		FileHandler.copy(src, dst);
		System.out.println(dst.toString());
		return dst.toString();	
	}
	
	
}
