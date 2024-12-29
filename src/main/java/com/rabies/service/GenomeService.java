package com.rabies.service;

import com.rabies.pojo.Genome;

import java.util.List;

public interface GenomeService {

    boolean sequenceAccept(Genome genome);

    boolean delSequence(String accession);

    List<Genome> genomePreciseSearch(String accession);

    List<Genome> genomeFlexSearch(String country, String refinedHost);

    boolean sequenceSave(Genome genome);

    List<Genome> waitingForCheck(String username);

    List<Genome> rejectedApplications(String username);

    List<Genome> acceptedApplications(String username);

    List<Genome> listGenomePage();

    boolean sequenceReject(Genome genome);
}
