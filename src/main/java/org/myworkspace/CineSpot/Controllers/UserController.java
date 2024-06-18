package org.myworkspace.CineSpot.Controllers;

import org.myworkspace.CineSpot.DTOs.Requests.UserRequest;
import jakarta.validation.Valid;
import org.myworkspace.CineSpot.DTOs.Responses.UserResponse;
import org.myworkspace.CineSpot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> addUser(@RequestBody @Valid UserRequest userInfo) {
        return ResponseEntity.ok(userService.addUser(userInfo));
    }

//    @PostMapping("/login") // How to do these !! password matching & all :(
//    public ResponseEntity<UserResponse> addUser(@RequestParam @Valid String userName,
//                                                @RequestParam @Valid String password) {

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(name = "id") @Min(value = 1, message = "User Id Cannot be -ve") long id) {
        UserResponse user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
