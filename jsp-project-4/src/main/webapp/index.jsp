<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Аптечный склад</title>
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

        p {
            font-size: 18px;
        }

        a {
            display: block;
            margin-bottom: 10px;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border-radius: 5px;
        }

        a:hover {
            background-color: #45a049;
        }

        footer {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
            position: absolute;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
<%@include file="WEB-INF/jspf/header.jspf" %>
<main>
    <p>Добро пожаловать на сайт аптечного склада!</p>
    <a href="pills">Препараты</a>
    <a href="pharmacies">Аптеки</a>
    <a href="totalamount">Общее количество</a>
</main>
<%@include file="WEB-INF/jspf/footer.jspf" %>
</body>
</html>