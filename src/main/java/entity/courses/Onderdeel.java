package entity.courses;

import entity.Docent;
import jakarta.persistence.*;
//import org.hibernate.annotations.Cascade;

@Entity
public class Onderdeel {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String naam;

    @ManyToOne //bi-directional association met Module class
    @JoinColumn(name = "fk_module")
    private ModuleDuur module;

    @ManyToOne
    @JoinColumn(name = "fk_docent")
    private Docent docent;

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

    public ModuleDuur getModule() {
        return module;
    }

    public void setModule(ModuleDuur module) {
        this.module = module;
    }

    public Docent getDocent() { return docent;}

    public void setDocent(Docent docent) {
        this.docent = docent;
    }
}
