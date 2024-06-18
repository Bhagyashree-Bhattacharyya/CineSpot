package org.myworkspace.CineSpot.DTOs.Responses;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.myworkspace.CineSpot.Entities.enums.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponse {

    private long refId;

    @NotBlank(message = "User name is Mandatory")
    private String name;

//    @NotBlank(message = "password is Mandatory")
//    private String password;

    private Role role;

    @NotBlank(message = "Mobile is Mandatory")
    private String mobile;

    @NotBlank(message = "Email is Mandatory")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TicketResponse> bookedTickets; // booking history
}
