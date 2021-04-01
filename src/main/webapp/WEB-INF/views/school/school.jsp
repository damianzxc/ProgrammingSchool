<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="./../template/header.jsp" />


<!-- DataTables Example -->
<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-table"></i>
        Last 5 solutions
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Created</th>
                    <th>Updated</th>
                    <th>User</th>
                    <th>Exercie</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Created</th>
                    <th>Updated</th>
                    <th>User</th>
                    <th>Exercie_id</th>
                    <th>Description</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${solutionList}" var="solution">
                    <tr>
                        <td>${solution.created}</td>
                        <td>${solution.updated}</td>
                        <td>${solution.user.username}</td>
                        <td>${solution.exercise}</td>
                        <td>${solution.description}
                            <a href="http://localhost:8080/solution?id=${solution.id}">link</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>

</div>

<jsp:include page="./../template/footer.jsp" />