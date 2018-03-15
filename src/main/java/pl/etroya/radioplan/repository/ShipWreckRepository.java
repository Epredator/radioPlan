package pl.etroya.radioplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.etroya.radioplan.model.Shipwreck;

public interface ShipWreckRepository extends JpaRepository<Shipwreck, Long> {
}
