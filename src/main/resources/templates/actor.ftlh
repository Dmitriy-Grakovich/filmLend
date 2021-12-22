<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Actor</title>
</head>
<body>
<h3>Films featuring - ${actor.firstName} ${actor.lastName}</h3>

<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Genre</th>
        <th>Director</th>
        <th>Actor</th>
        <th>Play</th>
    </tr>
    </thead>
    <tbody>
    <#list actor.removedFilm as film>
        <tr>
            <td>${film.title}</td>
            <td>${film.year}</td>
            <td>${film.genre}</td>
            <td><a href="/director/${film.director.id}">${film.director.firstName} ${film.director.lastName}</a></td>
            <td>
                <#list  film.actors as actor>
                    <a href="/actor/${actor.id}"> ${actor.firstName} ${actor.lastName}, </a>
                </#list>
            </td>
            <td><a href="/viewing/${film.id}">viewing</a></td>
        </tr>
    </#list>
    </tbody>
</table>

<form method="get" action="/">
    <input type="submit" value="Home page">
</form>
</body>
</html>