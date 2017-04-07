<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <style>
            .navbar-brand{
            color: red;
            background-color:#e5e5e5;
                padding: 0 10px;
            }
            .navbar-default .navbar-nav > li > a{
            color: white;
            background-color:#e5e5e5;
            
            font-size: x-large;
            font-family: monospace;
            }
            .navbar-collapse {
            background-color:#e5e5e5;
            }
            .navbar-default{
             background-color:#e5e5e5;
            }
            
            .navbar-default .navbar-nav > li > a:hover {
            color: #d41010;
            }
           
  </style>
 
  <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#one" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="/">                            
                    <img src="resources/img/new-logo.png" class="navbar-brand">
                    </a>
                                  
                </div>
                <div class="collapse navbar-collapse" id="one">
                    <ul class="nav navbar-nav">
                        <li><a href="/about">Про книгарню</a></li>
                        <li><a href="/dostavka">Доставка та оплата</a></li>
                        <li><a href="/registration">Особистий кабінет</a></li>
                        <li><a href="/showbucket">Корзина</a></li>
                    </ul>
                    <security:authorize access="!isAuthenticated()">
	                    <form:form class="navbar-form navbar-right" action="/login" method="POST">
	                        <div class="form-group">
	                            <input class="form-control" placeholder="Login" name="login">
	                        </div>
	                        <div class="form-group">
	                            <input class="form-control" placeholder="Password" type="password" name="password">
	                        </div>
	                        <div class="checkbox">
							    <label>
							      <input name="remember-me" type="checkbox"> Remember me
							    </label>
							</div>
	                        <button class="btn btn-danger">Sign in</button>
	                    </form:form>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
	                    <form:form class="navbar-form navbar-right" action="/logout" method="POST">
	                        <button class="btn btn-primary">Sign out</button>
	                    </form:form>
                    	<security:authorize access="hasRole('ROLE_ADMIN')">
		                    <ul class="nav navbar-nav navbar-right">
		                        <li><a href="/admin">Admin</a></li>
		                        <li class="dropdown">
		                            <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
		                                Entities <span class="caret"></span>
		                            </a>
		                            <ul class="dropdown-menu">
		                                <li><a href="/admin/b">Book</a></li>
		                                <li><a href="/admin/ba">Author</a></li>
										<li><a href="/admin/badd">Addition</a></li>
										<li><a href="/admin/bc">Cover</a></li>
										<li><a href="/admin/bl">Language</a></li>
										<li><a href="/admin/bp">Promo</a></li>
										<li><a href="/admin/bt">Topic</a></li>
										<li><a href="/admin/btpc">Topic`s Category</a></li>
		                            </ul>
		                        </li>
		                    </ul>
                    	</security:authorize>
                    </security:authorize>
                </div>
            </div>
        </nav>
        