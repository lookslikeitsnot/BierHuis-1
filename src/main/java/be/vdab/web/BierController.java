package be.vdab.web;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Bier;
import be.vdab.valueobjects.BestelbonLijn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 17:24.
 */
@Controller
@RequestMapping(path = "/bieren", produces = MediaType.TEXT_HTML_VALUE)
@SessionAttributes("basket")
class BierController {
    private static final String BIER_VIEW = "bieren/bier";
    private static final String ERROR_VIEW = "error";
    private static final String REDIRECT_TO_BASKET = "redirect:/basket";

    private final Basket basket;

    @Autowired
    public BierController(Basket basket) {
        this.basket = basket;
    }

    @RequestMapping(path = "{bier}", method = RequestMethod.GET)
    ModelAndView getBier(@PathVariable Bier bier) {
        return new ModelAndView(BIER_VIEW).addObject(new BestelbonLijn(bier));
    }

    @RequestMapping(path = "{bier}", method = RequestMethod.POST)
    String addBestelbonLijn(@Valid BestelbonLijn bestelbonLijn, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return BIER_VIEW;
        } else {
            if (basket.getBestelbon() != null) {
                basket.getBestelbon().addLijn(bestelbonLijn);
            } else {
                basket.setBestelbon(new Bestelbon(bestelbonLijn));
            }
        }
        return REDIRECT_TO_BASKET;
    }
}
