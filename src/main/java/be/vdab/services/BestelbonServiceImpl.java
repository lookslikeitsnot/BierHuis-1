package be.vdab.services;

import be.vdab.dao.BestelbonDAO;
import be.vdab.entities.Bestelbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 21/12/2015 at 22:16.
 */
@Service
@ReadOnlyTransactionalService
public class BestelbonServiceImpl implements BestelbonService {
    private final BestelbonDAO bestelbonDAO;

    @Autowired
    public BestelbonServiceImpl(BestelbonDAO bestelbonDAO) {
        this.bestelbonDAO = bestelbonDAO;
    }

    @Override
    @ModifyingTransactionalServiceMethod
    public void save(Bestelbon bestelbon) {
        bestelbonDAO.save(bestelbon);
    }
}
