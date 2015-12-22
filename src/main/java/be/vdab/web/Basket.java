package be.vdab.web;

import be.vdab.entities.Bestelbon;

/**
 * Created on 22/12/2015 at 00:09.
 */
public interface Basket {
    Bestelbon getBestelbon();

    void setBestelbon(Bestelbon bon);
}
