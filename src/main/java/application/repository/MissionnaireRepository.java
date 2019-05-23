package application.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.model.Missionnaire;


@Repository
public interface MissionnaireRepository extends JpaRepository<Missionnaire , String>{

	@Query("select o from Missionnaire o where o.cin=:x and o.code.code=:code")
	public Optional<Missionnaire> getMiss(@Param("x")String cin, @Param("code")String code); 

	@Query("select o from Missionnaire o ,DeptGen p where p.code =:codeDept and  o.code= p.code ")
	public List<Missionnaire> findMissionnaireByDept(@Param("codeDept")String code);
   
	@Query("select o from Missionnaire o ,DeptGen p where p.code =:codeDept and  o.code= p.code ")
	public List<Missionnaire> findMissionnaireDept(@Param("codeDept")String code) ;
	
	@Transactional
	@Modifying
	@Query("delete from Missionnaire ord where ord.cin=:k  ")
	int delete(@Param("k") String cin);
	
	
}
