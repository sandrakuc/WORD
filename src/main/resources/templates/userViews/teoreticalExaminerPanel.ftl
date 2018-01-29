<#import "../template.ftl" as t>

<@t.page>
                    <h2>Panel egzaminatora teoretycznego</h2>
    				<p>Twoje egzaminy:</p><br>
    				//tu wypisze egzaminy ktore zrobila krysia (o ile ona ma tworzyc ich obiekty), a które sa przypisane do zalogowanego egzaminatora np:

    				<table>
    				  <tr>
    				    <th>id egzaminu</th>
    				    <th>Data rozpoczecia</th>
    						<th>Data zakonczenia</th>
    						<th>Sala</th>
    				    <th>Status</th>
    				  </tr>
    				  <tr>
    				    <td name="id">1</td>
    				    <td>21.02.2018 21:57</td>
    				    <td>21.02.2018 22:20</td>
    						<td>12</td>
    						<td>Zakończony</td>
    				  </tr>
    				  <tr>
    				    <td name="id">2</td>
    				    <td>21.02.2018 12:57</td>
    				    <td>-</td>
    						<td>12</td>
    						<td>Trwa</td>
    				  </tr>
    					<tr>
    				    <td name="id">3</td>
    				    <td>-</td>
    				    <td>-</td>
    						<td>12</td>
    						<td>Gotowy do otwarcia</td>
    				  </tr>
    					<tr>
    				    <td name="id">4</td>
    				    <td>-</td>
    				    <td>-</td>
    						<td>12</td>
    						<td>Brak pytań</td>
    				  </tr>
    				</table>
    				<br>
    				<br>

    				                <form action="teoreticalExaminerPanel"  method="POST">
                    		 		<b>Wpisz id egzaminu:</b>
                    				<input type="text" name="examId" value=""><br>
                    				<input name="examAction" type="submit" value="Wylosuj pytania"><br>
                    				<p>//ten przycisk niech wykonuje sie i zwraca wynik na tej stronie. Zmieniajac dane w tabeli</p>
                    				<p>//np. Wylosowano pytania dla egzaminu o id=4</p>
                    		 		</form>

                                    <br>
                                    <br>
                    				<form action="openExam"  method="POST">
                    					<b>Wpisz id egzaminu:</b>
                    					<input type="text" name="examId" value=""><br>
                    					<input name="examAction" type="submit" value="Otwórz egzamin"><br>
                    					<p>//Otwiera egzamin i przechodzi do strony z zarzadzaniem nim</p>
                    				</form>


    				<br><br><br>
    				<form action="login"  method="POST">
    					 <input name="logout" type="submit" value="Wyloguj się">
    				 </form>
</@t.page>