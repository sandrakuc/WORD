<#import "../template.ftl" as t>

<@t.page>
    <h2>Panel Krysi</h2>
    	 <p>Wybierz co chcesz zrobić:</p><br>

    	 <form action="signOnExam"  method="POST">
    			<p><b>Zapisać kursanta na egzamin</b></p>
    			<input name="signOnExam" type="submit" value="Zapisz na egzamin">
    		</form>


    		<br>
    		<form action="getMoney"  method="POST">
    			 <p><b>Zaksiegować wpłate od zdającego</b></p>
    			 <input name="getMoney" type="submit" value="Przyjmij wpłate">
    		 </form>


    		 <br>
    			<form action="/"  method="POST">
    				 <input name="logout" type="submit" value="Wyloguj się">
    			 </form>
    		</div>
</@t.page>