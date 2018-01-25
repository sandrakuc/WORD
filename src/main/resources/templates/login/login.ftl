
<#import "../template.ftl" as t>

<@t.page>
    <h2>Zaloguj się</h2><br>
    <form method="POST">
       login: <input type="text" name="login"><br>
       haslo: <input type="password" name="password"><br><br>
       <input type="submit" value="Submit">
     </form>
     <br>
     <p>Nie masz jeszcze konta? <a href="register">Zarejestruj się</a></p>

</@t.page>

