package be.vdab.web;

import be.vdab.valueobjects.BestelbonLijn;
import be.vdab.entities.Bier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 17:24.
 */
@Controller
@RequestMapping("/bieren")
class BierController {
    private static final String BIER_VIEW = "bieren/bier";

    @RequestMapping(value = "{bier}", method = RequestMethod.GET)
    ModelAndView getBier(@PathVariable Bier bier) {
        return new ModelAndView(BIER_VIEW).addObject(new BestelbonLijn(bier));
    }
}
