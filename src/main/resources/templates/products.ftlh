<#-- textInput macro for html input -->
<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Товары</h4>
<#list products as product>
    <div>
        <p>${product.}</p>
    </div>
</#list>
</body>
</html>