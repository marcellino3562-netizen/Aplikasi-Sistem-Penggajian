package main;

public class AplikasiPenggajian {
    
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Gagal memuat tema: " + ex.getMessage());
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View.MenuLogin().setVisible(true); 
            }
        });
        
    }
}