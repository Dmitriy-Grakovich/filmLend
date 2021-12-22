<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Play</title>
</head>
<body>
        <h3> Просмотр фильма - ${film.title}</h3>
        <video   controls width="400" height="300">
            <source src="movie.mp4" type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"' />
            </video>


        <form method="get" action="/">
            <input type="submit" value="Home page">
        </form>
</body>
</html>