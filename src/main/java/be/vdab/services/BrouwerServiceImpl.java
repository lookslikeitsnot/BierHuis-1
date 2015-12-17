package be.vdab.services;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 15:34.
 */
@Service
class BrouwerServiceImpl implements BrouwerService {
    private final BrouwerDAO brouwerDAO;

    @Autowired
    public BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
        this.brouwerDAO = brouwerDAO;
    }

    @Override
    public List<Brouwer> findAll() {
        return brouwerDAO.findAll(new Sort("naam"));
    }
}
