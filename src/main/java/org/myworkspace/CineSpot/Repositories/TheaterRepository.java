package org.myworkspace.CineSpot.Repositories;

import org.myworkspace.CineSpot.Entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

    @Query(value = "SELECT * FROM theater t WHERE t.name = :name AND t.city = :city", nativeQuery = true)
    Optional<Theater> findByNameAndCity(@Param("name") String name, @Param("city") String cityName);

    Optional<Theater> findByCity(String cityName);
}

