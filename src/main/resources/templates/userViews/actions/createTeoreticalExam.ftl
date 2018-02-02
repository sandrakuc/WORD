<#import "../../template.ftl" as t>

<@t.page>
        <h2>Tworzenie egzaminu teoretycznego</h2>
                     <br>
               <form action="createTeoreticalExamResult" method="POST">
                  Data rozpoczęcia: <input type="datetime-local" name="teorExamDate" value=${curTime}><br>
                  Pokój: <input type="text" name="room" value="1">
                  <br><br>
                  <p>*Egzaminatora wylosuje losowo system</p>
                  <br>
                   <input name="createExam" type="submit" value="Stworz egzamin">
               </form>



                   <br>
                   <a href="krysiaPanel">Wstecz</a>
</@t.page>