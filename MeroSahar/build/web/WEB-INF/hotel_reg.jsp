<!DOCTYPE html>
<html>
<head>
	<title>Hotel Registration</title>
	<!-- Latest compiled and minified CSS -->
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

	<link rel="stylesheet" type="text/css" href="css/all.css">
</head>
<body>
	<div class="hotel-reg-contain">
	<form action="" class="hotel-form">
		<div class="form-group">
			<h2>
				Register Your Hotel
				<br>
				<small>Get more customers from our desk</small>
			</h2>
		</div>
		<div class="row main-conten">
			<div class="col-6">
				<div class="form-group">
					<img src="images/default_activity_image.jpg" alt="artical-img"  id="articalimg" class="img-thumbnail">
              		<input type="file" name="photo" class="form-control-file">
				</div>
				
			</div>

			<div class="col-6 right-conten">
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
						<input type="text" name="name" id="name" placeholder="Hotel Name" class="form-control form-control-lg">
					</div>	
				</div>
				
				<div class="form-group">
					<input type="text" name="contact" id="contact" placeholder="Contact Person" class="form-control form-control-lg">
				</div>

				<div class="form-group">
					<input type="text" name="telephone" id="telephone" placeholder="Telephone" class="form-control form-control-lg">
				</div>

				<div class="form-group">
					<select name="location" id="location" class="form-control form-control-lg">
						<option value="bhaktapur">Bhaktapur</option>
						<option value="kathamandu">kathmandu</option>
					</select>
				</div>

				<div class="form-group">
					<input type="text" name="website" id="website" placeholder="Website" class="form-control form-control-lg">
				</div>

				<div class="form-group">
					<button type="submmit" class="btn btn-primary btn-lg sub-btn" name="submmit">Register</button>
				</div>
			</div>
		</div>
	</form>
</div>
</body>
</html>