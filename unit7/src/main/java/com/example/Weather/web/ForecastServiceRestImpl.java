package com.example.Weather.web;









import com.example.Weather.dto.WeatherDto;
import com.example.Weather.web.ForecastService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;




@Service

public class ForecastServiceRestImpl implements ForecastService {
    private static String URL = "https://community-open-weather-map.p.rapidapi.com/weather?units=metric&mode=json&q=";

   private static String DEGREE = "\u2103";
    private HttpHeaders headers;
    private HttpEntity httpEntity;
    private final RestTemplate restTemplate;



   private void setHttpHeader(){
        headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com");
        headers.set("x-rapidapi-key", "cdd96ad95amsheebcca53e65aac1p136010jsn18e30e4e6350");
   }
   public ForecastServiceRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public String getForecast(String city) {
        setHttpHeader();
        httpEntity = new HttpEntity(headers);
        ResponseEntity<WeatherDto> responseEntity =
                restTemplate.exchange(  URL + city , HttpMethod.GET, httpEntity, WeatherDto.class);
        return responseEntity.getBody().getMain().getTemp() + DEGREE;
    }
}
// return city+" "+responseEntity.getBody().getMain().getTemp()+DEGREE;