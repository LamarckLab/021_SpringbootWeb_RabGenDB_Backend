package com.rabies.service;

import com.rabies.pojo.Genome;

import java.util.List;

public interface GenomeService {

    // 这个接口用于实现: 向genome表中增加一条序列
    boolean sequenceSave(Genome genome);

    // 这个接口用于实现：审核通过时修改genome表中某条序列的信息
    boolean sequenceAccept(Genome genome);

    // 这个接口用于实现：审核打回时修改genome表中某条序列的信息
    boolean sequenceReject(Genome genome);

    // 这个接口用于实现：删除Genome表中的某条序列
    boolean delSequence(String accession);

    // 这个接口用于实现: 将某个用户的待审核的序列全部列出来
    List<Genome> waitingForCheck(String username);

    // 这个接口用于实现: 将某个用户被打回的序列全部列出来
    List<Genome> rejectedApplications(String username);

    // 这个接口用于实现: 将某个用户审核通过的序列全部列出来
    List<Genome> acceptedApplications(String username);

    // 这个接口用于实现: 使用accession进行精确分页查询(已通过审核的)
    List<Genome> genomePreciseSearch(String accession);

    // 这个接口用于实现: 使用country和refinedHost进行模糊分页查询(已通过审核)
    List<Genome> genomeFlexSearch(String country, String refinedHost);

    // 该接口用于实现: 列出所有用户的待审核序列(供管理员查看)
    List<Genome> listGenomePage();


}
