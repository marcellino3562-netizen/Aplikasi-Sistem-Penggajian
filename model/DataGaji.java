package model;

public class DataGaji {

    private String idGaji;
    private String idKaryawan;
    private int gajiPokok;
    private int totalKasbon;
    private int gajiBersih;
    private int jumlahHadir;

    public String getIdGaji() {
        return idGaji;
    }

    public void setIdGaji(String idGaji) {
        this.idGaji = idGaji;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public int getTotalKasbon() {
        return totalKasbon;
    }

    public void setTotalKasbon(int totalKasbon) {
        this.totalKasbon = totalKasbon;
    }

    public int getGajiBersih() {
        return gajiBersih;
    }

    public void setGajiBersih(int gajiBersih) {
        this.gajiBersih = gajiBersih;
    }

    public int getJumlahHadir() {
        return jumlahHadir;
    }

    public void setJumlahHadir(int jumlahHadir) {
        this.jumlahHadir = jumlahHadir;
    }
}
