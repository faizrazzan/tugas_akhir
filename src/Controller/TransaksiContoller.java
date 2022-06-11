package Controller;

import Entity.TransaksiEntity;
import Model.TransaksiModel;

import java.util.Date;

public class TransaksiContoller {
    TransaksiModel transaksiModel = new TransaksiModel();
    public void insertTransaksi(Date tgl_transaksi, float total_pembayaran, int jumlah_Pesanan) {
        TransaksiModel transaksiModel = new TransaksiModel();
        TransaksiEntity transaksiEntity = new TransaksiEntity(0, tgl_transaksi, total_pembayaran, jumlah_Pesanan);
        transaksiModel.insertTransaksi(transaksiEntity);
    }

    public void viewTransaksi() {
        transaksiModel.viewTransaksi();
    }
}
