<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All info</title>
</head>
<body>
	<f:view>
		<table style="order-table" border="1">
			<tr><td>
				<h3>All info</h3>
					<h:form id="allInfoId">						
						<h:messages id="msjAllInfo" showDetail="true"></h:messages>
						<table>
							<tr>
								<td>
									<h:outputText id="oTuserName" 
												  value="User Name: ">
									</h:outputText>
								</td>
								<td>
									<h:inputText id="iTuserName" 
												 label="UserName"
												 readonly="true"
												 value ="#{createAccountBean.username}">
									</h:inputText>
								</td>
							</tr>						
							<tr>
								<td>
									<h:outputText id="oTpassword" 
												  value="Password: ">
									</h:outputText>
								</td>
								<td>
									<h:inputSecret id="iTpassword" 
												 value="#{createAccountBean.password}"
												 readonly="true"
												 label="Password">
									</h:inputSecret>
								</td>
							</tr>	
						</table>
						<table>
							<tr>
								<td>
									<h:outputText id="oTfirstName" 
												  value="First Name: ">
									</h:outputText>
								</td>
								<td>
									<h:inputText id="iTfirstName" 
												 value="#{createAccountBean.firstName}"
												 readonly="true"
												 label="FirstName">
									</h:inputText>
								</td>
							</tr>						
							<tr>
								<td>
									<h:outputText id="oTlastName" 
												  value="Last Name: ">
									</h:outputText>
								</td>
								<td>
									<h:inputText id="iTlastName" 
												 value="#{createAccountBean.lastName}"
												 readonly="true"
												 label="LastName">
									</h:inputText>
								</td>
							</tr>	
						</table>
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
												 readonly="true"
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
												 readonly="true"
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
												 readonly="true"
												 label="expiryDate">
									</h:inputText>
								</td>
							</tr>
						</table>
						<h:commandButton action="billingInfo" value="<(back) Edit" />
						<h:commandButton actionListener="#{createAccountBean.cancel()}"
										 action="menu" 
										 value="Cancel" /> 
						<h:commandButton actionListener="#{createAccountBean.confirmAccount()}"
										 action="menu" 
										 value="Confirm (next)>" />
					</h:form>
			</td></tr>
		</table>
	</f:view>
</body>
</html>