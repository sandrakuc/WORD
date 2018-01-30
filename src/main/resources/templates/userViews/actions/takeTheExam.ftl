<#import "../../template.ftl" as t>

<@t.page>

<h2>Panel Zdającego</h2>
				<p>Przykładowe pytania na razie napisane na sztywno</p>
			<p><b>Egzamin teoretyczny</b></p>
			<br><br><br>

			<p> ${QuestionBase.contents} </p>


			<form>
			    <br><input type="radio" name="pierwsze" value="a"> ${QuestionBase}
			    <br><input type="radio" name="pierwsze" value="b"> ${QuestionBase}
			    <br><input type="radio" name="pierwsze" value="c"> ${QuestionBase}
			    <br><input type="radio" name="pierwsze" value="d"> ${QuestionBase}
			</form>

			<br><br><br>
			<form action="finishAndConfirmTheExam"  method="GET">
				 <input name="confirm" type="submit" value="Zakończ i zapisz podejście">
			 </form>

</@t.page>