package Entity;

public class JenisMakananEntity {
    protected int id_jenisMakanan;
    protected String namaJenisMakanan;

    public JenisMakananEntity() {
    }
    public JenisMakananEntity(int id_jenisMakanan, String namaJenisMakanan){
        this.id_jenisMakanan=id_jenisMakanan;
        this.namaJenisMakanan=namaJenisMakanan;
    }

    public int getId_jenisMakanan() {
        return id_jenisMakanan;
    }

    public void setId_jenisMakanan(int id_jenisMakanan) {
        this.id_jenisMakanan = id_jenisMakanan;
    }

    public String getNamaJenisMakanan() {
        return namaJenisMakanan;
    }

    public void setNamaJenisMakanan(String namaJenisMakanan) {
        this.namaJenisMakanan = namaJenisMakanan;
    }
}
