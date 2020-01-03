<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="/WEB-INF/views/admin/commons/style.jsp" %>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <%@ include file="/WEB-INF/views/admin/commons/sidebar.jsp" %>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <%@ include file="/WEB-INF/views/admin/commons/topbar.jsp" %>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Użytkownik</h1>

                <form:form method="post" modelAttribute="user">
                    <div class="form-group">
                        <form:hidden name="userId" path="id"/>

                        <label for="inputFirstName">Imię</label>
                        <form:input path="name" type="text" class="form-control"
                                    id="inputFirstName" placeholder="Imię"/>
                        <label for="inputLastName">Nazwisko</label>
                        <form:input path="surname" type="text" class="form-control"
                                    id="inputLastName" placeholder="Nazwisko"/>
                        <label for="inputEmail">Email</label>
                        <form:input path="email" type="text" class="form-control"
                                    id="inputEmail" placeholder="Email"/>

                        <label for="inputStatus">Status (1=aktywny, 0 = nieaktywny)</label>
                        <form:input path="active" type="number" class="form-control"
                                    id="inputStatus" placeholder="Status"/>
                        <label for="inputRoles">Role</label>
                        <c:forEach items="${roles}" var="role">
                            <div>
                                <label>
                                    <form:checkbox id="inputRoles"
                                                   path="roles"
                                                   value="${role}"
                                    />
                                    <span class="checkbox"></span>
                                    <span class="description"
                                    >${role.name}</span
                                    >
                                </label>
                            </div>
                        </c:forEach> <br />
                        <form:hidden path="password" ></form:hidden>

                    </div>
                    <button type="submit" class="btn btn-primary">Zapisz</button>
                </form:form>


            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <%@ include file="/WEB-INF/views/admin/commons/footer.jsp" %>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>


<%@ include file="/WEB-INF/views/admin/commons/javaS.jsp" %>

</body>

</html>
