package com.oiji.springweb.dao;

import com.oiji.springweb.dto.image.Image;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ImageDao {

    public void updateHit(int id) {
        String sql = "UPDATE IMAGE SET HIT=HIT+1 WHERE ID=?";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "web", "oracle");
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            st.executeQuery();

            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Image getImageById(int id) {
        Image img = null;
        String sql = "SELECT TITLE, IMG_LOC, HIT FROM IMAGE WHERE ID = ?";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "web", "oracle");
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String title_ = rs.getString("TITLE");
                String[] title = title_.split(" ");
                String imgPath = rs.getString("IMG_LOC");
                int hit = rs.getInt("HIT");

                img = new Image(id, title, imgPath, hit);
            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return img;
    }

    public List<Image> getImageList(String query, int page){
        List<Image> list = new ArrayList<Image>();

        String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.* FROM "
                + "(SELECT * FROM IMAGE WHERE TITLE LIKE ? ORDER BY HIT DESC)N)"
                + "WHERE NUM BETWEEN ? AND ?";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "web", "oracle");
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, "%" + query + "%");
            st.setInt(2, 1 + (page - 1) * 32);
            st.setInt(3, page * 32);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String title_ = rs.getString("TITLE");
                String[] title = title_.split(" ");
                String imgPath = rs.getString("IMG_LOC");
                int hit = rs.getInt("HIT");

                Image img = new Image(id, title, imgPath, hit);
                list.add(img);
            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}
