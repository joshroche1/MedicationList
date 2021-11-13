<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="resources/css/w3.css"/>
  <link rel="stylesheet" href="resources/css/font-awesome.min.css" />
  <title>myRx</title>
</head>
<body>

<div class="w3-content">
  <div id="body" class="w3-container w3-mobile w3-auto">
  
    <div id="top" class="w3-container w3-bar w3-teal w3-card">
    
      <div class="w3-container w3-content w3-mobile w3-row w3-padding">
        <div class="w3-container w3-center w3-col s4 m4 l4">
          <a href="#"><button onclick="document.getElementById('modalprofile').style.display='block'" class="w3-button w3-green w3-round-xxlarge">
           Profile</button></a>
        </div>
        <div class="w3-container w3-center w3-col s4 m4 l4"><h1>myRx</h1></div>
        <div class="w3-container w3-center w3-col s4 m4 l4">
          <a href="index.jsp"><button class="w3-button w3-green w3-round-xxlarge">
           LOGOUT</button></a>
        </div>
      </div>
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
    </div>
    
    <div id="middle" class="w3-container w3-mobile w3-card">
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

    </div>

    <div id="bottom" class="w3-container w3-mobile w3-card">
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
    </div>

  </div>
</div>

</body>
</html>
