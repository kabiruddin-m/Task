<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
</head>
<body>
	<h1>
		<bean:write name="addressForm" property="message" />
	</h1>
</body>
</html>