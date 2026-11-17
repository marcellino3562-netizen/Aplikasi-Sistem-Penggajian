/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

public class GajiController {
public boolean tambahDataGaji(model.DataGaji gaji) { 
    try {
        java.sql.Connection conn = Connector.konekkan.configDB();
        
        
        String sql = "INSERT INTO gaji (Id_gaji, id_karyawan, gajiPokok, TotalKasbon, jumlah_hadir, gajiBersih) VALUES (?,?,?,?,?,?)";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, gaji.getIdGaji());
        pst.setString(2, gaji.getIdKaryawan());
        pst.setInt(3, gaji.getGajiPokok());
        pst.setInt(4, gaji.getTotalKasbon());
        pst.setInt(5, gaji.getJumlahHadir()); 
        pst.setInt(6, gaji.getGajiBersih()); 
        
        pst.executeUpdate();
        return true;
    } catch (Exception e) {
        System.err.println("Gagal menyimpan data: " + e.getMessage());
        return false;
    }
}
    
    public String generateIdOtomatis() {
        
        String idBaru = "GJ001"; 
        
        try {
            String sql = "SELECT Id_gaji FROM gaji ORDER BY Id_gaji DESC LIMIT 1";
            java.sql.Connection conn = Connector.konekkan.configDB();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                String idTerakhir = rs.getString("Id_gaji"); 
                
               
                String ambilAngka = idTerakhir.substring(2); 
                
                
                int angkaBaru = Integer.parseInt(ambilAngka) + 1;
                
                
                idBaru = String.format("GJ%03d", angkaBaru);
            }
        } catch (Exception e) {
            System.err.println("Gagal generate ID: " + e.getMessage());
        }
        
        return idBaru;
    }
    
    public java.util.ArrayList<String> ambilSemuaIdKaryawan() {
        java.util.ArrayList<String> listId = new java.util.ArrayList<>();
        String sql = "SELECT id_karyawan FROM karyawan"; 
        
        try {
            java.sql.Connection conn = Connector.konekkan.configDB();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
            
                listId.add(rs.getString("id_karyawan"));
            }
        } catch (Exception e) {
            System.err.println("Gagal mengambil list ID Karyawan: " + e.getMessage());
        }
        return listId;
    }

public javax.swing.table.DefaultTableModel getTabelPersetujuan() {
    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
    model.addColumn("ID Gaji");
    model.addColumn("Tanggal");
    model.addColumn("ID Karyawan");
    model.addColumn("Gaji Bersih");
    model.addColumn("Status");

    String sql = "SELECT * FROM gaji WHERE status_approval = 'Pending'";

    try {
        java.sql.Connection conn = Connector.konekkan.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("Id_gaji"),
                rs.getString("tanggal"),
                rs.getString("id_karyawan"),
                rs.getString("gajiBersih"),
                rs.getString("status_approval")
            });
        }
    } catch (Exception e) {
        System.err.println("Gagal memuat data persetujuan: " + e.getMessage());
    }
    return model;
}

public boolean updateStatusApproval(String idGaji, String statusBaru) {
    try {
        java.sql.Connection conn = Connector.konekkan.configDB();
        String sql = "UPDATE gaji SET status_approval = ? WHERE Id_gaji = ?";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, statusBaru);
        pst.setString(2, idGaji);
        
        pst.executeUpdate();
        return true;
    } catch (Exception e) {
        System.err.println("Gagal update status: " + e.getMessage());
        return false;
    }
}
}
