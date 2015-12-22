package be.vdab.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 12:51.
 */
@Entity
@Table(name = "bieren")
public class Bier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Valid
    @ManyToOne
    @JoinColumn(name = "soortid")
    private Soort soort;
    @Valid
    @ManyToOne
    @JoinColumn(name = "brouwerid")
    private Brouwer brouwer;
    @SafeHtml
    @NotBlank
    @Length(min = 1, max = 100)
    private String naam;
    @NotNull
    @Min(0)
    @Digits(integer = 5, fraction = 2)
    @NumberFormat(style = Style.NUMBER, pattern = "##0.##")
    private BigDecimal alcohol;
    @NotNull
    @Min(0)
    @Digits(integer = 17, fraction = 2)
    @NumberFormat(pattern = "##,##0.##")
    private BigDecimal prijs;

    public Bier() {
    }

    public Bier(String naam, Brouwer brouwer, Soort soort, BigDecimal alcohol, BigDecimal prijs) {
        this.naam = naam;
        this.brouwer = brouwer;
        this.soort = soort;
        this.alcohol = alcohol;
        this.prijs = prijs;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(BigDecimal alcohol) {
        this.alcohol = alcohol;
    }

    public Brouwer getBrouwer() {
        return brouwer;
    }

    public void setBrouwer(Brouwer brouwer) {
        this.brouwer = brouwer;
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

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public Soort getSoort() {
        return soort;
    }

    public void setSoort(Soort soort) {
        this.soort = soort;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bier)) return false;

        Bier bier = (Bier) o;

        if (getId() != bier.getId()) return false;
        if (!getSoort().equals(bier.getSoort())) return false;
        if (!getBrouwer().equals(bier.getBrouwer())) return false;
        if (!getNaam().equals(bier.getNaam())) return false;
        if (!getAlcohol().equals(bier.getAlcohol())) return false;
        return getPrijs().equals(bier.getPrijs());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getSoort().hashCode();
        result = 31 * result + getBrouwer().hashCode();
        result = 31 * result + getNaam().hashCode();
        result = 31 * result + getAlcohol().hashCode();
        result = 31 * result + getPrijs().hashCode();
        return result;
    }
}
