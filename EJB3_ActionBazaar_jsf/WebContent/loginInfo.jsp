<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Login Info</title>
</head>
<body>
	<f:view>
		<table style="order-table" border="1">
			<tr><td>
				<h3>Login info</h3>
					<h:form id="logininfoId">						
						<h:messages id="msjLoginInfo" showDetail="true"></h:messages>
						<table>
							<tr>
								<td>
									<h:outputText id="oTuserName" 
												  value="User Name: ">
									</h:outputText>
								</td>
								<td>
									<h:inputText id="iTuserName" 
												 value="#{createAccountBean.username}"
												 label="UserName">
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
												 label="Password">
									</h:inputSecret>
								</td>
							</tr>	
						</table>
						<h:commandButton action="menu" value="<(back) Edit" />
						<h:commandButton actionListener="#{createAccountBean.addLoginInfo()}" 
										 action="userInfo" 
										 value="Confirm (next)>" />
					</h:form>
			</td></tr>
		</table>
	</f:view>
</body>
</html>