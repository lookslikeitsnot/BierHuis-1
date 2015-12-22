package be.vdab.web;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created on 21/12/2015 at 21:52.
 */
@Controller
@RequestMapping(path = "/basket", produces = MediaType.TEXT_HTML_VALUE)
public class BestelbonController {
    private static final String BASKET_VIEW = "basket/basket";
    private static final String CONFIRMATION_VIEW = "basket/confirmation";
    private static final String REDIRECT_TO_CONFIRMATION = "redirect:/basket/confirmation/{id}";

    private final Basket basket;
    private final BestelbonService bestelbonService;

    @Autowired
    public BestelbonController(Basket basket, BestelbonService bestelbonService) {
        this.basket = basket;
        this.bestelbonService = bestelbonService;
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView getBasket() {
        return new ModelAndView(BASKET_VIEW).addObject(basket.getBestelbon());
    }

    @RequestMapping(method = RequestMethod.POST)
    ModelAndView saveBestelbon(@Valid Bestelbon bestelbon, BindingResult bindingResult, SessionStatus status) {
        if (bindingResult.hasErrors()) {
            bestelbon.setLijnen(basket.getBestelbon().getLijnen());
            return new ModelAndView(BASKET_VIEW);
        }
        bestelbon.setLijnen(basket.getBestelbon().getLijnen());
        bestelbonService.save(bestelbon);
        status.setComplete();
        return new ModelAndView(REDIRECT_TO_CONFIRMATION).addObject("id", bestelbon.getId());
    }

    @RequestMapping(path = "confirmation/{bestelbon}", method = RequestMethod.GET)
    ModelAndView getBestelbonConfirmation(@PathVariable Bestelbon bestelbon) {
        return new ModelAndView(CONFIRMATION_VIEW).addObject(bestelbon);
    }

    @InitBinder("bestelbon")
    void initBinderBestelbon(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }
}
