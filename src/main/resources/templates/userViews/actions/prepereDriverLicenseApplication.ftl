<#import "../../template.ftl" as t>

<@t.page>
    <h2>Składanie wniosku o prawo jazdy do PWPW</h2>


    	 <form name="sendToPwpw" method="POST">
           //Dobrze gdyby to java sama z obiektu PKK uzupełniała <br>
           imie: <input type="text" name="name"><br>
           Nazwisko: <input type="text" name="surname"><br>
           Adres: <input type="text" name="address"><br>
           Pesel: <input type="text" name="pesel"><br>

           <br>
           //To juz recznie by sie wpisywalo <br>
           Kategoria: <input type="text" name="DLCategory"><br><br>
           <input name="sendToPwpw" type="submit" value="Wyslij wniosek do PWPW">
           <br>
           //i niech po wcisnieciu wyswietli czy wyslalo na tej samej stronie

    	</form>


        <br><br>
        <a href="cityDepEmployeePanel">Wstecz</a>

</@t.page>
