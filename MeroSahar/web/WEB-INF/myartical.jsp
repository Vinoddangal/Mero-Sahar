<%-- 
    Document   : myartical
    Created on : Dec 1, 2019, 12:25:31 AM
    Author     : Rukesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="jspf/header.jspf" %>
    <body>
    <div class="empty-section">	</div>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Heading</th>
                <th>Image</th>
                <th>Content</th>
                <th>Tags</th>
                <th>Type</th>
                <th>Location</th>
                <th>action</th>
            </tr>
            </thead>
            <c:set var="userid" value="${sessionScope.loggedInUser.id}" scope="page"></c:set>
            <c:forEach var="artical" items="${articalList}">
                <c:if test="${artical.userid.id == userid}">
                <tbody>
                <tr>
                    <td>${artical.heading}  ${artical.subheading}</td>
                    <td><img src="${artical.photo}"></td>
                    <td>${artical.content}</td>
                    <td>${artical.tags}</td>
                    <td>${artical.type}</td>
                    <td>${artical.locationid.street},${artical.locationid.city}</td>
                    <td><a href="editartical?id=${artical.id}">Edit</a> <a href="deleteartical?id=${artical.id}">Delete</a></td>
                </tr>
                </tbody>
                </c:if>
            </c:forEach>
        </table>
    </body>

