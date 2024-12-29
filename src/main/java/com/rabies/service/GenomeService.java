package com.rabies.service;

import com.rabies.pojo.Genome;

import java.util.List;

public interface GenomeService {

    List<Genome> listByAccessionAndCountryAndHost(String accession, String country, String refinedHost);

    boolean addSequence(Genome genome);

    boolean modSequence(Genome genome);

    boolean delSequence(String accession);

    List<Genome> listGenomeTemp();

    List<Genome> genomePreciseSearch(String accession);

    List<Genome> genomeFlexSearch(String country, String refinedHost);
}
