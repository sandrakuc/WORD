<#import "../../template.ftl" as t>

<@t.page>

<h2>Panel Zdającego</h2>
				<p>Przykładowe pytania na razie napisane na sztywno</p>
			<p><b>Egzamin teoretyczny</b></p>
			<br><br><br>

			<p>Znak z biegnącą dziewczynką i chłopcem oznacza</p>


			<form>
			    <br><input type="radio" name="dzieci" value="a"> Uwaga! Pedofil!
			    <br><input type="radio" name="dzieci" value="b"> Uwaga! Marek Kowalczyk!
			    <br><input type="radio" name="dzieci" value="c"> Obie powyższe odpowiedzi oznaczają to samo
			    <br><input type="radio" name="dzieci" value="d"> Uwaga! Dzieci!
			</form>

			<br><br><br>
			<form action="finishAndConfirmTheExam"  method="POST">
				 <input name="confirm" type="submit" value="Zakończ i zapisz podejście">
			 </form>

</@t.page>