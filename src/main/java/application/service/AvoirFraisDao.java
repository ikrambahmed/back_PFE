package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import application.model.AvoirFrais;
import application.model.Mission;
import application.repository.AvoirFraisRepository;

@Service
@Primary
public class AvoirFraisDao implements IAvoirFrais {
	
	@Autowired
	AvoirFraisRepository avoirFraisRespository;

	@Override
	public List<AvoirFrais> getFrais() {
		return avoirFraisRespository.findAll() ; 
	}

	@Override
	public AvoirFrais addFrais(AvoirFrais frais) {
		return avoirFraisRespository.save(frais) ; 
	}

	@Override
	public void updateFrais(AvoirFrais frais) {
		avoirFraisRespository.save(frais) ; 		
	}

	@Override
	public void deleteFrais(AvoirFrais frais) {
	
		
	}

	@Override
	public List<AvoirFrais> AvoirFraisByMission(String num) {
		return avoirFraisRespository.getFraisByMission(num);
	}

	public List<AvoirFrais> getFraisMission(String codeDept, String numMission, String cin, Short numOrd) {
		// TODO Auto-generated method stub
		return avoirFraisRespository.getFraisMission(codeDept,numMission,cin,numOrd);
	}
	


	public Integer getSommeValue(String codeDept, String numMission, String cin, Short numOrd, String typeFrais) {
		// TODO Auto-generated method stub
		return avoirFraisRespository.getSommeValue(codeDept,numMission,cin,numOrd,typeFrais);
	}
	
	
}
