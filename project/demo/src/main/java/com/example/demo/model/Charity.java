package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Charity
{
    @Id
    private int id;
    private String charityname;
    private double chartityamount;
    private int age;
    private String address;
    public Charity()
    {

    }
    public Charity(int id, String charityname, double chartityamount, int age, String address) {
        this.id = id;
        this.charityname = charityname;
        this.chartityamount = chartityamount;
        this.age = age;
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCharityname() {
        return charityname;
    }
    public void setCharityname(String charityname) {
        this.charityname = charityname;
    }
    public double getChartityamount() {
        return chartityamount;
    }
    public void setChartityamount(double chartityamount) {
        this.chartityamount = chartityamount;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    
}