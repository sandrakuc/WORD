
<#import "../template.ftl" as t>

<@t.page>
    <h2>Zaloguj się</h2><br>
    <form method="POST">
       login: <input type="text" name="login"><br>
       haslo: <input type="password" name="password"><br><br>
       <input type="submit" value="Submit">
     </form>

</@t.page>

