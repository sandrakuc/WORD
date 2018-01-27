<#import "../../template.ftl" as t>

<@t.page>
    <h2>Tworzenie PKK</h2>

        <form method="POST">
          imie: <input type="text" name="name"><br>
          Nazwisko: <input type="text" name="surname"><br>
          Adres: <input type="text" name="address"><br>
          Telefon: <input type="text" name="phone"><br>

          <br>
          Pesel (jako login): <input type="text" name="pesel"><br>
          Domyslne haslo: <input type="text" value="word_ck" name="default_pass">
          <br><br>
          //dobrze gdyby na tej samej stronie wyswietlalo czy założone po wcisnieciu przycisku

          <input name="createPkk" type="submit" value="Załóż PKK">
       </form>

       <br>
       <a href="cityDepEmployeePanel">Wstecz</a>

</@t.page>
