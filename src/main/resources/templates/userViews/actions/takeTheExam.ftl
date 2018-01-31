<#import "../../template.ftl" as t>

<@t.page>

<h2>Panel Zdającego</h2>

			<p><b>Egzamin teoretyczny</b></p>
			<br>// dobra, to teraz zrobić żeby wylosowało nowe po włączeniu nowego podejścia
			<br> // i bedzie uproszczona wersja, wyswietla sie trzy pytania, bo bym sie zaorala
			<br><br><br>

			<p> ${questionBase1.contents} </p>
			<form>
			    <br><input type="radio" name="pierwsze" value="a"> ${questionBase1.possibleAnswer1}
			    <br><input type="radio" name="pierwsze" value="b"> ${questionBase1.possibleAnswer2}
			    <br><input type="radio" name="pierwsze" value="c"> ${questionBase1.possibleAnswer3}
			</form>

            <br> <br>
			<p> ${questionBase2.contents} </p>
            	<form>
                <br><input type="radio" name="drugie" value="a"> ${questionBase2.possibleAnswer1}
                <br><input type="radio" name="drugie" value="b"> ${questionBase2.possibleAnswer2}
                <br><input type="radio" name="drugie" value="c"> ${questionBase2.possibleAnswer3}
            	</form>

            <br> <br>
            <p> ${questionBase3.contents} </p>
            	<form>
                <br><input type="radio" name="trzecie" value="a"> ${questionBase3.possibleAnswer1}
                <br><input type="radio" name="trzecie" value="b"> ${questionBase3.possibleAnswer2}
                <br><input type="radio" name="trzecie" value="c"> ${questionBase3.possibleAnswer3}
            	</form>


			<br><br><br>
			<form action="finishAndConfirmTheExam"  method="GET">
				 <input name="confirm" type="submit" value="Zakończ i zapisz podejście">
			 </form>

</@t.page>