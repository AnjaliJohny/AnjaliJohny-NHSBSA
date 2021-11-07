package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.GenericFunction;

public class NHS_QuestionsPage extends GenericFunction {
	
	public NHS_QuestionsPage()throws IOException{
		PageFactory.initElements(driver,this);
	}
	/* ******************************************************************************************************
	 * Test Name: NHS_QuestionsPage
	 * Purpose: This class contains all the objects of questions related to NHS cost checker of Wales
	 * History Created by Anjali Johny
	 * *****************************************************************************************************/
	@FindBy(id="question-heading")
	public WebElement headerQuestion;
	@FindBy(id="label-wales")
	public WebElement rbtnWales;
	@FindBy(id="next-button")
	public WebElement btnNext;
	//Question2 dob
	@FindBy(id="dob-day")
	public WebElement txtDay;
	@FindBy(id="dob-month")
	public WebElement txtMonth;
	@FindBy(id="dob-year")
	public WebElement txtYear;
	//Question 3 Partner y/n
    @FindBy(id="label-yes")
    public WebElement rbtnYes;
    @FindBy(id="label-no")
    public WebElement rbtnNo;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='paidUniversalCredit_fieldset']//label[@class='block-label selection-button-radio radio-group']")
    public WebElement rbtnYesUniversal;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='universalCreditIncludePayments_fieldset']//label[@id='label-no']")
    public WebElement rbtnUniversalCreditDetails_No;
    @FindBy (xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='universalCreditIncludePayments_fieldset']//label[@id='label-yes']")
    public WebElement rbtnUniversalCreditDetails_Yes;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='universalCreditTakeHomePay_fieldset']//label[@id='label-yes']")
    public WebElement rbtnHomePay_Yes;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='universalCreditTakeHomePay_fieldset']//label[@id='label-no']")
    public WebElement rbtnHomePay_No;
    @FindBy(xpath="//h2")
    public WebElement message;
    @FindBy(xpath="//h1")
    public WebElement message2;
    @FindBy(xpath="//div[@id='error-summary']//span[contains(text(),'Select the country you live in')]")
    public WebElement txtErrorMessageCountryName;
    @FindBy(xpath="//div[@id='error-summary']//span[contains(text(),'Enter your date of birth')]")
    public WebElement txtErrorMessageDOB;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='pregnant-or-giving-birth_fieldset']//label[@id='label-no']")
    public WebElement rdtnPregnantNo;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='pregnant-or-giving-birth_fieldset']//label[@id='label-yes']")
    public WebElement rdtnPregnantYes;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='warPension_fieldset']//label[@id='label-no']")
    public WebElement rdtnwarpensionerNo;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='diabetes_fieldset']//label[@id='label-no']")
    public WebElement rbtnDiabetesNo;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='glaucoma_fieldset']//label[@id='label-no']")
    public WebElement rdtnNoGlaucomaNo;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='glaucoma_fieldset']//label[@id='label-yes']")
    public WebElement rdtnNoGlaucomaYes;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='inCareHome_fieldset']//label[@id='label-no']")
    public WebElement rbtnCareHomeNo;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='savings_fieldset']//label[@id='label-no']")
    public WebElement rbtnSavingsNo;
    @FindBy(xpath="//div[@class='grid-row']//form[@class='form']//fieldset[@id='savings_fieldset']//label[@id='label-yes']")
    public WebElement rbtnSavingsYes;
}