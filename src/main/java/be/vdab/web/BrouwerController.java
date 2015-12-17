package be.vdab.web;

import be.vdab.services.BrouwerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 15:37.
 */
@Controller
@RequestMapping("/brouwers")
class BrouwerController {
    private static final String BROUWERS_VIEW = "brouwers/brouwers";

    private final BrouwerService brouwerService;

    @Autowired
    public BrouwerController(BrouwerService brouwerService) {
        this.brouwerService = brouwerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView findAll() {
        return new ModelAndView(BROUWERS_VIEW).addObject("brouwers", brouwerService.findAll());
    }
}
