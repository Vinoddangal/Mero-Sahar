<%-- 
    Document   : logout
    Created on : Nov 24, 2019, 8:38:16 PM
    Author     : Rukesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:remove var="loggedInUser" scope="session"/>
<c:redirect url="index.jsp"/>
