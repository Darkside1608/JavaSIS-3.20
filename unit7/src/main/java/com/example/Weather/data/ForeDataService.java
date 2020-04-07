package com.example.Weather.data;

import java.util.List;

public interface ForeDataService {
    void save(String city, String temp);
    List<String> selectAll();
}
