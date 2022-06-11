package Entity;

public class MakananEntity {
    protected int id_makanan, id_jenisMakanan,stok_makanan;
    protected String nama_makanan;
    protected float harga_makanan;

    public MakananEntity() {
    }

    public MakananEntity(int id_makanan, int id_jenisMakanan,String nama_makanan, float harga_makanan,int stok_makanan) {
        this.id_makanan = id_makanan;
        this.id_jenisMakanan = id_jenisMakanan;
        this.nama_makanan = nama_makanan;
        this.harga_makanan = harga_makanan;
        this.stok_makanan = stok_makanan;
    }

    public int getId_makanan() {
        return id_makanan;
    }

    public void setId_makanan(int id_makanan) {
        this.id_makanan = id_makanan;
    }

    public int getId_jenisMakanan() {
        return id_jenisMakanan;
    }

    public void setId_jenisMakanan(int id_jenisMakanan) {
        this.id_jenisMakanan = id_jenisMakanan;
    }

    public int getStok_makanan() {
        return stok_makanan;
    }

    public void setStok_makanan(int stok_makanan) {
        this.stok_makanan = stok_makanan;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public float getHarga_makanan() {
        return harga_makanan;
    }

    public void setHarga_makanan(float harga_makanan) {
        this.harga_makanan = harga_makanan;
    }
}
