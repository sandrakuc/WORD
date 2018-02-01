<#import "../template.ftl" as t>

<@t.page>

<h2>Panel Zdającego</h2>
 Twoje id to: ${userId}
 <br><br>
			<p><b>Terminy Twoich egzaminów:</b></p>

			<br>
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

			<p><b>Egzaminy teoretyczne:</b></p>
                <table>
                  <tr>
                    <th>Data rozpoczecia</th>
                    <th>Wynik procentowy</th>
                    <th>Rezultat</th>
                  </tr>

                  <#list teoreticalExamToPKKList as teoreticalExamToPKKList>
                      <tr>
                        <td>${teoreticalExamToPKKList.getTeoreticalExam().getDate()}</td>
                        <td>${teoreticalExamToPKKList.getPercResult()}</td>
                        <td>${textResult}</td>
                      </tr>
                  </#list>

                </table>

			<br>
			<br>
			<p><b>Statusy Twoich wniosków:</b></p>
            <table>
                  <tr>
                    <th>Nr wniosku</th>
                    <th>Kategoria</th>
                    <th>Status prawa jazdy</th>
                  </tr>

                 <#list pkkApplicationsList as pkkApplicationsList>
                    <tr>
                        <td>${pkkApplicationsList.getId()}</td>
                        <td>${pkkApplicationsList.getCategory()}</td>
                        <td>${pkkApplicationsList.getStatus()}</td>
                    </tr>
                 </#list>



            </table>

			<br><br><br>
			<form action="takeTheExam" method="GET">
            	<input name="takeTheExam" type="submit" value="Rozpocznij podejście">
            </form>

			<br><br><br>
			<form action="logout"  method="POST">
				 <input name="logout" type="submit" value="Wyloguj się">
			 </form>

</@t.page>