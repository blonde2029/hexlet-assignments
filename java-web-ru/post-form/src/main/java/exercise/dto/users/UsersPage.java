package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@AllArgsConstructor
@Getter
@Setter
public class UsersPage {
    private List<User> users;
}
// END
