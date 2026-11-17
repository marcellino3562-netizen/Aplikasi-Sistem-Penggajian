package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class PersetujuanController {
    
    public void setujuiGaji(String idGaji) {
        try {
            Connection conn = Connector.konekkan.configDB();
            String sql = "UPDATE gaji SET status_approval = 'Disetujui' WHERE id_gaji = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, idGaji);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Mantap! Data Gaji " + idGaji + " Berhasil Disetujui!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menyetujui data: " + e.getMessage());
        }
    }
    

    public void tolakGaji(String idGaji) {
        try {
            java.sql.Connection conn = Connector.konekkan.configDB();
            String sql = "UPDATE gaji SET status_approval = 'Ditolak' WHERE id_gaji = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, idGaji);
            pst.executeUpdate();
            
            javax.swing.JOptionPane.showMessageDialog(null, "Data Gaji " + idGaji + " telah DITOLAK.");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal menolak data: " + e.getMessage());
        }
    }
}