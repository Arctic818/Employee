<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:template>

<c:if test = "${!empty departments}">
    <table class="book-list-table">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Manage</th>
        </tr>
        <c:forEach items = "${departments}" var = "department">
            <tr>
                <td>${department.id}</td>
                <td>${department.name}</td>
                <td><a href="javascript:DeleteDepartment.deleteDepartment(${department.id})">Delete</a> |
                    <a href="javascript:DeleteDepartment.deleteDepartment(${department.id})">Edit</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>

</t:template>