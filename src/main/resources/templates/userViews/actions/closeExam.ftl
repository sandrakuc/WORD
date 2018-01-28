<#import "../../template.ftl" as t>

<@t.page>

        <h3>Wyniki egzaminu teoretycznego id=</h3>
        <p>//Wylicza program i podaje w tabeli wyniki</p>
        <br>
        <table>
          <tr>
            <th>pkk id</th>
            <th>PESEL</th>
            <th>Imie</th>
            <th>Nazwisko</th>
            <th>Wynik %</th>
            <th>Rezultat</th>
          </tr>
          <tr>
            <td name="id">1</td>
            <td>12345678910</td>
            <td>Jan</td>
            <td>Kowalski</td>
            <td>21%</td>
            <td>Nie zdał</td>
          </tr>
          <tr>
            <td name="id">2</td>
            <td>12345678910</td>
            <td>Jan</td>
            <td>Kowalski</td>
            <td>89%</td>
            <td>Zdał</td>
          </tr>
        </table>
        <br>
        <br>


</@t.page>