<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
         "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
<h:body>

<ui:composition template="./templates/template-main.xhtml">
  <ui:define name="header">
    <h1>myRx</h1>
    <h2>Online Medication List</h2>
  </ui:define>
  <ui:define name="left">
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
  </ui:define>
  <ui:define name="middle">
    <p>
    #{testbean.getString()}
    </p>
  </ui:define>
  <ui:define name="right">
    <p>
      myRx provides you with a secure and easy to access way to view your medications when you need to.
    </p>
  </ui:define>
  <ui:define name="footer">
    <h2>myRX</h2>
  </ui:define>
</ui:composition>

</h:body>
</html>
