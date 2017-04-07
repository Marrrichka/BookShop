<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/admin/b">Book</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/ba">Book Autor</a></li>
					<li><a href="/admin/badd">Book Adition</a></li>
					<li><a href="/admin/bc">Book Cover</a></li>
					<li><a href="/admin/bl">Book Language</a></li>
					<li><a href="/admin/bp">Book Promo</a></li>
					<li><a href="/admin/bt">Book Topic</a></li>
					<li><a href="/admin/btpc">Book Topic Category</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/admin/b" method="get" class="form-horizontal" id="filter">
		<custom:hiddenInputs excludeParams="searchName, searchAutor, maxPrice, minPrice, maxYear, minYear, maxPages, minPages, baddIds, bcIds, blIds,bpIds,btpcIds"/>
			<div class="form-group">
			<div class="col-sm-12">
				<form:input path="searchName" placeholder="searchName" class="form-control" />
				</div>
				</div>
			<div class="form-group">
			<div class="col-sm-12">
				<form:input path="searchAutor" placeholder="searchAutor" class="form-control" />
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
						<form:select  class="form-control" items="${booktpcs}" path="btpcIds" itemLabel="booktpc" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<form:select  class="form-control" items="${booklanguages}" path="blIds" itemLabel="language" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<form:select  class="form-control" items="${bookaditions}" path="baddIds" itemLabel="adition" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<form:select  class="form-control" items="${bookcovers}" path="bcIds" itemLabel="cover" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-11">
					<div class="col-sm-1">
						<form:checkboxes items="${bookpromos}" path="bpIds" itemLabel="promo" itemValue="id"/>
						</div>
					</div>
				</div>
				<div class="form-group">
    				<div class="col-sm-12">
      					<button type="submit" class="btn btn-default">Search</button>
    				</div>
  				</div>
  				
		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/b" method="POST" modelAttribute="bookname"  enctype="multipart/form-data">
				<custom:hiddenInputs excludeParams="bookname"/>
					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="bookname"/></label>
					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Book name</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="bookname" id="name"/>
    					</div>
  					</div>
	  					<div class="form-group">
	    					<label class="col-sm-2 control-label">Book author</label>
	    					<div class="col-sm-10">
	      						<form:select class="form-control" path="bookautors" itemLabel="autor" itemValue="id"  items="${bookautors}"/>
	    					</div>
	  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Book addition</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="bookadition" itemLabel="adition" itemValue="id" items="${bookaditions}"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Book language</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="booklanguage" itemLabel="language" itemValue="id" items="${booklanguages}"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Book topic`s Category</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="booktpc" itemLabel="booktpc" itemValue="id" items="${booktpcs}"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Book promo</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="bookpromo" itemLabel="promo" itemValue="id" items="${bookpromos}"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">Book cover</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="bookcover" itemLabel="cover" itemValue="id" items="${bookcovers}"/>
    					</div>
  					</div>
  					<div class="form-group">
						<label for="bookYear" class="col-sm-offset-2 col-sm-10"><form:errors path="bookYear"/></label>
					</div>
  					<div class="form-group">
    					<label for="bookYear" class="col-sm-2 control-label">Book year</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="bookYear" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
						<label for="bookPages" class="col-sm-offset-2 col-sm-10"><form:errors path="bookPages"/></label>
					</div>
  					<div class="form-group">
    					<label for="bookPages" class="col-sm-2 control-label">Book pages</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="bookPages" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
						<label for="bookPrice" class="col-sm-offset-2 col-sm-10"><form:errors path="bookPrice"/></label>
					</div>
  					<div class="form-group">
    					<label for="bookPrice" class="col-sm-2 control-label">Book price</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="bookPrice" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
  						<div class="col-sm-offset-2 col-sm-10">
		  					<label class="btn btn-default btn-file">
		        				Browse <input type="file" name="file" style="display: none;">
		    				</label>
	    				</div>
    				</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-success">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		</div>
		
		<div class="col-md-2 col-xs-12">
	<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Bookname asc" paramValue="bookname"/>
						<custom:sort innerHtml="Bookname desc" paramValue="bookname,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
	</div>
		<div class="row">
			<div class="col-md-1 col-xs-1">Image</div>
			<div class="col-md-1 col-xs-1"><h5>Name</h5></div>
			<div class="col-md-1 col-xs-1"><h5>Author</h5></div>
			<div class="col-md-1 col-xs-1"><h5>Addition</h5></div>			
			<div class="col-md-1 col-xs-1"><h5>Language</h5></div>
			<div class="col-md-1 col-xs-1"><h5>Topic`s category</h5></div>
			<div class="col-md-1 col-xs-1"><h5>Promo</h5></div>	
			<div class="col-md-1 col-xs-1"><h5>Cover</h5></div>
			<div class="col-md-1 col-xs-1">					
			<div class="row">
			<div class="col-md-6 col-xs-6"><h5>Year</h5></div>
			<div class="col-md-6 col-xs-6"><h5>Pages</h5></div>			
			</div>
			</div>
			<div class="col-md-1 col-xs-1"><h5>Price</h5></div>			
			<div class="col-md-1 col-xs-1"><h5>Update</h5></div>
			<div class="col-md-1 col-xs-1"><h5>Delete</h5></div>
		</div>
			<c:forEach items="${page.content}" var="bookname">
				<div class="row">
				<div class="col-md-1 col-xs-1"><img class="img-rounded" width="100%" src="/images/bookname/${bookname.id}.jpg?version=${bookname.version}"></div>
					<div class="col-md-1 col-xs-1">${bookname.bookname}</div>
					<div class="col-md-1 col-xs-1">
					<c:forEach items="${bookname.bookautors}" var="autor">
					<div class="col-md-12 col-xs-12">${autor.autor}</div>
					</c:forEach>
					</div>
					
					<div class="col-md-1 col-xs-1">${bookname.bookadition.adition}</div>
					<div class="col-md-1 col-xs-1">${bookname.booklanguage.language}</div>
					<div class="col-md-1 col-xs-1">${bookname.booktpc.booktpc}</div>
					<div class="col-md-1 col-xs-1">${bookname.bookpromo.promo}</div>
					<div class="col-md-1 col-xs-1">${bookname.bookcover.cover}</div>
					<div class="col-md-1 col-xs-1">	
					<div class="row">
					<div class="col-md-6 col-xs-1">${bookname.bookYear}</div>
					<div class="col-md-6 col-xs-1">${bookname.bookPages}</div>			
					</div>
					</div>
					<div class="col-md-1 col-xs-1">${bookname.bookPrice}</div>					
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning" href="/admin/b/update/${bookname.id}<custom:allParams/>">update</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-danger" href="/admin/b/delete/${bookname.id}<custom:allParams/>">delete</a></div>
				</div>
				<div class="row"><br></div>
			</c:forEach>
	
	

<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" /></div>
</div>