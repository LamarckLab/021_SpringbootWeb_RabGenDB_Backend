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

    List<Genome> genomePreciseSearch(String accession);

    List<Genome> genomeFlexSearch(String country, String refinedHost);







    List<Genome> listGenomePage();


}
