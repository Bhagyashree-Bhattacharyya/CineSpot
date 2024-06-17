package org.myworkspace.CineSpot.Repositories;

import org.myworkspace.CineSpot.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {


    @Query(value = "select * from shows s, movies m , theaters t where m.id=s.movie_id and s.theater_id=t.id and m.title=? and city=?", nativeQuery = true)
    List<Show> findByCityNameAndMovieName(String cityName, String movieName);

    @Query(value= "select * from shows s, theaters t where s.theater_id=t.id and t.city=?",nativeQuery = true)
    List<Show> findByCity(String city);
}
