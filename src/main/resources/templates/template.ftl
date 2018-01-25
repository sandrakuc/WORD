<#macro page>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
		<title>WORD SYSTEM</title>
		<#include "/css/style.css">


	</head>
	<body>
		<div id="header">

		</div>
		<div id="topmenu">
				<a href="http://localhost:8080/">Home           </a>
				<a href="kontakt">Kontakt        </a>
				<a href="login">Zaloguj</a>
		</div>
		<div id="leftmenu">
				<a href="http://localhost:8080/">Home</a></li><br>
				<a href="kontakt">Kontakt</a></li><br>
				<a href="login">Zaloguj</a></li><br>
		</div>
		<div id="content">
        <#-- This processes the enclosed content:  -->
        <#nested>

		</div>

	</body>
</html>
</#macro>
