package be.vdab.web;

import be.vdab.services.BierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 13:47.
 */
@Controller
@RequestMapping(path = "/")
class IndexController {
    private static final String VIEW = "index";
    private final BierService bierService;

    @Autowired
    public IndexController(BierService bierService) {
        this.bierService = bierService;
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView getIndex() {
        return new ModelAndView(VIEW).addObject("count", bierService.getBierCount());
    }
}
