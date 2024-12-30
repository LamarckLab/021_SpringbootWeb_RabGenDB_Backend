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

    // 这个方法用于实现：用户重新提交被打回的序列时, 修改genome表中某条序列的信息
    @Update("update rabies.genome set collectionCountry=#{collectionCountry}, collectionDate=#{collectionDate}, rawHost=#{rawHost}, refinedHost=#{refinedHost}, message = #{message}, isSubmit = 1 where accession = #{accession}")
    boolean reSubmit(Genome genome);

    // 这个方法用于实现：删除Genome表中的某条序列
    @Delete("delete from rabies.genome where accession=#{accession}")
    boolean delSequence(String accession);

    // 这个方法用于实现: 将某个用户的待审核的序列全部列出来
    @Select("select * from rabies.genome where username = #{username} and isSubmit = 1")
    List<Genome> waitingForCheck(String username);

    // 这个方法用于实现: 将某个用户被打回的序列全部列出来
    @Select("select * from rabies.genome where username = #{username} and isSubmit = 0")
    List<Genome> rejectedApplications(String username);

    // 这个方法用于实现: 将某个用户审核通过的序列全部列出来
    @Select("select * from rabies.genome where username = #{username} and isSubmit = 2")
    List<Genome> acceptedApplications(String username);

    // 这个接口用于实现: 使用accession进行精确分页查询(已通过审核的)
    @Select("select * from rabies.genome where accession = #{accession} and isSubmit = 2")
    List<Genome> genomePreciseSearch(String accession);

    // 根据Collection Country和Host进行模糊查询(已审核的序列)
    @Select("select * from rabies.genome where collectionCountry like CONCAT('%', #{country}, '%') and (refinedHost like CONCAT('%', #{refinedHost}, '%') or rawHost like CONCAT('%', #{refinedHost}, '%')) and isSubmit = 2")
    List<Genome> listByCountryAndHost(String country, String refinedHost);

    // 根据Collection Country进行模糊查询(已审核的序列)
    @Select("select * from rabies.genome where (collectionCountry like CONCAT('%', #{country}, '%')) and isSubmit = 2")
    List<Genome> listByCountry(String country);

    // 根据Raw Host或者Refined Host进行模糊查询(已审核的序列)
    @Select("select * from rabies.genome where (refinedHost like CONCAT('%', #{refinedHost}, '%') or rawHost like CONCAT('%', #{refinedHost}, '%')) and isSubmit = 2")
    List<Genome> listByHost(String refinedHost);

    // 该方法用于实现: 列出所有用户的待审核序列(供管理员查看)
    @Select("select * from rabies.genome where isSubmit = 1")
    List<Genome> listGenomePage();

}
