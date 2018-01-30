<#import "../../template.ftl" as t>

<@t.page>

<h2>Panel Zdającego</h2>
				<p>Przykładowe pytania na razie napisane na sztywno</p>
			<p><b>Egzamin teoretyczny</b></p>
			<br><br><br>

			<p> ${questionBase.contents} </p>
			<form>
			    <br><input type="radio" name="pierwsze" value="a"> ${questionBase.possibleAnswer1}
			    <br><input type="radio" name="pierwsze" value="b"> ${questionBase.possibleAnswer2}
			    <br><input type="radio" name="pierwsze" value="c"> ${questionBase.possibleAnswer3}
			    <br><input type="radio" name="pierwsze" value="d"> ${questionBase.possibleAnswer4}
			</form>

			<p> ${QuestionBase.contents} </p>
            	<form>
                <br><input type="radio" name="drugie" value="a"> ${questionBase.possibleAnswer1}
                <br><input type="radio" name="drugie" value="b"> ${questionBase.possibleAnswer2}
                <br><input type="radio" name="drugie" value="c"> ${questionBase.possibleAnswer3}
                <br><input type="radio" name="drugie" value="d"> ${questionBase.possibleAnswer4}
            	</form>


            <p> ${QuestionBase.contents} </p>
            	<form>
                <br><input type="radio" name="trzecie" value="a"> ${questionBase.possibleAnswer1}
                <br><input type="radio" name="trzecie" value="b"> ${questionBase.possibleAnswer2}
                <br><input type="radio" name="trzecie" value="c"> ${questionBase.possibleAnswer3}
                <br><input type="radio" name="trzecie" value="d"> ${questionBase.possibleAnswer4}
            	</form>


			<br><br><br>
			<form action="finishAndConfirmTheExam"  method="GET">
				 <input name="confirm" type="submit" value="Zakończ i zapisz podejście">
			 </form>

</@t.page>