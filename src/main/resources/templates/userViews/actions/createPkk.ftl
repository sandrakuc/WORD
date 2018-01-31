<#import "../../template.ftl" as t>

<@t.page>

    <h2>Tworzenie PKK</h2>

    <#if usertmp??>
                 Dodano zdającego<br>
                 Imie: ${usertmp.firstName}<br>
                 Nazwisko: ${usertmp.lastName}<br>
                 Adres:  ${usertmp.address}<br>
                 Email:  ${usertmp.email}<br>
                 <br>
                 Login:  ${usertmp.login}<br>
                 Haslo:  ${usertmp.password}<br>

     <#else>


            <form action="createPkk" method="post">
              imie: <input type="text" name="firstName"><br>
              Nazwisko: <input type="text" name="lastName"><br>
              Adres: <input type="text" name="address"><br>
              Pesel: <input type="text" name="pesel"><br>
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
