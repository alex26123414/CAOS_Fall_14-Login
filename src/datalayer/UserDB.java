package datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDB {
    
    public static User getUserFromDB(String email, String pass){
        try {
            String sql = "SELECT * FROM users WHERE email = ? AND pass = MD5(?);";
            Connection con = ConnectionDB.getConnection();
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, email);
            p.setString(2, pass);
            
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPass(rs.getString("pass"));
                
                return u;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
