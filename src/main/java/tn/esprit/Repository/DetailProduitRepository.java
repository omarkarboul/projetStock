package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.DetailProduit;

@Repository
public interface DetailProduitRepository extends CrudRepository<DetailProduit, Long>{

}
