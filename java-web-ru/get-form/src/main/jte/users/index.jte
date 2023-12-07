@import exercise.dto.users.UsersPage
@param UsersPage page
<form action="/users" method="get">
    <input type="search" name="term" value="${page.getTerm()}" />
    <input type="submit" name="search" />
</form>
@for (var user : page.getUsers())
    <div>
    <h2>${user.getFirstName()} ${user.getLastName()}</h2>
    <p>${user.getEmail()}</p>
    </div>
@endfor