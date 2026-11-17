package controller;

public class LoginController {
    public boolean cekLogin(model.AkunPengguna akun) {

        String sql = "SELECT * FROM user WHERE id_user = ? AND password = ?";
        
        try {
            java.sql.Connection conn = Connector.konekkan.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            

            pst.setString(1, akun.getUsername()); 
            pst.setString(2, akun.getPassword());
            
            java.sql.ResultSet rs = pst.executeQuery();
            

            if (rs.next()) {
                return true; 
            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("Gagal mengecek login: " + e.getMessage());
            return false;
        }
    }
}