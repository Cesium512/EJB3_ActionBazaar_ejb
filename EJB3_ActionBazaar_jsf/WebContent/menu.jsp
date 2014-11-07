<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>EJB3_ActionBazaar_jsf</title>
	</head>
	<body>
		<h:form>
			
			<h:commandLink action="principal" value="List bids" /><br><br>
			<h:commandLink action="loginInfo" value="Create Bidder" /><br>
			
			<br><br><br>
			
			<h:dataTable id="FeaturedItem" value="#{initBean.items}" var="Item" border="2">
				<f:facet name="header">
					<h:outputText value="Featured Items" />
				</f:facet>
				<h:column id="itemId">
					<f:facet name="header">Item Id </f:facet>
					<h:outputText value="#{Item.itemId}"/>
				</h:column>
				<h:column id="itemName">
					<f:facet name="header">Item Name </f:facet>
					<h:outputText value="#{Item.itemName}"/>
				</h:column>
				<h:column id="createDate">
					<f:facet name="header">Create Date </f:facet>
					<h:outputText value="#{Item.createDate}"/>
				</h:column>
				
			</h:dataTable>
		</h:form>
	</body>
</html>
</f:view>