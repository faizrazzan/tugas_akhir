package Model;

import Database.database;
import Entity.JenisMakananEntity;
import Entity.MakananEntity;

import java.sql.*;

public class JenisMakananModel extends JenisMakananEntity {
    protected String JenisMakanan = "";
    String sql;
    public Connection conn = database.getconection();

    public void insertJenisMakanan(JenisMakananEntity jenisMakananEntity){
        try {
            sql = String.format("INSERT INTO jenis_makanan (ID_JENIS_MAKANAN, NAMA_JENIS_MAKANAN) VALUES " +
                            "('%s', '%s');",
                    jenisMakananEntity.getId_jenisMakanan(),
                    jenisMakananEntity.getNamaJenisMakanan()
            );
            PreparedStatement statement = conn.prepareStatement(sql);
            if(statement.executeUpdate() > 0){
                System.out.println("Berhasil Menambah Data Jenis Makanan");
            }else{
                System.out.println("Gagal Menambah Data Jenis Makanan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateJenisMakanan(int id_jenisMakanan,String nama_jenisMakanan){
        int result = 0;

        try {
            sql = String.format("UPDATE jenis_makanan set NAMA_JENIS_MAKANAN = " + "'%s' WHERE ID_JENIS_MAKANAN = '%s';",
                    nama_jenisMakanan,id_jenisMakanan
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
    public static void viewJenisMakanan(){
        Connection conn = database.getconection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM jenis_makanan";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println( + rs.getInt("ID_JENIS_MAKANAN") + ". "
                + rs.getString("NAMA_JENIS_MAKANAN")
                );
            }
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void deleteJenisMakanan(int id){
        int result = 0;

        try {
            Connection conn = database.getconection();
            String sql = String.format("DELETE FROM jenis_makanan WHERE ID_JENIS_MAKANAN = '%s';",
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

    public String getJenisMakanan() {
        return JenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        JenisMakanan = jenisMakanan;
    }
}
