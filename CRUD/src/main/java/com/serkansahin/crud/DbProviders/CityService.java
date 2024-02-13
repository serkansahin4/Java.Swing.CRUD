package com.serkansahin.crud.DbProviders;

import com.serkansahin.crud.Entities.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CityService {

    private MySqlDatabase database;

    public CityService(MySqlDatabase database) {
        this.database = database;
    }

    public String AddCity(City city) {
        StringBuilder resultTextBuilder = new StringBuilder();
        try {
            Connection connection = database.getConnection();
            String query = "insert into city(Name,District,Population) values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, city.getName());
            statement.setString(2, city.getDistrict());
            statement.setInt(3, city.getPopulation());
            int result = statement.executeUpdate();
            if (result == 1) {
                resultTextBuilder.append("İşlem Başarılı");
            }
        } catch (SQLException ex) {
            resultTextBuilder.append("İşlem Başarısız.");
        }

        return resultTextBuilder.toString();
    }

    public ArrayList<City> GetCities() {
        ArrayList<City> cities = null;
        try {
            Connection connection = database.getConnection();
            String query = "select * from city";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            cities = new ArrayList();
            while (result.next()) {
                City city = new City(result.getInt("ID"), result.getString("Name"), result.getString("District"), result.getInt("Population"));
                cities.add(city);
            }
        } catch (SQLException ex) {

        }

        return cities;
    }

    public String Remove(int id) {
        StringBuilder resultMessageBuilder = new StringBuilder();
        try {
            Connection connection = database.getConnection();
            String query = "delete from city where ID=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
            
            resultMessageBuilder.append(id + " Şehir Silindi");
        } catch (SQLException ex) {
            resultMessageBuilder.append(id + " Silme İşlemi Başarısız");
        }
        return resultMessageBuilder.toString();
    }

    public String Update(City city) {
        StringBuilder resultMessageBuilder = new StringBuilder();
        try {
            Connection connection = database.getConnection();
            String query = "update city set Name=?,District=?,Population=? where ID=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, city.getName());
            statement.setString(2, city.getDistrict());
            statement.setInt(3, city.getPopulation());
            statement.setInt(4, city.getId());
            int result = statement.executeUpdate();
            resultMessageBuilder.append(Integer.toString(city.getId()) + " Şehir Güncellendi");
        } catch (SQLException ex) {
            resultMessageBuilder.append(Integer.toString(city.getId()) + " Güncelleme Başarısız");
        }
        return resultMessageBuilder.toString();
    }
}
