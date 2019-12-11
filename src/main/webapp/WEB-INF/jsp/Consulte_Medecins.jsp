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
  <h2>Liste des médecins</h2>
  <table class="table table-striped">
   <thead>
    <th scope="row">#ID</th>
    <th scope="row">Nom</th>
    <th scope="row">Prénom</th>
    <th scope="row">Spécialité</th>
        <th scope="row">Update</th>
    <th scope="row">Delete</th>
   </thead>
   <tbody>
    <c:forEach items="${listemedecins}" var="med" >
     <tr>
      <td>${med.id}</td>
      <td>${med.nom}</td>
      <td>${med.prenom}</td>
      <td>${med.specialite}</td>
      <td>
       <spring:url value="/medecins/update/${med.id }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button" >Update</a>
      </td>
      <td>
       <spring:url value="/medecins/delete/${med.id }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" >Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/medecins/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button" >Ajouter un nouveau médecin</a>
 </div>

</body>
</html>