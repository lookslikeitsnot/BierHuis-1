package be.vdab.services;

import be.vdab.entities.Brouwer;

import java.util.List;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 15:33.
 */
public interface BrouwerService {
    List<Brouwer> findAll();
}
