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

    // 这个接口用于实现：审核通过时修改genome表中某条序列的信息
    @Override
    public boolean sequenceAccept(Genome genome) {
        return genomeMapper.sequenceAccept(genome);
    }

    @Override
    public boolean sequenceReject(Genome genome) {
        return genomeMapper.sequenceReject(genome);
    }

    @Override
    public boolean delSequence(String accession) {
        return genomeMapper.delSequence(accession);
    }

    @Override
    public List<Genome> genomePreciseSearch(String accession) {
        return genomeMapper.genomePreciseSearch(accession);
    }

    @Override
    public List<Genome> genomeFlexSearch(String country, String refinedHost) {
        if((country != null && !country.isEmpty()) && (refinedHost != null && !refinedHost.isEmpty())) {
            return genomeMapper.listByCountryAndHost(country, refinedHost);
        }
        else if(country != null && !country.isEmpty()){
            return genomeMapper.listByCountry(country);
        }
        else if(refinedHost != null && !refinedHost.isEmpty()){
            return genomeMapper.listByHost(refinedHost);
        }
        else{
            return genomeMapper.listGenomes();
        }
    }



    @Override
    public List<Genome> waitingForCheck(String username) {
        return genomeMapper.waitingForCheck(username);
    }

    @Override
    public List<Genome> rejectedApplications(String username) {
        return genomeMapper.rejectedApplications(username);
    }

    @Override
    public List<Genome> acceptedApplications(String username) {
        return genomeMapper.acceptedApplications(username);
    }

    @Override
    public List<Genome> listGenomePage() {
        return genomeMapper.listGenomePage();
    }


}
