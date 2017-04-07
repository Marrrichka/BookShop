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
    <div class="row"> 
     <div class="col-md-1"></div>    
    <div class="col-md-9">
    <c:forEach items="${page.content}" var="bookname">    
    <div class="row basic">
    <div class="col-md-2 kartynla"><img class="img-rounded" width="90%" src="/images/bookname/${bookname.id}.jpg?version=${bookname.version}"></div>
    <div class="col-md-8">
    <div>
    <div class="row name">${bookname.bookname}</div> 
    <div class="row autorname"> 
	<c:forEach items="${bookname.bookautors}" var="autor"> 
	<div class="col-md-12">${autor.autor}</div> 
	</c:forEach> 
	</div> 
	<div class="row"><div class="col-md-3 namestatic">Жанр:</div> <div class="col-md-9">${bookname.booktpc.booktpc}</div></div> 
    <div class="row"><div class="col-md-3 namestatic">Мова:</div> <div class="col-md-9">${bookname.booklanguage.language}</div></div>
    <div class="row">   
    <div class="col-md-6"><div class="row"><div class="col-md-6 namestatic">Видання:</div> <div class="col-md-6">${bookname.bookadition.adition}</div></div></div>
    <div class="col-md-6"><div class="row"><div class="col-md-6 namestatic">Обкладинка:</div> <div class="col-md-6">${bookname.bookcover.cover}</div></div></div></div>
    <div class="row">
    <div class="col-md-6"><div class="row"><div class="col-md-6 namestatic">Рік видання:</div> <div class="col-md-6">${bookname.bookYear}</div></div></div>
    <div class="col-md-6"><div class="row"><div class="col-md-6 namestatic">К-сть сторінок:</div> <div class="col-md-6">${bookname.bookPages}</div></div></div></div>
    </div>
    <div class="row"><div class="col-md-3 namestatic">Промо:</div><div class="col-md-9">${bookname.bookpromo.promo}</div></div>
    </div>
    <div class="col-md-1 autorname">${bookname.bookPrice} грн.</div>
    <div class="col-md-1"><a href="/buy/${bookname.id}"><button class="btn btn-danger">Buy</button></a></div>
    </div>
    </c:forEach>
    </div>
    <div class="col-md-1"></div>
    </div>
    <div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" /></div>
</div>
    </div>