<#import "../../template.ftl" as t>

<@t.page>
        <h2>Tworzenie egzaminu</h2>
             <br>


            <form action="createExamResults" method="POST">
              id: <input type="text" name="examId" value="1"> <br>
              Data: <input type="text" name="examDate"><br><br>
              <p>Godzina egzaminu:</p>
              <input type="radio" name="hour" value="9" checked> 9:00<br>
              <input type="radio" name="hour" value="12"> 12:00<br>
              <input type="radio" name="hour" value="14"> 14:00<br>
              <input type="radio" name="hour" value="16"> 16:00<br>
              <br>
              <p>Typ egzaminu</p>
              <input type="radio" name="examType" value="teoreticalExamCreate"> Teoretyczny<br>
              <input type="radio" name="examType" value="practicalExamCreate"> Praktyczny<br>

              <br>
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
              numer auta (dla egzaminu praktycznego)<br>
              <input type="text" name="carNr" value=""><br>
              <br><br>

              <input name="createExam" type="submit" value="Stworz egzamin">
           </form>

           <br>
           <!-- @TODO link do zmiany -->
           <a href="krysiaPanel">Wstecz</a>
</@t.page>