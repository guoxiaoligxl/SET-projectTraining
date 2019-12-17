<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mail</title>
</head>
<body>
	<h3>Start Time:${date}</h3>
	<br>
	<h3>Status:Pass ${pass} Failure ${fail}</h3>
	<br>
	<h4>TestCase</h4>
	<hr>
	<table border="1" cellpadding="2" cellspacing="0"  width="800" height="100" align="center"  bordercolor="blue" bgcolor="">
    <tr align="center">
        <td >count</td>
        <td bgcolor="red">fail-case</td>
        <td bgcolor="green">pass-case</td>
        <td bgcolor="yellow">skip-case</td>
    </tr>
    <tr align="center">
        <td>${method}</td>
        <td bgcolor="red">${fail}</td>
        <td bgcolor="green">${pass}</td>
        <td bgcolor="yellow">${skip}</td>
    </tr>
</table>
</body>
</html>
