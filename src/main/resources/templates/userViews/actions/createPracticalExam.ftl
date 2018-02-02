<#import "../../template.ftl" as t>

<@t.page>
        <h2>Tworzenie egzaminu praktycznego</h2>
             <br>


            <form action="createPracticalExamResult" method="POST">
                    Data rozpoczęcia: <input type="datetime-local" name="pracExamDate" value=${curTime}><br>
                    PESEL Zdajacego: <input type="text" name="pesel" value="1"><br>
                    Kategoria Zdajacego: <input type="text" name="examCategory" value="C"><br>
                    <br><br>
                    <p>*Egzaminatora i maszyne wylosuje system</p>
                    <br>
                    <input name="createExam" type="submit" value="Stworz egzamin">
           </form>

           <br>
           <a href="krysiaPanel">Wstecz</a>
</@t.page>