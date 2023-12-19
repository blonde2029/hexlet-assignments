@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

@if (page.getName().toString() != "")
    <form action="${NamedRoutes.logoutPath()}" method="post">
    <h1>${page.getName().toString()}</h1>
<%--    h1><a href="${NamedRoutes.logoutPath()}">Выйти</a></h1>--%>
        <input type="submit" value="Выйти"/>
    </form>
@else
<h1><a href="${NamedRoutes.buildSessionPath()}">Войти</a></h1>
@endif