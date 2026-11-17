package controller;

import Connector.konekkan;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class KaryawanController {


    public boolean tambahKaryawan(String id, String nama) {
    try {
        java.sql.Connection conn = Connector.konekkan.configDB();
        

        String sql = "INSERT INTO karyawan (id_karyawan, nama) VALUES (?,?)"; 
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, id);
        pst.setString(2, nama);
        
        pst.executeUpdate();
        return true;
    } catch (Exception e) {
        System.err.println("Gagal menyimpan data karyawan: " + e.getMessage());
        return false;
    }
}


    public javax.swing.table.DefaultTableModel getTabelKaryawan() {
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("ID Karyawan");
        model.addColumn("Nama");

        String sql = "SELECT * FROM karyawan";

        try {
            java.sql.Connection conn = Connector.konekkan.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_karyawan"),
                    rs.getString("nama"),
                });
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat data karyawan: " + e.getMessage());
        }
        
        return model;
    }
    
    public boolean editKaryawan(String id, String nama) {

        String sql = "UPDATE karyawan SET nama = ? WHERE id_karyawan = ?";
        try {
            java.sql.Connection conn = Connector.konekkan.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, id);
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Gagal edit karyawan: " + e.getMessage());
            return false;
        }
    }
    
    public boolean hapusKaryawan(String id) {
   
        String sql = "DELETE FROM karyawan WHERE id_karyawan = ?";
        try {
            java.sql.Connection conn = Connector.konekkan.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();
            return true;
        }  catch (java.sql.SQLException e) {
            if (e.getErrorCode() == 1451) {
                javax.swing.JOptionPane.showMessageDialog(null, 
                    "Karyawan ini tidak bisa dihapus karena sudah memiliki riwayat penggajian!\n" +
                    "Hapus dulu data gajinya di Menu Gaji jika memang ingin menghapus karyawan ini.", 
                    "Gagal Hapus", javax.swing.JOptionPane.WARNING_MESSAGE);
            } else {
                System.err.println("Gagal menghapus karyawan: " + e.getMessage());
            }
            return false;
           
    }
}
}