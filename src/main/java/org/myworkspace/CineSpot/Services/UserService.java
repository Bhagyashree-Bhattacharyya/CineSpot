package org.myworkspace.CineSpot.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.myworkspace.CineSpot.Entities.User;
import jakarta.validation.Valid;
import org.myworkspace.CineSpot.DTOs.Requests.UserRequest;
import org.myworkspace.CineSpot.DTOs.Responses.UserResponse;
import org.myworkspace.CineSpot.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public UserResponse addUser(@Valid UserRequest userInfo) {
        if (userRepository.existsByMobile(userInfo.getMobile())) {
            return userRepository.findByMobile(userInfo.getMobile()).toUserResponse();
        } else {
            User userEntity = userInfo.toUser();
            userEntity.setRefId(userRepository.getLastInsertedRefId()+ 1);
            User user = userRepository.save(userEntity);
            log.info("Added New User{}", user);
            return user.toUserResponse();
        }
    }

    public UserResponse getUser(long refId) {
        Optional<User> userEntity = userRepository.findByRefId(refId);
        if (userEntity.isEmpty()) {
            log.error("User not found for id: " + refId);
//            throw new EntityNotFoundException("User Not Found with ID: " + refId);
        }
        return userEntity.get().toUserResponse();
    }
}
