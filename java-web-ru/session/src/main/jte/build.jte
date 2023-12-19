@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

<%--@if (page.getError().length() != 0)--%>
    <p>${page.getError()}</p>
<%--@endif--%>
<form action="${NamedRoutes.loginPath()}" method="post">
    <div>
        <label>
            Login
            <input type="text" name="name"/>
        </label>
    </div>
    <div>
        <label>
            Password
            <input type="password" name="password"/>
        </label>
    </div>
    <input type="submit" value="Enter"/>
</form>