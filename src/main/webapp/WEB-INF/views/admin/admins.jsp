<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
                <h1 class="h3 mb-2 text-gray-800">Administatorzy</h1>

                <!-- DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the https://datatables.net -->
                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h5 class="m-0 font-weight-bold text-primary"><a href="/admin/user/add"> Dodaj Administratora</a></h5>


                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Nr</th>
                                    <th>Imię</th>
                                    <th>Nazwisko</th>
                                    <th>email</th>
                                    <th>login</th>
                                    <th>status</th>
                                    <th>role</th>
                                    <th>Edycja</th>
                                    <th>Usunięcie</th>

                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Nr</th>
                                    <th>Imię</th>
                                    <th>Nazwisko</th>
                                    <th>email</th>
                                    <th>login</th>
                                    <th>status</th>
                                    <th>role</th>
                                    <th>Edycja</th>
                                    <th>Usunięcie</th>

                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${admins}" var="user" varStatus="theCount">
                                    <tr>
                                        <th scope="row">${theCount.count}</th>
                                        <td>${user.name}</td>
                                        <td>${user.surname}</td>
                                        <td>${user.email}</td>
                                        <td></td>
                                        <td>${user.active}</td>
                                                <td>
                                            <c:forEach items="${user.roles}" var="role">
                                                <li>${role.name}</li>
                                            </c:forEach>
                                        </td>
                                        <td><a href="/admin/user/edit/${user.id}" >Edytuj</a></td>

                                        <!-- Nav Item - Alerts -->
                                        <td class="nav-item dropdown no-arrow mx-1">
                                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <!-- Counter - Alerts -->
                                                Usuń </a>
                                            <!-- Dropdown - Alerts -->
                                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                                                <h6 class="font-weight-bold">
                                                    Czy na pewno chcesz usunąć użytkownika?
                                                </h6>
                                                <a href="/admin/user/delete/${user.id}">
                                                    <span style="font-size: large" class="badge badge-danger badge-counter align-content-lg-center">TAK</span>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach> <br />
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

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
