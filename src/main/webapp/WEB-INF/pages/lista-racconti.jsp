<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- %@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  -->
<!-- %@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> -->

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Michele Lalla</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="/MicheleProject/application/img/michele.jpg" rel="icon">
<link href="/MicheleProject/application/img/michele.jpg"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="/MicheleProject/components/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/MicheleProject/components/vendor/icofont/icofont.min.css"
	rel="stylesheet">
<link
	href="/MicheleProject/components/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="/MicheleProject/components/vendor/venobox/venobox.css"
	rel="stylesheet">
<link
	href="/MicheleProject/components/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="/MicheleProject/components/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/MicheleProject/components/css/style.css" rel="stylesheet">
<link href="/MicheleProject/components/css/readMore.css"
	rel="stylesheet">
	
	
	 
	
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
				<img src="/MicheleProject/application/img/michele.jpg" alt=""
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
						<li><a href='<spring:url value="/pubblicazioni" />'><i
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

		<!-- ======= Hero Section ======= -->


		<!-- ======= About Section ======= -->
		<div id="listRacconti">
			<section id="diMe" class="services">
				<div class="container">
					<div class="row">
						<div class="col-lg-10">
							<div class="section-title">
								<h2>Racconti</h2>
							</div>
						</div>
						<c:if test="${not empty pageContext.request.remoteUser}">
							<div class="col-lg-2">
								<button type="button" data-toggle="modal"
									data-target="#popInsert" class="button">Inserisci</button>
							</div>
						</c:if>
					</div>
					<div class="section-title">
						<p>Il campanello squillò trinciando il silenzio meridiano
							immerso nell’insipienza del sonno, misto a stanchezza:
							«Professore, sono Manuela Giliberti. Posso salire un attimo da
							lei? Ho bisogno di una spiegazione».</p>
					</div>

					<c:forEach var="item" items="${racconti}">
						<div class="row icon-box" data-aos="fade-up">
							<div class="icon">
								<i class="icofont-computer"></i>
							</div>
							<h4 class="title">${item.titolo}</h4>

							<p class="showContentAll displayreadallsome">
								${item.descrizione}</p>
							<p>
							<div class="portfolio-wrap">
								<c:if test="${not empty pageContext.request.remoteUser}">
									<div class="portfolio-links">
										<a data-toggle="modal" data-target="#popUpdate"
											data-gall="portfolioGallery"
											onclick="updatePrepare('${item.id}')" class="button">Modifica</a>
										<a data-toggle="modal" data-target="#confirmazione" data-gall="portfolioGallery"
											onclick="confermaDelete('${item.id}', '${item.titolo}')"
											class="button">Elimina</a>

									</div>
								</c:if>
							</div>
							</p>
						</div>
					</c:forEach>

				</div>
			</section>
			<!-- End About Section -->

		</div>



		<!-- Insert -->
		<div class="container">
			<!-- .modal -->
			<div class="modal fade" id="popInsert" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="" class="">
							<div class="container">
								<div class="modal-header">
									<div class="section-title">
										<h2>Inserisci il racconto</h2>
									</div>

									<button type="button" class="close" aria-label="Close"
										data-dismiss="modal">
										<span aria-hidden="true">&times;</span>
									</button>

								</div>
								<div class="modal-body">

									<div class="row" data-aos="fade-in">
										<div class="col-lg-12">
											<!-- action="${url}" method="POST" -->
											<div class="form-group">
												<label for="titolo">Titolo:</label> <input type="text"
													class="form-control" id="titoloRacconti"
													data-rule="minlen:4" placeholder="Titolo"
													data-msg="Inserisci il titolo per favore" />
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Anno">Anno:</label> <input type="text"
													class="form-control" id="annoPubblicazione"
													data-rule="minlen:4" placeholder="Anno"
													data-msg="Inserisci l'anno per favore" />
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Descrizione">Descrizione:</label>
												<textarea class="form-control" rows="10"
													id="descrizioneRacconti" data-rule="required"
													placeholder="Descrizione"
													data-msg="Inserisci la descrizione per favore"></textarea>
												<div class="validate"></div>
											</div>
											<div id="result"></div>
											<div class="text-center">
												<button class="button" type="submit" onclick="insertRacconto()" value="Inserisci"
													data-toggle="modal" data-target="#popReslte" data-gall="portfolioGallery"
													>Inserisci</button>
											</div>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<div class="social-links mt-3 text-center">
										<a class="btn btn-default" data-dismiss="modal"> Close </a>
									</div>
								</div>
							</div>
						</section>
						<!-- End Contact Section -->
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<!-- .modal -->
			<div class="modal fade" id="popUpdate" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="popUpdateRacconto" class=""></section>
						<!-- End Contact Section -->
					</div>
				</div>
			</div>
		</div>
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


		<!-- Modal -->
		<div class="modal fade" id="confirmazione" role="dialog">
			<div class="modal-dialog" >
				<div class="modal-content">
					<div class="modal-header">
						<div class="section-title">
							<h2>Elimina Racconto</h2>
						</div>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div id="myTitele"></div>
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
	<!-- End  Footer -->


	</main>
	<!-- End #main -->




	<script src="/MicheleProject/components/vendor/jquery/jquery.min.js"></script>
	<script
		src="/MicheleProject/components/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="/MicheleProject/components/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script
		src="/MicheleProject/components/vendor/php-email-form/validate.js"></script>
	<script
		src="/MicheleProject/components/vendor/waypoints/jquery.waypoints.min.js"></script>
	<script
		src="/MicheleProject/components/vendor/counterup/counterup.min.js"></script>
	<script
		src="/MicheleProject/components/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="/MicheleProject/components/vendor/venobox/venobox.min.js"></script>
	<script
		src="/MicheleProject/components/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="/MicheleProject/components/vendor/typed.js/typed.min.js"></script>
	<script src="/MicheleProject/components/vendor/aos/aos.js"></script>

	<!-- Template Main JS File -->
	<script src="/MicheleProject/components/js/main.js"></script>
	<script src="/MicheleProject/components/js/racconti.js"></script>
	<script src="/MicheleProject/components/js/myLoader.js"></script>
	<script src="/MicheleProject/components/jquery/jquery-ajax-3.1.1.min.js"></script>


	
  

</body>



</html>