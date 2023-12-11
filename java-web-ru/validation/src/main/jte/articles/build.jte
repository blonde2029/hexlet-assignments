@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page
<ul>
@if (page.getErrors() != null)
    @for (var validator : page.getErrors().values())
        @for (var error : validator)
            <li>${error.getMessage()}</li>
        @endfor
    @endfor
@endif
</ul>
<form action="/articles" method="post">
    <div>
        <label>
            Title
            <input type="text" name="title" value="${page.getTitle()}"/>
        </label>
    </div>
    <div>
        <label>
            Content
            <input type="text" name="content" value="${page.getContent()}"/>
        </label>
    </div>
    <input type="submit" value="Create"/>
</form>