<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Medecin Form</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>

<div class="container">
  <spring:url value="/clients/save" var="saveURL" />
  <h2>Formulaire Client</h2>
  
  <form:form modelAttribute="clientForm" method="post" action="${saveURL}" cssClass="form" >
   <form:hidden path="id"/>
   
   <div class="form-group">
    <label>Nom</label>
    <form:input path="nom" cssClass="form-control" id="nom" />
   </div>
   
   <div class="form-group">
    <label>Prenom</label>
    <form:input path="prenom" cssClass="form-control" id="prenom" />
   </div>
   
   
   <button type="submit" class="btn btn-primary">Ajouter</button>
  </form:form>
  
 </div>

</body>
</html>