package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 13:02.
 */
@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @SafeHtml
    @NotBlank
    @Length(min = 1, max = 50)
    private String naam;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(0)
    @Digits(integer = 10, fraction = 0)
    private Long omzet;
    @Valid
    @Embedded
    private Adres adres;
    @OneToMany(mappedBy = "brouwer", fetch = FetchType.LAZY)
    private Set<Bier> bieren;


    public Brouwer() {
    }

    public Brouwer(Adres adres, Set<Bier> bieren, String naam, Long omzet) {
        this.adres = adres;
        this.bieren = bieren;
        this.naam = naam;
        this.omzet = omzet;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Set<Bier> getBieren() {
        return Collections.unmodifiableSet(bieren);
    }

    public void setBieren(Set<Bier> bieren) {
        this.bieren = bieren;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Long getOmzet() {
        return omzet;
    }

    public void setOmzet(Long omzet) {
        this.omzet = omzet;
    }

    @SuppressWarnings("SimplifiableIfStatement")

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brouwer brouwer = (Brouwer) o;

        if (getId() != brouwer.getId()) return false;
        return getNaam().equals(brouwer.getNaam());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getNaam().hashCode();
        return result;
    }
}
