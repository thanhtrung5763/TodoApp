<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <title>Todo App JavaScript | CodingNepal</title> -->
    <link rel="stylesheet" href="todopage.css">
    <!-- Font Awesome -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.css"
            rel="stylesheet"
    />
</head>
<body>
<section class="vh-100 gradient-custom-2">
    <div class="container-fluid py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-12 col-xl-10">
                <div class="card">
                    <div class="card-header p-3">
                        <h5 class="mb-0"><i class="fas fa-tasks me-2"></i>Task List</h5>
                        <span class="item-period">${email}</span>
                        <form action="/logout">
                            <span ><a href="/" class="item-small">Logout</a> </span>
                        </form>
                    </div>
                    <div class="card-body table-responsive" data-mdb-perfect-scrollbar="true" style="position: relative; height: 400px">
                        <table class="table mb-0 table-todo">
                            <thead>
                            <tr>
                                <th scope="col">Task</th>
                                <th scope="col">Priority</th>
                                <th scope="col">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="task" items="${listTask}">
                                <form action="/ToDoApp/Delete">
                                    <input type="hidden" name="email" value="${task.getEmail()}">
                                    <input type="hidden" name="taskId" value="${task.getTaskId()}">
                                    <tr class="fw-normal">
                                        <td class="align-middle">
                                            <span><c:out value="${task.getTaskName()}" /></span>
                                        </td>
                                        <td class="align-middle">
                                            <c:if test="${task.getPriority() == 1}">
                                            <span>
                                                <h6 class="mb-0">
                                                    <span class="badge bg-danger">High priority
                                                    </span>
                                                </h6>
                                            </span>
                                            </c:if>
                                            <c:if test="${task.getPriority() == 2}">
                                            <span>
                                                <h6 class="mb-0">
                                                    <span class="badge bg-warning">Middle priority
                                                    </span>
                                                </h6>
                                            </span>
                                            </c:if>
                                            <c:if test="${task.getPriority() == 3}">
                                            <span>
                                                <h6 class="mb-0">
                                                    <span class="badge bg-success">Low priority
                                                    </span>
                                                </h6>
                                            </span>
                                            </c:if>
                                        </td>
                                        <td class="align-middle m-0 p-0 ps-3">
                                            <button type="submit" class="icon-search me-2" title="Success"><i class="fas fa-check text-success "></i></button>
                                            <button type="submit" class="icon-search" title="Remove"><i class="fas fa-trash-alt text-danger"></i></button>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <form action="/ToDoApp/Add" method="post">
                        <div class="card-footer text-end p-3 ">
                            <div class="container mb-3">
                                <div class="d-md-flex align-items-center justify-content-between">
                                    <div class="input-group my-1 align-items-center justify-content-between">
                                        <input type="hidden" name="email" value=${email}>
                                        <input type="text" class="form-control me-1" placeholder="Enter Your Task" name="task_name">
                                        <div class="input-group-append ">
                                            <select name="priority" class="custom-select" id="inputGroupSelect02">
                                                <option selected>Priority...</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>
                                    </div>
                                    <button class="me-2 btn btn-link ">Cancel</button>
                                    <button class="btn btn-primary">Add Task</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- MDB -->
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.js"
></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<!-- <script src="script.js"></script> -->
</body>
</html>