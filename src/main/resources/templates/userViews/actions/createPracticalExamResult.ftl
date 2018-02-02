<#import "../../template.ftl" as t>

<@t.page>
    <#if message??>
       <b>${message}</b><br><br>
    <#else>
        <h3>Stworzono egzamin</h3>
        <br>
        <p><b>Typ: </b> ${examType}</p>
        <p><b>Data i godzina: </b> ${date?datetime}</p>
        <p><b>Egzaminator:</b> ${examinerFirstName} ${examinerLastName}</p>
        <br><br>
    </#if>
    <a href="krysiaPanel">Wróć do panelu</a>

</@t.page>