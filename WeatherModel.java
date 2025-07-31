import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = “weather”)
public class Weather {

```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name = "date")
private String date;

@Column(name = "lat")
private Double lat;

@Column(name = "lon")
private Double lon;

@Column(name = "city")
private String city;

@Column(name = "state")
private String state;

@ElementCollection
@CollectionTable(name = "weather_temperatures",
joinColumns = @JoinColumn(name = "weather_id"))
@Column(name = "temperature")
private List<Double> temperatures;

// Default constructor
public Weather() {}

// Constructor
public Weather(String date, Double lat, Double lon, String city, String state, List<Double> temperatures) {
this.date = date;
this.lat = lat;
this.lon = lon;
this.city = city;
this.state = state;
this.temperatures = temperatures;
}

// Getters and Setters
public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public Double getLat() {
return lat;
}

public void setLat(Double lat) {
this.lat = lat;
}

public Double getLon() {
return lon;
}

public void setLon(Double lon) {
this.lon = lon;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public List<Double> getTemperatures() {
return temperatures;
}

public void setTemperatures(List<Double> temperatures) {
this.temperatures = temperatures;
}
```

}
