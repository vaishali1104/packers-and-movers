package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.QuotationBean;
import com.KS.dao.HaulageDao;
import com.KS.dao.QuotationDao;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;

public class ChargeCreditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cardName = request.getParameter("cardName");
		String ccNumber = request.getParameter("creditCard");
		String expDate = request.getParameter("expDate");
		String amount = request.getParameter("amount");
		String quotId = request.getParameter("quotId");
		String venId = request.getParameter("venId");
		String cvv = request.getParameter("cvv");
		String haulId = request.getParameter("haulId");
		String deliveryDate = request.getParameter("deliveryDate");
		
		/*boolean isError=false;
		
		if (cardName.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("CardNameError", "<font color='red'>Please Enter card name</font>");
		}
		else
		{
            int flag=0;
			for(int i=0;i<cardName.trim().length();i++)
			{    
				
				if( (cardName.charAt(i)>=33 && cardName.charAt(i)<=64) || (cardName.charAt(i)>=91 && cardName.charAt(i)<=96) || (cardName.charAt(i)>=123 && cardName.charAt(i)<=126 ))
				{	
					isError = true;
					request.setAttribute("CardNameError", "<font color='red'>Please Enter valid card name</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				request.setAttribute("CardNameValue", cardName);
			}
		}
		
		
		if(cvv.trim().length()!=3)
		{
			isError=true;
			request.setAttribute("CvvError","<font color='red'>Please Enter valid cvv number</font>");
		}
		else
		{
			for(int i=0;i<cvv.trim().length();i++)
			{
				if(!(cvv.charAt(i)>=48 && cvv.charAt(i)<=57))
				{
					isError=true;
					request.setAttribute("CvvError","<font color='red'>Please Enter valid cvv number</font>");
					break;
				}
			}
			
		}*/
	//run("5mJs7W52", "2xg926XsHNj9H868", Double.parseDouble(amount), ccNumber, expDate);
		String ss = run("6SznW287", "72XjH2V847LkmgTp", Integer.parseInt(amount), ccNumber, expDate,quotId,venId,haulId,deliveryDate);
	    RequestDispatcher rd=null;
	    /*if(isError==true)
	    {
	    	rd=request.getRequestDispatcher("CreditCard.jsp");
	    }
	    else
	    {*/
	    	if(ss.contains("success,")) 
	    	{
				String aa [] = ss.split(",");
				request.setAttribute("Authcode",aa[1]);
				rd=request.getRequestDispatcher("paymentSucess.jsp");
		    	
		    }
	    	else
	    	{
		    	request.setAttribute("PaymentError","<font color='red'>"+ss+"</font>");
		    	rd=request.getRequestDispatcher("CreditCard.jsp");
		    }
	   // }
		rd.forward(request,response);
	}

	public static String run(String apiLoginId, String transactionKey, int amount, String ccNum,
			String expDate,String quotId,String venId,String haulId,String deliveryDate) {
		String palak = "";
		// Set the request to operate in either the sandbox or production
		// environment
		ApiOperationBase.setEnvironment(Environment.SANDBOX);

		// Create object with merchant authentication details
		MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType();
		merchantAuthenticationType.setName(apiLoginId);
		merchantAuthenticationType.setTransactionKey(transactionKey);

		// Populate the payment data
		PaymentType paymentType = new PaymentType();
		CreditCardType creditCard = new CreditCardType();
		creditCard.setCardNumber(ccNum);
		creditCard.setExpirationDate(expDate);
		paymentType.setCreditCard(creditCard);

		// Create the payment transaction object
		TransactionRequestType txnRequest = new TransactionRequestType();
		txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
		txnRequest.setPayment(paymentType);
		txnRequest.setAmount(new BigDecimal(amount).setScale(2, RoundingMode.CEILING));

		// Create the API request and set the parameters for this specific
		// request
		CreateTransactionRequest apiRequest = new CreateTransactionRequest();
		apiRequest.setMerchantAuthentication(merchantAuthenticationType);
		apiRequest.setTransactionRequest(txnRequest);

		// Call the controller
		CreateTransactionController controller = new CreateTransactionController(apiRequest);
		controller.execute();

		// Get the response
		CreateTransactionResponse response = new CreateTransactionResponse();
		response = controller.getApiResponse();
		// Parse the response to determine results
		if (response != null) {
			// If API Response is OK, go ahead and check the transaction
			// response
			if (response.getMessages().getResultCode() == MessageTypeEnum.OK)
			{
				TransactionResponse result = response.getTransactionResponse();
				if (result.getMessages() != null) {
					System.out.println("Successfully created transaction with Transaction ID: " + result.getTransId());
					System.out.println("Response Code: " + result.getResponseCode());
					System.out.println("Message Code: " + result.getMessages().getMessage().get(0).getCode());
					System.out.println("Description: " + result.getMessages().getMessage().get(0).getDescription());
					System.out.println("Auth Code: " + result.getAuthCode());
					// user display ----> authcode -->db save ..
					
					
					QuotationDao Qdao=new QuotationDao();
					if(Qdao.updateQuotationStatus(quotId))
					{
						System.out.println("status updated in Quotation");
					}
					
					HaulageDao hdao=new HaulageDao();
					if(hdao.updateHaulageStatus(haulId, venId, result.getAuthCode(),deliveryDate,amount))
					{
						System.out.println("status updated in haulage");
					}
					palak = "success,"+result.getAuthCode();
					//RequestDispatcher rd=null;
					//rd=request.getRequestDispatcher(request,response);
				
				} else {
					System.out.println("Failed Transaction.");
					if (response.getTransactionResponse().getErrors() != null) {
						System.out.println("Error Code: "
								+ response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
						System.out.println("Error message: "
								+ response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
						}
					palak = response.getTransactionResponse().getErrors().getError().get(0).getErrorText();
				}
			} else {
				System.out.println("Failed Transaction.");
				if (response.getTransactionResponse() != null && response.getTransactionResponse().getErrors() != null)
				{
					System.out.println("Error Code: "
							+ response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
					System.out.println("Error message: "
							+ response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
                   palak = response.getTransactionResponse().getErrors().getError().get(0).getErrorText();
				} else {
					System.out.println("Error Code: " + response.getMessages().getMessage().get(0).getCode());
					System.out.println("Error message: " + response.getMessages().getMessage().get(0).getText());
					palak =  response.getMessages().getMessage().get(0).getText();
				}
			}
		} else {
			// Display the error code and message when response is null
			ANetApiResponse errorResponse = controller.getErrorResponse();
			System.out.println("Failed to get response");
			if (!errorResponse.getMessages().getMessage().isEmpty()) {
				System.out.println("Error: " + errorResponse.getMessages().getMessage().get(0).getCode() + " \n"
						+ errorResponse.getMessages().getMessage().get(0).getText());
				palak = errorResponse.getMessages().getMessage().get(0).getText();
			}
		}

		return palak;
	}

}
