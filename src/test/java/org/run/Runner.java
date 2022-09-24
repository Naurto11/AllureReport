package org.run;

import java.io.IOException;

import org.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pojo.LoginPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Runner extends BaseClass {

	

	@BeforeClass
	private void browserLaunch() {

		launchBrowser();
		maxBrowser();
	}

	@AfterClass
	private void browserClose() throws InterruptedException {

//		Thread.sleep(7000);
//		closebrowser();

	}

	@BeforeMethod

	public void startsTime() throws InterruptedException {

		passUrl("http://192.168.1.111:8085/JMSRS/jmslogin.php");

	}

	@AfterMethod
	public void endsTime() throws InterruptedException {

		Thread.sleep(7000);

	}

	@Test
	private void tc1() throws InterruptedException, IOException {

		LoginPojo login = new LoginPojo();

		String username = "mp001";
		String password = "pass@123";

		for (int i = 1; i < 7; i++) {

			String username1 = excelRead(i, 3);
			// System.out.println(username1);
//			
			String password1 = excelRead(i, 4);
			// System.out.println(password1);

			toInput(login.getUserId(), excelRead(i, 3));
			toInput(login.getPassword(), excelRead(i, 4));

			// System.out.println(i);

			driver.findElement(By.xpath("//a[text()='Log In']")).click();

			Thread.sleep(1000);

			if (driver.findElement(By.xpath("//button[text()='OK']")).isEnabled()) {

				if ((username.equals(username1)) && (password.equals(password1)))

				{
					//excelWrite(i, 8, "valid");

					System.out.println("valid");

					

					btnClick(login.getBridgeClk());
					Thread.sleep(1000);
					btnClick(login.getConBtn());
					Thread.sleep(1000);
					btnClick(login.getCkMaster());
					Thread.sleep(2000);
					btnClick(login.getMarketPage());
					Thread.sleep(2000);
					btnClick(login.getPressAdd());
					Thread.sleep(1000);

					for (int j = 1; j < 7; j++) {

						System.out.println(j);

						 System.out.println(excelReadGeneral(j, 0));
						 System.out.println(excelReadGeneral(j, 1));
						 System.out.println(excelReadGeneral(j, 2));
						 System.out.println(excelReadGeneral(j, 3));
						 System.out.println(excelReadGeneral(j, 4));
						 System.out.println(excelReadGeneral(j, 5));
						 System.out.println(excelReadGeneral(j, 6));
						 

						toInput(login.getCode(), excelReadGeneral(j, 0));

						toInput(login.getDesc1(), excelReadGeneral(j, 1));

						toInput(login.getDesc2(), excelReadGeneral(j, 2));
						toInput(login.getRemarks1(), excelReadGeneral(j, 3));
						toInput(login.getRemarks2(), excelReadGeneral(j, 4));
						
						
Select s=new Select(driver.findElement(By.xpath("//select[@id='cboDateFormat']")));
						
						//s.selectByVisibleText("Active");
						
						s.selectByValue("A");
						
					//	toInput(login.getStatus(), excelReadGeneral(j, 5));
						
						
						toInput(login.getSortorder(), excelReadGeneral(j, 6));
						
							driver.findElement(By.xpath("//span[contains(text(),'Save & Close')]")).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath("//button[text()='OK']")).click();
							Thread.sleep(1000);
						//	driver.findElement(By.xpath("//a[@title='Add']")).click();
						

						
						
					}

				}
			} else {

				System.out.println("Invalid");
				excelWrite(i, 7, "Invalid");
			}

			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
//
			// Thread.sleep(1000);

		}

	}

}
