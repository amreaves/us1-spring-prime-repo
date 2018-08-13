<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Prime Number Generator</title>

		<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
		<link href="${bootstrapCss}" rel="stylesheet" />

	</head>

	<spring:url value="/" var="urlHome" />
	<nav class="navbar navbar-inverse ">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${urlHome}">US1 Programming Test</a>
			</div>	
		</div>
	</nav>
	
<body>
	<div class="container">
	<form:form action="primenumber_generator_results" method="post" modelAttribute="primeForm">
		<table>
        	<tr>
            	<td><h2>Prime Number Generator</h2></td>
            </tr>
            <tr>
            	<td><p>Enter pairs of number ranges to determine prime numbers:</p></td>                  	
            </tr>
             <tr>       
            	<td><p>Example input: <code>{ [0,10], [50,61] }</code></p></td>
            </tr>
            <tr>
                <td><form:label path="numberPairInput">Input:</form:label>
                <td><form:input path="numberPairInput" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Generate Prime Numbers" /></td>
            </tr>
            </table>	
	</form:form>	
	</div>
	
	<div class="container">
		<hr>
		<footer>
			<p class="small">&copy; A.Reaves 2018</p>
		</footer>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />

	<script src="${bootstrapJs}"></script>
	
	</body>
</html>