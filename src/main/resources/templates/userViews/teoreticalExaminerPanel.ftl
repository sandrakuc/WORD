<#import "../template.ftl" as t>

<@t.page>
                    <br>
    				 <b>${message}</b>
    				<br>
                    <h2>Panel egzaminatora teoretycznego</h2>

                    Twoje id to: ${userId}
    				<p>Twoje egzaminy:</p><br>


    				<table>
    				  <tr>
    				    <th>id egzaminu</th>
    				    <th>Data rozpoczecia</th>
    					<th>Data zakonczenia</th>
    				    <th>Sala</th>
    			    	<th>Status</th>
    				  </tr>
    				  <#list teoreticalExams as teoreticalExams>
                          <tr>
                            <td name="id">${teoreticalExams.getId()}</td>
                            <td>${teoreticalExams.getDate()}</td>
                            <td>${teoreticalExams.getEndDate()}</td>
                            <td>${teoreticalExams.getRoom()}</td>
                            <td>${teoreticalExams.getTeoreticalExamStatus()}</td>
                          </tr>
                       </#list>
    				</table>
    				<br>



                    	<form action="teoreticalExaminerPanel"  method="POST">
                    	    <b>Wpisz id egzaminu:</b>
                            <input type="text" name="examId" value=""><br><br>

                    	    <p><b>Wybierz czynność</b></p>
                    	    <br>
                    	    <input type="radio" name="examStatus" value="otwarty" checked> Otwórz egzamin<br>
                            <input type="radio" name="examStatus" value="zamkniety">Zamknij egzamin<br><br>

                    		<input name="examAction" type="submit" value="Zmien status"><br>
                    	</form>


    				<br><br><br>
    				<form action="logout"  method="POST">
    					 <input name="logout" type="submit" value="Wyloguj się">
    				 </form>
</@t.page>