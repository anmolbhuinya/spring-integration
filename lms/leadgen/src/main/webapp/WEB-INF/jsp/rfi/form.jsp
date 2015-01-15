<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Online University Request for Information</title>
</head>
<body>

<h1>Online University Request for Information</h1>

<p>Please complete the following form and we will contact you shortly with
more information.</p>

<form:form modelAttribute="rfi">
	<table>
		<tr>
			<td>First name:</td>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><form:input path="lastName" /></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><form:input path="address1" /></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><form:input path="address2" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><form:input path="city" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><form:input path="state" /></td>
		</tr>
		<tr>
			<td>ZIP code:</td>
			<td><form:input path="zipCode" /></td>
		</tr>
		<tr>
			<td>Home phone:</td>
			<td><form:input path="homePhone" /></td>
		</tr>
		<tr>
			<td>Work phone:</td>
			<td><form:input path="workPhone" /></td>
		</tr>
		<tr>
			<td>Mobile phone:</td>
			<td><form:input path="mobilePhone" /></td>
		</tr>
		<tr>
			<td>E-mail:</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit"></input></td>
		</tr>
	</table>
</form:form>

</body>
</html>
