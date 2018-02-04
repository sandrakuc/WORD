<#import "../template.ftl" as t>

<@t.page>
            <br>
   			<b>${message}</b>
   			<br>

             <h2>Panel egzaminatora praktycznego</h2>
             Twoje id to: ${userId}

   			<p>Twoje egzaminy:</p><br>
   			<table>
   				<tr>
   					<th>id egzaminu</th>
   					<th>Data rozpoczęcia</th>
   					<th>Numer tablicy auta</th>
   					<th>PESEL zdającego</th>
   					<th>Wynik egzaminu</th>
   				</tr>

   				<#list practicExamsList as practicExamsList>
                    <tr>
                        <td name="id">${practicExamsList.getId()}</td>
                        <td>${practicExamsList.getDate()}</td>
                        <td>${practicExamsList.getMachine().getPlate()}</td>
                        <td>${practicExamsList.getPesel()}</td>
                        <td>${practicExamsList.getExamResult()}</td>
                    </tr>
                 </#list>
   			</table>
   			<br>




   			<form action="practicalExaminerPanel"  method="POST">
   				<p><b>Wpisz id egzaminu:</b></p>
   				<input type="text" name="examId" value="1"><br><br>

   				<p><b>Wybierz wynik egzaminu</b></p>
   				<input type="radio" name="examResult" value="positive" checked> Pozytywny<br>
   				<input type="radio" name="examResult" value="negative"> Negatywny<br>
   				<br>
   				<input name="saveExamResult" type="submit" value="Zapisz">
   			</form>


   			<br><br><br>
   			<form action="logout"  method="POST">
   				 <input name="logout" type="submit" value="Wyloguj się">
   			 </form>
</@t.page>