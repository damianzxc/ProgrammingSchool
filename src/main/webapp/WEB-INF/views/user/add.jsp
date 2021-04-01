<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="./../template/header.jsp"></jsp:include>


<!-- Page Content -->
<h1>Add new User</h1>
<hr>
<p>This is a great starting point for new custom pages.</p>

<form action="#" method="post">
    <input type="text" name="username" placeholder="username" />
    <input type="text" name="email" placeholder="email" />
    <<input type="text" name="password" placeholder="password" />
    <select name="group_id">
        <c:forEach items="${groupList}" var="group">
            <option value="${group.id}">${group.name} </option>
        </c:forEach>
    </select>

    <input type="text" name="isbn" placeholder="isbn" />
    <input type="submit" value="save">
</form>


<jsp:include page="./../template/footer.jsp"></jsp:include>