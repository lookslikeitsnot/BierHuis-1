package be.vdab.web;

import be.vdab.entities.Brouwer;
import be.vdab.exceptions.ResourceNotFoundException;
import be.vdab.services.BrouwerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 15:37.
 */
@Controller
@RequestMapping(path = "/brouwers", produces = MediaType.TEXT_HTML_VALUE)
class BrouwerController {
    private static final String BROUWERS_VIEW = "brouwers/brouwers";
    private static final String BROUWER_VIEW = "brouwers/brouwer";

    private final BrouwerService brouwerService;

    @Autowired
    BrouwerController(BrouwerService brouwerService) {
        this.brouwerService = brouwerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView findAll() {
        return new ModelAndView(BROUWERS_VIEW).addObject("brouwers", brouwerService.findAll());
    }

    @RequestMapping(path = "{brouwer}", method = RequestMethod.GET)
    ModelAndView read(@PathVariable Brouwer brouwer) {
        if (brouwer == null) {
            throw new ResourceNotFoundException();
        }
        return new ModelAndView(BROUWER_VIEW).addObject(brouwer);
    }
}
