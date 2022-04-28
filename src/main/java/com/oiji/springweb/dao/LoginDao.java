package com.oiji.springweb.dao;

import com.oiji.springweb.dto.member.Member;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

@Repository
public class LoginDao {

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public LoginDao() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String dbID = "web";
            String dbPassword = "oracle";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, dbID, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int isExistName(String userName) {
        String SQL = "SELECT * FROM MEMBER WHERE USERNAME = ?";
        try {
            st = con.prepareStatement(SQL);
            st.setString(1, userName);
            rs = st.executeQuery();
            if (!rs.next()) {
                return 1;
            }
            else {
                return 0;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    public int isExistId(String userID) {
        String SQL = "SELECT * FROM MEMBER WHERE USERID = ?";
        try {
            st = con.prepareStatement(SQL);
            st.setString(1, userID);
            rs = st.executeQuery();
            if (!rs.next()) {
                return 1;
            }
            else {
                return 0;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    public Optional<Member> findByLoginId(String loginId) {
        String SQL = "SELECT * FROM MEMBER WHERE USERID = ?";
        Member member = null;
        try {
            st = con.prepareStatement(SQL);
            st.setString(1, loginId); // sql injection을 방어하기 위해 pstmt를 사용함
            rs = st.executeQuery();
            if (rs.next()) {
                String userPassword = rs.getString("USERPASSWORD");
                String userName = rs.getString("USERNAME");
                String userEmail = rs.getString("USEREMAIL");
                member = new Member(loginId, userPassword, userName, userEmail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(member);
    }

    public int join(Member user) {
        String SQL = "INSERT INTO MEMBER VALUES(?,?,?,?)";
        try {
            st = con.prepareStatement(SQL);
            st.setString(1, user.getLoginId());
            st.setString(2, user.getPassword());
            st.setString(3, user.getEmail());
            st.setString(4, user.getName());
            int result = st.executeUpdate();

            if(result == 1)
                return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
