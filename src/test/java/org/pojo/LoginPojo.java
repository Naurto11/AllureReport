package org.pojo;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass {

	public LoginPojo() {

		PageFactory.initElements(driver, this);
	}

	@FindAll({

			@FindBy(xpath = "(//input[@type='text'])[1]"),
			@FindBy(xpath = "(//input[@aria-label='Text input with dropdown button'])[1]"),
			@FindBy(xpath = "//input[@class='form-control form-control-line col-md-8 m-t-20 ng-valid ng-touched ng-dirty ng-valid-parse ng-empty']")

	})

	private WebElement userId;

	@FindAll({

			@FindBy(xpath = "//input[@ng-model='Password']"),
			@FindBy(xpath = "//input[@class='form-control form-control-line col-md-8 ng-pristine ng-valid ng-empty ng-touched']"),
			@FindBy(xpath = "(//input[@type='password'])[1]")

	})
	private WebElement password;

	@FindBy(xpath = "//a[text()='Log In']")

	private WebElement loginBtn;

	@FindAll({

			@FindBy(xpath = "//td[text()='Bridges Advertisement Riyadh']"), @FindBy(xpath = "(//td[@id='td-id-1'])[1]"),
			@FindBy(xpath = "(//td[@class='td-class-1 '])[1]")

	})
	private WebElement bridgeClk;

	@FindAll({

			@FindBy(xpath = "//a[contains(text(),'Continue ')]"), @FindBy(xpath = "//a[@style='font-style: normal;']"),
			@FindBy(xpath = "//a[@class='btn btn-success collapsed']") })

	private WebElement conBtn;

	@FindAll({
	
	@FindBy(xpath = "(//h6[@class='main-btntext ng-binding'])[3]"),
	@FindBy(xpath="(//img[@class='m-b-5 m-t-5 '])[3]"),
	@FindBy(xpath="(//img[@style='height:10%;width:10%;border:none;'])[3]")
	
	})

	private WebElement ckMaster;

	@FindBy(xpath = "//span[text()='Markets']")

	private WebElement marketPage;

	@FindAll({

			@FindBy(xpath = "(//a[@id='txtsearchresultP'])[1]"), @FindBy(xpath = "//a[@title='Add']"),
			@FindBy(xpath = "(//a[@class='btn btn-success collapsed'])[2]")

	})
	private WebElement pressAdd;

	@FindBy(xpath = "(//input[@type='text'])[2]")

	private WebElement Code;

	@FindAll({

			@FindBy(xpath = "(//input[@id='txtComments1'])[1]"),
			@FindBy(xpath = "//input[@ng-model='MarketData.Headers.ADPK_DESC1']"),
			@FindBy(xpath = "//input[@tabindex='2']")

	})
	private WebElement Desc1;

	@FindBy(xpath = "(//input[@id='txtComments2'])[1]")
	private WebElement Desc2;

	@FindAll({

			@FindBy(xpath = "(//input[@id='txtComments1'])[2]"), @FindBy(xpath = "//input[@tabindex='4']"),
			@FindBy(xpath = "//input[@ng-model='MarketData.Headers.ADPK_REMS1']")

	})

	private WebElement Remarks1;

	@FindBy(xpath = "(//input[@id='txtComments2'])[2]")
	private WebElement Remarks2;

	@FindBy(xpath = "//option[text()='Select']")
	private WebElement Status;

	@FindBy(xpath = "//input[@id='txtSortOrder']")
	private WebElement Sortorder;

	public WebElement getUserId() {
		return userId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getBridgeClk() {
		return bridgeClk;
	}

	public WebElement getConBtn() {
		return conBtn;
	}

	public WebElement getCkMaster() {
		return ckMaster;
	}

	public WebElement getMarketPage() {
		return marketPage;
	}

	public WebElement getPressAdd() {
		return pressAdd;
	}

	public WebElement getCode() {
		return Code;
	}

	public WebElement getDesc1() {
		return Desc1;
	}

	public WebElement getDesc2() {
		return Desc2;
	}

	public WebElement getRemarks1() {
		return Remarks1;
	}

	public WebElement getRemarks2() {
		return Remarks2;
	}

	public WebElement getStatus() {
		return Status;
	}

	public WebElement getSortorder() {
		return Sortorder;
	}

}
