<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
function ldapAuthenticate() {
	var userData = {"userId" : "", "userPassword" : ""};
	userData.userId = $('#userId').val();
	userData.userPassword = $('#userPassword').val();
	
	$.ajax({
		type : "POST",
		url : "/ldap/user/auth",
		data : JSON.stringify(userData),
        contentType: 'application/json',
		success : function(msg) {
			alert("success");
		},
		error : function() {
			alert("failure");
		}
	});
}	
</script>
</head>
<body>
	<h1>Example - Spring Boot LDAP Authentication</h1>

	<form method="POST" action="/">
		User ID :  <input type="text" name="userId" id="userId"/><br /> 
		Password : <input type="password" name="userPassword" id="userPassword"/><br /> 
		<br /> <input type="button" value="Submit" onClick="ldapAuthenticate();"/>
	</form>

</body>
</html>