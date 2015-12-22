package be.vdab.valueobjects;

import be.vdab.entities.Bier;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 12:48.
 */
@Embeddable
@Table(name = "bestelbonlijnen")
public class BestelbonLijn implements Serializable {
    private static final long serialVersionUID = 1L;

    @Valid
    @ManyToOne
    @JoinColumn(name = "bierid")
    private Bier bier;
    @Min(2)
    private Long aantal;

    public BestelbonLijn() {
    }

    public BestelbonLijn(Bier bier) {
        this.bier = bier;
        this.aantal = null;
    }

    public BestelbonLijn(Bier bier, Long aantal) {
        this.bier = bier;
        this.aantal = aantal;
    }

    public Long getAantal() {
        return aantal;
    }

    public void setAantal(Long aantal) {
        this.aantal = aantal;
    }

    public Bier getBier() {
        return bier;
    }

    public void setBier(Bier bier) {
        this.bier = bier;
    }

    public BigDecimal getTotal() {
        if (this.aantal != null && this.bier.getPrijs() != null) {
            return this.bier.getPrijs().multiply(BigDecimal.valueOf(this.aantal));
        }
        else {
            throw new ArithmeticException();
        }
    }

    @SuppressWarnings("SimplifiableIfStatement")

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BestelbonLijn that = (BestelbonLijn) o;

        return getBier().equals(that.getBier());

    }

    @Override
    public int hashCode() {
        return getBier().hashCode();
    }
}
