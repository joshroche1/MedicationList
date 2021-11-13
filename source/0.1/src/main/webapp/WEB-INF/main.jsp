
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
         "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
<h:body>

<ui:composition template="./templates/template-appmain.xhtml">

  <ui:define name="top">
    <div class="w3-container w3-content w3-mobile w3-row w3-padding">
      <div class="w3-container w3-center w3-col s4 m4 l4">
        <a href="#"><button onclick="document.getElementById('modalprofile').style.display='block'" class="w3-button w3-green w3-round-xxlarge">
        Profile</button></a>
      </div>
      <div class="w3-container w3-center w3-col s4 m4 l4"><h1>myRx</h1></div>
      <div class="w3-container w3-center w3-col s4 m4 l4">
        <a href="index.xhtml"><button class="w3-button w3-green w3-round-xxlarge">
        LOGOUT</button></a>
      </div>
    </div>
  </ui:define>

  <ui:define name="middle">
    <div class="">
<!-- TEMPORARY TABLE TO ILLUSTRATE DATA PRESENTATION -->
<table class="w3-table">
<tr><th></th><th>Medication</th><th>Dosage</th><th></th><th>Expiration</th></tr>
<tr>
<td><button onclick="document.getElementById('modal01').style.display='block'" class="w3-button">i</button>
</td><td>MEDICATION NAME</td><td>123</td>
<td>mg</td><td>DD-MMM-YYYY</td>
</tr>
<tr>
<td><button onclick="document.getElementById('modal01').style.display='block'" class="w3-button">i</button>
</td><td>MEDICATION NAME</td><td>123</td>
<td>mg</td><td>DD-MMM-YYYY</td>
</tr>
<tr>
<td><button onclick="document.getElementById('modal01').style.display='block'" class="w3-button">i</button>
</td><td>MEDICATION NAME</td><td>123</td>
<td>mg</td><td>DD-MMM-YYYY</td>
</tr>
<tr>
<td><button onclick="document.getElementById('modal01').style.display='block'" class="w3-button">i</button>
</td><td>MEDICATION NAME</td><td>123</td>
<td>mg</td><td>DD-MMM-YYYY</td>
</tr>
<tr>
<td><button onclick="document.getElementById('modal01').style.display='block'" class="w3-button">i</button>
</td><td>MEDICATION NAME</td><td>123</td>
<td>mg</td><td>DD-MMM-YYYY</td>
</tr>
<tr>
<td><button onclick="document.getElementById('modal01').style.display='block'" class="w3-button">i</button>
</td><td>MEDICATION NAME</td><td>123</td>
<td>mg</td><td>DD-MMM-YYYY</td>
</tr>
<tr>
<td><button onclick="document.getElementById('modal01').style.display='block'" class="w3-button">i</button>
</td><td>MEDICATION NAME</td><td>123</td>
<td>mg</td><td>DD-MMM-YYYY</td>
</tr>
</table>
<!-- -->
    </div>
    <div id="modal01" class="w3-modal">
      <div class="w3-modal-content">
        <div class="w3-container w3-card">
          <span onclick="document.getElementById('modal01').style.display='none'" class="w3-button w3-display-topright">X</span>
          <table class="w3-table">
            <tr><h1>MEDICATION NAME</h1></tr>
            <tr><h2>Manufacturer</h2></tr>
            <tr>
              <p>Some text about the medication. This can be fetched from the database or resource text/xml files in a folder.</p>
            </tr>
          </table>
    </div></div></div>
    <div id="modalprofile" class="w3-modal">
      <div class="w3-modal-content">
        <div class="w3-container w3-card">
          <span onclick="document.getElementById('modalprofile').style.display='none'" class="w3-button w3-display-topright">X</span>
          <table class="w3-table">
            <tr><th></th><th><h1>MR/MS/MX/DR LASTNAME FIRSTNAME</h1></th></tr>
            <tr><td></td><td><h2>email@address.com</h2></td></tr>
            <tr><td>Home:</td><td>123-456-7890</td></tr>
            <tr><td>Address:</td><td>123 Street Rd.<br />Cityville, ZZ 99999</td></tr>
          </table>
    </div></div></div>
  </ui:define>

  <ui:define name="bottom">
    <div class="w3-container w3-bar w3-mobile w3-row w3-padding">
      <div class="w3-container w3-center w3-col s3 m3 l3"><button class="w3-button w3-teal w3-round-xxlarge">HISTORY</button>
      </div>
      <div class="w3-container w3-center w3-col s3 m3 l3"><button class="w3-button w3-teal w3-round-xxlarge">SHARE</button>
      </div>
      <div class="w3-container w3-center w3-col s3 m3 l3"><button class="w3-button w3-teal w3-round-xxlarge">###</button>
      </div>
      <div class="w3-container w3-center w3-col s3 m3 l3"><button class="w3-button w3-teal w3-round-xxlarge">###</button>
      </div>
    </div>
  </ui:define>

  <ui:define name="footer">
    <h2>myRX</h2>
  </ui:define>
</ui:composition>

</h:body>
</html>
