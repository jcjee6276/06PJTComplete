<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- --%>
<%--@ page import="com.model2.mvc.service.domain.*" --%>



<%--
	Purchase pvo = (Purchase)request.getAttribute("purcVO");
--%>



<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=" method="post">

다음과 같이 구매가 되었습니다.

<table border=1>
	<tr>
		<td>물품번호</td>
		<td>${purcVO.purchaseProd.prodNo }</td>
		<td></td>
	</tr> 
	<tr>
		<td>구매자아이디</td>
		<td>${purcVO.buyer.userId }</td>
		<td></td>
	</tr> 
	<tr>
		<td>구매방법</td>
		<td>
		
			${purcVO.paymentOption =='1' ? '현금구매' : '신용구매' }
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자이름</td>
		<td>${purcVO.receiverName }</td>
		<td></td> 
	</tr>
	<tr>
		<td>구매자연락처</td>
		<td>${purcVO.receiverPhone }</td>
		<td></td> 
	</tr>
	<tr>
		<td>구매자주소</td>
		<td>${purcVO.buyer.addr }</td>
		<td></td> 
	</tr>
		<tr>
		<td>구매요청사항</td>
		<td>${purcVO.divyRequest }</td>
		<td></td> 
	</tr>
	<tr>
		<td>배송희망일자</td>
		<td>${purcVO.divyDate }</td>
		<td></td> 
	</tr>
</table>
</form>

</body>
</html>