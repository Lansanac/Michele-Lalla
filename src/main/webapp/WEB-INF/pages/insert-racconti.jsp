<!doctype html>
<html lang="en">
<head>
<title>Bootstrap Modal</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<h2>Bootstrap Modal</h2>
	<!-- .Launch Modal Button-->
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#Mymodal">
		Launch Modal
	</button>

	<!-- .modal -->
	<div class="modal fade" id="Mymodal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						�
					</button> 
					<h4 class="modal-title">
						Notification
					</h4>                                                             
				</div> 
				<div class="modal-body">
					Are you sure you want to continue?
				</div>   
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Close
					</button>
					<button type="button" class="btn btn-primary">
						Ok
					</button>                                 
				</div>
			</div>                                                                       
		</div>                                      
	</div>
</div>
</body>
</html>              
