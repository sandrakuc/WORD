<#import "../../template.ftl" as t>

<@t.page>
    <h2>Zapisywanie na egzamin teoretyczny</h2><br>

    	 <form action="signOnTeoreticalExamResult" method="POST">
           PESEL zdającego: <input type="text" name="pesel"><br>
           ID egzaminu: <input type="text" name="teoreticalExamId"><br>

           <br>
             <input name="signOnExam" type="submit" value="Zapisz na egzamin">
        </form>

        <br>
        <br>
        <h3>Tabela egzaminów</h3>
        <table>
                  <tr>
                    <th>ID</th>
                    <th>Data</th>
                    <th>Status</th>
                  </tr>
                  <#list examRecords as examRecords>
                      <tr>
                         <td>  ${examRecords.getId()} </td>
                        <td>  ${examRecords.getDate()} </td>
                        <td>  ${examRecords.getTeoreticalExamStatus()} </td>
                      </tr>
                   </#list>
         </table>

        <br>
        <a href="krysiaPanel">Wstecz</a>

</@t.page>
