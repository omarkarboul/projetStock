package tn.esprit.Service;

import java.util.List;

import tn.esprit.Entity.DetailProduit;

public interface DetailProduitService {

	List<DetailProduit> retrieveAllDetailProduit();

	DetailProduit addDetailProduit(DetailProduit c);

	void deleteDetailProduit(Long id);

	DetailProduit updateDetailProduit(DetailProduit c);

	DetailProduit retrieveDetailProduit(Long id);

}
