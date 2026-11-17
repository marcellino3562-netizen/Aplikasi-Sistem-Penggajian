package model;

public class DataLaporan {
    private String idGaji;
    private String tanggal;
    private String idKaryawan;
    private int gajiBersih;

    public String getIdGaji() {
        return idGaji;
    }

    public void setIdGaji(String idGaji) {
        this.idGaji = idGaji;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public int getGajiBersih() {
        return gajiBersih;
    }

    public void setGajiBersih(int gajiBersih) {
        this.gajiBersih = gajiBersih;
    }
}