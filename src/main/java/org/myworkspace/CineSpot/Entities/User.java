package org.myworkspace.CineSpot.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myworkspace.CineSpot.Entities.enums.Role;
import org.myworkspace.CineSpot.DTOs.Responses.UserResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private long refId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name = "mobile", nullable = false, unique = true)
    private String mobile;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role" ,columnDefinition = "varchar(30) default 'USER'")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> bookedTickets;

    public UserResponse toUserResponse(){
        return UserResponse.builder().name(name).refId(refId).role(role).email(email).mobile(mobile).build();
    }

}
