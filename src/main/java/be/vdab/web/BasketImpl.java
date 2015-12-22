package be.vdab.web;

import be.vdab.entities.Bestelbon;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

/**
 * Created on 22/12/2015 at 00:10.
 */
@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public class BasketImpl implements Basket, Serializable {
    private static final long serialVersionUID = 1L;
    private Bestelbon bestelbon;

    public BasketImpl() {}

    public BasketImpl(Bestelbon bestelbon) {
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
}
