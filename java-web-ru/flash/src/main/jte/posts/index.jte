@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(page = page, content = @`
@for (var post : page.getPosts())
   <p>${post.getName()}</p>
@endfor
   <h2><a href="${NamedRoutes.buildPostPath()}">Create new post</a></h2>
`)
