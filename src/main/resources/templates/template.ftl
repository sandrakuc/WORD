<#macro page>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
		<title>WORD SYSTEM</title>
		<#include "style.css">


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
			<#if Session.user?exists>
			<span>Witaj ${Session.user.firstName} ${Session.user.lastName}</span>
			</#if>
		</div>
		<div id="content">

		<#if flashMessageManager.issetMessage()>
			${flashMessageManager.getMessage()}
		</#if>

        <#-- This processes the enclosed content:  -->
        <#nested>
		</div>

	</body>
</html>
</#macro>
