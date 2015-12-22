package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BestelbonLijn;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
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
    private long id;

    @SafeHtml
    @NotBlank
    @Length(min = 1, max = 50)
    private String naam;
    @Valid
    @Embedded
    private Adres adres;
    @ElementCollection
    @CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "bestelbonid"))
    private Set<BestelbonLijn> lijnen;

    public Bestelbon() {}

    public Bestelbon(String naam, Adres adres, Set<BestelbonLijn> lijnen) {
        this.naam = naam;
        this.adres = adres;
        this.lijnen = lijnen;
    }

    public Bestelbon(BestelbonLijn bestelbonLijn) {
        this.naam = null;
        this.adres = null;
        this.lijnen = new LinkedHashSet<>();
        addLijn(bestelbonLijn);
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
        return Collections.unmodifiableSet(lijnen);
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

    public Bestelbon addLijn(BestelbonLijn lijn) {
        this.lijnen.add(lijn);
        return this;
    }

    public BigDecimal getTotal() {
        return lijnen.stream().map(BestelbonLijn::getTotal).reduce(BigDecimal::add).get();
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bestelbon)) return false;

        Bestelbon bestelbon = (Bestelbon) o;

        if (!getId().equals(bestelbon.getId())) return false;
        if (!getNaam().equals(bestelbon.getNaam())) return false;
        return getAdres().equals(bestelbon.getAdres());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getNaam().hashCode();
        result = 31 * result + getAdres().hashCode();
        return result;
    }
}
