package com.example.Weather.data.impl;

import com.example.Weather.data.ForeDataService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ForeDataServiceImpl implements ForeDataService {
    private final JdbcTemplate jdbcTemplate;
   private static final String SQL_SELECT_ALL = "SELECT * FROM forecast";
   private static final String SQL_SAVE = "INSERT INTO forecast (city, temp, date) VALUES (?, ?, ?)";



    public ForeDataServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String city, String temp) {
      LocalDate id = LocalDate.now();
      jdbcTemplate.update(SQL_SAVE, city, temp, id);

    }

    @Override
    public List<String> selectAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, ((rs, rowNum) ->
                rs.getString("date") + " " +
                        rs.getString("city")
                        + " " + rs.getString("temp")));


    }
}
