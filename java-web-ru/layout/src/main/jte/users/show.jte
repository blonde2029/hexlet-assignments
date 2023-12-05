@import exercise.dto.users.UserPage
@param UserPage page
@template.layout.page(header = @`
<h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
    <p>${page.getUser().getEmail()}</p>
`, footer = @``)
