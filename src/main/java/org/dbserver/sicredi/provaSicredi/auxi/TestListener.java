package org.dbserver.sicredi.provaSicredi.auxi;

import java.io.IOException;

import org.dbserver.sicredi.provaSicredi.auxi.ScreenShot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {


	@Override
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " iniciou sua execução ***");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " finalizada ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(("*** Executando o teste " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executou o teste " + result.getMethod().getMethodName() + " com sucesso...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Executou o teste " + result.getMethod().getMethodName() + " com falha...");
		try {
			ExtentTestManager.getTest().log(Status.FAIL, "Test failed ", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot.captureToBase64()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Teste " + result.getMethod().getMethodName() + " foi ignorado...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}
