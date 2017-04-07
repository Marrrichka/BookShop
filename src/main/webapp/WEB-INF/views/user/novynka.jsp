<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link href="/resources/css/novynka.css" rel="stylesheet">
   
    <div class="container">
    <div class="row">
    <div class="col-md-10">
    <div class="breadcrumbs">
    <ul>
    <li>
    <a href="/">Home</a>
    
    </li>
        
    </ul>
    </div>
    </div>
    <div class="col-md-2">
	
    </div>
    </div>
    
    <div class="row">
     <div class="col-md-1"></div>
    <div class="col-md-10">
    <c:forEach items="${promos}" var="promo">
<ul class="nav navbar-nav">
<li class="item">
<div class="category-box">
<a href="/promo/${promo.id}">${promo.promo}</a>
</div></li>
</ul>
</c:forEach>
    </div>
     <div class="col-md-1"></div>
    </div>
    </div>
    