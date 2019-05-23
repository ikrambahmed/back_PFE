package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import application.model.Missionnaire;
import application.model.OrdMis;
import application.repository.Ord_MissRepository;

	@Service
	@Primary
	public class Ord_MissDao {
		
		
		@Autowired
        Ord_MissRepository ordmissRepository	 ; 	
		
		public List<OrdMis> findAll(){
			return ordmissRepository.findAll();
		}
		
		
		public OrdMis ajouter(OrdMis o) {
			 return ordmissRepository.save(o);
		}
		
		public OrdMis updateOrd(OrdMis o) {
			return ordmissRepository.save(o);
		}


		public List<OrdMis> getMissionnaireByMission(String numMission) {
			// TODO Auto-generated method stub
			return ordmissRepository.getMissionnaireByNumMission(numMission);
		}

		public String getLatestOrdreNum(String codeDept,String numMission) {
			// TODO Auto-generated method stub
			return ordmissRepository.getLastestNum(codeDept,numMission);
		}


		public List<OrdMis> getOrdre(String codeDept) {
			// TODO Auto-generated method stub
			return ordmissRepository.getOrdres(codeDept);
		}
		public List<OrdMis> searchOrdMiss(String cin, String code) {
			// TODO Auto-generated method stub
			return ordmissRepository.searchOrdMiss(cin , code);
		}


		public List<OrdMis> getAllOdre(String numMission, String code) {
			// TODO Auto-generated method stub
			return ordmissRepository.getAllOrdre(numMission , code) ; 
		}

}
