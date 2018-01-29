<#import "../../template.ftl" as t>

<@t.page>
        <h2>Tworzenie egzaminu teoretycznego</h2>
             <br>


            <form action="createTeoreticalExam" method="POST">
              id: <input type="text" name="examId" value="1"> <br>
              Data: <input type="text" name="examDate"><br><br>
              <p>Godzina egzaminu:</p>
              <input type="radio" name="hour" value="9" checked> 9:00<br>
              <input type="radio" name="hour" value="12"> 12:00<br>
              <input type="radio" name="hour" value="14"> 14:00<br>
              <input type="radio" name="hour" value="16"> 16:00<br>
              <br>


              <br><br>

              <input name="createExam" type="submit" value="Stworz egzamin">
           </form>

           <br>
           <!-- @TODO link do zmiany -->
           <a href="krysiaPanel">Wstecz</a>
</@t.page>