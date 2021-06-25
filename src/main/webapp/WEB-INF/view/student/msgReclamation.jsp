<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/userheader.jsp" />

<div class="container">


	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">



			<jsp:include page="../fragments/studentmenu.jsp" />

		</div>
	</nav>



	<f:form method="POST" action="/HelloWeb/addUser"
		modelAttribute="MessageModel">
		<div class="form-row">

			<f:hidden path="expediteurid" />





			<div class="form-group col-md-6">
				<!--   <label for="exampleFormControlTextarea1">Example textarea</label>
    <textarea  id="exampleFormControlTextarea1" rows="3"></textarea> -->

				<f:label path="text">Message</f:label>

				<f:textarea class="form-control" path="text" rows="5" cols="30" />
			</div>



			<div class="form-group col-md-6">
				<label for="adminList">Admin</label> <select name="adminChose"
					class="form-control" id="adminList">
					<c:forEach items="${AdminList}" var="ad">
						<option value="${ad.nom}">${ad.nom}</option>
					</c:forEach>
				</select>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</div>

	</f:form>


	<c:forEach items="${AdminList}" var="p">
		<c:out value="${p.nom}" />
		<br />

	</c:forEach>

	<%-- <p>Messages</p>
	
	
			<c:forEach items="${messages}" var="p">
					<c:out value="${p.idMessage}" /><br/>
					<c:out value="${p.texte }" />
				
			</c:forEach>	 --%>

</div>


<jsp:include page="../fragments/userfooter.jsp" />
