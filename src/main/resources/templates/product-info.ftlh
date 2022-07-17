<!DOCTYPE html>
<html>
<head>
    <title>КУПИ-ПРОДАЙ</title>
</head>
<body>
<h1>КУПИ-ПРОДАЙ</h1><hr>
<h4>Подробная информация о товаре:</h4>
<#--<img src="/images/${product.images.get(0)}" height = "60px"><br>-->
<#--<img src="/images/${product.images.get(1)}" height = "60px"><br>-->
<#--<img src="/images/${product.images.get(2)}" height = "60px"><br>-->
<#list images as img>
    <img src="/images/${img.id}" height="150px"/><br>
</#list>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<b>Город: </b>${product.city}<br>
<b>Автор: </b><a href = "/user/${product.user.id}">${product.user.name}</a><br>
</body>
</html>