<#import "../../template.ftl" as t>

<@t.page>

    <h3>Egzamin teoretyczny id=</h3>
        <br><br>
        <p><b>Lista zdających</b></p>
        <p>//Niech zczytuje ja i wypelnia tabele (oprocz ostatniej kolumny) na podstawie listy zdajacych egzaminu teor. o tym id</p>
        <br>
        <table>
          <tr>
            <th>pkk id</th>
            <th>PESEL</th>
            <th>Imie</th>
            <th>Nazwisko</th>
            <th>Status</th>
          </tr>
          <tr>
            <td name="id">1</td>
            <td>12345678910</td>
            <td>Jan</td>
            <td>Kowalski</td>
            <td>Pisze</td>
          </tr>
          <tr>
            <td name="id">2</td>
            <td>12345678910</td>
            <td>Jan</td>
            <td>Kowalski</td>
            <td>Zablokowany</td>
          </tr>
        </table>
        <br>
        <br>

        <form action="openExam"  method="post">
          Wpisz pkkId zdającego:
          <input type="text" name="pkkId" value=""><br>
          <input name="blockPkk" type="submit" value="Zablokuj za oszustwo">
        </form>


      <br><br>
        <form action="closeExam"  method="post">
          <input name="closeExam" type="submit" value="Zakończ egzamin">
        </form>

</@t.page>