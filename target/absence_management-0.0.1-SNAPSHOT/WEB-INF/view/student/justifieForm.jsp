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


	<%-- 	
 --%>
	<f:form method="POST"
		action="${pageContext.request.contextPath}/studentfile/uploadfile"
		modelAttribute="DocumentModel" enctype="multipart/form-data">

		<f:input path="absence[0].idAbsence" type="hidden" name="isabs"
			value="${idAbcense}" />

		<div class="form-group">
			<label for="intitule">intitule</label> 
			<f:input path="intitule"
				type="text" class="form-control" id="intitule"
				/>
		</div>

		<div class="mb-3">
			<label for="formFile" class="form-label">Default file input
				example</label> <input path="cheminFichier" class="form-control" name="file"
				type="file" id="formFile" />
		</div>
		<input type="submit" value="Submit" class="btn btn-primary" />
	</f:form>


</div>

<jsp:include page="../fragments/userfooter.jsp" />
