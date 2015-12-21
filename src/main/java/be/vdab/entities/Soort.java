package be.vdab.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 13:02.
 */
@Entity
@Table(name = "soorten")
public class Soort implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @SafeHtml
    @NotBlank
    @Length(min = 1, max = 50)
    private String naam;
    @OneToMany(mappedBy = "soort")
    private Set<Bier> bieren;

    public Soort() {
    }

    public Soort(Set<Bier> bieren, String naam) {
        this.bieren = bieren;
        this.naam = naam;
    }

    public Set<Bier> getBieren() {
        return bieren;
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

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soort)) return false;

        Soort soort = (Soort) o;

        if (getId() != soort.getId()) return false;
        return getNaam().equals(soort.getNaam());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getNaam().hashCode();
        return result;
    }
}
