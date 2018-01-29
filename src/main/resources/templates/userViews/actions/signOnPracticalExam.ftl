<#import "../../template.ftl" as t>

<@t.page>
    <h2>Zapisywanie na egzamin praktyczny</h2><br>

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

            <p>Tabela dostepnych aut</p>
                         <table>
                           <tr>
                             <th>nr auta</th>
                             <th>model</th>
                           </tr>
                           <tr>
                             <td name="id">1</td>
                             <td>Toyota Yaris</td>
                           </tr>
                           <tr>
                             <td name="id">2</td>
                             <td>Toyota Yaris</td>
                           </tr>
            </table>


                         <br>
        Numer auta: <input type="text" name="carNr" value=""><br>
                         <br><br>

           <br>
           <input name="signOnExam" type="submit" value="Zapisz na egzamin">
           <br>


        </form>

        <br>
        <a href="krysiaPanel">Wstecz</a>

</@t.page>
