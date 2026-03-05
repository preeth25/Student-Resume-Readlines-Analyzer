package com.resume.dao;

import java.util.List;
import com.resume.bean.Certification;

public interface CertificationDAO {

    // CREATE
    boolean addCertification(Certification cert);

    // READ
    List<Certification> getCertificationsByStudent(int studentId);

    // UPDATE
    boolean updateCertification(Certification cert);

    // DELETE
    boolean deleteCertification(int certId);
}