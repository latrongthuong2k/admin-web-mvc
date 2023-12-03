<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thuongnim
  Date: 13/11/2023
  Time: 12:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    bootstrap Link--%>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <%--    <link href="<%=request.getContextPath()%>/resources/plugins/fontawesome-free/css/all.min.css" rel="stylesheet"/>--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <!-- iCheck -->
    <link href="<%=request.getContextPath()%>/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css"
          rel="stylesheet"/>
    <!-- JQVMap -->
    <link href="<%=request.getContextPath()%>/resources/plugins/jqvmap/jqvmap.min.css" rel="stylesheet"/>
    <!-- Theme style -->
    <link href="<%=request.getContextPath()%>/resources/dist/css/adminlte.min.css" rel="stylesheet"/>
    <!-- overlayScrollbars -->
    <link href="<%=request.getContextPath()%>/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css"
          rel="stylesheet"/>
    <!-- Daterange picker -->
    <link href="<%=request.getContextPath()%>/resources/plugins/daterangepicker/daterangepicker.css" rel="stylesheet"/>
    <!-- summernote -->
    <link href="<%=request.getContextPath()%>/resources/plugins/summernote/summernote-bs4.min.css" rel="stylesheet"/>
    <%--    <script src="~/Contten/ckeditor/ckeditor.js"></script>--%>
    <%--    <link href="~/Contten/css/css.css" rel="stylesheet" />--%>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="https://unpkg.com/bootstrap-table@1.21.0/dist/bootstrap-table.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="<%=request.getContextPath()%>/resources/css/category.css" rel="stylesheet"/>


</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <div class="collapse navbar-collapse justify-content-center d-flex justify-content-between" id="navbarNav">
                <ul class="navbar-nav text-lg text-center text-black">
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/dashboard/dashBoard-data" class="nav-link">

                            <p>
                                Dashboard
                            </p>
                        </a>
                    </li>
                    <!--   Category -->
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/categoryController/categoryGetAllData" class="nav-link">

                            <p class="text-cyan">
                                Category
                            </p>
                        </a>
                    </li>
                    <!--   Product -->
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/productController/productGetAllData" class="nav-link">

                            <p>
                                Product
                            </p>
                        </a>
                    </li>
                    <!--  Bill -->
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/billController/billGetAllData" class="nav-link">

                            <p>
                                Bill
                            </p>
                        </a>
                    </li>
                    <!--  Account -->
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/accountController/accountGetAllData" class="nav-link">
                            <span>Accounts</span>
                        </a>
                    </li>
                </ul>
                <a href="<%=request.getContextPath()%>/loginController/login" class="nav-link">
                    <span>Logout</span>
                </a>
            </div>
        </div>
    </nav>
    <div class="">
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <h1></h1>
                <h1 class="text-center mt-2">Category</h1>
                <div class="main">
                    <div class="d-flex mt-5 mb-5 justify-content-center">
                            <div class="createDataButton">
                                <%--            <a type="button" class="btn btn-success" href="<%=request.getContextPath()%>/productController/initCreate">Create New Product</a>--%>
                                <a type="button" class="btn btn-primary mb-3" data-bs-toggle="modal"
                                   href="#createData">Create
                                    New
                                    Category</a>
                            </div>
                        <div class="col-4">
                            <form class="d-flex"
                                  action="<%=request.getContextPath()%>/categoryController/categoryGetAllData"
                                  method="get">
                                <input class="form-control me-2" type="text" placeholder="Search by category mame"
                                       id="categoryNameSearch"
                                       name="categoryNameSearch" value="${categoryNameDefault}">
                                <button class="btn btn-dark" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                    <div class="w-auto g mb-3 d-flex ">
                        <div class="d-flex">
                            <div class="mr-4">Sort By</div>
                            <select class="form-select" aria-label="Default select example" id="direction"
                                    name="direction" onchange="changeDirection()">
                                <option value="Default" ${direction.equals("ASC") && sortBy.equals("categoryId")?'selected':''}>
                                    Default
                                </option>
                                <option value="ASC" ${direction.equals("ASC") && sortBy.equals("categoryName")?'selected':''}>
                                    Category Name Asc
                                </option>
                                <option value="DESC" ${direction.equals("DESC") && sortBy.equals("categoryName") ?'selected':''}>
                                    Category Name Des
                                </option>
                            </select>
                        </div>
                    </div>
                    <table class="table table-dark table-striped text-center text-lg">
                        <thead>
                        <tr>
                            <th>Category ID</th>
                            <th>Category Name</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listCategory}" var="category">
                            <tr>
                                <td>${category.categoryId}</td>
                                <td>${category.categoryName}</td>
                                <td>${category.categoryDescription}</td>
                                <td class="${category.categoryStatus ? 'bg' : 'btn btn-outline-secondary'}">${category.categoryStatus ? "Active" : "Inactive"}</td>
                                <td>
                                    <a class="btn btn-outline-primary update" data-bs-toggle="modal"
                                       href="#updateData"><i class="fa-solid fa-wrench"></i></a>
                                        <%--                                            <a class="btn btn-warning update" href="<%=request.getContextPath()%>/categoryController/initUpdate?categoryId=${category.categoryId}">Update</a>--%>
                                    <a class="btn btn-outline-danger delete" data-bs-toggle="modal"
                                       href="#deleteData"><i class="fa-solid fa-xmark"></i></a>
                                    <input type="hidden" id="caId" value="${category.categoryId}">
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div>
                        <nav aria-label="...">
                            <ul class="pagination">
                                <li class="page-item ${currentPage <= 1 ? 'disabled' : ''}">
                                    <c:choose>
                                        <c:when test="${currentPage <= 1}">
                                            <a class="page-link"
                                               href="<%=request.getContextPath()%>/categoryController/categoryGetAllData?page=${currentPage}"
                                               tabindex="-1" aria-disabled="true">Prev</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="page-link"
                                               href="<%=request.getContextPath()%>/categoryController/categoryGetAllData?page=${currentPage - 1}"
                                               tabindex="-1" aria-disabled="false">Prev</a>
                                        </c:otherwise>
                                    </c:choose>
                                </li>
                                <c:forEach begin="1" end="${totalPage}" var="i">
                                    <li class="page-item ${currentPage == i ? 'active' : ''}"
                                        aria-current="page">
                                        <a class="page-link"
                                           href="<%=request.getContextPath()%>/categoryController/categoryGetAllData?page=${i}">${i}</a>
                                    </li>
                                </c:forEach>
                                <li class="page-item ${currentPage >= totalPage ? 'disabled' : ''}">
                                    <c:choose>
                                        <c:when test="${currentPage >= totalPage}">
                                            <a class="page-link"
                                               href="<%=request.getContextPath()%>/categoryController/categoryGetAllData?page=${totalPage}"
                                               tabindex="-1" aria-disabled="true">Next</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="page-link"
                                               href="<%=request.getContextPath()%>/categoryController/categoryGetAllData?page=${currentPage + 1}"
                                               tabindex="-1" aria-disabled="false">Next</a>
                                        </c:otherwise>
                                    </c:choose>
                                </li>
                            </ul>

                        </nav>
                    </div>
                    <%--                        </c:otherwise>--%>

                    <%--                    </c:choose>--%>

                    <%--    Modal Create Data--%>
                    <div class="modal fade" id="createData" tabindex="-1" aria-labelledby="createDataModal"
                         aria-hidden="true">
                        <div class="modal-dialog d-flex justify-content-center">
                            <div class="modal-content modalSet">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="createDataModal">Thêm mới danh mục</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form action="<%=request.getContextPath()%>/categoryController/create"
                                          method="post">
                                        <div class="row groupRow">
                                            <div class="col-6">
                                                <label for="categoryName" class="fw-bold">Category Name</label>
                                                <input type="text" id="categoryName" name="categoryName"
                                                       class="form-control">
                                            </div>
                                            <div class="col-6">
                                                <label for="categoryDescription" class="fw-bold">Category
                                                    Description</label>
                                                <input type="text" id="categoryDescription" name="categoryDescription"
                                                       class="form-control">
                                            </div>
                                        </div>
                                        <div class="row groupRow">
                                            <div class="col-6">
                                                <label for="categoryStatus" class="fw-bold">Category Status</label>
                                                <select id="categoryStatus" name="categoryStatus" class="form-select">
                                                    <option value="true" selected id="activeValue">Active</option>
                                                    <option value="false">Inactive</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-dark">Create</button>
                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close
                                            </button>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--    Modal Update Data--%>
                    <div class="modal fade" id="updateData" tabindex="-1" aria-labelledby="updateDataModal"
                         aria-hidden="true">
                        <div class="modal-dialog d-flex justify-content-center">
                            <div class="modal-content modalSet">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="updateDataModal">update category</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form action="<%=request.getContextPath()%>/categoryController/update"
                                          method="post">
                                        <div class="row groupRow">
                                            <div class="col-6">
                                                <label for="categoryIdUpdate" class="fw-bold">Category ID</label>
                                                <input type="text" id="categoryIdUpdate" name="categoryId"
                                                       class="form-control"
                                                       value="${categoryEdit.categoryId}" readonly>
                                            </div>
                                            <div class="col-6">
                                                <label for="categoryNameUpdate" class="fw-bold">Category Name</label>
                                                <input type="text" id="categoryNameUpdate" name="categoryName"
                                                       class="form-control"
                                                       value="${categoryEdit.categoryName}">
                                            </div>
                                        </div>

                                        <div class="row groupRow">
                                            <div class="col-6">
                                                <label for="categoryDescriptionUpdate" class="fw-bold">Category
                                                    Description</label>
                                                <input type="text" id="categoryDescriptionUpdate"
                                                       name="categoryDescription"
                                                       class="form-control" value="${categoryEdit.categoryDescription}">
                                            </div>
                                            <div class="col-6">
                                                <label for="categoryStatusUpdate" class="fw-bold">Category
                                                    Status</label>
                                                <select id="categoryStatusUpdate" name="categoryStatus"
                                                        class="form-select">
                                                    <option value="true" selected>Active</option>
                                                    <option value="false">Inactive</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-dark">Update</button>
                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--    Modal Delete Data--%>
                    <div class="modal" id="deleteData">
                        <div class="modal-dialog d-flex justify-content-center">
                            <div class="modal-content modalSetDelete">
                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Do you want to delete this category ?</h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                </div>
                                <!-- Modal body -->
                                <div class="modal-body text-center">
                                    <form class="mt-5" action="<%=request.getContextPath()%>/categoryController/delete?">
                                        <button type="submit" class="btn btn-danger" id="btnDelete">Delete</button>
                                        <button type="button" class="btn btn-success" data-bs-dismiss="modal">No
                                        </button>
                                        <input type="hidden" name="catalogIdDelete" id="catalogIdDelete" value="">
                                    </form>
                                </div>
                                <div class="modal-footer">
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--    Modal Sucess --%>

                    <%--                    Test BootStrap--%>


                    <!-- Alert delete success -->
                    <div class="toast-container position-absolute top-0 start-50 mt-5">
                        <div id="liveToastDeleteSuccess" class="toast bg-success" role="alert" aria-live="assertive"
                             aria-atomic="true" style="width:290px;height:100px;">
                            <div class="toast-header"></div>
                            <div class="toast-body text-light fs-5">
                                Delete Successfully
                            </div>
                        </div>
                    </div>

                    <!-- Alert delete error -->
                    <div class="toast-container position-absolute top-0 start-50 mt-5">
                        <div id="liveToastDeleteError" class="toast bg-danger" role="alert" aria-live="assertive"
                             aria-atomic="true" style="width:500px;height:100px;">
                            <div class="toast-header"></div>
                            <div class="toast-body text-light fs-5">
                                Products already exists in category so this category can't be deleted
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </section>
        <!-- /.content -->
    </div>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<!-- jQuery -->

<script src="<%=request.getContextPath()%>/resources/plugins/jquery/jquery.min.js" type="text/javascript"></script>

<script src="https://unpkg.com/bootstrap-table@1.21.0/dist/bootstrap-table.min.js" type="text/javascript"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/resources/plugins/jquery-ui/jquery-ui.min.js"
        type="text/javascript"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"
        type="text/javascript"></script>
<!-- ChartJS -->
<script src="<%=request.getContextPath()%>/resources/plugins/chart.js/Chart.min.js" type="text/javascript"></script>
<!-- Sparkline -->
<script src="<%=request.getContextPath()%>/resources/plugins/sparklines/sparkline.js" type="text/javascript"></script>
<!-- JQVMap -->
<script src="<%=request.getContextPath()%>/resources/plugins/jqvmap/jquery.vmap.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/jqvmap/maps/jquery.vmap.usa.js"
        type="text/javascript"></script>
<!-- jQuery Knob Chart -->
<script src="<%=request.getContextPath()%>/resources/plugins/jqvmap/maps/jquery.vmap.usa.js"
        type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/jquery-knob/jquery.knob.min.js"
        type="text/javascript"></script>
<!-- daterangepicker -->
<script src="<%=request.getContextPath()%>/resources/plugins/moment/moment.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/plugins/daterangepicker/daterangepicker.js"
        type="text/javascript"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"
        type="text/javascript"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/resources/plugins/summernote/summernote-bs4.min.js"
        type="text/javascript"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"
        type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/dist/js/adminlte.js" type="text/javascript"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<!-- AdminLTE for demo purposes -->
<%--<script src="<%=request.getContextPath()%>/resources/dist/js/demo.js" type="text/javascript"></script>--%>

<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script>
    $('table .update').click(function () {
        console.log('Vào update dữ liệu');
        let getId = $(this).parent().find('#caId').val();
        $.ajax({
            type: 'GET',
            url: '<%=request.getContextPath()%>/categoryController/initUpdate?categoryId=' + getId,
            success: function (categoryUpdateEdit) {
                console.log("Ok");
                try {
                    $('#categoryIdUpdate').val(categoryUpdateEdit.categoryId);
                    $('#categoryNameUpdate').val(categoryUpdateEdit.categoryName);
                    $('#categoryDescriptionUpdate').val(categoryUpdateEdit.categoryDescription);
                    let status = categoryUpdateEdit.categoryStatus.toString();
                    $('#categoryStatusUpdate').val(status);

                } catch (e) {
                    console.error("Error parsing JSON response:", e);
                }

            }
        })
    });

    <%--document.addEventListener("DOMContentLoaded", function() {--%>
    <%--    let btnDelete = document.getElementById("btnDelete");--%>
    <%--    btnDelete.addEventListener("click", function(e) {--%>
    <%--        e.preventDefault();--%>
    <%--        if(${message.equals("error")}){--%>
    <%--            console.log("Không th xóa ");--%>
    <%--        }else{--%>
    <%--            console.log("Xóa thành công");--%>
    <%--        }--%>
    <%--    });--%>
    <%--});--%>

    const urlParams = new URLSearchParams(window.location.search);
    const myParam = urlParams.get('message');

    if (myParam == "error") {
        showToastDeleteError();
    }
    if (myParam == "success") {
        showToastDeleteSuccess();
    }

    function showToastDeleteSuccess() {
        let toastLiveShow = document.getElementById("liveToastDeleteSuccess");
        let toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveShow);
        toastBootstrap.show();
        let autoCloseTimeout = 1000;
        setTimeout(() => {
            toastBootstrap.hide();
        }, autoCloseTimeout);
    }

    function showToastDeleteError() {
        let toastLiveShow = document.getElementById("liveToastDeleteError");
        let toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveShow);
        toastBootstrap.show();
        let autoCloseTimeout = 1000;
        setTimeout(() => {
            toastBootstrap.hide();
        }, autoCloseTimeout);
    }


</script>

<script src="<%=request.getContextPath()%>/resources/js/category.js" type="text/javascript"></script>
</body>
</html>
