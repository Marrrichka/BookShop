<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link href="/resources/css/showbucket.css" rel="stylesheet">
<div class="container">

<div class="row">
<div class="col-md-12">
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-7 titel">Book name</div>
<div class="col-md-1 titel">Price</div>
</div>
<c:forEach items="${users.books}" var="book">
<div class="row">
<div class="col-md-2">${users.id}</div>
<div class="col-md-2"><img class="img-rounded" width="40%" src="/images/bookname/${book.id}.jpg?version=${book.version}"></div>
<div class="col-md-7 name">${book.bookname}</div>
<div class="col-md-1 price">${book.bookPrice} грн.</div>
</div>
<div class="row"><br></div>

</c:forEach>
</div>
</div>
</div>