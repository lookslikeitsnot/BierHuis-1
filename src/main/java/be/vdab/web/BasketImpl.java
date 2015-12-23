package be.vdab.web;

import be.vdab.entities.Bestelbon;

import java.io.Serializable;

/**
 * Created on 22/12/2015 at 00:10.
 */
class BasketImpl implements Basket, Serializable {
    private static final long serialVersionUID = 1L;
    private Bestelbon bestelbon;

    BasketImpl() {
    }

    BasketImpl(Bestelbon bestelbon) {
        this.bestelbon = bestelbon;
    }

    @Override
    public Bestelbon getBestelbon() {
        if (bestelbon == null) {
            this.bestelbon = new Bestelbon();
        }
        return this.bestelbon;
    }

    @Override
    public void setBestelbon(Bestelbon bon) {
        this.bestelbon = bon;
    }

    @Override
    public void clearBasket() {
        this.bestelbon = null;
    }
}
