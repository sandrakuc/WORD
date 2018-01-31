<#import "../template.ftl" as t>

<@t.page>

<h2>Panel Zdającego</h2>
			<p><b>Terminy Twoich egzaminów:</b></p>

			<br><br>
			<p><b>Egzaminy praktyczne:</b></p>
                <table>
                  <tr>
                    <th>Data</th>
                    <th>Egzaminator</th>
                    <th>Pojazd</th>
                    <th>Status</th>
                  </tr>

                  <#list pkkPracticalExamsList as pkkPracticalExamsList>
                      <tr>
                        <td>${pkkPracticalExamsList.getDate()}</td>

                        <td>
                            ${pkkPracticalExamsList.getExaminer().getFirstName()}
                            ${pkkPracticalExamsList.getExaminer().getLastName()}<br>
                            ${pkkPracticalExamsList.getExaminer().getEmail()}<br>
                        </td>

                        <td>
                             ${pkkPracticalExamsList.getMachine().getBrand()}
                             ${pkkPracticalExamsList.getMachine().getModel()}
                        </td>

                        <td>${pkkPracticalExamsList.getExamResult()}</td>
                      </tr>
                  </#list>

                </table>

            <br><br>
            <p>//Jeszcze nie wiem jak w rekordzie egzaminu teoretycznego zapisac liste pkk osob</p>
			<p><b>Egzaminy teoretyczne:</b></p>
                <table>
                  <tr>
                    <th>Data</th>
                    <th>Wynik</th>
                    <th>Status</th>
                  </tr>
                  <tr>

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
			<form action="takeTheExam" method="GET">
            	<input name="takeTheExam" type="submit" value="Rozpocznij podejście">
            </form>

			<br><br><br>
			<form action="login"  method="POST">
				 <input name="logout" type="submit" value="Wyloguj się">
			 </form>

</@t.page>