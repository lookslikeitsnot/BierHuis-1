package be.vdab.web;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created on 21/12/2015 at 21:52.
 */
@Controller
@RequestMapping(path = "/basket", produces = MediaType.TEXT_HTML_VALUE)
@SessionAttributes("basket")
public class BestelbonController {
    private static final String BASKET_VIEW = "basket/basket";
    private static final String CONFIRMATION_VIEW = "basket/confirmation";
    private static final String REDIRECT_TO_CONFIRMATION = "redirect:/basket/confirmation";


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
    ModelAndView saveBestelbon(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bestelbon.setLijnen(basket.getBestelbon().getLijnen());
            return new ModelAndView(BASKET_VIEW);
        }
        bestelbon.setLijnen(basket.getBestelbon().getLijnen());
        bestelbonService.save(bestelbon);
        return new ModelAndView(REDIRECT_TO_CONFIRMATION).addObject(bestelbon);
    }

    @InitBinder("bestelbon")
    void initBinderBestelbon(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }
}
