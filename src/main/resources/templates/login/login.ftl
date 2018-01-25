
<#import "../template.ftl" as t>

<@t.page>

    <form method="POST">
       login: <input type="text" name="login"><br>
       haslo: <input type="password" name="password"><br>
       <input type="submit" value="Submit">
     </form>

</@t.page>

