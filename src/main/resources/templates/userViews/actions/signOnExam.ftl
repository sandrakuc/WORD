<#import "../../template.ftl" as t>

<@t.page>
    <h2>Zapisywanie na egzamin</h2><br>

    	<form name="signOnExam" method="POST">
           Imie: <input type="text" name="name"><br>
           Nazwisko: <input type="text" name="surname"><br>
           PESEL: <input type="text" name="pesel"><br>
           //Po Peselu znajdowałoby o ktore PKK chodzi
           <br>
           <br>
           Kategoria: <input type="text" name="category"><br>
           <br>
           Data: <input type="text" name="date"><br>
           Godzina: <input type="text" name="time"><br><br>
           <br>
           Zapisz na egzamin:<br>
           <input type="radio" name="examType" value="teoretical" checked> Teoretyczny<br>
           <input type="radio" name="examType" value="practical"> Praktyczny<br>

           <br>
           <input name="signOnExam" type="submit" value="Zapisz na egzamin">
           <br>
           //i niech po wcisnieciu wyswietli czy wyslalo na tej samej stronie

        </form>

        <br>
        <a href="cityDepEmployeePanel">Wstecz</a>

</@t.page>
