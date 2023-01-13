package edu.javacourse.studentorder.dao;

import config.Config;
import edu.javacourse.studentorder.domain.PassportOffice;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.domain.StudentOrderStatus;
import edu.javacourse.studentorder.exception.DaoException;

import java.sql.*;
import java.time.LocalDateTime;

public class StudentDaoImpl implements StudentOrderDao {

    public static final String INSERT_ORDER =
            "INSERT INTO jc_student_order(" +
                    "            student_order_status, student_order_date, h_sur_name," +
                    "            h_given_name, h_patronymic, h_date_of_birth, h_passport_seria, h_passport_number," +
                    "            h_passport_date, h_passport_office_id, h_post_index, h_street_code, h_building," +
                    "            h_extension, h_apartment, w_sur_name, w_given_name, w_patronymic, w_date_of_birth," +
                    "            w_passport_seria, w_passport_number, w_passport_date, w_passport_office_id, w_post_index," +
                    "            w_street_code, w_building, w_extension, w_apartment, certificate_id, register_office_id," +
                    "            marriage_date)" +
                    "    VALUES (?, ?, ?, ?," +
                    "            ?, ?, ?, ?," +
                    "            ?, ?, ?, ?," +
                    "            ?, ?, ?, ?," +
                    "            ?, ?, ?, ?," +
                    "            ?, ?, ?, ?," +
                    "            ?, ?, ?, ?," +
                    "            ?, ?, ?);";

    //TODO refactoring - make one method
    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return con;
    }


    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {

        Long result = -1L;

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_ORDER, new String[]{"student_order_id"})) {
//header
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));

//h
            stmt.setString(3, so.getHusband().getSurName());
            stmt.setString(4, so.getHusband().getGivenName());
            stmt.setString(5, so.getHusband().getPatronymic());
            stmt.setDate(6, java.sql.Date.valueOf(so.getHusband().getDateOfBirth()));
            stmt.setString(7, so.getHusband().getPassportSeria());
            stmt.setString(8, so.getHusband().getPassportNumber());
            stmt.setDate(9, java.sql.Date.valueOf(so.getHusband().getIssueDate()));
            stmt.setLong(10, so.getHusband().getIssueDepartment().getOfficeId());
            stmt.setString(11, so.getHusband().getAddress().getPostCode());
            stmt.setLong(12, so.getHusband().getAddress().getStreet().getStreetCode());
            stmt.setString(13, so.getHusband().getAddress().getBuilding());
            stmt.setString(14, so.getHusband().getAddress().getExtension());
            stmt.setString(15, so.getHusband().getAddress().getApartment());
//w

            stmt.setString(16, so.getWife().getSurName());
            stmt.setString(17, so.getWife().getGivenName());
            stmt.setString(18, so.getWife().getPatronymic());
            stmt.setDate(19, java.sql.Date.valueOf(so.getWife().getDateOfBirth()));
            stmt.setString(20, so.getWife().getPassportSeria());
            stmt.setString(21, so.getWife().getPassportNumber());
            stmt.setDate(22, java.sql.Date.valueOf(so.getWife().getIssueDate()));
            stmt.setLong(23, so.getWife().getIssueDepartment().getOfficeId());
            stmt.setString(24, so.getWife().getAddress().getPostCode());
            stmt.setLong(25, so.getWife().getAddress().getStreet().getStreetCode());
            stmt.setString(26, so.getWife().getAddress().getBuilding());
            stmt.setString(27, so.getWife().getAddress().getExtension());
            stmt.setString(28, so.getWife().getAddress().getApartment());
//certificate

            stmt.setString(29, so.getMarriageCertificateId());
            stmt.setLong(30, so.getMarriageOffice().getOfficeId());
            stmt.setDate(31, java.sql.Date.valueOf(so.getMarriageDate()));

            stmt.executeUpdate();

           ResultSet gkRs =  stmt.getGeneratedKeys();
           if(gkRs.next()){
               result = gkRs.getLong(1);
           }gkRs.close();

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return  result;
    }
}
