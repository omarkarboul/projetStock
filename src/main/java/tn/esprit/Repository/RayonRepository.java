package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Rayon;


@Repository
public interface RayonRepository extends CrudRepository<Rayon, Long> {

}
