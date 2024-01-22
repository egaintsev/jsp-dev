<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Препараты - Аптечный склад</title>

    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <main>
            <h2>Препараты</h2>
            <%
                String editing = (String)request.getAttribute("edit");
                if (editing != null && editing.equals("true")) { %>
                <form action="pills" method="post">
                    <p>ID: <input type="text" name="id" value="${pill.getId()}" /></p>
                    <p>Название: <input type="text" name="name" value="${pill.getName()}" /></p>
                    <p>Фирма: <input type="text" name="firm" value="${pill.getFirm()}" /></p>
                    <p>Форма выпуска: <input type="text" name="releaseForm" value="${pill.getReleaseForm()}" /></p>
                    <p>Страна производства: <input type="text" name="country" value="${pill.getCountry()}" /></p>
                    <p>Описание: <input type="text" name="descr" value="${pill.getDescription()}" /></p>
                    <p>Дозировка: <input type="text" name="dose" value="${pill.getDose()}" /></p>
                <button type="submit">Сохранить</button>
                </form>
            <% } else { %>
                    <p>ID: ${pill.getId()}</p>
                    <p>Название: ${pill.getName()}</p>
                    <p>Фирма: ${pill.getFirm()}</p>
                    <p>Страна производства: ${pill.getCountry()}</p>
                    <p>Форма выпуска: ${pill.getReleaseForm()}</p>
                    <p>Описание: ${pill.getDescription()}</p>
                    <p>Дозировка: ${pill.getDose()}</p>
                <a href="?edit=true">Редактировать</a>
            <% } %>
        </main>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
