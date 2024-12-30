package com.rabies.service.impl;

import com.rabies.mapper.GenomeMapper;
import com.rabies.pojo.Genome;
import com.rabies.service.GenomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenomeServiceImpl implements GenomeService {

    @Autowired
    private GenomeMapper genomeMapper;


    @Override
    // 这个接口用于实现: 向genome表中增加一条序列
    public boolean sequenceSave(Genome genome) {
        return genomeMapper.sequenceSave(genome);
    }

    @Override
    // 这个接口用于实现：审核通过时修改genome表中某条序列的信息
    public boolean sequenceAccept(Genome genome) {
        return genomeMapper.sequenceAccept(genome);
    }

    @Override
    // 这个接口用于实现：审核打回时修改genome表中某条序列的信息
    public boolean sequenceReject(Genome genome) {
        return genomeMapper.sequenceReject(genome);
    }

    @Override
    // 这个接口用于实现：删除Genome表中的某条序列
    public boolean delSequence(String accession) {
        return genomeMapper.delSequence(accession);
    }

    @Override
    // 这个接口用于实现: 将某个用户的待审核的序列全部列出来
    public List<Genome> waitingForCheck(String username) {
        return genomeMapper.waitingForCheck(username);
    }

    @Override
    // 这个接口用于实现: 将某个用户被打回的序列全部列出来
    public List<Genome> rejectedApplications(String username) {
        return genomeMapper.rejectedApplications(username);
    }

    @Override
    // 这个接口用于实现: 将某个用户审核通过的序列全部列出来
    public List<Genome> acceptedApplications(String username) {
        return genomeMapper.acceptedApplications(username);
    }

    @Override
    // 这个接口用于实现: 使用accession进行精确分页查询(已通过审核的)
    public List<Genome> genomePreciseSearch(String accession) {
        return genomeMapper.genomePreciseSearch(accession);
    }

    @Override
    // 这个接口用于实现: 使用country和refinedHost进行模糊分页查询(已通过审核)
    public List<Genome> genomeFlexSearch(String country, String refinedHost) {
        // country和host都不为空
        if((country != null && !country.isEmpty()) && (refinedHost != null && !refinedHost.isEmpty())) {
            return genomeMapper.listByCountryAndHost(country, refinedHost);
        }
        // country不为空、host为空
        else if(country != null && !country.isEmpty()){
            return genomeMapper.listByCountry(country);
        }
        // country为空、host不为空
        else if(refinedHost != null && !refinedHost.isEmpty()){
            return genomeMapper.listByHost(refinedHost);
        }
        // country和host都为空
        else{
            return genomeMapper.listGenomes();
        }
    }

    @Override
    // 该接口用于实现: 列出所有用户的待审核序列(供管理员查看)
    public List<Genome> listGenomePage() {
        return genomeMapper.listGenomePage();
    }

    @Override
    public boolean reSubmit(Genome genome) {
        return genomeMapper.reSubmit(genome);
    }


}
