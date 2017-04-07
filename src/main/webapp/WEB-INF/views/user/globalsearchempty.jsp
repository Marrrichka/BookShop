<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link href="/resources/css/novynka.css" rel="stylesheet">   
    <div class="container">
    <div class="row">   
     <div class="col-md-2"></div>  
     <div class="col-md-9"> 
    	<form:form modelAttribute="globalfilter"  method="get" class="form-horizontal" id="globalfilter">
		<custom:hiddenInputs excludeParams="global"/>
			<div class="col-sm-8">
			<div class="form-group">
			<div class="col-sm-12">
				<form:input path="global" placeholder="Global search" class="form-control" />
				</div>
				</div>
				</div>
				<div class="col-sm-1">
				<div class="form-group">
				<div class="col-sm-12">
				
      					<a href="/globalsearch"><button class="btn btn-default">Search</button></a>
    				</div>
    				</div>
    				</div>
    				</form:form>
    </div>
    </div>
    </div>