@import exercise.dto.users.UserPage
@param UserPage page
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>${page.getUser().getFirstName() + " " + page.getUser().getLastName()}</h1>
    <p>${page.getUser().getEmail()}</p>
</body>
</html>