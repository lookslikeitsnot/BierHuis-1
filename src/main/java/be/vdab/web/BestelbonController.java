package be.vdab.web;

import be.vdab.entities.Bestelbon;
import be.vdab.valueobjects.BestelbonLijn;
import be.vdab.services.BestelbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.LinkedHashSet;

/**
 * Created on 21/12/2015 at 21:52.
 */
@Controller
@RequestMapping("/basket")
@SessionAttributes("basket")
public class BestelbonController {
    private static final String BASKET_VIEW = "basket/basket";
    private static final String ERROR_VIEW = "error";
    private static final String REDIRECT_TO_BASKET = "redirect:/basket";
    private static final String CONFIRMATION_VIEW = "basket/confirmation";


    private final Basket basket;
    private final BestelbonService bestelbonService;

    @Autowired
    public BestelbonController(Basket basket, BestelbonService bestelbonService) {
        this.basket = basket;
        this.bestelbonService = bestelbonService;
    }


    @RequestMapping(method = RequestMethod.GET)
    ModelAndView getBasket() {
        if (basket.getBestelbon() == null) {
            Bestelbon bestelbon = new Bestelbon();
            bestelbon.setLijnen(new LinkedHashSet<>());
            basket.setBestelbon(bestelbon);
        }
        return new ModelAndView(BASKET_VIEW).addObject(basket.getBestelbon());
    }

    @RequestMapping(method = RequestMethod.POST, params = {"bier", "aantal"})
    String addBestelbonLijn(@Valid BestelbonLijn bestelbonLijn, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ERROR_VIEW;
        }
        else {
            if (basket.getBestelbon() != null) {
                basket.getBestelbon().addLijn(bestelbonLijn);
            }
            else {
                basket.setBestelbon(new Bestelbon(bestelbonLijn));
            }
        }
        return REDIRECT_TO_BASKET;
    }

    @RequestMapping(method = RequestMethod.POST)
    ModelAndView saveBestelbon(@Valid Bestelbon bestelbon, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            bestelbon.setLijnen(basket.getBestelbon().getLijnen());
            bestelbonService.save(bestelbon);
            return new ModelAndView(CONFIRMATION_VIEW).addObject("id", bestelbon.getId());
        }
        else {
            return getBasket();
        }
    }

    @InitBinder("bestelbonLijn")
    void initBinderBestelbonLijn(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }

    @InitBinder("bestelbon")
    void initBinderBestelbon(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }
}
