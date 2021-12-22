<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Film add</title>
</head>
<body>
<h1>Create film</h1>
<form method="post" action="/addFilm">
    <label>Title:
        <input name="title" placeholder="Title">
    </label>
    <label>Year of release:
        <input name="year" placeholder="Year of release">
    </label>
    <label>Genre:
        <input name="genre" placeholder="Genre">
    </label>
    <label>Director:
        <input name="director" placeholder="Director">
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
     <input type="submit" value="Create">
</form>

<h5></h5>
<form method="get" action="/">
    <input type="submit" value="Home page">
</form>
</body>
</html>