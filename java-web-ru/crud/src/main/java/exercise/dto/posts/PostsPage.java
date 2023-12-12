package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
    private Integer pageNumber;
    public Integer nextPage() {
        return this.pageNumber + 1;
    }

    public Integer previousPage() {
        return this.pageNumber - 1;
    }
}
// END


