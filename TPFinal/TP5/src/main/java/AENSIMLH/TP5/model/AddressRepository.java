package AENSIMLH.TP5.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface AddressRepository extends
        CrudRepository< Address , Long > {


    @Query(value = "Select Count(*) from address", nativeQuery = true)
    long compterLesAdresses();


    @Modifying
    @Query(value="insert into address values(:id, :auteur, :content, :date)", nativeQuery = true)
    @Transactional
    void ajouter(@Param("id") Long id, @Param("auteur") String auteur, @Param("content") String content, @Param("date") Date date);



    @Query(value ="Select Auteur From Address Where content = :cont", nativeQuery = true)
    String trouverAuteur(@Param("cont") String cont);
}