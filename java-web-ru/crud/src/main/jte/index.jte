@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page
@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                  <a href="${NamedRoutes.postsPath()}">Все посты</a>
            </main>
        </div>
    `
)
