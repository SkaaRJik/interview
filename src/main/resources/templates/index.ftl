<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <form method="post">
        <input type="text" name="arr" placeHolder="Введите ваши числа через пробел" />
        <button type="submit">Отсортировать</button>
    </form>
</div>
<table border="1">
    <tr>
        <th>Date</th>
        <th>Input</th>
        <th>Output</th>
    </tr>
    <#list sorts as sort>
        <tr>
            <td>${sort.getDate()?date}</td>
            <td>${sort.getInputs()}</td>
            <td>${sort.getOutput()}</td>
        </tr>
    </#list>
</table>
</body>
</html>