/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serkansahin.crud.Entities;

/**
 *
 * @author SOFT
 */
public class City {

    private int Id;

    public City(String name, String district, int population) {
        this.name = name;
        this.district = district;
        this.population = population;
    }
    private String name;
    private String district;
    private int population;

    public City(int id,String name, String district, int population) {
        this.name = name;
        this.district = district;
        this.population = population;
        this.Id=id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public City(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
