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
    public boolean addSequence(Genome genome) {
        return genomeMapper.addSequence(genome);
    }

    @Override
    public boolean modSequence(Genome genome) {
        return genomeMapper.modSequence(genome);
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
}
