<#import "../template.ftl" as t>

<@t.page>
             <h2>Panel egzaminatora praktycznego</h2>
   			<p>Twoje egzaminy:</p><br>
   			//tu wypisze egzaminy ktore zrobila krysia (o ile ona ma tworzyc ich obiekty), a które sa przypisane do zalogowanego egzaminatora np:

   			<table>
   				<tr>
   					<th>id egzaminu</th>
   					<th>Data rozpoczęcia</th>
   					<th>Numer auta</th>
   					<th>PESEL zdającego</th>
   					<th>Wynik egzaminu</th>
   				</tr>
   				<tr>
   					<td name="id">1</td>
   					<td>12.12.2018 12:00</td>
   					<td>1</td>
   					<td>12345678910</td>
   					<td>Pozytywny</td>
   				</tr>
   				<tr>
   					<td name="id">2</td>
   					<td>12.12.2018 12:00</td>
   					<td>12</td>
   					<td>12345678910</td>
   					<td>Negatywny</td>
   				</tr>
   				<tr>
   					<td name="id">3</td>
   					<td>12.12.2018 12:00</td>
   					<td>12</td>
   					<td>12345678910</td>
   					<td>-</td>
   				</tr>
   			</table>
   			<br>
   			<br>


   			<form action="practicalExaminerPanel"  method="POST">
   				<p><b>Wpisz id egzaminu:</b></p>
   				<input type="text" name="examId" value=""><br><br>

   				<p><b>Wybierz wynik egzaminu</b></p>
   				<input type="radio" name="examResult" value="positive" checked> Pozytywny<br>
   				<input type="radio" name="examResult" value="negative"> Negatywny<br>
   				<br>
   				<input name="saveExamResult" type="submit" value="Zapisz">
   			</form>


   			<br><br><br>
   			<form action="login"  method="POST">
   				 <input name="logout" type="submit" value="Wyloguj się">
   			 </form>
</@t.page>