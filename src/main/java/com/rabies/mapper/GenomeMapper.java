package com.rabies.mapper;

import com.rabies.pojo.Genome;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GenomeMapper {

    @Select("select * from rabies.genome")
    List<Genome> listGenomes();

    @Select("select * from rabies.genome where accession =#{accession}")
    List<Genome> findByAccession(String accession);

    @Select("select * from rabies.genome where collectionCountry like CONCAT('%', #{country}, '%')")
    List<Genome> findByCountry(String country);

    @Select("select * from rabies.genome where (refinedHost like CONCAT('%', #{refinedHost}, '%') or rawHost like CONCAT('%', #{refinedHost}, '%'))")
    List<Genome> findByHost(String refinedHost);

    @Select("select * from rabies.genome where accession = #{accession} and collectionCountry like CONCAT('%', #{country}, '%')")
    List<Genome> findByAccessionAndCountry(String accession, String country);

    @Select("select * from rabies.genome where accession = #{accession} and (refinedHost like CONCAT('%', #{refinedHost}, '%') or (rawHost like CONCAT('%', #{refinedHost}, '%')))")
    List<Genome> findByAccessionAndHost(String accession, String refinedHost);

    @Select("select * from rabies.genome where collectionCountry like CONCAT('%', #{country}, '%') and (refinedHost like CONCAT('%', #{refinedHost}, '%') or rawHost like CONCAT('%', #{refinedHost}, '%'))")
    List<Genome> findByCounrtyAndHost(String country, String refinedHost);

    @Select("select * from rabies.genome where accession = #{accession} and collectionCountry like CONCAT('%', #{country}, '%') and (refinedHost like CONCAT('%', #{refinedHost}, '%') or rawHost like CONCAT('%', #{refinedHost}, '%'))")
    List<Genome> findByAccessionAndCountryAndHost(String accession, String country, String refinedHost);
}
