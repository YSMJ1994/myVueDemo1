<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body>
    <form action="${pageContext.request.contextPath }/queryItem.action" method="post">
    查询条件：
        <table width="100%" border="1">
            <tr>
                <td>
                    <input name="..">
                    <input type="submit" value="查询">
                </td>
            </tr>
        </table>
        商品列表：
        <table width="100%" border="1">
            <tr>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>生产日期</td>
                <td>商品描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${itemsList}" var="item">
                <tr>
                    <td>${item.item_name}</td>
                    <td>${item.price}</td>
                    <td>${item.description}</td>
                    <%--<td><a href="${pageContext.request.contextPath}/item.editItem.action?id=${item.id}">修改</a> </td>--%>
                </tr>
            </c:forEach>
        </table>

    </form>
</body>
</html>
