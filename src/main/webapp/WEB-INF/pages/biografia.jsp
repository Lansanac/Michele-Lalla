<!-- %@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> -->
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
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
<link href="/MicheleProject/application/img/michele.jpg" rel="icon">
<link href="/MicheleProject/application/img/michele.jpg"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="/MicheleProject/components/css/fonts.googleapis.com.css"
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

<style>
#hero {
	background-image: url("/MicheleProject/application/img/michele3.jpg");
}

#michele2 {
	width: 350px;
	height: 500px;
}
</style>

<!-- 	<script src="<spring:url value='js/myscript.js'/>" type="text/javascript"> </script>
	=======================================================
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


		<!-- ======= Hero Section ======= -->


		<!-- ======= About Section ======= -->
		<div id="biografia">
			<section id="diMe" class="about resume">
				<div class="container">

					<div class="section-title">
						<h2>Biografia</h2>
						<p>Michele Lalla è nato a Liscia (provincia di Chieti) il 18
							febbraio 1952. Si è laureato in fisica all’Università degli Studi
							di Roma nel 1976. Si è specializzato in didattica della fisica
							all’Università degli Studi di Modena nel 1977. È stato
							funzionario tecnico e professore di statistica sociale presso il
							Dipartimento di Economia “Marco Biagi” dell’Università degli
							Studi di Modena e Reggio Emilia, con un periodo di insegnamento
							presso la Facoltà di Economia dell’Università degli Studi di
							Palermo nell’anno accademico 1992/93. È in pensione dal primo
							novembre 2020.</p>
					</div>

					<c:if test="${ empty pageContext.request.remoteUser}">
						<div class="row">
							<div class="col-lg-4" data-aos="fade-right">
								<img id="michele2"
									src="/MicheleProject/application/img/michele2.jpg"
									class="img-fluid" alt="">
							</div>
							<div class="col-lg-8 pt-4 pt-lg-0 content" data-aos="fade-left">
								<h3>Professore &amp; Scrittore</h3>
								<p class="font-italic">Lorem ipsum dolor sit amet,
									consectetur adipiscing elit, sed do eiusmod tempor incididunt
									ut labore et dolore magna aliqua.</p>

								<div class="row">
									<div class="col-lg-7">
										<ul>
											<li><i class="icofont-rounded-right"></i> <strong>Nato:</strong>
												il 18 febbraio 1952</li>
											<li><i class="icofont-rounded-right"></i> <strong>Site
													web:</strong> www.poetipoesia.com/michele-lalla</li>
										</ul>
									</div>
									<div class="col-lg-5">
										<ul>
											<li><i class="icofont-rounded-right"></i> <strong>Studi:</strong>
												Laurea</li>
											<li><i class="icofont-rounded-right"></i> <strong
												class="flag-icon flag-icon-it">Città:</strong> Modena</li>
										</ul>
									</div>
								</div>

								<c:forEach var="opera" items="${opere}">
									<ul>
										<li><i class="icofont-rounded-right"></i> <strong>In
												${opera.data}:</strong> ${opera.descrizione}</li>
									</ul>
								</c:forEach>
							</div>
						</div>
					</c:if>

					<c:if test="${not empty pageContext.request.remoteUser}">
						<div class="row">
							<div class="col-lg-10 pt-4 pt-lg-0 content" data-aos="fade-left"">
								<div class="section-title">
									<h3>Professore &amp; Scrittore</h3>
								</div>
							</div>
							<div class="col-lg-2">
								<button type="button" data-toggle="modal"
									data-target="#popInsertOpera" class="button">Inserisci</button>
							</div>
							<!-- <c:if test="${not empty pageContext.request.remoteUser}"> -->

							<!-- </c:if> -->
						</div>

						<div class="row">
							<!-- <div class="col-lg-4" data-aos="fade-right">
									<img id="michele2" src="http://localhost:8080/MicheleProject/application/img/michele2.jpg"
										class="img-fluid" alt="">
								</div> -->

							<div class="col-lg-12 pt-4 pt-lg-0 content" data-aos="fade-left">
								<!-- <h3>Professore &amp; Scrittore</h3> -->


								<p class="font-italic">Lorem ipsum dolor sit amet,
									consectetur adipiscing elit, sed do eiusmod tempor incididunt
									ut labore et dolore magna aliqua.</p>

								<div class="row">
									<div class="col-lg-7">
										<ul>
											<li><i class="icofont-rounded-right"></i> <strong>Nato:</strong>
												il 18 febbraio 1952</li>
											<li><i class="icofont-rounded-right"></i> <strong>Site
													web:</strong> www.poetipoesia.com/michele-lalla</li>
										</ul>
									</div>
									<div class="col-lg-5">
										<ul>
											<li><i class="icofont-rounded-right"></i> <strong>Studi:</strong>
												Laurea</li>
											<li><i class="icofont-rounded-right"></i> <strong
												class="flag-icon flag-icon-it">Città:</strong> Modena</li>
									</div>
								</div>

								<table class="table table-sm">
									<c:forEach var="opera" items="${opere}">
										<tr>
											<td style="width: 100px;">
												<div>
													<ul>
														<li><i class="icofont-rounded-right"></i> <strong>In
																${opera.data}:</strong></li>
													</ul>
												</div>
											</td>
											<td>${opera.descrizione}</td>
											<td style="cursor: pointer"><a data-toggle="modal"
												data-target="#popUpdateOpera" data-gall="portfolioGallery"
												onclick="updatePrepareOpera('${opera.id}')">Modifica</a></td>
											<td style="cursor: pointer"><a data-toggle="modal"
												data-target="#confirmazioneO" data-gall="portfolioGallery"
												onclick="confermaDeleteO('${opera.id}', '${opera.descrizione}')">Elimina</a>
											</td>
										</tr>
									</c:forEach>
								</table>


							</div>

						</div>
					</c:if>
					<div class="row">
						<div class="col-lg-10">
							<div class="section-title">
								<h2>Premiazioni &amp; Segnalazioni</h2>
							</div>
						</div>

						<c:if test="${not empty pageContext.request.remoteUser}">
							<div class="col-lg-2">
								<button type="button" data-toggle="modal"
									data-target="#popInsertPremiazione" class="button">Inserisci</button>
							</div>
						</c:if>

					</div>

					<%
					int j = 1;
					%>
					<c:forEach var="item" items="${premiazioni}">
						<%
						if (j == 1) {
						%>
						<div class="row">
							<div class="col-lg-4 col-md-6 portfolio-item filter-app"
								data-aos="fade-up" data-aos-delay="100">
								<div class="resume-item">
									<h4>${item.titolo}</h4>
									<h5>${item.data}</h5>
									<p>
										<em> ${item.citta} </em>
									</p>

									<ul>${item.descrizione}
									</ul>
									<p>
									<div class="portfolio-wrap">
										<c:if test="${not empty pageContext.request.remoteUser}">
											<div class="portfolio-links">
												<a data-toggle="modal" data-target="#popUpdate"
													data-gall="portfolioGallery"
													onclick="updatePrepare('${item.id}')" class="button">Modifica</a>
												<a data-toggle="modal" data-target="#confirmazione"
													data-gall="portfolioGallery"
													onclick="confermaDeleteP('${item.id}', '${item.titolo}')"
													class="button">Elimina</a>
											</div>
										</c:if>
									</div>
									</p>
								</div>
							</div>
							<%
							j++;
							} else if (j == 2) {
							%>
							<div class="col-lg-4" data-aos="fade-up" data-aos-delay="100">
								<div class="resume-item">
									<h4>${item.titolo}</h4>
									<h5>${item.data}</h5>
									<p>
										<em> ${item.citta} </em>
									</p>
									<ul>${item.descrizione}
									</ul>
									<p>
									<div class="portfolio-wrap">
										<c:if test="${not empty pageContext.request.remoteUser}">
											<div class="portfolio-links">
												<a data-toggle="modal" data-target="#popUpdate"
													data-gall="portfolioGallery"
													onclick="updatePrepare('${item.id}')" class="button">Modifica</a>
												<a data-toggle="modal" data-target="#confirmazione"
													data-gall="portfolioGallery"
													onclick="confermaDeleteP('${item.id}', '${item.titolo}')"
													class="button">Elimina</a>
											</div>
										</c:if>
									</div>
									</p>
								</div>
							</div>
							<%
							j++;
							} else if (j == 3) {
							%>
							<div class="col-lg-4" data-aos="fade-up" data-aos-delay="100">
								<div class="resume-item">
									<h4>${item.titolo}</h4>
									<h5>${item.data}</h5>
									<p>
										<em> ${item.citta} </em>
									</p>
									<ul>${item.descrizione}
									</ul>
									<p>
									<div class="portfolio-wrap">
										<c:if test="${not empty pageContext.request.remoteUser}">
											<div class="portfolio-links">
												<a data-toggle="modal" data-target="#popUpdate"
													data-gall="portfolioGallery"
													onclick="updatePrepare('${item.id}')" class="button">Modifica</a>
												<a data-toggle="modal" data-target="#confirmazione"
													data-gall="portfolioGallery"
													onclick="confermaDeleteP('${item.id}', '${item.titolo}')"
													class="button">Elimina</a>
											</div>
										</c:if>
									</div>
									</p>
								</div>
							</div>
						</div>
						<%
						j = 1;
						}
						%>

					</c:forEach>



				</div>
			</section>
			<!-- End About Section -->

		</div>



		<!-- Inserisci la premiazioni -->
		<div class="container">
			<!-- .modal -->
			<div class="modal fade" id="popInsertPremiazione" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="" class="">
							<div class="container">
								<div class="modal-header">
									<div class="section-title">
										<h2>Inserisci la premiazioni</h2>
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
													class="form-control" id="titoloPremiazioe"
													data-rule="minlen:4" placeholder="Titolo"
													data-msg="Inserisci il titolo per favore" />
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Anno">Anno:</label> <input type="text"
													class="form-control" id="annoPremiazioe"
													data-rule="minlen:4" placeholder="Anno"
													data-msg="Inserisci l'anno per favore" />
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Anno">Città:</label> <input type="text"
													class="form-control" id="cittaPremiazioe"
													data-rule="minlen:4" placeholder="Citta"
													data-msg="Inserisci la città per favore" />
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Descrizione">Descrizione:</label>
												<textarea class="form-control" rows="10"
													id="descrizionePremiazioe" data-rule="required"
													placeholder="Descrizione"
													data-msg="Inserisci la descrizione per favore"></textarea>
												<div class="validate"></div>
											</div>
											<div id="result"></div>
											<div class="text-center">
												<button class="button" type="submit"
													onclick="insertPremiazioe()" value="Inserisci"
													data-toggle="modal" data-target="#myReslteP"
													data-gall="portfolioGallery">Inserisci</button>
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

		<!-- Inserisci la opera -->
		<div class="container">
			<!-- .modal -->
			<div class="modal fade" id="popInsertOpera" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="" class="">
							<div class="container">
								<div class="modal-header">
									<div class="section-title">
										<h2>Inserisci l'opera</h2>
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
												<label for="Anno">Anno:</label> <input type="text"
													class="form-control" id="annoOpera" data-rule="minlen:4"
													placeholder="Anno" data-msg="Inserisci l'anno per favore" />
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Descrizione">Descrizione:</label>
												<textarea class="form-control" rows="10"
													id="descrizioneOpera" data-rule="required"
													placeholder="Descrizione"
													data-msg="Inserisci la descrizione per favore"></textarea>
												<div class="validate"></div>
											</div>
											<div id="result"></div>
											<div class="text-center">
												<button class="button" type="submit" onclick="insertOpera()"
													value="Inserisci" data-toggle="modal"
													data-target="#popReslte" data-gall="portfolioGallery">Inserisci</button>
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

		<!-- .modal Modifica Opere-->
		<div class="container">

			<div class="modal fade" id="popUpdateOpera" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="popUpdatePremiazioe" class=""></section>
						<!-- End Contact Section -->
					</div>
				</div>
			</div>
		</div>

		<!-- .modal Modifica Pre -->
		<div class="container">

			<div class="modal fade" id="popUpdate" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="popUpdatePremiazioe" class=""></section>
						<!-- End Contact Section -->
					</div>
				</div>
			</div>
		</div>

		<!-- Resulte Opere-->
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

		<!-- Resulte Pre-->
		<div class="container">
			<!-- .modal -->
			<div class="modal fade" id="popReslte" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="myReslteP" class=""></section>
						<!-- End Contact Section -->
					</div>
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="confirmazioneO" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<div class="section-title">
							<h2>Elimina L'opera</h2>
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
		<!-- Modal -->
		<div class="modal fade" id="confirmazione" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<div class="section-title">
							<h2>Elimina Premiazione</h2>
						</div>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div id="myTiteleP"></div>
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
						<a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
						<!-- a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>  -->
						<a href="#" class="google-plus"><i class="bx bxl-skype"></i></a> <a
							href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
					</p>
				</div>
			</div>

		</footer>
	</main>
	<!-- End #main -->

	<!-- Vendor JS Files -->
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
	<script src="/MicheleProject/components/js/biografia.js"></script>
	<script src="/MicheleProject/components/js/myLoader.js"></script>
	<script
		src="/MicheleProject/components/jquery/jquery-ajax-3.1.1.min.js"></script>

</body>

</html>