<#import "../../template.ftl" as t>

<@t.page>
        <h3>Sprawdzanie statusu wniosku dla zdającego o PESELu = ${drivingLicenseApplication.pesel} </h3>
        <p>Status wniosku to: ${drivingLicenseApplication.status} </p>

    <br>
    <a href="cityDepEmployeePanel">Wstecz</a>
</@t.page>
