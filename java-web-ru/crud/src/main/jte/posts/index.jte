@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page
@template.layout.page(content = @`
@for (var post : page.getPosts())
    <div>
        <h2><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h2>
    </div>
    <div>
    </div>
@endfor
    @if (page.previousPage() > 0)
        <a href="${NamedRoutes.postsPath() + "?page=" + page.previousPage()}">Previous</a>
    @endif
    <a href="${NamedRoutes.postsPath() + "?page=" + page.nextPage()}">Next</a>
`)

