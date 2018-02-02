<#import "../../template.ftl" as t>

<@t.page>
   <#if pkkErrMsg??>
      <b> ${pkkErrMsg} </b><br>
    <#elseif examErrMsg??>
       <b> ${ examErrMsg} </b><br>
    <#elseif examErrMsg?? && pkkErrMsg??>
      <b> ${pkkErrmsg} </b><br>
      <b> ${ examErrMsg} </b><br>
    <#else>
        <h3>Zapisano na egzamin:</h3>
        <p>Imie zdajacego: <#if pkkName??> ${pkkName} </#if> </p>
        <p>Nazwisko zdajacego: <#if pkkSurname??> ${pkkSurname} </#if> </p>
        <p>Termin egzaminu: <#if examData??> ${examData} </#if> </p>
        <p>Sala: <#if examRoom??> ${examRoom} </#if> </p>
    </#if>

<a href="krysiaPanel">Wróć do panelu</a>
</@t.page>