<#import "../template.ftl" as t>

<@t.page>
    <h2>Panel Krysi</h2>
    	 <p>Wybierz co chcesz zrobić:</p><br>

    	 <form action="signOnTeoreticalExam"  method="get">
    			<p><b>Zapisać kursanta na egzamin teoretyczny</b></p>
    			<input name="signTeoreticalOnExam" type="submit" value="Zapisz na egzamin">
    		</form>
            <br>

            <form action="createTeoreticalExam" metod="get"  >
                 <p><b>Utworzyć egzamin teoretyczny</b></p>
                 <input name="createExam" type="submit" value="Utwórz egzamin teoretyczny">
             </form>

             <br>
                <form action="createPracticalExam" metod="get"  >
                  <p><b>Utworzyć egzamin praktyczny</b></p>
                  <input name="createPracticalExam" type="submit" value="Utwórz egzamin praktyczny">
               </form>

               	<br>
                 <form action="getMoney"  method="get">
                   	<p><b>Zaksiegować wpłate od zdającego</b></p>
                   	<input name="getMoney" type="submit" value="Przyjmij wpłate">
                  </form>

    		 <br>
    			<form action="logout"  method="POST">
    				 <input name="logout" type="submit" value="Wyloguj się">
    			</form>
    		</div>
</@t.page>