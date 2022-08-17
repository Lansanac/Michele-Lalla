<!-- %@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> -->
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Michele Lalla</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="./application/img/michele.jpg" rel="icon">
<link href="./application/img/michele.jpg" rel="apple-touch-icon">

<!-- Google Fonts -->
<link type="text/css" href="./components/css/fonts.googleapis.com.css" rel="stylesheet" >

<!-- Vendor CSS Files -->
<link type="text/css" href="./components/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="./components/vendor/icofont/icofont.min.css" rel="stylesheet">
<link type="text/css" href="./components/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link type="text/css" href="./components/vendor/venobox/venobox.css" rel="stylesheet">
<link type="text/css" href="./components/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
<link type="text/css" href="./components/vendor/aos/aos.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link type="text/css" href="./components/css/style.css" rel="stylesheet">




<style>
#hero {
	background-image: url("./application/img/michele3.jpg");
}
</style>


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
				<img id="myloginForm"
					src="./application/img/michele.jpg" alt=""
					class="img-fluid rounded-circle">

				<h1 class="text-light">
					<a href="index.html">Michele Lalla</a>
				</h1>
				<div class="social-links mt-3 text-center">
					<!-- a href="" class="twitter"><i class="bx bxl-twitter"></i></a> -->
					<a href="" class="facebook"><i class="bx bxl-facebook"
						data-toggle="modal" data-target="#popLogin"></i></a>
					<!-- a href="" class="instagram"><i class="bx bxl-instagram"></i></a>  -->
					<a href="" class="google-plus"><i class="bx bxl-skype"></i></a> <a
						href="" class="linkedin"><i class="bx bxl-linkedin"></i></a>
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

					<!-- <button type="button" data-toggle="modal" data-target="#popLogin" class="button">Login</button> -->
					<c:if test="${not empty pageContext.request.remoteUser}">
						<div class="lc-block">
							<h6>
								Ciao <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
							</h6>
							<form action="${pageContext.request.contextPath}/logout"
								method="post">
								<input type="submit" class="button red big" value="Logout" /> <input
									type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</div>


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

		<!-- ======= Breadcrumbs ======= ->
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

		<section id="hero"
			class="d-flex flex-column justify-content-center align-items-center">
			<div class="container">


				<div id="index">
					<div class="hero-container" data-aos="fade-in">
						<h1>Michele Lalla</h1>
						<p>
							Ho scritto: <span class="typed"
								data-typed-items="${pubblicazioni}"></span>
								<!-- data-typed-items="  Il campo di pomodori , Vita in B minore, Andrò in America 1 , 70 storie zen occidentali , Le cinque stagioni , Il campo di pomodori "></span> --> 
						</p>
						<!-- Trovare il senso:<br-->
					</div>
					<div id="biografia"></div>
				</div>
			</div>
		</section>
		<!-- End Hero -->

		<!-- Login -->
		<div class="container">
			<!-- .modal -->
			<div class="modal fade" id="popLogin" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="" class="">
							<div class="container">
								<div class="modal-header">
									<div class="section-title">
										<h2>Autentificazione</h2>
									</div>

									<button type="button" class="close" aria-label="Close"
										data-dismiss="modal">
										<span aria-hidden="true">&times;</span>
									</button>

								</div>
								<div class="modal-body">

									<div class="row" data-aos="fade-in">
										<div class="col-lg-12">
											<!-- action="${url}" method="POST"  action="${url}" modelAttribute="user"-->
											<spring:url var="url" value="login" />
											<form method="POST" role="form" class="php-email-for">
												<div class="form-group">
													<label for="Username">Username:</label> <input type="text"
														class="form-control" id="username" name="username"
														placeholder="Username" data-rule="minlen:4"
														data-msg="Inserisci l'username per favore" />
													<div class="validate"></div>
												</div>
												<div class="form-group">
													<label for="Password">Password:</label> <input
														type="password" class="form-control" id="password"
														name="password" placeholder="Password"
														data-rule="minlen:3"
														data-msg="Inserisci la password per favore" />
													<div class="validate"></div>
												</div>

												<div class="text-center">
													<button class="button" type="submit" value="Login"
														onclick="myLogin()">Login</button>
													<!-- onclick="myLogin()" -->
												</div>
											</form>
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



	</main>
	<!-- End #main -->

	<!-- ======= Footer =======
	<footer id="footer">
		<div class="container">
			<div class="copyright">
				&copy; Copyright <strong><span>iPortfolio</span></strong>
			</div>
			<div class="credits"> -->
				<!-- All the links in the footer should remain intact. -->
				<!-- You can delete the links only if you purchased the pro version. -->
				<!-- Licensing information: https://bootstrapmade.com/license/ -->
				<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/iportfolio-bootstrap-portfolio-websites-template/ -->
				<!-- Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
			</div>
		</div>
	</footer>
	End  Footer

	<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a> -->


	<!-- jQuery 3.2.1 
		<script type="text/javascript" src="/MicheleProject/components/jquery/jquery.min1.js"></script> -->
	<!-- Vendor JS Files -->

	<!-- Vendor JS Files -->
	<script type="text/javascript" src="./components/vendor/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="./components/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="./components/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script type="text/javascript" src="./components/vendor/php-email-form/validate.js"></script>
	<script type="text/javascript" src="./components/vendor/waypoints/jquery.waypoints.min.js"></script>
	<script type="text/javascript" src="./components/vendor/counterup/counterup.min.js"></script>
	<script type="text/javascript" src="./components/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script type="text/javascript" src="./components/vendor/venobox/venobox.min.js"></script>
	<script type="text/javascript" src="./components/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script type="text/javascript" src="./components/vendor/typed.js/typed.min.js"></script>
	<script type="text/javascript" src="./components/vendor/aos/aos.js"></script>

	<!-- Template Main JS File -->
	<script type="text/javascript" src="./components/js/main.js"></script>
	<script type="text/javascript" src="./components/js/index.js"></script>
	<!-- <script type="text/javascript" src="./components/js/myLoader.js"></script>
	<script src="/MicheleProject/components/jquery/jquery-ajax-3.1.1.min.js"></script> -->

</body>

</html>