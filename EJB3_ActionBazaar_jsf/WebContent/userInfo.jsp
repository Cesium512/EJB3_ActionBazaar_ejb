<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Bidder Info</title>
</head>
<body>
	<f:view>
		<table style="order-table" border="1">
			<tr><td>
				<h3>Bidder info</h3>
					<h:form id="bidderinfoId">						
						<h:messages id="msjBidderInfo" showDetail="true"></h:messages>
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
												 label="LastName">
									</h:inputText>
								</td>
							</tr>	
						</table>
						<h:commandButton action="loginInfo" value="<(back) Edit" />
						<h:commandButton actionListener="#{createAccountBean.addBiographicalInfo()}" 
										 action="billingInfo" 
										 value="Confirm (next)>" />
					</h:form>
			</td></tr>
		</table>
	</f:view>
</body>
</html>