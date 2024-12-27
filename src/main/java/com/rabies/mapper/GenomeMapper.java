package com.rabies.mapper;

import com.rabies.pojo.Genome;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Insert("insert into rabies.genome_temp (accession, collectionCountry, collectionDate, rawHost) values (#{accession}, #{collectionCountry}, #{collectionDate}, #{rawHost})")
    boolean addSequence(Genome genome);

    @Update("update rabies.genome set collectionCountry=#{collectionCountry}, collectionDate=#{collectionDate}, rawHost=#{rawHost}, refinedHost=#{refinedHost} where accession=#{accession}")
    boolean modSequence(Genome genome);
}
