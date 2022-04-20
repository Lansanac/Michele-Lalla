
														
							<div class="container">
								<div class="modal-header">
									 <div class="section-title">
								          <h2>Modifica la premiazione</h2>
							         </div>
									 
									 <button type="button" class="close" aria-label="Close" data-dismiss="modal">
										  <span aria-hidden="true">&times;</span>
									 </button>
									 
								</div> 
								<div class="modal-body">
							        <div class="row" data-aos="fade-in" id="updateForm">
							          <div class="col-lg-12"> <!-- action="${url}" method="POST" -->
											<div class="form-group">
												<label for="titolo">Titolo:</label>
												<input type="text"
													class="form-control" name="titolo" id="titoloPremiazioeUp" value="${premiazioniData.titolo}"
													data-rule="minlen:4" placeholder="Titolo" data-msg="Inserisci il titolo per favore"/>
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Anno">Anno:</label> 
												<input type="text"
													class="form-control" name="annoPubblicazione" id="annoPremiazioeUp" value="${premiazioniData.data}"
													data-rule="minlen:4" placeholder="Anno" data-msg="Inserisci l'anno per favore" />
												<div class="validate"></div>
											</div>
																						<div class="form-group">
												<label for="Anno">Citta:</label> 
												<input type="text"
													class="form-control" name="annoPubblicazione" id="cittaPremiazioeUp" value="${premiazioniData.citta}"
													data-rule="minlen:4" placeholder="Citta" data-msg="Inserisci l'anno per favore" />
												<div class="validate"></div>
											</div>
											<div class="form-group">
												<label for="Descrizione">Descrizione:</label>
												<textarea class="form-control" name="descrizione" rows="10" id="descrizionePremiazioeUp" 
													data-rule="required" placeholder="Descrizione" data-msg="Inserisci la descrizione per favore">${premiazioniData.descrizione}</textarea>
												<div class="validate"></div>
											</div>
											<div id="result"></div>
											<div class="text-center">
												<button class="button" type="submit" onclick="update('${premiazioniData.id}')" value="Inserisci" data-dismiss="modal" 
												data-toggle="modal" data-target="#popReslte" data-gall="portfolioGallery">Modifica</button>
											</div>
									</div>
									
						        </div>
					      	</div>
							<div class="modal-footer">
								<div class="social-links mt-3 text-center">
									<a class="btn btn-default" data-dismiss="modal">
										Close
									</a>
								</div>
							</div>
						</div>
						
						
	