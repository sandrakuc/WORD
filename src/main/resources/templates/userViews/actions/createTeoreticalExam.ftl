<#import "../../template.ftl" as t>

<@t.page>
        <h2>Tworzenie egzaminu teoretycznego</h2>
                     <br>
               <form action="createExamResults" method="POST">
                  Data rozpoczęcia: <input type="datetime-local" name="teorExamDate" value="2017-06-01T08:30"><br>
                  Pokój: <input type="text" name="room" value="1">
                  <br><br>
                  <p>*Egzaminatora wylosuje losowo system</p>
                  <br>
                   <input name="createExam" type="submit" value="Stworz egzamin">
               </form>



                   <br>
                   <a href="krysiaPanel">Wstecz</a>
</@t.page>