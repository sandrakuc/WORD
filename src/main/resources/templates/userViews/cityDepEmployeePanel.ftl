<#import "../template.ftl" as t>

<@t.page>
    <h2>Panel pracownika urzędu miasta</h2>
    		 <p>Wybierz co chcesz zrobić:</p><br>

    		
    		 <form action="createPkk"  method="GET">
    				<p><b>Utworzyć Profil Kandydata na Kierowce</b></p>
    				<input name="createPkk" type="submit" value="Utwórz Pkk">
    			</form><br>


    		
    		 <form action="prepereDriverLicenseApplication"  method="GET">
    		       <p><b>Złóż dla zdającego wniosek o prawo jazdy</b></p><br>
                   	Wprowadz PESEL: <input type="text" name="pesel"><br><br>
                   	<input name="prepereApplication" type="submit" value="Zacznij wypełniać wniosek">
              </form><br>



             <form action="checkDriverLicenseApplication"  method="GET">
                <p><b>Sprawdz status wniosku o prawo jazdy</b></p><br>
                 Wprowadz PESEL: <input type="text" name="pkk_pesel"><br><br>
                  <input name="checkStatus" type="submit" value="Sprawdz status wniosku">
              </form>

    			 <br>
     			
     			<form action="login"  method="GET">
     				 <input name="logout" type="submit" value="Wyloguj się">
     			 </form>
</@t.page>