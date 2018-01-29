e<#import "../../template.ftl" as t>

<@t.page>
    <h2>Składanie wniosku o prawo jazdy do PWPW</h2>
     <#if drivingLicenseApplication?? >
                 Dodano zdającego<br>
                 Imie: ${drivingLicenseApplication.name}<br>
                 Nazwisko: ${drivingLicenseApplication.surname}<br>
                 Adres:  ${drivingLicenseApplication.address}<br>
                 PESEL:  ${drivingLicenseApplication.pesel}<br>
                 <br>
                 Kategoria:  ${drivingLicenseApplication.category}<br>
                 Status:  ${drivingLicenseApplication.status}<br>
         <#else>

             <form action="prepereDriverLicenseApplication" method="POST">

               Imie: <input type="text" name="name"><br>
               Nazwisko: <input type="text" name="surname"><br>
               Adres: <input type="text" name="address"><br>
               PESEL: <input type="text" name="pesel"><br>

               <br>
               Kategoria: <input type="text" name="DLCategory"><br><br>
               <input name="sendToPwpw" type="submit" value="Wyslij wniosek do PWPW">
               <br>

            </form>
    	</#if>


        <br><br>
        <a href="cityDepEmployeePanel">Wstecz</a>

</@t.page>
