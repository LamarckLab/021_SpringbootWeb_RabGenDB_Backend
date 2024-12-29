package com.rabies.pojo;

// 序列实体类
public class Genome {
    private Integer id;
    private String accession;
    private String collectionDate;
    private String collectionCountry;
    private String rawHost;
    private String refinedHost;
    private Integer isSubmit;
    private String username;
    private String message;

    // 无参构造方法
    public Genome() {
    }

    // 全参构造方法
    public Genome(Integer id, String accession, String collectionDate, String collectionCountry, String rawHost, String refinedHost, Integer isSubmit, String username, String message) {
        this.id = id;
        this.accession = accession;
        this.collectionDate = collectionDate;
        this.collectionCountry = collectionCountry;
        this.rawHost = rawHost;
        this.refinedHost = refinedHost;
        this.isSubmit = isSubmit;
        this.username = username;
        this.message = message;
    }

    // 全部字段的get set方法
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

    public Integer getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(Integer isSubmit) {
        this.isSubmit = isSubmit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // toString方法
    @Override
    public String toString() {
        return "Genome{" +
                "id=" + id +
                ", accession='" + accession + '\'' +
                ", collectionDate='" + collectionDate + '\'' +
                ", collectionCountry='" + collectionCountry + '\'' +
                ", rawHost='" + rawHost + '\'' +
                ", refinedHost='" + refinedHost + '\'' +
                ", isSubmit=" + isSubmit +
                ", username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}