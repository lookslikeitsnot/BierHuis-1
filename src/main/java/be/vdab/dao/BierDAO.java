package be.vdab.dao;

import be.vdab.entities.Bier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 14:06.
 */
@Repository
public interface BierDAO extends JpaRepository<Bier, Long> {
}
