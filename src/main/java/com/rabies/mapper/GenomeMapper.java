package com.rabies.mapper;

import com.rabies.pojo.Genome;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GenomeMapper {

    // 这个方法用于实现: 向genome表中增加一条序列
    @Insert("insert into rabies.genome (accession, collectionCountry, collectionDate, rawHost, username, isSubmit) values (#{accession}, #{collectionCountry}, #{collectionDate}, #{rawHost}, #{username}, #{isSubmit})")
    boolean sequenceSave(Genome genome);

    // 这个方法用于实现: 把genome表中查验通过的条目全部列出来
    @Select("select * from rabies.genome where isSubmit = 2")
    List<Genome> listGenomes();

    // 这个方法用于实现：审核通过时修改genome表中某条序列的信息
    @Update("update rabies.genome set collectionCountry=#{collectionCountry}, collectionDate=#{collectionDate}, rawHost=#{rawHost}, refinedHost=#{refinedHost}, message = #{message}, isSubmit = 2 where accession = #{accession}")
    boolean sequenceAccept(Genome genome);

    // 这个方法用于实现：审核打回时修改genome表中某条序列的信息
    @Update("update rabies.genome set collectionCountry=#{collectionCountry}, collectionDate=#{collectionDate}, rawHost=#{rawHost}, refinedHost=#{refinedHost}, message = #{message}, isSubmit = 0 where accession = #{accession}")
    boolean sequenceReject(Genome genome);

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



    @Select("select * from rabies.genome where username = #{username} and isSubmit = 1")
    List<Genome> waitingForCheck(String username);

    @Select("select * from rabies.genome where username = #{username} and isSubmit = 0")
    List<Genome> rejectedApplications(String username);

    @Select("select * from rabies.genome where username = #{username} and isSubmit = 2")
    List<Genome> acceptedApplications(String username);

    @Select("select * from rabies.genome where isSubmit = 1")
    List<Genome> listGenomePage();


}
