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
					<li><a href="/admin/b">Book</a></li>
					<li><a href="/admin/ba">Book Autor</a></li>
					<li><a href="/admin/badd">Book Adition</a></li>
					<li><a href="/admin/bc">Book Cover</a></li>
					<li><a href="/admin/bl">Book Language</a></li>
					<li><a href="/admin/bp">Book Promo</a></li>
					<li><a href="/admin/bt">Book Topic</a></li>
					<li class="active"><a href="/admin/btpc">Book Topic Category</a><span
						class="sr-only">(current)</span></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/admin/btpc" method="get" class="form-inline">
			<div class="form-group">
				<form:input path="search" placeholder="search" class="form-control" />
				<custom:hiddenInputs excludeParams="search"/>
				<button type="submit" class="btn btn-primary">Ok</button>
			</div>
		</form:form>
	</div>
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/btpc" method="POST" modelAttribute="booktpc">
				<custom:hiddenInputs excludeParams="booktpc"/>
				<div class="form-group">
    					<label class="col-sm-2 control-label">Book Topic</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="topic" itemLabel="topic" itemValue="id" items="${topics}"/>
    					</div>
  					</div>
				<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10">
						<form:errors path="booktpc"/></label>
					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="booktpc" id="name"/>
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
		<div class="row">
			<div class="col-md-3 col-xs-3"><h3>Book Topic`s Category name</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Book Topic</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Update</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${page.content}" var="booktpc">
				<div class="row">
					<div class="col-md-3 col-xs-3">${booktpc.booktpc}</div>
					<div class="col-md-3 col-xs-3">${booktpc.topic.topic}</div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-warning" href="/admin/btpc/update/${booktpc.id}<custom:allParams/>">update</a></div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-danger" href="/admin/btpc/delete/${booktpc.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
	<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="booktpc asc" paramValue="booktpc"/>
						<custom:sort innerHtml="booktpc desc" paramValue="booktpc,desc"/>
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
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" /></div>
</div>