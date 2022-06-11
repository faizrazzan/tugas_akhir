package Entity;
import java.util.Date;

public class TransaksiEntity {
    protected int id_transaksi,jumlahPesanan;
    protected float totalPembayaran;
    protected Date tglPesan;

    public TransaksiEntity() {
    }
    public TransaksiEntity(int id_transaksi,Date tglPesan,float totalPembayaran ,int jumlahPesanan) {
        this.id_transaksi = id_transaksi;
        this.tglPesan = tglPesan;
        this.totalPembayaran = totalPembayaran;
        this.jumlahPesanan = jumlahPesanan;

    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

    public float getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(float totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

    public Date getTglPesan() {
        return tglPesan;
    }

    public void setTglPesan(Date tglPesan) {
        this.tglPesan = tglPesan;
    }
}
