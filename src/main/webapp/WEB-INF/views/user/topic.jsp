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
	<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Bookname asc" paramValue="bookname"/>
						<custom:sort innerHtml="Bookname desc" paramValue="bookname,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
    </div>
    </div>
    
    <div class="row">
     <div class="col-md-1"></div>
    <div class="col-md-10">
    <c:forEach items="${booktpcs}" var="booktpc">
<ul class="nav navbar-nav">
<li class="item">
<div class="category-box">
<a href="/booktpc/${booktpc.id}">${booktpc.booktpc}</a>
</div></li>
</ul>
</c:forEach>
    </div>
     <div class="col-md-1"></div>
    </div>
			<div class="row">
			
    <div class="col-md-3">
    <div class="row"><br></div>
     <div class="row"><br></div>
			<div class="row"><br></div>
    <form:form modelAttribute="filter"  method="get" class="form-horizontal" id="filter">
		<custom:hiddenInputs excludeParams="searchName, searchAutor, maxPrice, minPrice, maxYear, minYear, maxPages, minPages, language, addition"/>
			<div class="form-group">
			<div class="col-sm-12">
				<form:input path="searchName" placeholder="search name" class="form-control" />
				</div>
				</div>
			<div class="form-group">
			<div class="col-sm-12">
				<form:input path="searchAutor" placeholder="search author" class="form-control" />
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-12">
				<form:input path="language" placeholder="search language" class="form-control" />
				</div>
				</div>
				<div class="form-group">
			<div class="col-sm-12">
				<form:input path="addition" placeholder="search addition" class="form-control" />
				</div>
				</div>
		
			<div class="form-group">
					<div class="col-sm-6 col-xs-4">
	      				<form:input type="text" class="form-control" path="minPrice" placeholder="Min price"/>
	    			</div>
	    			
	    			<div class="col-sm-6 col-xs-4">
	      				<form:input type="text" class="form-control" path="maxPrice" placeholder="Max price"/>
	    			</div>
	    			
				</div>
				
				<div class="form-group">
					<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="minPages" placeholder="Min pages"/>
	    			</div>
	    			<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="maxPages" placeholder="Max pages"/>
	    			</div>
				</div>
				<div class="form-group">
					<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="minYear" placeholder="Min year"/>
	    			</div>
	    			<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="maxYear" placeholder="Max year"/>
	    			</div>
				</div>
				
				
				
				<div class="form-group">
    				<div class="col-sm-12">
      					<button type="submit" class="btn btn-default">Search</button>
    				</div>
  				</div>
  				
  				
		</form:form>
    
    
    
    
    
    </div>
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
    </div>
    <div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" /></div>
</div>
    </div>