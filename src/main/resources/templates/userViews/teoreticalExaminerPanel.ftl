<#import "../template.ftl" as t>

<@t.page>
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
    				<br>


                        <br>
                        <br>
                    	<form action="openExam"  method="POST">
                    		<b>Wpisz id egzaminu:</b>
                    		<input type="text" name="examId" value=""><br>
                    		<input name="examAction" type="submit" value="Otwórz egzamin"><br>
                    		<p>//Otwiera egzamin i przechodzi do strony z zarzadzaniem nim</p>
                    	</form>


    				<br><br><br>
    				<form action="login"  method="POST">
    					 <input name="logout" type="submit" value="Wyloguj się">
    				 </form>
</@t.page>