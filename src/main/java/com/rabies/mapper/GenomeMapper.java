package com.rabies.mapper;

import com.rabies.pojo.Genome;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GenomeMapper {

    // 把genome表中查验通过的条目全部列出来
    @Select("select * from rabies.genome where isSubmit = 2")
    List<Genome> listGenomes();

    @Update("update rabies.genome set collectionCountry=#{collectionCountry}, collectionDate=#{collectionDate}, rawHost=#{rawHost}, refinedHost=#{refinedHost} where accession=#{accession}")
    boolean modSequence(Genome genome);

    @Delete("delete from rabies.genome where accession=#{accession}")
    boolean delSequence(String accession);

    @Select("select * from rabies.genome where accession = #{accession} and isSubmit = 2")
    List<Genome> genomePreciseSearch(String accession);

    // 根据 Collection Country 和 Host 对正式序列进行模糊查询
    @Select("select * from rabies.genome where collectionCountry like CONCAT('%', #{country}, '%') and (refinedHost like CONCAT('%', #{refinedHost}, '%') or rawHost like CONCAT('%', #{refinedHost}, '%')) and isSubmit = 2")
    List<Genome> listByCountryAndHost(String country, String refinedHost);

    // 根据 Collection Country 对正式序列进行模糊查询
    @Select("select * from rabies.genome where (collectionCountry like CONCAT('%', #{country}, '%')) and isSubmit = 2")
    List<Genome> listByCountry(String country);

    // 根据 Raw Host 或者 Refined Host 对正式序列进行模糊查询
    @Select("select * from rabies.genome where (refinedHost like CONCAT('%', #{refinedHost}, '%') or rawHost like CONCAT('%', #{refinedHost}, '%')) and isSubmit = 2")
    List<Genome> listByHost(String refinedHost);

    // 添加待审核的序列到genome表中
    @Insert("insert into rabies.genome (accession, collectionCountry, collectionDate, rawHost, username, isSubmit) values (#{accession}, #{collectionCountry}, #{collectionDate}, #{rawHost}, #{username}, #{isSubmit})")
    boolean sequenceSave(Genome genome);
}
