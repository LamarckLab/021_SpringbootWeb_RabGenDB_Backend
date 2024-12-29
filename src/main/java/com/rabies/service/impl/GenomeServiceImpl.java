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
    public List<Genome> listByAccessionAndCountryAndHost(String accession, String country, String refinedHost) {
        if((accession != null && !accession.isEmpty()) && (country != null && !country.isEmpty()) && (refinedHost != null && !refinedHost.isEmpty())) {
            return genomeMapper.findByAccessionAndCountryAndHost(accession, country, refinedHost);
        }
        else if((accession != null && !accession.isEmpty()) && (country != null && !country.isEmpty())) {
            return genomeMapper.findByAccessionAndCountry(accession, country);
        }
        else if((accession !=null && !accession.isEmpty()) && (refinedHost != null && !refinedHost.isEmpty())) {
            return genomeMapper.findByAccessionAndHost(accession, refinedHost);
        }
        else if((country != null && !country.isEmpty()) && (refinedHost != null && !refinedHost.isEmpty())) {
            return genomeMapper.findByCounrtyAndHost(country, refinedHost);
        }
        else if((accession !=null && !accession.isEmpty())){
            return genomeMapper.findByAccession(accession);
        }
        else if((country != null && !country.isEmpty())){
            return genomeMapper.findByCountry(country);
        }
        else if((refinedHost != null && !refinedHost.isEmpty())){
            return genomeMapper.findByHost(refinedHost);
        }
        else{
            return genomeMapper.listGenomes();
        }
    }

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
    public List<Genome> listGenomeTemp() {
        return genomeMapper.listGenomeTemp();
    }
}
