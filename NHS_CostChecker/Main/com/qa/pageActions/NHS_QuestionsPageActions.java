package com.qa.pageActions;

import java.io.IOException;

import org.openqa.selenium.support.ui.Sleeper;

import com.aventstack.extentreports.Status;
import com.qa.pages.NHS_QuestionsPage;
import com.qa.pages.NHS_StartPage;


public class NHS_QuestionsPageActions extends NHS_QuestionsPage{
String errorMessageCountry="Select the country you live in";
String errorMessageDOB="Enter your date of birth";
	public NHS_QuestionsPageActions() throws Exception {
		super();
	}
	/* ******************************************************************************************************
	 * Test Name: NHS_QuestionsPageAction
	 * Purpose: This class contains the action of NHS_Questions Page
	 * History Created by Anjali Johny
	 * *****************************************************************************************************/
	
	
	public void validateQuestions(String day,String month,String year,String partnerStatus,String taxStatus,String universalCreditStatus,String universalCreditDetail,String takehomePay,String pregnantOrgivenbirth, String warPensioner,String diabetes,String glaucoma,String careHome,String savings,String confirmmsg) throws Exception {
		validateCountryErrorMessage();
		validateCountrySelection();
		validateDOBErrorMessage();
		validateDOBEntry(day,month,year);
		validateQuestionPartner(partnerStatus);
		validateTaxQuestion(partnerStatus,taxStatus);
		validateUniCreditQuestioPregnant(partnerStatus,taxStatus,universalCreditStatus,pregnantOrgivenbirth);
		validateUniversalCreditDetails(partnerStatus,universalCreditStatus,universalCreditDetail,pregnantOrgivenbirth,warPensioner);
		validateHomePayDetails(universalCreditDetail,takehomePay,diabetes,warPensioner);
		validateQuestion3(partnerStatus,diabetes,glaucoma, careHome,savings);
		validateQuestion4(partnerStatus,glaucoma, careHome, savings);
		validateConfirmation(confirmmsg);
	}
	
	
	
	//method for selecting country as Wales
	public void validateCountrySelection() throws Exception {
		
		assertText(headerQuestion,"Which country do you live in?","Country Selection Question");
		ClickElement(rbtnWales,"Wales Radio Button");
		ClickElement(btnNext, "Next Button");
		
	}
	//method for entering DOB
	public void validateDOBEntry(String day,String month,String year) throws Exception {
		
		assertText(headerQuestion,"What is your date of birth?","DOB Entry Question");
		EnterText(txtDay, day, "Day");
		EnterText(txtMonth, month, "Month");
		EnterText(txtYear, year,"Year");
		ClickElement(btnNext, "Next Button");
	}
	//method for selecting Partner Question
	public void validateQuestionPartner(String partnerStatus) {
		assertText(headerQuestion,"Do you live with a partner?","Partner Question");
		try {
			if(partnerStatus.equalsIgnoreCase("Yes")) {
				ClickElement(rbtnYes, "Partner_Yes ");
				ClickElement(btnNext, "Next Button");
				assertText(headerQuestion,"Do you or your partner claim any benefits or tax credits?","Claim Benfit/Tax Question");
				
				
			}
		
		else if(partnerStatus.equalsIgnoreCase("No")) {
			ClickElement(rbtnNo, "Partner_No ");
			ClickElement(btnNext, "Next Button");
			assertText(headerQuestion,"Do you claim any benefits or tax credits?","Claim Benefit/Tax Question");
			
		}
		     }
	catch(Exception e) {
		e.printStackTrace();
	}	
		
	}
	//method for benefit or tax credits selection Question
	public void validateTaxQuestion(String partnerStatus,String taxStatus) {
		try {
			if(partnerStatus.equalsIgnoreCase("Yes")) {
				if (taxStatus.equalsIgnoreCase("Yes")) {
					    ClickElement(rbtnYes, "Claim Benefits/Tax credits_Yes");
					    ClickElement(btnNext, "Next Button");
					    assertText(headerQuestion,"Do you or your partner get paid Universal Credit?","Universal Credit Question");
		                                             	}
		        else if(taxStatus.equalsIgnoreCase("No")) { 
			            ClickElement(rbtnNo, "Claim Benefits/Tax credits_No ");
			            ClickElement(btnNext, "Next Button");
				        assertText(headerQuestion,"Are you pregnant or have you given birth in the last 12 months?","Pregnancy Question");
                                  }
			}
			else if (partnerStatus.equalsIgnoreCase("No")) {
				if (taxStatus.equalsIgnoreCase("Yes")) {
					 ClickElement(rbtnYes, "Claim Benefits/Tax credits_Yes");
					 ClickElement(btnNext, "Next Button");
					 assertText(headerQuestion,"Do you get paid Universal Credit?","Universal Credit Question");
		                                             	}
		        else if(taxStatus.equalsIgnoreCase("No")) { 
			        ClickElement(rbtnNo, "Claim Benefits/Tax credits_No");
			        ClickElement(btnNext, "Next Button");
			    	assertText(headerQuestion,"Are you pregnant or have you given birth in the last 12 months?","Pregnancy Question");
			
		                                                 }
			                                               }
		    } 
	     catch(Exception e) {
	      	e.printStackTrace();
			}	
	}
	
	
	
	    //method for selecting Universal Credit /Pregnant or Give Birth Question
	    public void validateUniCreditQuestioPregnant(String partnerStatus,String taxStatus,String universalCredit,String pregnantOrgivenbirth) throws Exception {
	    try{
			if(taxStatus.equalsIgnoreCase("Yes")&&(partnerStatus.equalsIgnoreCase("Yes"))) {
				
				if (universalCredit.equalsIgnoreCase("Yes")) {
					 ClickElement(rbtnYesUniversal, "Universal Credits Details");
					 ClickElement(btnNext, "Next Button");
					 System.out.println(headerQuestion.getText());
					 assertText(headerQuestion,"As part of your joint Universal Credit, do you have any of these?","Universal Credit Options Question");
}
				
			}
			else if(taxStatus.equalsIgnoreCase("Yes")&&(partnerStatus.equalsIgnoreCase("No"))) {
				
				if (universalCredit.equalsIgnoreCase("Yes")) {
					 ClickElement(rbtnYesUniversal, "Universal Credits Details");
					 ClickElement(btnNext, "Next Button");
					 System.out.println(headerQuestion.getText());
					 assertText(headerQuestion,"As part of your Universal Credit, do you have any of these?","Universal Credit Options Question");
}
				
			}
			else if (taxStatus.equalsIgnoreCase("No"))
			{ 
				if (pregnantOrgivenbirth.equalsIgnoreCase("No")) {
				      ClickElement(rdtnPregnantNo, "Pregnant or Give Birth_No");
					  ClickElement(btnNext, "Next Button");
					  assertText(headerQuestion,"Do you have an injury or illness caused by serving in the armed forces?","War-pensioner Question");
			}
				else if (pregnantOrgivenbirth.equalsIgnoreCase("Yes")) {
				      ClickElement(rdtnPregnantYes, "Pregnant or Give Birth_Yes");
					  ClickElement(btnNext, "Next Button");
					  assertText(headerQuestion,"Do you have an injury or illness caused by serving in the armed forces?","War-pensioner Question");
			}	}}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
            //method for Universal credit details/war pensioner Question		
			public void validateUniversalCreditDetails(String partnerStatus,String universalCredit,String universalCreditDetail,String pregnantOrgivenbirth,String warpensioner ) throws Exception {
				try { 
						if(partnerStatus.equalsIgnoreCase("Yes")) {
							if (universalCreditDetail.equalsIgnoreCase("Yes")) {
								if (universalCredit.equalsIgnoreCase("Yes")) {
			
								 ClickElement(rbtnUniversalCreditDetails_Yes, "Universal Credit Details_Yes");
								 ClickElement(btnNext, "Next Button");
								 assertText(headerQuestion,"Did you and your partner have a combined take-home pay of £935 or less in your last Universal Credit period?","Universal Credit Take Home Pay Question");
			}}	   else   if (universalCreditDetail.equalsIgnoreCase("No")) {
				         if (universalCredit.equalsIgnoreCase("Yes")) {
					
					         ClickElement(rbtnUniversalCreditDetails_No, "Universal Credit Details_No");
					         ClickElement(btnNext, "Next Button");
					         assertText(headerQuestion,"Did you and your partner have a combined take-home pay of £435 or less in your last Universal Credit period?","Universal Credit Take Home Pay Question");
                                                                    }} 	
						   
						   	
					else if (pregnantOrgivenbirth.equalsIgnoreCase("No")){
								   if(warpensioner.equalsIgnoreCase("No")) {
									   ClickElement(rdtnwarpensionerNo, "War pensioner_No");
									   ClickElement(btnNext, "Next Button");
									   assertText(headerQuestion,"Do you have diabetes?","Diabetes Question");
								                                           }
}							}
							
							
						else if (partnerStatus.equalsIgnoreCase("No")) {
							if (universalCreditDetail.equalsIgnoreCase("Yes")) {
								if (universalCredit.equalsIgnoreCase("Yes")) {
				                    ClickElement(rbtnUniversalCreditDetails_Yes, "Universal Credit Details_Yes");
				                    ClickElement(btnNext, "Next Button");
				                    assertText(headerQuestion,"Was your take-home pay for your last Universal Credit period £935 or less?","Universal Credit Take Home Pay Question");
								                                             }
								}
							else if(warpensioner.equalsIgnoreCase("No")) {
								   ClickElement(rdtnwarpensionerNo, "War pensioner_No");
								   ClickElement(btnNext, "Next Button");
								   assertText(headerQuestion,"Do you have diabetes?","Diabetes Question");
							                                           }
		                                                               	}

				}
                   catch(Exception e) {
		             e.printStackTrace();
	                                  }
	                                  }
			//method for Universal Credit/Take Home Pay Question
			public void validateHomePayDetails(String universalCreditDetail,String takehomePay,String warpensioner,String diabetes ) throws Exception {
				try {
						if(universalCreditDetail.equalsIgnoreCase("Yes")) {
							
							if (takehomePay.equalsIgnoreCase("Yes")) {
								 ClickElement(rbtnHomePay_Yes, "Take Home pay Details_Yes");
								  ClickElement(btnNext, "Next Button");
			}
							else if (takehomePay.equalsIgnoreCase("No")) {
									 ClickElement(rbtnHomePay_No, "Take Home pay Details_No");
									 ClickElement(btnNext, "Next Button");
									 assertText(headerQuestion,"Are you pregnant or have you given birth in the last 12 months?","Pregnancy Question");
							}
						}
						else 
						{
							if(warpensioner.equalsIgnoreCase("No")) { 
								
								if (diabetes.equalsIgnoreCase("No")) {
				
									 ClickElement(rbtnDiabetesNo,"Diabetes Radio Button");
									
									  ClickElement(btnNext, "Next Button");
										assertText(headerQuestion,"Do you have glaucoma?","Glaucoma Question");
						}

			}
							}
						}
	           catch(Exception e) {
		       e.printStackTrace();
	                              }
	}	
			
			//method for selecting Glaucoma Question
			public void validateQuestion3(String partnerStatus,String diabetes,String glaucoma,String careHome,String savings) throws Exception {
				try{
						if(diabetes.equalsIgnoreCase("No")&&(partnerStatus.equalsIgnoreCase("Yes"))) {
							
							if (glaucoma.equalsIgnoreCase("No")) {
								
								 ClickElement(rdtnNoGlaucomaNo, "Glaucoma_No");
								
								  ClickElement(btnNext, "Next Button");
								assertText(headerQuestion,"Do you or your partner live permanently in a care home?","Care Home Question");
			
							}
							
							else {
								System.out.println("no");
							}
						}
						else  if (diabetes.equalsIgnoreCase("No")&&(partnerStatus.equalsIgnoreCase("No")))
						{ if (glaucoma.equalsIgnoreCase("No")) {
							
							 ClickElement(rdtnNoGlaucomaNo, "Glaucoma_No");
							
							  ClickElement(btnNext, "Next Button");
							assertText(headerQuestion,"Do you live permanently in a care home?","Care Home Question");
		
						}else if (glaucoma.equalsIgnoreCase("Yes")) {
							
							 ClickElement(rdtnNoGlaucomaYes, "Glaucoma_Yes");
							
							  ClickElement(btnNext, "Next Button");
							assertText(headerQuestion,"Do you live permanently in a care home?","Care Home Question");
		
						}
							
						}
				}
				
						catch(Exception e) {
							e.printStackTrace();
						}
				}
			//method for selecting CareHome/Savings Question
			public void validateQuestion4(String partnerStatus, String glaucoma,String careHome,String savings) throws Exception {
				try{
						if(glaucoma.equalsIgnoreCase("No")&&(partnerStatus.equalsIgnoreCase("Yes"))) {
							
							if (careHome.equalsIgnoreCase("No")) {
								
								 ClickElement(rbtnCareHomeNo, "CareHome Radio Button");
								
								  ClickElement(btnNext, "Next Button");
								assertText(headerQuestion,"Do you and your partner have more than £16,000 in savings, investments or property?","Savings Question");
			             if(savings.equalsIgnoreCase("No")) {
				ClickElement(rbtnSavingsNo,"Savings_No Radio Button");
				  ClickElement(btnNext, "Next Button");
				
			}
			else if(savings.equalsIgnoreCase("Yes")){
				ClickElement(rbtnSavingsNo,"Savings_No Radio Button");
				  ClickElement(btnNext, "Next Button");
			}
							}
							
							else {
								System.out.println("no");
							}
						}
						else if (glaucoma.equalsIgnoreCase("No")&&(partnerStatus.equalsIgnoreCase("No"))) {
							
							if (careHome.equalsIgnoreCase("No")) {
								
								 ClickElement(rbtnCareHomeNo, "CareHome Radio Button");
								
								  ClickElement(btnNext, "Next Button");
								assertText(headerQuestion,"Do you have more than £16,000 in savings, investments or property?","Savings Question");
			             if(savings.equalsIgnoreCase("No")) {
				ClickElement(rbtnSavingsNo,"Savings_No Radio Button");
				  ClickElement(btnNext, "Next Button");
				
			}
			else if(savings.equalsIgnoreCase("Yes")){
				ClickElement(rbtnSavingsNo,"Savings_No Radio Button");
				  ClickElement(btnNext, "Next Button");
			}
							}
							
							else {
								System.out.println("no");
							}
						}
        else if (glaucoma.equalsIgnoreCase("Yes")&&(partnerStatus.equalsIgnoreCase("No"))) {
							
							if (careHome.equalsIgnoreCase("No")) {
								
								 ClickElement(rbtnCareHomeNo, "CareHome Radio Button");
								
								  ClickElement(btnNext, "Next Button");
								assertText(headerQuestion,"Do you have more than £16,000 in savings, investments or property?","Savings Question");
			             if(savings.equalsIgnoreCase("No")) {
				ClickElement(rbtnSavingsNo,"Savings_No Radio Button");
				  ClickElement(btnNext, "Next Button");
				
			}
			else if(savings.equalsIgnoreCase("Yes")){
				ClickElement(rbtnSavingsNo,"Savings_No Radio Button");
				  ClickElement(btnNext, "Next Button");
			}
							}
							
							else {
								System.out.println("no");
							}
						}
				}
				
						catch(Exception e) {
							e.printStackTrace();
						}
				}
	//method for validating error message in Country selection Question		
	public void validateCountryErrorMessage() {
		ClickElement(btnNext, "Next Button");
		assertText(txtErrorMessageCountryName,errorMessageCountry,"Country Selection Error message");

	}	
	//method for validating error message in DOB selection Question	
	public void validateDOBErrorMessage() {
		ClickElement(btnNext, "Next Button");
		assertText(txtErrorMessageDOB,errorMessageDOB,"DOB Error message");

	}
	//method for validating Confirmation Status
   public void validateConfirmation(String confirmmsg) {
	            String s = message.getText();
	            String p = message2.getText();
	         if (confirmmsg.equalsIgnoreCase("Success")){
	     
             if(s.equals("Based on what you've told us\n" + 
                       "You get help with NHS costs")){
            	extentTest.log((Status.PASS),"Confirmation status is: "+s);
                System.out.println("Confirmation message Text is "+ s);

                 }
             else if (p.equals("Based on what you've told us\n" + 
                     "You get help with NHS costs")) {
            		extentTest.log((Status.PASS),"Confirmation status is: "+p);
                 System.out.println("Confirmation message Text is "+ p);
             }
                else {
                	extentTest.log((Status.FAIL),"Confirmation status is not expected one");
                System.out.println("Sorry You won't get help with NHS costs");
          }
             }
	       else if (confirmmsg.equalsIgnoreCase("Apply")){
    
    if(s.equals("Based on what you've told us\n" + 
              "You can apply for help with NHS costs")) {
    	
    	extentTest.log((Status.PASS),"Confirmation status is: "+s);
    
    	    		  
    	System.out.println("Confirmation message Text is "+ s);

        }
       else {
       System.out.println("Sorry You won't get help with NHS costs");
       extentTest.log((Status.FAIL),"Confirmation status is not expected one");
}
}}

 
}




