<#import "../../template.ftl" as t>

<@t.page>
    <h3>Stworzono egzamin</h3>
    <br>
    <p><b>Typ: </b> ${examType}</p>
    <p><b>Data i godzina: </b> ${date?datetime}</p>
    <p><b>Egzaminator:</b> ${examinerFirstName} ${examinerLastName}</p>
    <br><br>
    <a href="krysiaPanel">Wróć do panelu</a>

</@t.page>