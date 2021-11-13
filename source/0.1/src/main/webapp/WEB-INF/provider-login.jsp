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
    <p>Provider Login</p>
  </ui:define>
  <ui:define name="middle">
    <form class="w3-container">
      <label class="w3-text-blue">Username</label>
      <input class="w3-input w3-border" />
      <label class="w3-text-blue">Password</label>
      <input class="w3-input w3-border" />
      <label class="w3-text-blue">Access Code (can change this to something else like clinic code)</label>
      <input class="w3-input w3-border" />
      <button class="w3-button w3-teal">
        <a href="provider-patients.xhtml">LOGIN</a>
      </button>
      <button class="w3-button w3-teal">RESET</button>
    </form>
  </ui:define>
  <ui:define name="right">
    <table class="w3-table">
      <tr><a href="#">Forgot your username or password?</a></tr>
      <tr><a href="#">Register for an account</a></tr>
    </table>
  </ui:define>
  <ui:define name="footer">
    <h2>myRX</h2>
  </ui:define>
</ui:composition>

</h:body>
</html>
