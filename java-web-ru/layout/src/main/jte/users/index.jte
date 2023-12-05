@import exercise.dto.users.UsersPage
@param UsersPage page
@template.layout.page(header = @`
    @for (var user : page.getUsers())
        <div>
            <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
        </div>
    @endfor
`, footer = @``)

