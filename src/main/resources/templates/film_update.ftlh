<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
</head>
<body>
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
    </tbody>

</table><br><br>

<form method="post" action="/updateFilm/${film.id}">

    <label>Title:</label>
    <input name="title" placeholder="${film.title}">
    <label>Year:</label>
    <input name="year" placeholder="${film.year}">
    <label>Genre:</label>
    <input name="genre" placeholder="${film.genre}">
    <label>Director:
        <input name="director" placeholder="${film.director.firstName} ${film.director.lastName}">
    </label>
    <label>
        <table>
            <thead><tr><td>Actors:</td></tr></thead>
            <tbody>
            <tr>
                <td>
                    <input name="actor1" placeholder="Actor1">
                </td>
            </tr>

            <tr>
                <td>
                    <input name="actor2" placeholder="Actor2">
                </td>
            </tr>
            <tr>
                <td>
                    <input name="actor3" placeholder="Actor3">
                </td>
            </tr>
            </tbody>
        </table>
    </label>


    <input type="submit" value="Submit">
</form>
<h5></h5>
<form method="get" action="/">
    <input type="submit" value="Home page">
</form>
</body>
</html>
