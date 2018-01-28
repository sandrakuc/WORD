<#import "../template.ftl" as t>

<@t.page>

<h2>Panel Zdającego</h2>
				<p>przykladowe tabele poki co zapisane na sztywno</p>
			<p><b>Terminy Twoich egzaminów:</b></p>
			///Tu by iterowało po kolekcji Exam i wypisywało nazwe terminu i termin
			<table>
	      <tr>
	        <th>Typ egzaminu</th>
	        <th>Data</th>
	        <th>Egzaminator</th>
					<th>Status</th>
	      </tr>
	      <tr>
	        <td>Teoretyczny</td>
	        <td>21.02.2018</td>
	        <td>Adam Nowak</td>
	        <td>-</td>
	      </tr>
	      <tr>
	        <td>Praktyczny</td>
	        <td>21.02.2018</td>
	        <td>Adam Nowak</td>
	        <td>Zakończony. Nie zdany</td>
	      </tr>
				<tr>
				 <td>Teoretyczny</td>
				 <td>21.02.2018</td>
				 <td>Adam Nowak</td>
				 <td>Zakończony. Zdany</td>
			 </tr>
	    </table>

			<br>
			<br>
			<p><b>Statusy Twoich wniosków:</b></p>
			//tu by iterowało po wnioskach i wyswietlało status tych ktore maja pole "pkkId" takie jak id zalogowanego
			<table>
	      <tr>
	        <th>Nr wniosku</th>
	        <th>Kategoria</th>
					<th>Status prawa jazdy</th>
	      </tr>
	      <tr>
	        <td name="id">1</td>
	        <td>B2</td>
	        <td>Odebrane</td>
	      </tr>
	      <tr>
					<td name="id">2</td>
	        <td>B2</td>
	        <td>Do odbioru</td>
	      </tr>
				<tr>
				 <td name="id">3</td>
				 <td>B2</td>
				 <td>Wysłane do PWPW</td>
			 </tr>
	    </table>

			<br><br><br>
			<form action="../index.html"  method="POST">
				 <input name="logout" type="submit" value="Wyloguj się">
			 </form>
</@t.page>