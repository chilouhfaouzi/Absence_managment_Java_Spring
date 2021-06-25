<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.util.* "%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/userheader.jsp" />


<div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">



			<jsp:include page="../fragments/studentmenu.jsp" />

		</div>
	</nav>
	<h2>Submitted File</h2>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">intitule</th>
				<th scope="col">ETAT</th>
				<th scope="col">dateLivraison</th>
				<th scope="col">Type Seance</th>
				<th scope="col">cheminFichier</th>

				<th scope="col">Action</th>
			</tr>
		</thead>

		<c:forEach items="${pieceList}" var="p">
			<tr>
				<td><c:out value="${p.idPieceJustificative}" /></td>
				<td><c:out value="${p.intitule }" /></td>
				<td><c:if test="${p.etat== 0}" var="variable">
					justifiée
					</c:if> <c:if test="${p.etat== 1}" var="variable">
					non justifiée
					</c:if> <c:if test="${p.etat== 2}" var="variable">
					annulée
					</c:if> <c:out value="" /></td>
				<td><c:out value="${p.dateLivraison}" /></td>
				<td><c:out value="${p.absence.get(0).typeSeance}" /></td>
				<td><a href="${p.cheminFichier}" target="_blank"   >file</a></td>


				<td>
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/studentt/justifie/">justifier</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/studentt/messagereclamation/">réclamation</a>
						</li>



					</ul>
				</td>


			</tr>

		</c:forEach>

	</table>
	
	
</div>

        



<jsp:include page="../fragments/userfooter.jsp" />
