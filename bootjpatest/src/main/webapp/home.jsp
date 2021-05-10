<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ashish Learns Spring</title>
</head>
<body style="background-color:powderblue">
	<h1 style="text-align:center"><u>CRUD operations using Spring Boot</u></h1>
	<h2>To add the Data to the DataBase</h2>
	<form action="addAlien">
		Alien Id:<input type="text" name="aid"><br>
		Alien Name:<input type="text" name="aname"><br>
		Alien Tech:<input type="text" name="atech"><br>
		<button onclick="insertfunction()"><input type="submit" value="Insert"><br></button>	
	</form>
	
	<h2>To find the Data Based on the ID</h2>
	<form action="getAlien">
		Alien Name:<input type="text" name="aid"><br>
		<input type="submit" value="Find"><br>
	</form>
	
	<h2>To Update the Data</h2>
	<form action="updateAlien">
		Alien Id:<input type="text" name="aid"><br>
		Alien Name:<input type="text" name="aname"><br>
		Alien Tech:<input type="text" name="atech"><br>
		<button onclick="updatefunction()"><input type="submit" value="Update"><br></button>
	</form>
	
	<h2>To delete the Data</h2>
	<form action="deleteAlien">
		Alien Id:<input type="text" name="aid"><br>
		<button onclick="deletefunction()"><input type="submit" value="Delete"><br></button>
	</form>
	
	<h2>To Find by Tech Name</h2>
	<form action="findAlien">
		Alien Tech:<input type="text" name="tech"><br>
		<input type="submit" value="Find By Tech Name"><br>	
	</form>
	
	<script>
		function deletefunction() {
		  alert("Deleted the entry Succesfully");
		}
		function insertfunction() {
			  alert("Inserted the entry Succesfully");
		}
		function updatefunction() {
			  alert("Updated the entry Succesfully");
		}
	</script>
	
</body>
</html>