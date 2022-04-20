<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- /index -->

<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//IT">
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
<link rel="stylesheet"
	href="/MicheleProject/components/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/MicheleProject/components/vendor/icofont/icofont.min.css">
<link rel="stylesheet"
	href="/MicheleProject/components/vendor/boxicons/css/boxicons.min.css">
<link rel="stylesheet"
	href="/MicheleProject/components/vendor/venobox/venobox.css">
<link rel="stylesheet"
	href="/MicheleProject/components/vendor/owl.carousel/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="/MicheleProject/components/vendor/aos/aos.css">

<!-- Template Main CSS File -->
<link rel="stylesheet" href="/MicheleProject/components/css/style.css">
<style>
#hero {
	background-image: url("/MicheleProject/application/img/michele3.jpg");
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
			<img src="/MicheleProject/application/img/michele.jpg" alt=""
				class="img-fluid rounded-circle">
			<h1 class="text-light">
				<a href="index.html">Michele Lalla</a>
			</h1>
			<div class="social-links mt-3 text-center">
				<!-- a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> -->
				<a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
				<!-- a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>  -->
				<a href="#" class="google-plus"><i class="bx bxl-skype"></i></a> <a
					href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
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

	<main id="main"> <!-- ======= Breadcrumbs ======= ->
	    <section class="breadcrumbs">
	      <div class="container">
	
	        <div class="d-flex justify-content-between align-items-center">
	          <h2>Inner Page</h2>
	          <ol>
	            <li><a href="index.html">Home</a></li>
	            <li>Inner Page</li>
	          </ol>
	        </div>
	
	      </div>
	    </section><!-- End Breadcrumbs -->
	<div id="myIndex">
		<section id="hero"
			class="d-flex flex-column justify-content-center align-items-center">
		<div class="hero-container" data-aos="fade-in">
			<h1>Michele Lalla</h1>
			<p>
				Sono <span class="typed"
					data-typed-items="  Professore, Poeta, Scrittore, Fisico"></span>
			</p>
		</div>
		</section>
		<!-- End Hero -->

	</div>
	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer">
	<div class="container">
		<div class="copyright">
			&copy; Copyright <strong><span>iPortfolio</span></strong>
		</div>
		<div class="credits">
			<!-- All the links in the footer should remain intact. -->
			<!-- You can delete the links only if you purchased the pro version. -->
			<!-- Licensing information: https://bootstrapmade.com/license/ -->
			<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/iportfolio-bootstrap-portfolio-websites-template/ -->
			Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
		</div>
	</div>
	</footer>
	<!-- End  Footer -->

	<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

	<!-- Vendor JS Files -->
	<script type="javascript"
		src="/MicheleProject/components/vendor/jquery/jquery.min.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/php-email-form/validate.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/waypoints/jquery.waypoints.min.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/counterup/counterup.min.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/venobox/venobox.min.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/typed.js/typed.min.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/aos/aos.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/typed.js/typed.js"></script>
	<script type="javascript"
		src="/MicheleProject/components/vendor/typed.js/typed.min.js.map"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/typed.js/1.1.1/typed.min.js"></script>

	<!-- jQuery 3.2.1
	<script src="/MicheleProject/components/jquery/jquery.min1.js" type="javascript"></script> -->

	<!-- Template Main JS File -->
	<script type="javascript" src="/MicheleProject/components/js/main.js"></script>

</body>

</html>