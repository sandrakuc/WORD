<#import "../../template.ftl" as t>

<@t.page>
    <h2>Zapisywanie na egzamin teoretyczny</h2><br>

    	<form name="signOnExam" method="POST">
           Imie: <input type="text" name="name"><br>
           Nazwisko: <input type="text" name="surname"><br>
           PESEL: <input type="text" name="pesel"><br>
           //Po Peselu znajdowałoby o ktore PKK chodzi
           <br>
           <br>
           Kategoria: <input type="text" name="category"><br>
           <br>
            <p>Godzina egzaminu:</p>
                         <input type="radio" name="hour" value="9" checked> 9:00<br>
                         <input type="radio" name="hour" value="12"> 12:00<br>
                         <input type="radio" name="hour" value="14"> 14:00<br>
                         <input type="radio" name="hour" value="16"> 16:00<br>
           <br>

           <br>
           <input name="signOnExam" type="submit" value="Zapisz na egzamin">
           <br>
           //i niech po wcisnieciu wyswietli czy wyslalo na tej samej stronie

        </form>

        <br>
        <a href="cityDepEmployeePanel">Wstecz</a>

</@t.page>
