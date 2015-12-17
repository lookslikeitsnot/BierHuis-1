package be.vdab.valueobjects;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 12:34.
 */
@SuppressWarnings("JpaAttributeMemberSignatureInspection")
@Embeddable
public class Adres {
    @SafeHtml
    @NotBlank
    @Length(min = 1, max = 50)
    private String straat;
    @SafeHtml
    @NotBlank
    @Length(min = 1, max = 50)
    private String huisNr;
    @NotNull
    @Range(min = 1000, max = 9999)
    private Integer postcode;
    @SafeHtml
    @NotBlank
    @Length(min = 1, max = 50)
    private String gemeente;

    public Adres() {
    }

    public Adres(String gemeente, String straat, String huisNr, Integer postcode) {
        this.gemeente = gemeente;
        this.straat = straat;
        this.huisNr = huisNr;
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public String getStraat() {
        return straat;
    }
}
