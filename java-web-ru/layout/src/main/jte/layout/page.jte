@import gg.jte.Content
@param Content header
@param Content footer
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<p>
    <div>
        <a href="/">Main page</a>
    </div>
    <div>
        <a href="/users">Users</a>
    </div>
</p>
${header}

<p> This is just a footer
<a href="https://github.com/blonde2029"> With my GitHub page</a>
</p>
${footer}
</body>
</html>
