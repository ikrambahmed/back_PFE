package application.repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.model.Mission;
import application.model.MissionPK;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Class<MissionPK>> {

	
	
	@Query("select MAX(m.numMission) from Mission m , DeptGen d where m.code=:codeDept and m.code=d.code")
	public String LatestMissionCode(@Param("codeDept")String codeDept);

	
	@Query("select o from Mission o ,DeptGen p where p.code =:codeDept and  o.deptGen.code= p.code order by o.numMission desc ")
	List<Mission> findMissionByDept(@Param("codeDept")String codeDept);

	@Query("select m from Mission m ,DeptGen d where d.code=:code and d.code=m.code and m.numMission=:numMission ")
	Optional<Mission> recherche(@Param("code")String code , @Param("numMission")String numMission);

	@Query("select m from Mission m where  m.numMission=:numMission")
	public Optional<Mission> getOnMission(@Param("numMission")String numMission);

	@Query("select m from Mission m , DeptGen d where  m.numMission=:x and m.deptGen.code=:codeDept and  m.code=d.code")
	public Mission getMissValidation(@Param("x")String numMission , @Param("codeDept")String codeDept);
	
	
	@Query("select count(numMission) from Mission m where m.annee =:annee")
	public Integer getCountMissions(@Param("annee")String annee );
	
} 