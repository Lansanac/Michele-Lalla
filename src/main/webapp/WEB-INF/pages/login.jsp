<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta charset="utf-8"/>
		
		<title>Authentication</title>
	</head>
	<body>
		<div class="col-md-4 col-md-offset-4 spacer40">
			<div class="panel panel-primary">
				<div class="panel-heading">Autenticazione</div>
				<div class="panel-body">
					<div  class="red">
						Username o passwword sbagliato!
					</div>
					<div  class="red">
						Sei disconesso!
					</div>
					<form  method="post" >
						<div>
							<label> Usernam</label>
							<input type="text" name="username"/>
						</div>
						<div>
							<label> Password</label>
							<input type="password" name="password"/>
						</div>
						<button type="submit">Login</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>