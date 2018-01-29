<#import "../../template.ftl" as t>

<@t.page>

    <h2>Tworzenie PKK</h2>
     <#if user?? >
             Dodano zdającego<br>
             Imie: ${user.firstName}<br>
             Nazwisko: ${user.lastName}<br>
             Adres:  ${user.address}<br>
             Email:  ${user.email}<br>
             <br>
             Login:  ${user.login}<br>
             Haslo:  ${user.password}<br>
     <#else>

            <form action="/createPkk" method="post">
              imie: <input type="text" name="firstName"><br>
              Nazwisko: <input type="text" name="lastName"><br>
              Adres: <input type="text" name="address"><br>
              Email:   <input type="text" name="email"><br>

              <br>
              Pesel (jako login): <input type="text" name="login"><br>
              Domyslne haslo: <input type="text" value="word_ck" name="password">
              <br><br>

              <input name="createPkk" type="submit" value="Załóż PKK">
           </form>
      </#if>

       <br>
       <a href="cityDepEmployeePanel">Wstecz</a>

</@t.page>
