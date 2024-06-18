package org.myworkspace.CineSpot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.myworkspace.CineSpot.Entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByMobile(String mobile);

    boolean existsByMobile(String mobile);

    Optional<User> findByRefId(long refId);

    @Query(value = "SELECT ref_id FROM user ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Long getLastInsertedRefId();
}
