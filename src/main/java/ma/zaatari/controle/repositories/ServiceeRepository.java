package ma.zaatari.controle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.zaatari.controle.entities.Servicee;

@Repository
public interface ServiceeRepository extends JpaRepository<Servicee, Long> {

}