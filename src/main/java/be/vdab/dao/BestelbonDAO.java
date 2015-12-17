package be.vdab.dao;

import be.vdab.entities.Bestelbon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 13:44.
 */
@Repository
public interface BestelbonDAO extends JpaRepository<Bestelbon, Long> {
}
