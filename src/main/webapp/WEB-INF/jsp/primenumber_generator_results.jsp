<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Prime Number Generator Results</title>

		<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
		<link href="${bootstrapCss}" rel="stylesheet" />
		<link href="${coreCss}" rel="stylesheet" />
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
        <table>
            <tr>
            	<td colspan="2" align="center"><h2>Prime numbers generated:</h2></td>
            </tr>            
            <tr>
                <td>Number Pair Input:</td>
                <td>${primeForm.numberPairInput}</td>
            </tr>
            <tr>
                <td>Prime Number Output:</td>
                <td>${primeForm.listOfAllPrimes}</td>
            </tr>           
        </table>
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