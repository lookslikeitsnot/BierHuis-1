package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Set;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 12:42.
 */
@Entity
@Table(name = "bestelbonnen")
public class Bestelbon implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SafeHtml
    @NotBlank
    @Length(min = 1, max = 50)
    private String naam;
    @Valid
    @Embedded
    private Adres adres;
    @OneToMany(mappedBy = "bestelbon")
    private Set<BestelbonLijn> lijnen;

    public Bestelbon() {
    }

    public Bestelbon(String naam, Adres adres, Set<BestelbonLijn> lijnen) {
        this.naam = naam;
        this.adres = adres;
        this.lijnen = lijnen;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BestelbonLijn> getLijnen() {
        return lijnen;
    }

    public void setLijnen(Set<BestelbonLijn> lijnen) {
        this.lijnen = lijnen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bestelbon)) return false;

        Bestelbon bestelbon = (Bestelbon) o;

        if (getId() != null ? !getId().equals(bestelbon.getId()) : bestelbon.getId() != null) return false;
        if (!getNaam().equals(bestelbon.getNaam())) return false;
        if (!getAdres().equals(bestelbon.getAdres())) return false;
        return getLijnen().equals(bestelbon.getLijnen());

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getNaam().hashCode();
        result = 31 * result + getAdres().hashCode();
        result = 31 * result + getLijnen().hashCode();
        return result;
    }
}
