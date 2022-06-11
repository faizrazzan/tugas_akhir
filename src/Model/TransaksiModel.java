package Model;
import Database.database;
import Entity.TransaksiEntity;

import java.sql.*;

public class TransaksiModel extends TransaksiEntity {
    protected String Transaksi = "";
    int result = 0;
    String sql;
    public Connection conn = database.getconection();

    public void insertTransaksi(TransaksiEntity transaksiEntity){
        try {
            sql = String.format("INSERT INTO transaksi (ID_TRANSAKSI, TGL_PESAN, TOTAL_PEMBAYARAN, JUMLAH_PESANAN) VALUES " +
                            "('%s', NOW(),'%s', '%s');",
                    transaksiEntity.getId_transaksi(),
                    transaksiEntity.getTotalPembayaran(),
                    transaksiEntity.getJumlahPesanan()
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            result = statement.executeUpdate();
            if(result > 0){
                System.out.println("Berhasil Menambah Data Transaksi");
            }else{
                System.out.println("Gagal Menambah Data Transaksi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewTransaksi() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM transaksi";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println( + rs.getInt("ID_TRANSAKSI") + ". |"
                        + rs.getDate("TGL_PESAN") + " | "
                        + rs.getFloat("TOTAL_PEMBAYARAN") + " | "
                        + rs.getInt("JUMLAH_PESANAN") + " | "
                );
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
