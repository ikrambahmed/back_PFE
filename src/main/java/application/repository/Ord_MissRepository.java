package application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.model.Missionnaire;
import application.model.OrdMis;
import application.model.OrdMisPK;

@Repository
public interface Ord_MissRepository extends JpaRepository<OrdMis, Class<OrdMisPK>>{
	
	@Transactional
	@Modifying
	@Query("delete from OrdMis ord where  ord.code=:i and ord.cin=:j and ord.numord=:k and ord.numMission=:l ")
	int delete(@Param("i") String code,@Param("j") String cin,@Param("k") short numord,@Param("l") String numMission);

	
	//@Query("select o from Missionnaire o ,DeptGen p where p.code =:codeDept and  o.code= p.code ")
    @Query("select ord from OrdMis ord , Mission m where ord.numMission=:num and ord.numMission=m.numMission")
	 List<OrdMis> getMissionnaireByNumMission(@Param ("num")String num);

	@Query("select MAX(m.numord) from OrdMis m , DeptGen d , Mission o where m.code=:codeDept and m.code=d.code and m.numMission=:numMission and o.numMission=m.numMission")
	String getLastestNum(@Param("codeDept")String codeDept,@Param("numMission")String numMission);

    @Query("select o from OrdMis o where o.code=:codeDept")
	List<OrdMis> getOrdres(@Param("codeDept")String codeDept);
    @Query("select o from OrdMis o, Missionnaire m, Mission mi, DeptGen d  where m.code.code=:code and m.cin=:cin and o.missionnaire.cin= m.cin and m.code.code=o.code")
    List<OrdMis> searchOrdMiss(@Param("cin")String cin, @Param("code")String code);

    @Query("select o from OrdMis o  where o.code=:code and o.numMission=:numMission ")
	List<OrdMis> getAllOrdre(@Param("numMission")String numMission, @Param("code")String code);
    @Transactional
    @Modifying
    @Query("delete from OrdMis o where o.numord=:numord and o.numMission=:numMission and o.code=:code")
	int deleteord(@Param("numord")short numord, @Param("numMission")String numMission,@Param("code") String code);
    //and o.numMission=(select MAX(o.numMission) where o.cin=:cin and o.code=:o.code )
    @Query("select o from OrdMis o where o.cin=:cin and  o.code=:code and o.numord=(select MAX(o.numord) from OrdMis o where o.cin=:cin and  o.code=:code ) ")
    OrdMis getOneOrdre(@Param("cin")String cin , @Param("code")String code) ; 
    
}