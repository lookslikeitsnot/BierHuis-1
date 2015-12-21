package be.vdab.dao;

import be.vdab.entities.Brouwer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 15:32.
 */
@Repository
public interface BrouwerDAO extends JpaRepository<Brouwer, Long> {
    Brouwer findOne(Long aLong);
}
