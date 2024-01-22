<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Препараты - Аптечный склад</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        main {
            padding: 20px;
        }

        h2 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        form {
            margin-top: 20px;
        }

        form p {
            margin-bottom: 15px;
        }

        form input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        form button {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        form button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%@include file="WEB-INF/jspf/header.jspf" %>
<main>
    <h2>Препараты</h2>
    <%
        String editing = (String)request.getAttribute("editing");
        if (editing != null && editing.equals("true")) { %>
    <form action="pills" method="post">
        <p>ID: <input type="text" name="id" value="${pill.getId()}" /></p>
        <p>Название: <input type="text" name="name" value="${pill.getName()}" /></p>
        <p>Фирма: <input type="text" name="firm" value="${pill.getFirm()}" /></p>
        <p>Страна производства: <input type="text" name="country" value="${pill.getCountry()}" /></p>
        <p>Описание: <input type="text" name="descr" value="${pill.getDescription()}" /></p>
        <p>Дозировка: <input type="text" name="dose" value="${pill.getDose()}" /></p>
        <button type="submit">Сохранить</button>
    </form>
    <% } else { %>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Фирма</th>
            <th>Страна производства</th>
            <th>Описание</th>
            <th>Дозировка</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="pill" items="${pills}">
            <tr>
                <td>${pill.getId()}</td>
                <td>${pill.getName()}</td>
                <td>${pill.getFirm()}</td>
                <td>${pill.getCountry()}</td>
                <td>${pill.getDescription()}</td>
                <td>${pill.getDose()}</td>
                <td><a href="?edit=true&id=${pill.getId()}">Редактировать</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <% } %>
</main>
<%@include file="WEB-INF/jspf/footer.jspf" %>
</body>
</html>