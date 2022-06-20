
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
<link href="/MicheleProject/components/css/style.css" rel="stylesheet" />

<style>
#hero {
	background-image: url("application/img/michele6.jpg");
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
					<li><a href='<spring:url value="/pubblicazioni/list" />'><i
							class="bx bx-server"></i>Pubblicazioni</a></li>
					<c:if test="${empty pageContext.request.remoteUser}">
						<li><a href='<spring:url value="/contattoPage" />'><i
								class="bx bx-envelope"></i>Contatti</a></li>
					</c:if>
					<c:if test="${not empty pageContext.request.remoteUser}">
						<li><a href='<spring:url value="/contattoPage/list" />'><i
								class="bx bx-envelope"></i>Contatti</a></li>
					</c:if>
			</nav>
			<!-- .nav-menu
			<button type="button" class="mobile-nav-toggle d-xl-none">
				<i class="icofont-navigation-menu"></i>
			</button> -->

		</div>
	</header>
	<!-- End Header -->

	<main id="main">

		<!-- ======= Portfolio Section ======= -->
		<c:if test="${empty pageContext.request.remoteUser}">
			<section id="pubblicazioni" class="portfolio section-bg">
				<div class="container">

					<div class="section-title">
						<h2>Pubblicazioni</h2>
						<p>Magnam dolores commodi suscipit. Necessitatibus eius
							consequatur ex aliquid fuga eum quidem. Sit sint consectetur
							velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit
							suscipit alias ea. Quia fugiat sit in iste officiis commodi
							quidem hic quas.</p>
					</div>

					<!-- <div class="row" data-aos="fade-up">
					<div class="col-lg-12 d-flex justify-content-center">
						<ul id="portfolio-flters">
							<li data-filter="*" class="filter-active">All</li>
							<li data-filter=".filter-app">App</li>
							<li data-filter=".filter-card">Card</li>
							<li data-filter=".filter-web">Web</li>
						</ul>
					</div>
				</div> -->

					<div class="row portfolio-container" data-aos="fade-up"
						data-aos-delay="100">
						<% int i = 1;%>
							<c:forEach var="pubblicazione" items="${pubblicazione}">
						<% if(i==1){%>
							<div class="col-lg-4 col-md-6 portfolio-item filter-app">
								<div class="portfolio-wrap">
									<img class="myImg" src="data:image/jpg;base64,${pubblicazione.image}"
										class="img-fluid" alt="">
									<div class="portfolio-links">
										<a href="data:image/jpg;base64,${pubblicazione.image}"
											data-gall="portfolioGallery" class="venobox" title="${pubblicazione.titolo}"
											width="141" height="192" data-target="#popImg"><i
											class="bx bx-plus"></i></a> <a href="${pubblicazione.description}"
											title="More Details" data-toggle="modal" onclick="dettaglio('${pubblicazione.id}')"
											data-target="#pubCampo"><i class="bx bx-link"></i></a>
									</div>
								</div>
							</div>
						<% 	i++; }
						else if(i==2){ %>
						
							<div class="col-lg-4 col-md-6 portfolio-item filter-web">
								<div class="portfolio-wrap">
									<img class="myImg" src="data:image/jpg;base64,${pubblicazione.image}"
										class="img-fluid" alt="">
									<div class="portfolio-links">
										<a href="data:image/jpg;base64,${pubblicazione.image}"
											data-gall="portfolioGallery" class="venobox" title="${pubblicazione.titolo}"
											width="141" height="192" data-target="#popImg"><i
											class="bx bx-plus"></i></a> <a href="${pubblicazione.description}"
											title="More Details" data-toggle="modal" onclick="dettaglio('${pubblicazione.id}')"
											data-target="#pubCampo"><i class="bx bx-link"></i></a>
									</div>
								</div>
							</div>
					  	<% i++;}
	       				else if(i==3){ %>
							<div class="col-lg-4 col-md-6 portfolio-item filter-app">
								<div class="portfolio-wrap">
									<img class="myImg" src="data:image/jpg;base64,${pubblicazione.image}"
										class="img-fluid" alt="">
									<div class="portfolio-links">
										<a href="data:image/jpg;base64,${pubblicazione.image}"
											data-gall="portfolioGallery" class="venobox" title="${pubblicazione.titolo}"
											width="141px" height="192px" data-target="#popImg" ><i
											class="bx bx-plus"></i></a> <a href="${pubblicazione.description}" onclick="dettaglio('${pubblicazione.id}')"
											title="More Details" data-toggle="modal"
											data-target="#pubCampo"><i class="bx bx-link"></i></a>
									</div>
								</div>
							</div>
						<% i=1;	} %>
						</c:forEach>

						
					</div>

				</div>
			</section>
			<!-- End Portfolio Section -->


			<!--POP Il campo di pomodori -->
			<div class="container">
				<!-- .modal -->
				<div class="modal fade" id="pubImg" role="dialog">
					<!-- <div class="modal-dialog modal-lg">
						<div class="modal-content">
							<section id="popDettaglioPub" class="">
							
							</section> <!-- End Contact Section -->
						<!-- End Contact Section ->
						</div>
					</div> -->
				</div>
			</div>
			
			<!--POP Il campo di pomodori -->
			<div class="container">
				<!-- .modal -->
				<div class="modal fade" id="pubCampo" role="dialog">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<section id="popDettaglioPub" class="">
							
							</section> <!-- End Contact Section -->
						<!-- End Contact Section -->
						</div>
					</div>
				</div>
			</div>

			<!--POP Vita in b minore -->
			<div class="container">
				<!-- .modal -->
				<div class="modal fade" id="popVitaInBMinore" role="dialog">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<section id="" class="">
								<div class="container">
									<div class="modal-header">
										<div class="section-title">
											<h2>Vita in B minore</h2>
										</div>

										<button type="button" class="close" aria-label="Close"
											data-dismiss="modal">
											<span aria-hidden="true">&times;</span>
										</button>

									</div>
									<div class="modal-body">
										<div class="container">
											<div class="row" data-aos="fade-in">
												<p>
													Un bruco (letterario) espone le sue riflessioni e
													condizioni, aspirazioni e frustrazioni, esperienze e
													sentimenti, confronti e contrasti con l'uomo. Quasi tutte
													le liriche tirano fila che collegano i due piani (bruco e
													uomo, animale e spirituale, corpo e anima) proiettandoli
													sullo spazio-tempo che materializza le illusioni, i sogni,
													le angustie, i bisogni, l'amore. Tutto accade e trasforma
													l'esssere nel presente certo per un futuro incerto. <br>
													Si procede, cosí, fino al materiale ultimo della sua
													disfatta e al macero del cosmo, utilizzando uno stile
													"libero" e un linguaggio piú o meno articolato perché è
													quello di un bruco non asservito alle regole dominanti.
												</p>

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
		</c:if>

		<c:if test="${not empty pageContext.request.remoteUser}">
			<div id="listContatto">
				<section id="diMe" class="services">
					<div class="container">

						<div class="section-title">
							<div class="row">
								<div class="col-lg-10">
									<div class="section-title">
										<h2>Pubblicazioni</h2>
									</div>
								</div>
								<div class="col-lg-2">
									<button type="button" data-toggle="modal"
										data-target="#popInsert" class="button">Inserisci</button>
								</div>
							</div>
						</div>

						<div class="row icon-box" data-aos="fade-up">
							<table class="table table-sm">
								
								<c:forEach var="pubblicazione" items="${pubblicazione}">
									<tr>
										<td style="cursor: pointer"><strong>${pubblicazione.titolo}</strong></td>
										<td>${pubblicazione.description}</td>
										<td>${pubblicazione.dataPubblicazioneM}</td>
										<td>
											<div class="portfolio-wrap">
												<img src="data:image/jpg;base64,${pubblicazione.image}" style='width: 100%; '>
											</div>

										</td>
										<td>
											<p style="cursor: pointer"><button type="button" 
											data-toggle="modal" data-target="#popUpdatePub" onclick="updatePreparePub('${pubblicazione.id}')" 
											class="button">Modifica</button></p>
											<p style="cursor: pointer">
											<button type="button" data-toggle="modal" data-target="#confirmazione" data-gall="portfolioGallery"
											onclick="confermaDelete('${pubblicazione.id}', '${pubblicazione.titolo}')" class="button">Elimina</button></p>
											
										</td>
										
									</tr>
								</c:forEach>
							</table>
						</div>

					</div>

				</section>
			</div>
		</c:if>



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
										<h2>Inserisci la pubblicazioni</h2>
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
													class="form-control" id="titoloPubb"
													data-rule="minlen:4" placeholder="Titolo"
													data-msg="Inserisci il titolo per favore" />
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Anno">Anno:</label> <input type="text"
													class="form-control" id="annoPubb"
													data-rule="minlen:4" placeholder="Anno"
													data-msg="Inserisci l'anno per favore" />
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Descrizione">Descrizione:</label>
												<textarea class="form-control" rows="10"
													id="descrizionePubb" data-rule="required"
													placeholder="Descrizione"
													data-msg="Inserisci la descrizione per favore"></textarea>
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Anno">Immagine:</label> <input type="file"
													class="form-control uploadedfile" id="imagePubbIn"
													placeholder="immagine" /> <!-- onclick="fileuploadinit()" --> 
												<div class="validate"></div>
											</div>
											<div id="result"></div>
											<div class="text-center">
												<button class="button" type="submit" onclick="insertPublicazione()" value="Inserisci"
												data-toggle="modal" data-target="#popReslte" data-gall="portfolioGallery">Inserisci</button>
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
			<div class="modal fade" id="popUpdatePub" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<section id="popUpdatePubblicazioni" class="">
							
						</section> <!-- End Contact Section -->                                                                
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
							<h2>Elimina Pubblicazione</h2>
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


	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer">
		<jsp:include page="../template/menuFooter.jsp" />
	</footer>
	<!-- End  Footer -->
	
	</div>
	!-- Vendor JS Files -->
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
	<script src="/MicheleProject/components/js/publicazione.js"></script>
	<script src="/MicheleProject/components/js/myLoader.js"></script>
	<script src="/MicheleProject/components/jquery/jquery-ajax-3.1.1.min.js"></script>


</body>
</html>