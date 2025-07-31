import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(”/weather”)
public class WeatherController {

```
@Autowired
private WeatherRepository weatherRepository;

// POST /weather - Create a new weather record
@PostMapping
public ResponseEntity<Weather> createWeather(@RequestBody Weather weather) {
// Remove id from request body as it should be auto-generated
weather.setId(null);
Weather savedWeather = weatherRepository.save(weather);
return ResponseEntity.status(HttpStatus.CREATED).body(savedWeather);
}

// GET /weather - Get all weather records with optional query parameters
@GetMapping
public ResponseEntity<List<Weather>> getAllWeather(
@RequestParam(required = false) String date,
@RequestParam(required = false) String city,
@RequestParam(required = false) String sort) {

List<Weather> weatherList;

// Determine sorting order (default is ascending by id)
boolean sortDescending = "date".equals(sort);

// Filter by date and/or city
if (date != null && city != null) {
if (sortDescending) {
weatherList = weatherRepository.findByDateAndCityIgnoreCaseOrderByDateDescIdAsc(date, city);
} else {
weatherList = weatherRepository.findByDateAndCityIgnoreCaseOrderByIdAsc(date, city);
}
} else if (date != null) {
if (sortDescending) {
weatherList = weatherRepository.findByDateOrderByDateDescIdAsc(date);
} else {
weatherList = weatherRepository.findByDateOrderByIdAsc(date);
}
} else if (city != null) {
if (sortDescending) {
weatherList = weatherRepository.findByCityIgnoreCaseOrderByDateDescIdAsc(city);
} else {
weatherList = weatherRepository.findByCityIgnoreCaseOrderByIdAsc(city);
}
} else {
if (sortDescending) {
weatherList = weatherRepository.findAllByOrderByDateDescIdAsc();
} else {
weatherList = weatherRepository.findAllByOrderByIdAsc();
}
}

return ResponseEntity.ok(weatherList);
}

// GET /weather/{id} - Get weather record by ID
@GetMapping("/{id}")
public ResponseEntity<Weather> getWeatherById(@PathVariable Integer id) {
Optional<Weather> weather = weatherRepository.findById(id);

if (weather.isPresent()) {
return ResponseEntity.ok(weather.get());
} else {
return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}
}
```

}
