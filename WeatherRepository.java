package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

```
// Find by date
List<Weather> findByDateOrderByIdAsc(String date);

// Find by city (case insensitive)
@Query("SELECT w FROM Weather w WHERE LOWER(w.city) = LOWER(:city) ORDER BY w.id ASC")
List<Weather> findByCityIgnoreCaseOrderByIdAsc(@Param("city") String city);

// Find by date and city (case insensitive)
@Query("SELECT w FROM Weather w WHERE w.date = :date AND LOWER(w.city) = LOWER(:city) ORDER BY w.id ASC")
List<Weather> findByDateAndCityIgnoreCaseOrderByIdAsc(@Param("date") String date, @Param("city") String city);

// Find all ordered by id
List<Weather> findAllByOrderByIdAsc();

// Find all ordered by date desc
@Query("SELECT w FROM Weather w ORDER BY w.date DESC, w.id ASC")
List<Weather> findAllByOrderByDateDescIdAsc();

// Find by date ordered by date desc
@Query("SELECT w FROM Weather w WHERE w.date = :date ORDER BY w.date DESC, w.id ASC")
List<Weather> findByDateOrderByDateDescIdAsc(@Param("date") String date);

// Find by city ordered by date desc (case insensitive)
@Query("SELECT w FROM Weather w WHERE LOWER(w.city) = LOWER(:city) ORDER BY w.date DESC, w.id ASC")
List<Weather> findByCityIgnoreCaseOrderByDateDescIdAsc(@Param("city") String city);

// Find by date and city ordered by date desc (case insensitive)
@Query("SELECT w FROM Weather w WHERE w.date = :date AND LOWER(w.city) = LOWER(:city) ORDER BY w.date DESC, w.id ASC")
List<Weather> findByDateAndCityIgnoreCaseOrderByDateDescIdAsc(@Param("date") String date, @Param("city") String city);
```

}
