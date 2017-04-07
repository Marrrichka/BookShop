<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link href="/resources/css/registration.css" rel="stylesheet">
<div class="container">
<div class="row">
<h4 class="tytylka">УВІЙДІТЬ АБО ЗАПОВНІТЬ ФОРМУ ДЛЯ РЕЄСТРАЦІЇ</h4>
	<div class="col-sm-6 col-xs-6">
		<form:form class="form-horizontal" action="/registration" method="POST" modelAttribute="formm"  id="formm">		
			<div class="form-group">
				<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="username"/></label>
			</div>
			<div class="form-group">
    			<label for="name" class="col-sm-2 control-label">Login</label>
    			<div class="col-sm-10">
      				<form:input class="form-control" path="username" id="name"/>
    			</div>
  			</div>
  			<div class="form-group">
				<label for="number" class="col-sm-offset-2 col-sm-10"><form:errors path="number"/></label>
			</div>
  			<div class="form-group">
    			<label for="number" class="col-sm-2 control-label">Number</label>
    			<div class="col-sm-10">
      				<form:input class="form-control" path="number" id="number"/>
    			</div>
  			</div>
  			<div class="form-group">
				<label for="email" class="col-sm-offset-2 col-sm-10"><form:errors path="email"/></label>
			</div>
			<div class="form-group">
    			<label for="email" class="col-sm-2 control-label">Email</label>
    			<div class="col-sm-10">
      				<form:input class="form-control" path="email" id="email"/>
    			</div>
  			</div>
  			<div class="form-group">
				<label for="email" class="col-sm-offset-2 col-sm-10"><form:errors path="password"/></label>
			</div>
			<div class="form-group">
    			<label for="password" class="col-sm-2 control-label">Password</label>
    			<div class="col-sm-10">
      				<form:password class="form-control" path="password" id="password"/>
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
      				<button type="submit" class="btn btn-danger">Register</button>
    			</div>
  			</div>
		</form:form>
	</div>
</div>
<div class="row">
</div>
<h4 class="tytylka">БОНУСНА ПРОГРАМА</h4>
<div class="row bonus">
<img src="resources/img/header.png" width="100%">
<h4 class="text"><strong>Що дає бонусна програма?</strong></h4>
<div class="body-text">
<p>Бонусна програма дає вам можливість здійснювати покупки вигідно. Щоразу, використовуючи бонуси, ви отримуєте знижку відповідного розміру. 1 бонус = 1 гривня.</p>
</div>
<div class="row bonustable">
<h3 class="text"><strong>Як це працює?</strong></h3>
<div class="body-text">
<p>При першій покупці кожен клієнт отримує на свій бонусний рахунок не менше 5% від суми замовлення.&nbsp;</p>
<p>Таблиця розрахунку бонусів наведена нижче.</p>
</div>
<div class="bonus-table">
<table>
<tbody>
<tr><th>Сумма покупки за останні 365 днів</th><th>Бонус</th></tr>
<tr>
<td>до&nbsp;1000 грн&nbsp;</td>
<td class="red-color">5%</td>
</tr>
<tr>
<td>від&nbsp;1000 грн до 2000 грн&nbsp;</td>
<td class="red-color">6%</td>
</tr>
<tr>
<td>від&nbsp;2000 грн до 3000 грн&nbsp;</td>
<td class="red-color">7%</td>
</tr>
<tr>
<td>від&nbsp;3000 грн до 4000 грн&nbsp;</td>
<td class="red-color">8%</td>
</tr>
<tr>
<td>від&nbsp;4000 грн до 5000 грн&nbsp;</td>
<td class="red-color">9%</td>
</tr>
<tr>
<td>від&nbsp;5000 грн до 6000 грн&nbsp;</td>
<td class="red-color">10%</td>
</tr>
<tr>
<td>від 6000 грн до 7000 грн&nbsp;&nbsp;грн</td>
<td class="red-color">11%</td>
</tr>
<tr>
<td>більше 7000 грн&nbsp;</td>
<td class="red-color">12%</td>
</tr>
<tr>
<td>&nbsp;</td>
<td class="red-color">&nbsp;</td>
</tr>
</tbody>
</table>
<div class="table-legend">
<p>* Бонус можна використати при здійсненні наступної покупки.</p>
<p><span>*&nbsp;</span>Бонуси не нараховуються на акційні товари зі знижкою.</p>
<p>* Юридичні особи не підпадають під дію бонусної системи.</p>
<p>&nbsp;</p>
</div>
<p>Відсоток і залишок на бонусному рахунку можна переглянути в особистому кабінеті, дані оновлюються раз на добу.</p>
<div class="bonusvyk">
<h3><strong>Коли і як можна використовувати бонуси?</strong></h3>
Бонуси нараховуються лише за сплачені замовлення. Зазвичай бонуси нараховуються протягом 1-2 днів для замовлень з доставкою по Києву і протягом 14 днів – з доставкою по Україні. Бонуси автоматично списуються при оформленні замовлення, і клієнт отримує відповідну знижку.</div>
<div class="arrow-padding">
<div class="arrow-box light">&nbsp;</div>
</div>
<div class="party-table">
<div class="text">
<div class="head">Як взяти участь?</div>
</div>
<div class="row">
<div class="col-md-3">
<img src="resources/img/1.png">
<h4>1</h4>
<p>Здійсніть покупку на будь-яку суму в нашому інтернет-магазині  або в магазині у Львові.</p>
</div>
<div class="col-md-3">
<img src="resources/img/2.png">
<h4>2</h4>
<p>В магазині у Львові для використання поточних бонусів, а також нарахування бонусів на наступні покупки, необхідно пред’явити картку чи продиктувати номер телефону, на який зареєстровано Ваш бонусний рахунок.</p>
</div>
<div class="col-md-3">
<img src="resources/img/3.png">
<h4>3</h4>
<p>Після оплати замовлення в інтернет-магазині, вказана сума бонусів нараховується на особистий рахунок клієнта. Бонуси можна використати для повної або часткової оплати наступного замовлення. Бонусами не можна розрахуватися за доставку.</p></div>
<div class="col-md-3">
<img src="resources/img/4.png">
<h4>4</h4>
<p>Бонуси накопичуються при покупці будь-яких книг чи аксесуарів, окрім акційних позицій та «Хітів місяця». У вартість таких позицій вже внесено суттєву знижку.</p>
</div>
</div>
</div>
<div class="arrow-padding">
<div class="arrow-box dark">&nbsp;</div>
</div>
</div>
</div>
</div>
</div>