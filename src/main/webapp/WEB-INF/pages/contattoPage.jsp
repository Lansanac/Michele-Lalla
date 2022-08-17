<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="it">

	<head>
		<meta charset="utf-8">
		<meta content="width=device-width, initial-scale=1.0" name="viewport">
		
		<title>Michele Lalla</title>
		<meta content="" name="description">
		<meta content="" name="keywords">
		<meta content="text/html; charset=UTF-8; X-Content-Type-Options=nosniff" http-equiv="Content-Type" />
		
		<!-- Favicons -->
		<link href="<c:url value="/application/img/michele.jpg" />" rel="icon">
		<link href="<c:url value="/application/img/michele.jpg" />" rel="apple-touch-icon">
		
		<!-- Google Fonts -->
		<link href="<c:url value="/components/css/fonts.googleapis.com.css" />" rel="stylesheet" type="text/css">
		
		<!-- Vendor CSS Files -->
		<link type="text/css" href="<c:url value="/components/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
		<link type="text/css" href="<c:url value="/components/vendor/icofont/icofont.min.css" />" rel="stylesheet">
		<link type="text/css" href="<c:url value="/components/vendor/boxicons/css/boxicons.min.css" />" rel="stylesheet">
		<link type="text/css" href="<c:url value="/components/vendor/venobox/venobox.css" />" rel="stylesheet">
		<link type="text/css" href="<c:url value="/components/vendor/owl.carousel/assets/owl.carousel.min.css" />" rel="stylesheet">
		<link type="text/css" href="<c:url value="/components/vendor/aos/aos.css" />" rel="stylesheet">
		
		<!-- Template Main CSS File -->
		<link type="text/css" href="<c:url value="/components/css/style.css" />" rel="stylesheet">
		
		<style>
			#hero {
				background-image: url("/MicheleProject/application/img/michele6.jpg");
			}
			
			.myImg {
				width: 350px;
				height: 450px;
			}
		</style>
		
		<!-- =======================================================
			  * Template Name: iPortfolio - v1.5.0
			  * Template URL: https://bootstrapmade.com/iportfolio-bootstrap-portfolio-websites-template/
			  * Author: BootstrapMade.com
			  * License: https://bootstrapmade.com/license/
			  ======================================================== -->
	</head>
<body>

	<!-- ======= Mobile nav toggle button ======= -->
	<button type="button" class="mobile-nav-toggle d-xl-none">
		<i class="icofont-navigation-menu"></i>
	</button>

	<!-- ======= Header ======= -->
	<header id="header">
		<div class="d-flex flex-column">

			<div class="profile">
				<img src="<c:url value="/application/img/michele.jpg" />" alt=""
					class="img-fluid rounded-circle">
				<h1 class="text-light">
					<a href="index.html">Michele Lalla</a>
				</h1>
				<div class="social-links mt-3 text-center">
					<!-- a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> -->
					<a href="https://www.facebook.com/facebook/" class="facebook"  target="_blank"><i class="bx bxl-facebook"></i></a>
					<!-- a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>  -->
					<a href="https://web.skype.com/" class="google-plus"  target="_blank"><i class="bx bxl-skype"></i>
					</a> <a	href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
				</div>
			</div>

			<nav class="nav-menu">
				<ul>
					<li class="active"><a class="/index"
						href="<spring:url value='/index' />"><i class="bx bx-home"></i>
							<span>Home</span></a></li>
					<li><a href='<spring:url value="/biografia/list" />'><i
							class="bx bx-user"></i> <span>Biografia</span></a></li>
					<li><a href='<spring:url value="/poesia/list" />'><i
							class="bx bx-file-blank"></i> <span>Poesie</span></a></li>
					<li><a href='<spring:url value="/racconti/list" />'><i
							class="bx bx-book-content"></i>Racconti</a></li>
					<c:if test="${empty pageContext.request.remoteUser}">
						<li><a href='<spring:url value="/pubblicazioni/list" />'><i
							class="bx bx-server"></i>Pubblicazioni</a></li>
					</c:if>
					<c:if test="${not empty pageContext.request.remoteUser}">
						<li><a href='<spring:url value="/pubblicazioni/list" />'><i
							class="bx bx-server"></i>Pubblicazioni</a></li>
					</c:if>
					<c:if test="${empty pageContext.request.remoteUser}">
						<li><a href='<spring:url value="/contattoPage" />'><i
								class="bx bx-envelope"></i>Contatti</a></li>
					</c:if>
					<c:if test="${not empty pageContext.request.remoteUser}">
						<li><a href='<spring:url value="/contattoPage/list" />'><i
								class="bx bx-envelope"></i>Contatti</a></li>
					</c:if>
				</ul>
			</nav>
			<!-- .nav-menu -->
			<button type="button" class="mobile-nav-toggle d-xl-none">
				<i class="icofont-navigation-menu"></i>
			</button>

		</div>
	</header>
	<!-- End Header -->

	<main id="main">

		<c:if test="${empty pageContext.request.remoteUser}">
			<section id="contact" class="contact">
				<div class="container">


					<div class="section-title">
						<h2>Contatto</h2>
					</div>

					<div class="col-lg-12 mt-5 mt-lg-0 d-flex align-items-stretch">
						<spring:url var="url" value="/messaggio" />
						<form action="${url}" method="post" role="form"
							class="php-email-form" id="myFormID">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="name">Nome &amp; Cognome:</label> <input
										type="text" name="nomeCognome" id="nomeCognome"
										class="form-control" data-rule="minlen:4"
										data-msg="Please enter nam and lastnam" />
									<div class="validate"></div>
								</div>
								<div class="form-group col-md-6">
									<label for="email">Email:</label> <input type="email"
										class="form-control" name="email" id="email" data-rule="email"
										data-msg="Please enter a valid email" />
									<div class="validate"></div>
								</div>
							</div>
							<div class="form-group">
								<label for="name">Soggetto:</label> <input type="text"
									class="form-control" name="soggetto" id="soggetto"
									data-rule="minlen:4"
									data-msg="Please enter at least 8 chars of subject" />
								<div class="validate"></div>
							</div>
							<div class="form-group">
								<label for="name">Messaggio:</label>
								<textarea class="form-control" name="messaggio" id="messaggio"
									rows="6" data-rule="required" maxlength="512"
									data-msg="Please write something for us"></textarea>
								<div class="validate"></div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-1">
									<input type="checkbox" class="form-control check" name="privacy" 
									id="privacy" onclick="myCheck()" />
								</div>
								<div class="form-group col-md-11">
									<label class="form-check-label" for="flexCheckDefault"><br><b>Dichiaro di aver letto l'informativa Privacy</b>, disposti ai senzi degli articoli 13 e 14 del Regolamento UE 679/2016.</label>
									<div class="validate"></div>
								</div>
							</div>
							<div class="text-center">
								<div class="mb-3">
									<div class="loading"></div>
									<!-- <div class="spinner-grow" role="status">
									<span class="sr-only">Loading...</span>
								</div> -->
									<div class="error-message" id="error"></div>
									<div class="sent-message" id="send"></div>
								</div>
								<button type="submit" onclick="sendMessage()" 
									data-toggle="modal" data-target="#popReslte" data-gall="portfolioGallery" 
									id="mybutton" style="display:none">Invia</button>
							</div>
						</form>
					</div>

				</div>
			</section>
		</c:if>
		<c:if test="${not empty pageContext.request.remoteUser}">
			<div id="listContatto"> 
				<section id="diMe" class="services">
					<div class="container">
						<div class="row">
							<div class="col-lg-10">
								<div class="section-title">
									<h2>Contatto email</h2>
								</div>
							</div>
						</div>
						<!-- <div class="section-title">
							<p>...</p>
						</div> -->

						<div class="row icon-box" data-aos="fade-up">
							<table class="table table-hover">
								<thead>
								    <tr>
								      <th scope="col">Nominativi</th>
								      <th scope="col">Email</th>
								      <th scope="col">Oggetti</th>
								      <th scope="col">Messaggi</th>
								    </tr>
								  </thead>
								<c:forEach var="contatti" items="${contatti}">
									<tr>
										<td>
											<div>
												${contatti.nome}
											</div>
										</td>
										<td>${contatti.email}</td>
										<td style="cursor: pointer">${contatti.soggetto}</td>
										<td style="cursor: pointer"> ${contatti.messaggio}</td>
										<!-- <a data-toggle="modal"
											data-gall="portfolioGallery" data-target="#popUpdateOpera"
											onclick="updatePre('')"> </a> -->

									</tr>
								</c:forEach>
							</table>
						</div>

					</div>

				</section>
			</div>
		</c:if>


		<!-- Resulte -->
		<div class="container">
			<!-- .modal -->
			<div class="modal fade" id="popReslte" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="myReslte" class=""></section>
						<!-- End Contact Section -->
					</div>
				</div>
			</div>
		</div>
		<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>
		
			<!-- ======= Footer ======= -->
		<footer class="container-fluid bg-footer text-center">
		  	<div class="d-flex flex-column">
				<div class="social-links mt-3">
					<p class="text-light">
						<a href="index.html">Michele Lalla</a>

						<!-- a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> -->
						<a href="https://www.facebook.com/facebook/" class="facebook"  target="_blank"><i class="bx bxl-facebook"></i></a>
						<!-- a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>  -->
						<a href="https://web.skype.com/" class="google-plus"  target="_blank"><i class="bx bxl-skype"></i>
						</a> <a	href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
					</p>
				</div>
			</div>
	  
		</footer>

	</main>
	
	
	
	<!-- Vendor JS Files -->
		<script type="text/javascript" src="<c:url value="/components/vendor/jquery/jquery.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/jquery.easing/jquery.easing.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/php-email-form/validate.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/waypoints/jquery.waypoints.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/counterup/counterup.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/isotope-layout/isotope.pkgd.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/venobox/venobox.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/owl.carousel/owl.carousel.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/typed.js/typed.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/vendor/aos/aos.js" />"></script>
	
		<!-- Template Main JS File -->
		<script type="text/javascript" src="<c:url value="/components/js/main.js" />"></script>
		<script type="text/javascript" src="<c:url value="/components/js/contattoPage.js" />"></script>
		<!-- <script type="text/javascript" src="<c:url value="/components/js/myLoader.js" />"></script> -->

	
</body>
</html>
