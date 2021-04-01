<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="./../template/header.jsp"/>

<!-- DataTables Example -->
<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-table"></i>
        ${user.username}
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${user.email}</td>
                    </tr>
                    <c:forEach items="${solutions}" var="solution">
                        <tr>
                            <td>${solution.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>

</div>



<jsp:include page="./../template/footer.jsp"/>