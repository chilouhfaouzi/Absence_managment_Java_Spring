<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/userheader.jsp" />

<div class="container">


test me

<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Date</th>
					<th scope="col">ETAT</th>
					<th scope="col">Enseignat</th>
					<th scope="col">Type Seance</th>
					<th scope="col">Matiere</th>	
					<th scope="col">Action</th>			
				</tr>
			</thead>

			<c:forEach items="${absenceList}" var="p">
				<tr>				
					<td><c:out value="${p.idAbsence}" /></td>
					<td><c:out value="${p.dateHeureDebutAbsence } / ${p.dateHeureFinAbsence }" /></td>
					<td>
					<c:if test="${p.etat== 0}" var="variable">
					justifiée
					</c:if>
					<c:if test="${p.etat== 1}" var="variable">
					non justifiée
					</c:if>
					<c:if test="${p.etat== 2}" var="variable">
					annulée
					</c:if>
					<c:out value="" /></td>
					 <td><c:out value="${p.observateur.nom}" /></td>
    				<td><c:out value="${p.typeSeance.alias}" /></td> 
    				<td><c:out value="${p.matiere.nom}" /></td> 
    				<td>
    				<ul>
    				<li>
    				<a href="${pageContext.request.contextPath}/studentt/justifie/${p.idAbsence}">justifier</a>
    				</li>
    				<li>
    				<a href="${pageContext.request.contextPath}/studentt/messagereclamation/${p.idAbsence}">réclamation</a>
    				</li>
    				
    				
    			
    				</ul>
    				</td>
    				
 
				</tr>

			</c:forEach>
			
</table>
</div>
		
			
<jsp:include page="../fragments/userfooter.jsp" />
