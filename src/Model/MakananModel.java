package Model;

import Database.database;
import Entity.MakananEntity;

import java.sql.*;
import java.util.ArrayList;

public class MakananModel extends MakananEntity {

    protected String Makanan = "";
    String sql;
    public Connection conn = database.getconection();


    public void insertMakanan(MakananEntity makananEntity){
        try {
            sql = String.format("INSERT INTO makanan (ID_MAKANAN ,ID_JENIS_MAKANAN, NAMA_MAKANAN,HARGA_MAKANAN,STOK_MAKANAN) VALUES " +
                            "('%s', '%s', '%s', '%s', '%s');",
                    makananEntity.getId_makanan(),
                    makananEntity.getId_jenisMakanan(),
                    makananEntity.getNama_makanan(),
                    makananEntity.getHarga_makanan(),
                    makananEntity.getStok_makanan()
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            if(statement.executeUpdate() > 0){
                System.out.println("Berhasil Menambah Data Makanan");
            }else{
                System.out.println("Gagal Menambah Data Makanan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void updateMakanan(int id_makanan,int id_jenisMakanan,String nama_makanan,float harga_makanan,int stok_makanan){
    int result = 0;

    try {
        sql = String.format("UPDATE makanan set ID_JENIS_MAKANAN = " + "'%s', " +
                        "NAMA_MAKANAN = " + "'%s'," +
                        "HARGA_MAKANAN = " + "'%s'," +
                        "STOK_MAKANAN = " + "'%s' WHERE ID_MAKANAN = '%s';",
                id_jenisMakanan,nama_makanan,harga_makanan,stok_makanan,id_makanan
        );
        PreparedStatement statement = conn.prepareStatement(sql);
        result = statement.executeUpdate();
        if(result > 0){
            System.out.println("Berhasil Mengubah Data");
        }else{
            System.out.println("Gagal Mengubah Data");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void deleteMakanan(int id){
    int result = 0;

    try {
        Connection conn = database.getconection();
        String sql = String.format("DELETE FROM makanan WHERE ID_MAKANAN = '%s';",
                id
        );
        PreparedStatement statement = conn.prepareStatement(sql);
        result = statement.executeUpdate();
        if (result > 0) {
            System.out.println("Berhasil Menghapus Data");
        } else {
            System.out.println("Gagal Menghapus Data");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public static void viewMakanan() {
        Connection conn = database.getconection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM makanan";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println( + rs.getInt("ID_MAKANAN") + ". "
                        + rs.getString("NAMA_MAKANAN") + " | Rp."
                        + rs.getFloat("HARGA_MAKANAN") + " | "
                        + rs.getInt("STOK_MAKANAN") + " | "
                );
            }
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Boolean updateStock(int jumlah, int id) {
        try {
            Connection conn = database.getconection();
            String sql = String.format("UPDATE FROM makanan set stok_makanan = '%s' where id_makanan = '%s';",
                    jumlah, id
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Berhasil Menghapus Data");
            } else {
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getMakanan() {
        return Makanan;
    }

    public void setMakanan(String makanan) {
        this.Makanan = makanan;
    }
}
