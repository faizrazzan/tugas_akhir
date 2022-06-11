package Model;

import Entity.MengelolaEntity;
import Database.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MengelolaModel {
    protected String Mengelola = "";
    String sql;
    public Connection conn = database.getconection();

    public void insertMengelola(MengelolaEntity mengelolaEntity) {
        try {
            sql = String.format("INSERT INTO mengelola (ID_TRANSAKSI, ID_MAKANAN) VALUES " +
                            "('%s', '%s');",
                    mengelolaEntity.getId_transaksiMengelola(),
                    mengelolaEntity.getId_makanan()
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            if (statement.executeUpdate() > 0) {
                System.out.println("Berhasil Menambah Data");
            } else {
                System.out.println("Gagal Menambah Data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
