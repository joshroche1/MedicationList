<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="w3.css"/>
  <link rel="stylesheet" href="font-awesome.min.css" />
  <title>myRx</title>
</head>
<body>

<div class="w3-content">
  <div id="body" class="w3-container w3-auto">
    <div id="header" class="header w3-container w3-row w3-cell-row w3-bar w3-teal w3-card w3-section">
      <div class="w3-container w3-cell w3-mobile w3-content w3-margin w3-third" />
        <div class="w3-conatiner w3-cell w3-mobile w3-content w3-margin w3-third">
          <h1>myRx</h1>
          <h2>Online Medication List</h2>
        </div>
        <div class="w3-container w3-cell w3-mobile w3-content w3-margin w3-third" />
      </div>
	  <div class="w3-cell-row w3-section">
        <div id="left" class="w3-container w3-cell w3-cell-middle w3-mobile w3-third">
	      <p>Login:</p>
          <ul class="w3-ul">
            <li class="w3-margin">
              <a href="login.xhtml">
              <button class="w3-button w3-teal w3-round-xxlarge">Patient</button></a>
            </li>
            <li class="w3-margin">
              <a href="provider-login.xhtml">
              <button class="w3-button w3-teal w3-round-xxlarge">Provider</button></a>
            </li>
            <li><a href="#">Forgot your username or password?</a>
            </li>
            <li><a href="#">Register for an account</a>
            </li>
          </ul>
        </div>
        <div id="middle" class="w3-container w3-cell w3-cell-middle w3-mobile w3-third">
          <p>
            #{testbean.getString()}
          </p>
        </div>
        <div id="right" class="w3-container w3-cell w3-cell-middle w3-mobile w3-third">
          <p>
            myRx provides you with a secure and easy to access way to view your medications when you need to.
          </p>
        </div>
      </div>
 
    <div id="footer" class="footer w3-container w3-bar w3-teal w3-card w3-section">
      <a href="index.xhtml"><h2>myRX</h2></a>
    </div>
  </div>
</div>

</body>
</html>
