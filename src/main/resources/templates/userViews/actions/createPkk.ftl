<#import "../../template.ftl" as t>

<@t.page>
    <h2>Tworzenie PKK</h2>
       <#if user?? >
            <p><b>Dodano Zdajacego</b></p>
             Imie: ${user.firstName}<br>
             Nazwisko: ${user.lastName}<br>
             Adres: ${user.address}<br>
             Email: ${user.email}<br>
             <br>
             Login: ${user.login}<br>
             Haslo: ${user.password}<br>
             <br>
             Rola: ${user.role}

        <#else>

            <form method="POST">
              id: <input type="text" name="id"><br>
              id: <input type="text" name="role" value="PKK" disabled><br>
              imie: <input type="text" name="firstName"><br>
              Nazwisko: <input type="text" name="lastName"><br>
              Adres: <input type="text" name="address"><br>
              Email:   <input type="text" name="email"><br>

              <br>
              Pesel (jako login): <input type="text" name="login"><br>
              Domyslne haslo: <input type="text" value="word_ck" name="password">
              <br><br>
              //dobrze gdyby na tej samej stronie wyswietlalo czy założone po wcisnieciu przycisku
              <br>
              <input name="createPkk" type="submit" value="Załóż PKK">
           </form>

       </#if>

       <br>
       <a href="cityDepEmployeePanel">Wstecz</a>

</@t.page>
