<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Загрузка файлов</title>
</head>
<body>
<form method="post" action="/files/upload" enctype="multipart/form-data">
    <label>Комментарий к файлу:
        <input name="description" placeholder="Введите описание файла">
    </label>
    <input type="file" name="file">
    <input type="submit" value="Загрузить">
</form>
</body>
</html>
