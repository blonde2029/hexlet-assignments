package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
   @Autowired
   private PostRepository postRepository;

   @Autowired
   private CommentRepository commentRepository;

   public PostDTO postToDTO (Post post) {
        var postDTO = new PostDTO();
        postDTO.setBody(post.getBody());
        postDTO.setId(post.getId());
        List<CommentDTO> postComments = commentRepository
                .findByPostId(post.getId())
                .stream()
                .map(this::commentToDTO)
                .toList();
        postDTO.setComments(postComments);
        return postDTO;
   }

   public CommentDTO commentToDTO (Comment comment) {
       var commentDTO = new CommentDTO();
       commentDTO.setBody(comment.getBody());
       commentDTO.setId(comment.getId());
       return commentDTO;
   }
   @GetMapping(path = "")
   public List<PostDTO> index() {
       var posts = postRepository.findAll();
       var result = posts.stream()
               .map(this:: postToDTO)
               .toList();
       return result;
   }

   @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) {
       var post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " +
               + id + " not found"));
       var postDTO = new PostDTO();
       postDTO.setId(post.getId());
       postDTO.setTitle(post.getTitle());
       postDTO.setBody(post.getBody());
       List<CommentDTO> postComments = commentRepository.findByPostId(post.getId())
                       .stream()
                       .map(this::commentToDTO)
                       .toList();
       postDTO.setComments(postComments);
       return postDTO;
   }
}
// END
