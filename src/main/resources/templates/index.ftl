<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Date</th>
        <th>Input</th>
        <th>Output</th>
    </tr>
    <#list sorts as sort>
        <tr>
            <td>${sort.date}</td>
            <td>${sort.inputs}</td>
            <td>${sort.output}</td>
        </tr>
    </#list>
</table>
</body>
</html>