package be.vdab.services;

import be.vdab.dao.BierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 14:05.
 */
@Service
class BierServiceImpl implements BierService {
    private final BierDAO bierDAO;

    @Autowired
    public BierServiceImpl(BierDAO bierDAO) {
        this.bierDAO = bierDAO;
    }

    @Override
    public Long getBierCount() {
        return bierDAO.count();
    }
}
