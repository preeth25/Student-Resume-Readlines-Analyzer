package com.resume.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.resume.bean.Certification;
import com.resume.dao.CertificationDAO;
import com.resume.util.ConnectionFactory;

public class CertificationDAOImpl implements CertificationDAO {

    @Override
    public boolean addCertification(Certification cert) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO certifications(student_id, cert_name, organization) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cert.getStudentId());
            ps.setString(2, cert.getCertName());
            ps.setString(3, cert.getOrganization());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Certification> getCertificationsByStudent(int studentId) {

        List<Certification> list = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM certifications WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Certification c = new Certification();
                c.setCertId(rs.getInt("cert_id"));
                c.setStudentId(rs.getInt("student_id"));
                c.setCertName(rs.getString("cert_name"));
                c.setOrganization(rs.getString("organization"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateCertification(Certification cert) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "UPDATE certifications SET cert_name=?, organization=? WHERE cert_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cert.getCertName());
            ps.setString(2, cert.getOrganization());
            ps.setInt(3, cert.getCertId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteCertification(int certId) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM certifications WHERE cert_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, certId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}