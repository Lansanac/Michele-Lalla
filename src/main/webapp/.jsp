<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<link
	href="http://localhost:8080/MicheleProject/components/img/favicon.png"
	rel="icon">
<link
	href="http://localhost:8080/MicheleProject/components/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="http://localhost:8080/MicheleProject/components/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://localhost:8080/MicheleProject/components/vendor/icofont/icofont.min.css"
	rel="stylesheet">
<link
	href="http://localhost:8080/MicheleProject/components/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="http://localhost:8080/MicheleProject/components/vendor/venobox/venobox.css"
	rel="stylesheet">
<link
	href="http://localhost:8080/MicheleProject/components/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="http://localhost:8080/MicheleProject/components/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link
	href="http://localhost:8080/MicheleProject/components/css/style.css"
	rel="stylesheet">

</head>
<body>

	<main id="myPoesie">
		<!--<c:forEach var="item" items="${contratti}">
				<tr>
					<td>${item.anagrafica.codiceFiscale}</td>
					<td><script> 
					document.write(new Date(${item.dataInizio.getYear()}+1900, ${item.dataInizio.getMonth()}, ${item.dataInizio.getDate()}).toLocaleDateString()); </script></td>
					<td><script> 
					document.write(new Date(${item.dataFine.getYear()}+1900, ${item.dataFine.getMonth()}, ${item.dataFine.getDate()}).toLocaleDateString()); </script></td>
					<td>${item.mansione}</td>
					<td><a id="dettaglio"
						href="<spring:url value="/contratti/get/${item.id}"/>">Apri
							Dettaglio</a></td>
				</tr>
			</c:forEach>-->


		<section id="sPoesie" class="services">
			<div class="container">

				<div class="section-title">
					<h2>Poesie</h2>
				</div>

				<div class="row">
					<div class="col-lg-4 col-md-6 icon-box" data-aos="fade-up">
						<div class="icon">
							<i class="icofont-computer"></i>
						</div>
						<h4 class="title">
							<a href="">Lorem Ipsum</a>
						</h4>
						<p class="description">Voluptatum deleniti atque corrupti quos
							dolores et quas molestias excepturi sint occaecati cupiditate non
							provident</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="fade-up"
						data-aos-delay="100">
						<div class="icon">
							<i class="icofont-chart-bar-graph"></i>
						</div>
						<h4 class="title">
							<a href="">Dolor Sitema</a>
						</h4>
						<p class="description">Minim veniam, quis nostrud exercitation
							ullamco laboris nisi ut aliquip ex ea commodo consequat tarad
							limino ata</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="fade-up"
						data-aos-delay="200">
						<div class="icon">
							<i class="icofont-earth"></i>
						</div>
						<h4 class="title">
							<a href="">Sed ut perspiciatis</a>
						</h4>
						<p class="description">Duis aute irure dolor in reprehenderit
							in voluptate velit esse cillum dolore eu fugiat nulla pariatur</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="fade-up"
						data-aos-delay="300">
						<div class="icon">
							<i class="icofont-image"></i>
						</div>
						<h4 class="title">
							<a href="">Magni Dolores</a>
						</h4>
						<p class="description">Excepteur sint occaecat cupidatat non
							proident, sunt in culpa qui officia deserunt mollit anim id est
							laborum</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="fade-up"
						data-aos-delay="400">
						<div class="icon">
							<i class="icofont-settings"></i>
						</div>
						<h4 class="title">
							<a href="">Nemo Enim</a>
						</h4>
						<p class="description">At vero eos et accusamus et iusto odio
							dignissimos ducimus qui blanditiis praesentium voluptatum
							deleniti atque</p>
					</div>
					<div class="col-lg-4 col-md-6 icon-box" data-aos="fade-up"
						data-aos-delay="500">
						<div class="icon">
							<i class="icofont-tasks-alt"></i>
						</div>
						<h4 class="title">
							<a href="">Eiusmod Tempor</a>
						</h4>
						<p class="description">Et harum quidem rerum facilis est et
							expedita distinctio. Nam libero tempore, cum soluta nobis est
							eligendi</p>
					</div>
				</div>

			</div>
		</section>
		<!-- End Services Section -->

	</main>



	<!-- Vendor JS Files -->
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/jquery/jquery.min.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/php-email-form/validate.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/waypoints/jquery.waypoints.min.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/counterup/counterup.min.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/venobox/venobox.min.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/typed.js/typed.min.js"></script>
	<script
		src="http://localhost:8080/MicheleProject/components/vendor/aos/aos.js"></script>

	<!-- Template Main JS File -->
	<script
		src="http://localhost:8080/MicheleProject/components/js/main.js"></script>


</body>
</html>