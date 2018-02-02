<#import "../../template.ftl" as t>

<@t.page>

<h2>Panel Zdającego</h2>

			<p><b>Egzamin teoretyczny</b></p>
            <br> //Już wkrótce zapisanie podejścia do bazy danych!!!!!!
			<br> // i bedzie uproszczona wersja, wyswietla sie trzy pytania, bo bym sie zaorala
			<br><br><br>

            <form action="takeTheExam" method="POST">
			<p> ${questionBase1.contents} </p>
			    <br><input type="radio" name="pierwsze" value="${questionBase1.possibleAnswer1}"> ${questionBase1.possibleAnswer1}
			    <br><input type="radio" name="pierwsze" value="${questionBase1.possibleAnswer2}"> ${questionBase1.possibleAnswer2}
			    <br><input type="radio" name="pierwsze" value="${questionBase1.possibleAnswer3}"> ${questionBase1.possibleAnswer3}


            <br> <br>
			<p> ${questionBase2.contents} </p>
                <br><input type="radio" name="drugie" value="${questionBase2.possibleAnswer1}"> ${questionBase2.possibleAnswer1}
                <br><input type="radio" name="drugie" value="${questionBase2.possibleAnswer2}"> ${questionBase2.possibleAnswer2}
                <br><input type="radio" name="drugie" value="${questionBase2.possibleAnswer3}"> ${questionBase2.possibleAnswer3}

            <br> <br>
            <p> ${questionBase3.contents} </p>
                <br><input type="radio" name="trzecie" value="${questionBase3.possibleAnswer1}"> ${questionBase3.possibleAnswer1}
                <br><input type="radio" name="trzecie" value="${questionBase3.possibleAnswer2}"> ${questionBase3.possibleAnswer2}
                <br><input type="radio" name="trzecie" value="${questionBase3.possibleAnswer3}"> ${questionBase3.possibleAnswer3}
            </form>

			<br><br><br>
			<form action="finishAndConfirmTheExam"  method="GET">
				 <input name="confirm" type="submit" value="Zakończ i zapisz podejście">
			 </form>

</@t.page>