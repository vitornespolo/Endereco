package com.example.endereco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String streetName;
    @Column(nullable = false)
    private Integer number;
    private String complement;
    @Column(nullable = false)
    private String neighbourhood;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String zipcode;
    private double latitude;
    private double longitude;

    Endereco() {

    }

    public Endereco(String streetName, Integer number, String complement, String neighbourhood, String city,
            String state,
            String country, String zipcode, double latitude, double longitude) {

        this.streetName = streetName;
        this.number = number;
        this.complement = complement;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return this.zipcode + "+" + this.city + "," + this.state;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.zipcode = parts[0];
        this.city = parts[1];
        this.state = parts[2];
    }
}
