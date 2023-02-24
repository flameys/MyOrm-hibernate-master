package entity.courses;

import entity.courses.Richting;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Opleiding {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String naam;

// -----------Getters & Setters------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


}
