<#import "../../template.ftl" as t>

<@t.page>
    <h2>Zapisywanie na egzamin teoretyczny</h2><br>

    	 <form action="signOnTeoreticalExamResult" method="POST">
           PESEL zdającego: <input type="text" name="pesel"><br>
           ID egzaminu: <input type="text" name="teoreticalExamId"><br>

           <br>
             <input name="signOnExam" type="submit" value="Zapisz na egzamin">
        </form>

        <br>
        <a href="krysiaPanel">Wstecz</a>

</@t.page>
