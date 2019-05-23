package application.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import application.model.Missionnaire;
import application.model.Utilisateur;
import application.repository.MissionnaireRepository;
@Service
@Primary
public class MissionnaireService implements IMissionnaire {
    @Autowired
	private MissionnaireRepository missionnaireRepository ; 
	 
    
	@Override
	public List<Missionnaire> getMissionnaires() {
		// TODO Auto-generated method stub
		return missionnaireRepository.findAll() ; 	}

	@Override
	public Missionnaire addMissionaire(Missionnaire missionaire) {
	return 	missionnaireRepository.save(missionaire) ; 
		
	}

	@Override
	public void updateMissionaire(Missionnaire missionaire) {
		
		
		missionnaireRepository.save(missionaire) ; 
		
	}

	@Override
	public void deleteteMissionaire(String cin) {
		
		Missionnaire missionaire = new Missionnaire() ; 
		missionaire.setCin(cin);
		missionnaireRepository.delete(missionaire);
	}

	public Optional<Missionnaire> getMissionnaire(String cin, String code) {
		// TODO Auto-generated method stub
		return missionnaireRepository.getMiss(cin,code) ; 
	}

	@Override
	public List<Missionnaire> findMissionnaire(String code) {
		// TODO Auto-generated method stub
		return missionnaireRepository.findMissionnaireByDept(code);
	}

	@Override
	public List<Missionnaire> findOneMissionnaireDept(String codeDept) {
		// TODO Auto-generated method stub
		return missionnaireRepository.findMissionnaireDept(codeDept) ; 
	}
	
	public List<Map<String,Object>> report(){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>() ; 
		for(Missionnaire m:this.getMissionnaires()) { 
			Map<String,Object> item =
					new HashMap<String,Object>() ;
		item.put("nom", m.getNom()) ; 
		result.add(item) ; 
		
		
		}
			return result ; 
			
		}
		
		
	}
	
	
	

