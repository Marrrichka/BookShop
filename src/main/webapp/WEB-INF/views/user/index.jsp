<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <script src="http://bootstrap-ru.com/204/assets/js/bootstrap-carousel.js"></script> -->
<link href="/resources/css/menu.css" rel="stylesheet">
<body>
<div class="row newrow">
<div class="menu">
<div class="customenu">
<div class="menu1">
<c:forEach items="${topics}" var="topic">
<ul class="nav navbar-nav">
<li class="dropdown"><a href="/topic/${topic.id}">${topic.topic}</a></li>
</ul>
</c:forEach>
</div>
</div>
</div>
<div class="row">
<div class="container rowlend">
<div id="myCarousel1" class="carousel slide" data-interval="3000" data-ride="carousel" >
            <ol class="carousel-indicators">
                <li data-target= "#myCarousel1" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel1" data-slide-to="1"></li>
                <li data-target="#myCarousel1" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner Car1">
                <div class="active item">
      <img src="resources/img/file_11.jpg">
       </div>
                <div class="item">
      <img src="resources/img/file_12.jpg">      
    </div>
                <div class="item">
      <img src="resources/img/Propozycyya.jpg">      
    </div>
  </div>
            <a class="carousel-control left" href="#myCarousel1" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
  </a>
            <a class="carousel-control right" href="#myCarousel1" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="tr"></span>
  </a>
</div>
</div>
<div class="row"></div>
	<div class="container">
		 <div id="myCarousel2" class="carousel slide">
		     <div class="carousel-inner"> 
                    <div class=" item active">
                    <div class="row"><br></div>
                         <div class="row text-center">                     
                               <div class="col-md-3">
                                  <div>
                                    <a href="#"><img src="resources/img/9785496024259_1.jpg" width="30%"></a>
                                </div>
                                <h6>Другая книга, которой нет. 20 наиболее эффективных инструментов саморазвития</h6>
                                <h5>Алекс Новак</h5>
                                <h6>74,50 грн</h6>
                              <div><button class="btn btn-success">Новинка</button></div>
                                </div>
                            <div class="col-md-3">
                            <div>
                                    <a href="#"><img src="resources/img/67231.jpg" width="29%"></a>
                                </div>
                                <h6>Защита личной информации в интернете, смартфоне и компьютере</h6>
                                <h5>Камський</h5>
                                <h6>225,50 грн</h6>
                                <div><button class="btn btn-warning">Хіт</button></div>
                           </div>
                            <div class="col-md-3">
                               <div>
                                    <a href="#"><img src="resources/img/67550.jpg" width="30%"></a>
                                </div>
                                <h6>Женский ежедневник «Флай планнер», рыжеволосая девушка</h6>
                                <h5>Светлана Гончарова</h5>
                                <h6>199,00 грн</h6>
                                <div><button class="btn btn-success">Новинка</button></div>                                
                           </div>
                            <div class="col-md-3">
                            <div>
                                    <a href="#"><img src="resources/img/9785001003311_1.jpg" width="42%"></a>
                                </div>
                                <h6>Открываем космос. От телескопа до марсохода</h6>
                                <h5>Мартин Дженкинс,Стивен Бисти</h5>
                                <h6>605,00 грн</h6>
                                <div><button class="btn btn-warning">Хіт</button></div>
                             </div>
                            </div>
                            <div class="row"><br></div>
                       </div>
                <div class="item">
                <div class="row"><br></div>
                        <div class="row text-center">
                        <div class="col-md-3">
                              <div>
                                    <a href="#"><img src="resources/img/37833.jpg" width="30%"></a>
                                </div>
                                <h6>Кримінальне право України. Для підготовки до іспитів. Навчальний </h6>
                                <h5>Тетарчук І.В.</h5>
                                <h6>84,40 грн</h6>
                                <div><button class="btn btn-success">Новинка</button></div>
                                 </div>
                            <div class="col-md-3">
                                <div>
                                    <a href="#"><img src="resources/img/66219.jpg" width="42%"></a>
                                </div>
                                <h6>Дитяча розвивально-корекційна психологія. Навчальний посібник</h6>
                                <h5>Дуткевич Т.В.</h5>
                                <h6>192,00 грн</h6>
								<div><button class="btn btn-warning">Хіт</button></div>
                                 
                            </div>
                            <div class="col-md-3">
                                <div>
                                    <a href="#"><img src="resources/img/9789665804994.jpg" width="28%"></a>
                                </div>
                                <h6>Повість без назви…</h6>                                                          
                                <h5><br>Валер'ян Підмогильний</h5>
                                <h6>72,00 грн</h6>
                                <div><button class="btn btn-success">Новинка</button></div>
                                 </div>
                            <div class="col-md-3">
                                <div>
                                    <a href="#"><img src="resources/img/67306.jpg" width="41%"></a>
                                </div>
                                <h6>Грамматический тренажер. Как правильно говорить и писать по-английски</h6>
                                <h5>Инна Гивенталь, Павел Ремизов</h5>
                                <h6>214,00 грн</h6>
                                <div><button class="btn btn-warning">Хіт</button></div>
                               </div>
                           </div>
                           <div class="row"><br></div>
             </div>          
             </div>
                <a class="carousel-control left"
                   href="#myCarousel2" data-slide="prev"><i class="icon-chevron-left"></i></a>
  <a class="carousel-control right" href="#myCarousel2" data-slide="next"><i class="icon-chevron-right"></i></a>	
  </div>
   <div class="collapse navbar-collapse id=one">
</div>
</div>
   <div class="container">	
  <div class="row">
   <div class="row"></div>
  <div class="col-md-4"></div>
  <div class="col-md-5">
<a href="/novynka">  <button class="btn btn btn-danger">Переглянути усі книги з промо акцією</button></a></div>
<div class="col-md-3"></div>
</div>
   </div>		 
	</div>
<script type="text/javascript">
$("#myCarousel").carousel();
</script>
<div class="container newmenu">
<h3 align="left"><strong>Найкраща книгарня онлайн</strong></h3>
<p align="left">Книгарня онлайн - це найзручніший спосіб придбати улюблені книги за найкращою ціною. Варто лише один раз скористатися сервісом, який пропонує інтернет-магазин книг, щоб переконатися в цьому.</p>
<p align="left">По-перше, тут вас очікує величезний вибір літератури різних жанрів. У книгарні Ви зможете купити книги дешево.</p>
<h3 align="left"><strong>Кому потрібен книжковий інтернет-магазин?</strong></h3>
<p align="left">Кожному з нас час від часу треба купити книги. Львів, звичайно, має дуже багато книгарень, де ми можемо це зробити, але ж похід по магазинах займає дуже багато часу. Крім того, ви ведете пошук практично всліпу, заходячи до кожного торгівельного центру та шукаючи там необхідне.</p>
<p align="left">Книжковий інтернет-магазин - це принципово нове ставлення до питання "де купити книги". У Львові, чи будь-якому іншому місті України, де б ви не знаходились, книгарня-онлайн буде до ваших послуг. Цей зручний і сучасний сервіс стане в нагоді кожному з нас. Особливо це стосується тих, хто звик заощаджувати свій час, а також бажає придбати книги дешево.</p>
<p align="left"><strong style="font-size: 1.5em;">Як працює книжковий інтернет-магазин?</strong></p>
<p align="left">Передбачуючи ваші питання, ми розповімо, як саме працює книжковий інтернет-магазин.</p>
<p align="left">Перше, що Ви захочете зробити - це, звичайно ж, ознайомитись із нашим величезним асортиментом. Наш інтернет-магазин книг має дуже зручний онлайн-каталог. У ньому всі книги розміщуються згідно з їх тематикою. Наприклад, Ви знайдете розділи художня література, книжки для дітей, книги з бізнесу, психології, філософії, тощо.</p>
<p align="left">Обирайте будь-які книги та замовляйте у зручний для вас спосіб. Необхідну інформацію Ви знайдете у відповідному розділі сайту.</p>
<p align="left">Ми спеціально розробили цей алгоритм для Вашого комфорту та гарантії вчасного отримання свого замовлення. Отже, книга й досі лишається найкращім подарунком, вишуканим і корисним. Вона свідчить про добрий смак и гарну освіту того, хто ії дарує. А скарби, що вона містить на своїх сторінках, подібні коштовним перлинам, які завжди будуть зростати в ціні.</p>
<p align="left">Тож, ласкаво просимо у наш книжковий магазин, і хай Вам пощастить відшукати книгу своєї мрії. Сподіваємося, що наші зустрічі стануть для Вас справжнім святом.</p>
</div>
</div>
</body>