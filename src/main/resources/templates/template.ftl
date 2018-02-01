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
				<a href="contact">Kontakt        </a>
				<a href="login">Zaloguj</a>
                <a href="logout">Wyloguj</a>
		</div>
		<div id="leftmenu">
		            <#if Session.user?exists>
        			<span>Witaj ${Session.user.firstName} ${Session.user.lastName}</span>
        			<#else>
        			<span>Odwiedzasz strone jako gość</span>
        			</#if><br><br>

				<a href="http://localhost:8080/">Home</a><br>
				<a href="contact">Kontakt</a><br>
				<a href="login">Zaloguj</a><br>
                <a href="logout">Wyloguj</a><br>

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
