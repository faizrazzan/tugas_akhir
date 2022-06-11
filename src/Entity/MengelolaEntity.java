package Entity;

public class MengelolaEntity {
    protected int id_transaksiMengelola,id_makanan;

    public MengelolaEntity() {
    }

    public MengelolaEntity(int id_transaksiMengelola, int id_makanan) {
        this.id_transaksiMengelola = id_transaksiMengelola;
        this.id_makanan = id_makanan;
    }

    public int getId_transaksiMengelola() {
        return id_transaksiMengelola;
    }

    public void setId_transaksiMengelola(int id_transaksiMengelola) {
        this.id_transaksiMengelola = id_transaksiMengelola;
    }

    public int getId_makanan() {
        return id_makanan;
    }

    public void setId_makanan(int id_makanan) {
        this.id_makanan = id_makanan;
    }
}
