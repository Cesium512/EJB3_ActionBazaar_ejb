<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Action Bazaar ... </title>
</head>
<body>
	<f:view>
		<table style="order-table" border="1">
			<tr><td>
				<h3>Bid info</h3>
					<h:form id="bidBid">
						<h:messages id="msjBidBid" showDetail="true"></h:messages>
						<h:outputText id="oTitemId" value="Item Id: "></h:outputText>
						<h:inputText id="iTitemIdd" 
									 value="#{BidBean.idItem}"
									 label="Item id">
									 </h:inputText><br>
						<h:outputText id="oTUserId" value="User Id: "></h:outputText>
						<h:inputText id="iTUserId" 
									 value="#{BidBean.idUser}"
									 label="User id">
									 </h:inputText><br>
						<h:outputText id="oTAmount" value="Amount: "></h:outputText>
						<h:inputText id="iTU" 
								 value="#{BidBean.importe }" 
								 label="Amount" >
								 </h:inputText><br>
						<h:outputText id="oTBidId" value="Bid id: "></h:outputText>
						<h:inputText id="iTBidid" 
										value="#{BidBean.idBid}"
										label="Bid id">
								</h:inputText><br>
						<h:commandButton id="ConfirmarBid" 
							 type="submit" 
							 value="Confirmar"  
							 action="#{BidBean.addBid()}"/>  
						
						<h:commandButton id="BuscarBid"
							type="submit"
							value="Search" 
							action="#{BidBean.bidSearch()}"/>
						<br><br>
					</h:form>
			</td></tr>
		</table>




	</f:view>
</body>
</html>