
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- %@ taglib prefix="spring" uri="http://www.springframework.org/tags"% -->


<!DOCTYPE html>
<html lang="it">

<head lang="it">
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Michele Lalla</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link
	href="application/img/michele.jpg"
	rel="icon">
<link
	href="application/img/michele.jpg"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="components/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="components/vendor/icofont/icofont.min.css"
	rel="stylesheet">
<link
	href="components/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="components/vendor/venobox/venobox.css"
	rel="stylesheet">
<link
	href="components/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="http://localhost:8080/MicheleProject/components/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link
	href="components/css/style.css"
	rel="stylesheet">

<style>
#hero {
	background-image: url("application/img/michele0.jpg");
}
</style>
<!-- jQuery 3.2.1 -->
<script
	src="<spring:url value='components/jquery/jquery.min.js'/>"
	type="text/javascript"></script>

</head>
<body>
	
	<!-- ======= Mobile nav toggle button ======= -->
	<button type="button" class="mobile-nav-toggle d-xl-none">
		<i class="icofont-navigation-menu"></i>
	</button>
	
	<header id="header">
		<div class="d-flex flex-column">
	
			<div class="profile">
				<img
					src="application/img/michele.jpg"
					alt="" class="img-fluid rounded-circle">
				<h1 class="text-light">
					<a href="index.html">Michele Lalla</a>
				</h1>
				<div class="social-links mt-3 text-center">
					<!-- a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> -->
					<a href="#" class="facebook"><i class="bx bxl-facebook"></i></a> 
					<!-- a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>  -->
					<a href="#" class="google-plus"><i class="bx bxl-skype"></i></a> 
					<a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
				</div>
			</div>
	
			<nav class="nav-menu">
				<ul>
					<li class="active"><a class="/index" href="<spring:url value='/index' />"><i
							class="bx bx-home"></i> <span>Home</span></a></li>
					<li><a class="/biografia" href='<spring:url value="/biografia" />'><i
							class="bx bx-user"></i> <span>Biografia</span></a></li>
					<li><a class="/listPoesie" href='<spring:url value="/listPoesie" />'><i
							class="bx bx-file-blank"></i> <span>Poesie</span></a></li>
					<li><a class="/listRacconti" href='<spring:url value="/listRacconti" />'><i
							class="bx bx-book-content"></i>Racconti</a></li>
					<li><a class="/pubblicazioni" href='<spring:url value="/pubblicazioni" />'><i
							class="bx bx-server"></i>Pubblicazioni</a></li>
					<li><a class="/contattoPage" href='<spring:url value="/contattoPage" />'><i
							class="bx bx-envelope"></i>Contatti</a></li>
				</ul>
			</nav>
			<!-- .nav-menu -->
			<button type="button" class="mobile-nav-toggle d-xl-none">
				<i class="icofont-navigation-menu"></i>
			</button>
	
		</div>
	</header><!-- End Header -->

	<!-- Vendor JS Files -->
	<script
		src="components/vendor/jquery/jquery.min.js"></script>
	<script
		src="components/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="components/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script
		src="components/vendor/php-email-form/validate.js"></script>
	<script
		src="components/vendor/waypoints/jquery.waypoints.min.js"></script>
	<script
		src="components/vendor/counterup/counterup.min.js"></script>
	<script
		src="components/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script
		src="components/vendor/venobox/venobox.min.js"></script>
	<script
		src="components/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script
		src="components/vendor/typed.js/typed.min.js"></script>
	<script
		src="components/vendor/aos/aos.js"></script>

	<!-- Template Main JS File -->
	<script
		src="components/js/main.js"></script>

</body>
</html>