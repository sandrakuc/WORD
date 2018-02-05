<#import "../../template.ftl" as t>

<@t.page>
        <#if msg ??>
             <p><b>${msg}</b></p>
        <#else>
            <h3>Wniosek o id = ${id} ma status: ${drivingLicenseApplicationStatus}</h3><br>


            <h3>Zmien status wniosku na </h3><br>
            <form action="changeDriverLicenseApplicationStatus"  method="POST">
              <input type="radio" name="statusBox" value="PODANIE_UTWORZONE"> PODANIE_UTWORZONE<br>
              <input type="radio" name="statusBox" value="PRAWO_JAZDY_WYRABIANE"> PRAWO_JAZDY_WYRABIANE<br>
              <input type="radio" name="statusBox" value="DO_ODBIORU"> DO_ODBIORU<br>
              <input type="radio" name="statusBox" value="ODEBRANE"> ODEBRANE<br>
              <input type="radio" name="statusBox" value="WYSLANE_DO_PWPW"> WYSLANE_DO_PWPW <br><br>
              <input name="change" type="submit" value="Zmien status">
            </form>

        </#if>



    <br>
    <a href="cityDepEmployeePanel">Wstecz</a>
</@t.page>
