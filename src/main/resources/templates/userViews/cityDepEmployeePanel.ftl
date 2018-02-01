<#import "../template.ftl" as t>

<@t.page>
    <h2>Panel pracownika urzędu miasta</h2>
    		 <p>Wybierz co chcesz zrobić:</p><br>

    		

    				<p><b>Utworzyć Profil Kandydata na Kierowce</b></p>
    				<a href="createPkk">Utworz pkk</a><br><br>



    		
    		 <form action="prepereDriverLicenseApplication"  method="GET">
    		       <p><b>Złóż dla zdającego wniosek o prawo jazdy</b></p><br>

                   	<input name="prepereApplication" type="submit" value="Zacznij wypełniać wniosek">
              </form><br>



             <form action="checkDriverLicenseApplication"  method="GET">
                <p><b>Sprawdz status wniosku o prawo jazdy</b></p><br>
                 Wprowadz ID wniosku: <input type="text" name="id"><br><br>
                  <input name="checkStatus" type="submit" value="Sprawdz status wniosku">
              </form>

    			 <br>
     			
     			<form action="logout"  method="POST">
     				 <input name="logout" type="submit" value="Wyloguj się">
     			 </form>
</@t.page>