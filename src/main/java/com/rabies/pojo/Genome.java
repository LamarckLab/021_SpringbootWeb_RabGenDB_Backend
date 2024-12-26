package com.rabies.pojo;

public class Genome {
    private Integer id;
    private String accession;
    private String collectionDate;
    private String collectionCountry;
    private String rawHost;
    private String refinedHost;

    public Genome() {
    }

    public Genome(Integer id, String accession, String collectionDate, String collectionCountry, String rawHost, String refinedHost) {
        this.id = id;
        this.accession = accession;
        this.collectionDate = collectionDate;
        this.collectionCountry = collectionCountry;
        this.rawHost = rawHost;
        this.refinedHost = refinedHost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getCollectionCountry() {
        return collectionCountry;
    }

    public void setCollectionCountry(String collectionCountry) {
        this.collectionCountry = collectionCountry;
    }

    public String getRawHost() {
        return rawHost;
    }

    public void setRawHost(String rawHost) {
        this.rawHost = rawHost;
    }

    public String getRefinedHost() {
        return refinedHost;
    }

    public void setRefinedHost(String refinedHost) {
        this.refinedHost = refinedHost;
    }

    @Override
    public String toString() {
        return "Genome{" +
                "id=" + id +
                ", accession='" + accession + '\'' +
                ", collectionDate='" + collectionDate + '\'' +
                ", collectionCountry='" + collectionCountry + '\'' +
                ", rawHost='" + rawHost + '\'' +
                ", refinedHost='" + refinedHost + '\'' +
                '}';
    }
}
