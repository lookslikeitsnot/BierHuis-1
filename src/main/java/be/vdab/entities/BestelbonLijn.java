package be.vdab.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 12:48.
 */
@Entity
@Table(name = "bestelbonlijnen")
public class BestelbonLijn implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @ManyToOne
    @JoinColumn(name = "bestelbonid")
    private Bestelbon bestelbon;
    @Valid
    @ManyToOne
    @JoinColumn(name = "bierid")
    private Bier bier;
    @Min(1)
    private Long aantal;

    public BestelbonLijn() {
    }

    public BestelbonLijn(Long aantal, Bestelbon bestelbon, Bier bier) {
        this.aantal = aantal;
        this.bestelbon = bestelbon;
        this.bier = bier;
    }

    public Long getAantal() {
        return aantal;
    }

    public void setAantal(Long aantal) {
        this.aantal = aantal;
    }

    public Bestelbon getBestelbon() {
        return bestelbon;
    }

    public void setBestelbon(Bestelbon bestelbon) {
        this.bestelbon = bestelbon;
    }

    public Bier getBier() {
        return bier;
    }

    public void setBier(Bier bier) {
        this.bier = bier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BestelbonLijn)) return false;

        BestelbonLijn that = (BestelbonLijn) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getBestelbon().equals(that.getBestelbon())) return false;
        return getBier().equals(that.getBier()) && getAantal().equals(that.getAantal());

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getBestelbon().hashCode();
        result = 31 * result + getBier().hashCode();
        result = 31 * result + getAantal().hashCode();
        return result;
    }
}
