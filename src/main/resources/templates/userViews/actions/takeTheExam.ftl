<#import "../../template.ftl" as t>

<@t.page>

<h2>Panel Zdającego</h2>

			<p><b>Egzamin teoretyczny</b></p>
            <br> //Już wkrótce zapisanie podejścia do bazy danych!!!!!!
			<br> // i bedzie uproszczona wersja, wyswietla sie trzy pytania, bo bym sie zaorala
			<br><br><br>

            <form action="takeTheExam" method="POST">
			<p> ${questionBase1.contents} </p>
			    <br><input type="radio" name="pierwsze" value="a"> ${questionBase1.possibleAnswer1}
			    <br><input type="radio" name="pierwsze" value="b"> ${questionBase1.possibleAnswer2}
			    <br><input type="radio" name="pierwsze" value="c"> ${questionBase1.possibleAnswer3}


            <br> <br>
			<p> ${questionBase2.contents} </p>
                <br><input type="radio" name="drugie" value="a"> ${questionBase2.possibleAnswer1}
                <br><input type="radio" name="drugie" value="b"> ${questionBase2.possibleAnswer2}
                <br><input type="radio" name="drugie" value="c"> ${questionBase2.possibleAnswer3}

            <br> <br>
            <p> ${questionBase3.contents} </p>
                <br><input type="radio" name="trzecie" value="a"> ${questionBase3.possibleAnswer1}
                <br><input type="radio" name="trzecie" value="b"> ${questionBase3.possibleAnswer2}
                <br><input type="radio" name="trzecie" value="c"> ${questionBase3.possibleAnswer3}

                <br>
                <input type="submit" name="save" value="Zapisz i zakończ podejście" />
            </form>


</@t.page>