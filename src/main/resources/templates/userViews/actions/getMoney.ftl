<#import "../../template.ftl" as t>

<@t.page>
    <h2>Księgowanie wpłaty zdającego</h2><br>
    	<form method="POST">

           Kwota: <input type="text" name="cash"><br>
           PESEL wpłacającego: <input type="text" name="pesel"><br>
             <br>//po peselu wiedzialoby ktoremy pkk oznaczyc ze zaplacone<br><br>

           <input name="getMoney" type="submit" value="Zaksięguj wpłate">
           <br>
           //i niech po wcisnieciu wyswietli czy zaksiegowane, na tej samej stronie

    	</form>


        <br><br>
        <a href="krysiaPanel">Wstecz</a>
</@t.page>
