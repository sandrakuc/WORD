<#import "../../template.ftl" as t>

<@t.page>
        <h3>Sprawdzanie statusu wniosku <br>
        <#if errMessage ??>
             <p><b>${errMessage}</b></p>
        </#if>

        <#if drivingLicenseApplication ??>
            dla wniosku o id = ${drivingLicenseApplication.getId()} </h3>
            <br>
            <p>Status wniosku to: ${drivingLicenseApplication.getStatus()} </p>
         </#if>

    <br>
    <a href="cityDepEmployeePanel">Wstecz</a>
</@t.page>
