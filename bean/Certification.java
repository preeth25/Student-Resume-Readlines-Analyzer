package com.resume.bean;

public class Certification {

    private int certId;
    private int studentId;
    private String certName;
    private String organization;

    public Certification() {}

    public Certification(int certId, int studentId, String certName, String organization) {
        this.certId = certId;
        this.studentId = studentId;
        this.certName = certName;
        this.organization = organization;
    }

    public int getCertId() {
        return certId;
    }

    public void setCertId(int certId) {
        this.certId = certId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Certification [certId=" + certId + 
               ", certName=" + certName + 
               ", organization=" + organization + "]";
    }
}