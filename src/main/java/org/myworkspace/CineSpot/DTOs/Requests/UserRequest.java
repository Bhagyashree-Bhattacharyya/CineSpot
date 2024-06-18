package org.myworkspace.CineSpot.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.myworkspace.CineSpot.Entities.User;
import org.myworkspace.CineSpot.Entities.enums.Role;

@Data
@Builder
public class UserRequest {

    private long refId;
    @NotBlank(message = "User name is Mandatory")
    private String name;
    @NotBlank(message = "password is Mandatory")
    private String password;

    private Role role; // ISSUE : user should not pass their role --- system will assign

    @NotBlank(message = "Mobile is Mandatory")
    private String mobile;
    @NotBlank(message = "Email is Mandatory")
    private String email;

    public User toUser(){
        return User.builder().name(name).email(email).password(password).refId(0).mobile(mobile).role(role).build();
    }
}
