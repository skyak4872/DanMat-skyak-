<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>search User list</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/admin.min.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/mgMain.css'/>">
</head>
<body>
<body id="page-top">
    <div id="wrapper">
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/main">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">DANMAT</div>
            </a>
            <hr class="sidebar-divider my-0">
            <li class="nav-item">
                <a class="nav-link" href="/Manager/mgMain">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>ADMIN</span></a>
            </li>
            <hr class="sidebar-divider">
            <div class="sidebar-heading">
                USER
            </div>
            <li class="nav-item">
                <a class="nav-link" href="/Manager/searchUser"">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>유저 관리</span>
                </a>
            </li>
            <hr class="sidebar-divider">
            <div class="sidebar-heading">
                ADMIN
            </div>
            <li class="nav-item">
                <a class="nav-link" href="notice">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>공지사항</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="board"">
                    <i class="fas fa-fw fa-table"></i>
                    <span>게시판</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="category" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>PUZZLE</span>
                </a>
            </li>
            <hr class="sidebar-divider d-none d-md-block">
        </ul>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">admin</span>
                            </a>
                        </li>
                </nav>
                <div class="container-fluid">
                    <h1 class="h3 mb-2 text-gray-800">DANMAT 공지사항</h1>
                    <p class="mb-4"><a target="_blank">공지입니다</a></p>
      				  <i class="fas fa-download fa-sm text-white-50"></i>검색</a>
					     <h3 class="searchInfo"></h3>
                            <i class="fas fa-download fa-sm text-white-50"></i>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Title</th>
                                            <th>Name</th>
                                            <th>Date</th>
                                            <th>View</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                    <tbody>
                                      <tr>
                                        <td>1</td>
                                        <td>신규 게임이 업데이트 될 예정입니다</td>
                                        <td>admin</td>
                                        <td>2022-08-19 12:58</td>
                                        <td>3</td>
                                       </tr>
                                       <tr>
                                          <td>2</td>
                                          <td>어서오세요 DANMAT 입니다</td>
                                          <td>admin</td>
                                          <td>2022-08-19 12:59</td>
                                          <td>5</td>
                                        </tr>
                                       <tr>
                                           <td>3</td>
                                           <td>회원페이지랑</td>
                                           <td>연동해야하는데</td>
                                           <td>전 잘 모르겠숨돠</td>
                                           <td>^o^</td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>6</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>7</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>8</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>9</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>10</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                      <span>단어의 맛&copy;<br></span>
                      <span>Copyright danmat Corp. All Rights Reserved.</span>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</body>
</html>
