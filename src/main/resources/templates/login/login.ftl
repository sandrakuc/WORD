
<#import "../template.ftl" as t>

<@t.page>
    <h2>Zaloguj się</h2><br>
    <form method="POST">
       login: <input type="text" name="login"><br>
       haslo: <input type="password" name="password"><br><br>
       <input type="submit" value="Submit">
     </form>
     <br>
     <p>Nie masz jeszcze konta? <a href="register"></a></p>

     <br><br>
     Póki co dla testu linki do odpowiednich paneli użytkownikow beda tutaj
     <br><br>
     <a href="adminPanel">adminPanel</a><br>
     <a href="krysiaPanel">krysiaPanel</a><br>
     <a href="pkkPanel">pkkPanel</a><br>
     <a href="practicalExaminerPanel">practicalExaminerPanel</a><br>
     <a href="teoreticalExaminerPanel">teoreticalExaminerPanel</a><br>


</@t.page>

