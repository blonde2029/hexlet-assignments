package exercise.dto;

// BEGIN

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class GuestCreateDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Size(min = 12, message = "must be at least 11 digits")
    @Size(max = 14, message = "must be shorter than 13 digits")
    @Pattern(regexp = "^\\+[0-9]*$", message = "must start with + and contain only digits")
    private String phoneNumber;
    @Size(min = 4)
    @Size(max = 4)
    @Pattern(regexp = "\\d{4}$")
    private String clubCard;
    @Future
    private LocalDate cardValidUntil;
}
// END
