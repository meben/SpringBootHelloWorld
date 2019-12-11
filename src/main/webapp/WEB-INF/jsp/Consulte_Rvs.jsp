<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Liste des médecins</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script></head>
<body>

<div class="container">
  <h2>Liste des rendez-vous</h2>
  <table class="table table-striped">
   <thead>
    <th scope="row">#ID</th>
    <th scope="row">Client_ID</th>
    <th scope="row">Medecin_ID</th>
    <th scope="row">Date</th>    
    <th scope="row">Update</th>
    <th scope="row">Delete</th>
   </thead>
   <tbody>
    <c:forEach items="${listerdvs}" var="c" >
     <tr>
      <td>${c.id}</td>
      <td>${c.client.id}</td>
      <td>${c.medecin.id}</td>
      <td>${c.jour}</td>
      
      <td>
       <spring:url value="/rdvs/update/${c.id }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL}" role="button" >Update</a>
      </td>
      <td>
       <spring:url value="/rdvs/delete/${c.id }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" >Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/clients/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button" >Ajouter un nouveau rendez-vous</a>
 </div>

</body>
</html>