<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.*,java.util.HashMap,java.util.Map,
    java.util.Iterator,java.util.Map.*" %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulaire rendez-vous</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>


<div class="container">
  <spring:url value="/rdvs/save" var="saveURL" />
  <h2>Formulaire rendez-vous</h2>
  
  <form:form modelAttribute="rdvForm" method="post" action="${saveURL}" cssClass="form" >
   <form:hidden path="id"/>
   
   <div class="form-group">
    <label>Client</label>
 
       <form:select path="client.id" cssClass="form-control" name="client.id" id="client.id">
            <%
          HashMap cls;
     	 cls= (HashMap) request.getAttribute("clients"); 
     	  Iterator iterator = cls.entrySet().iterator();
          while (iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry) iterator.next();
                    
            %>
            
            <option value="<%=mapentry.getKey()%>"><%= mapentry.getValue()%></option>
            
            <%
          } 
          
          %>
        </form:select>
        
   </div>
   
      <div class="form-group">
    <label>Medecin</label>
       <form:select path="medecin.id" cssClass="form-control" id="rdv.medecin.id">
          <%
          HashMap meds;
     	 meds= (HashMap) request.getAttribute("meds"); 
     	  Iterator iterator = meds.entrySet().iterator();
          while (iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry) iterator.next();
                    
            %>
            
            <option value="<%=mapentry.getKey()%>"><%= mapentry.getValue()%></option>
            
            <%
          } 
          
          %>
        </form:select>
   </div>
   
<div class="form-group">
    <label>Date</label>
    <form:input path="jour" cssClass="form-control" id="rdv.jour" />
   </div>
   
   
   <button type="submit" class="btn btn-primary">Ajouter</button>
  </form:form>
  
 </div>

</body>
</html>