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

    @Select("select * from rabies.genome where collectionCountry =#{country}")
    List<Genome> findByCountry(String country);

    @Select("select * from rabies.genome where refinedHost =#{refinedHost}")
    List<Genome> findByHost(String refinedHost);

    @Select("select * from rabies.genome where accession =#{accession} and collectionCountry =#{country}")
    List<Genome> findByAccessionAndCountry(String accession, String country);

    @Select("select * from rabies.genome where accession =#{accession} and refinedHost =#{refinedHost}")
    List<Genome> findByAccessionAndHost(String accession, String refinedHost);

    @Select("select * from rabies.genome where collectionCountry =#{country} and refinedHost =#{refinedHost}")
    List<Genome> findByCounrtyAndHost(String country, String refinedHost);

    @Select("select * from rabies.genome where accession =#{accession} and collectionCountry = #{country} and refinedHost =#{refinedHost}")
    List<Genome> findByAccessionAndCountryAndHost(String accession, String country, String refinedHost);
}
