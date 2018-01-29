<#import "template.ftl" as t>

<@t.page>
    <h2>Test Wojtek</h2>
       <#if person?? >
            <p><b>Dodano Osobe</b></p>
             Imie: ${person.name}<br>
             Nazwisko: ${person.surname}<br>

        <#else>

            <form action="person" method="POST">
              imie: <input type="text" name="name"><br>
              nazwisko: <input type="text" name="surname"><br>

              <input name="createPerson" type="submit" value="Utworz osobe">
           </form>

       </#if>

       <br>
       <a href="login">Wstecz</a>

</@t.page>
