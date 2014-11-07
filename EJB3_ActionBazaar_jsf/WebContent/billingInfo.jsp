<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Billing Info</title>
</head>
<body>
	<f:view>
		<table style="order-table" border="1">
			<tr><td>
				<h3>Billing info</h3>
					<h:form id="billingInfoId">						
						<h:messages id="msjBillingInfo" showDetail="true"></h:messages>
						<table>
							<tr>
								<td>
									<h:outputText id="oTaccountNumber" 
												  value="Account Number: ">
									</h:outputText>
								</td>
								<td>
									<h:inputText id="iTaccountNumber" 
												 value="#{createAccountBean.accountNumber}"
												 label="AccountNumber">
									</h:inputText>
								</td>
							</tr>						
							<tr>
								<td>
									<h:outputText id="oTcreditCardType" 
												  value="credit Card Type: ">
									</h:outputText>
								</td>
								<td>
									<h:inputText id="iTcreditCardType" 
												 value="#{createAccountBean.creditCardType}"
												 label="creditCardType">
									</h:inputText>
								</td>
							</tr>
							<tr>
								<td>
									<h:outputText id="oTexpiryDate" 
												  value="expiry Date: ">
									</h:outputText>
								</td>
								<td>
									<h:inputText id="iTexpiryDate" 
												 value="#{createAccountBean.expiryDate}"
												 label="expiryDate">
									</h:inputText>
								</td>
							</tr>
						</table>
						<h:commandButton action="userInfo" value="<(back) Edit" />
						<h:commandButton actionListener="#{createAccountBean.addBillingInfo()}"
										 action="infoConfirm" 
										 value="Confirm (next)>" />
					</h:form>
			</td></tr>
		</table>
	</f:view>
</body>
</html>