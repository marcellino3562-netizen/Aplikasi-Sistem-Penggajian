package controller;

import Connector.konekkan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ManajerLaporan {

   
    public DefaultTableModel getTabelLaporan(java.sql.Date tanggal) {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Laporan");
        model.addColumn("Tanggal");
        model.addColumn("ID Karyawan");
        model.addColumn("Gaji Bersih");

        String sql = "SELECT laporan.id_laporan, laporan.tanggal, gaji.id_karyawan, gaji.gajiBersih "
                   + "FROM laporan JOIN gaji ON laporan.id_gaji = gaji.id_gaji "
                   + "WHERE laporan.tanggal = ?";

        try {
            Connection conn = konekkan.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, tanggal);
            ResultSet rs = pst.executeQuery();

          
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_laporan"),
                    rs.getString("tanggal"),
                    rs.getString("id_karyawan"),
                    rs.getString("gajiBersih")
                });
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat data laporan: " + e.getMessage());
        }
        
        return model; 
    }
    

    public boolean simpanLaporan(String idLaporan, java.sql.Date tanggal, String idGaji) {

        String sql = "INSERT INTO laporan (id_laporan, tanggal, id_gaji) VALUES (?, ?, ?)";
        
        try {
            java.sql.Connection conn = Connector.konekkan.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
           
            pst.setString(1, idLaporan);
            pst.setDate(2, tanggal);
            pst.setString(3, idGaji);
            
           
            pst.executeUpdate();
            
            return true; 
            
        } catch (Exception e) {
            System.err.println("Gagal menyimpan data laporan: " + e.getMessage());
            return false; 
        }
    }

    public java.sql.ResultSet getLaporanGaji() {
        try {
            java.sql.Connection conn = Connector.konekkan.configDB();
            java.sql.Statement st = conn.createStatement();
            
           
            String sql = "SELECT Id_gaji, tanggal, id_karyawan, gajiBersih FROM gaji ORDER BY Id_gaji DESC";
            
            return st.executeQuery(sql);
        } catch (Exception e) {
            System.err.println("Gagal mengambil data laporan: " + e.getMessage());
            return null;
        }
    }
    
    public java.util.ArrayList<model.DataLaporan> getLaporanGajiByTanggal(String tanggalCari) {
        java.util.ArrayList<model.DataLaporan> listLaporan = new java.util.ArrayList<>();
        
        try {
            java.sql.Connection conn = Connector.konekkan.configDB();
            String sql = "SELECT Id_gaji, tanggal, id_karyawan, gajiBersih FROM gaji WHERE tanggal = ? ORDER BY Id_gaji DESC";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, tanggalCari);
            
            java.sql.ResultSet rs = pst.executeQuery();
            
            
            while (rs.next()) {
                model.DataLaporan data = new model.DataLaporan();
                data.setIdGaji(rs.getString("Id_gaji"));
                data.setTanggal(rs.getString("tanggal"));
                data.setIdKaryawan(rs.getString("id_karyawan"));
                data.setGajiBersih(rs.getInt("gajiBersih"));
                
                
                listLaporan.add(data);
            }
        } catch (Exception e) {
            System.err.println("Gagal memfilter data laporan: " + e.getMessage());
        }
        
        return listLaporan; 
    }
}