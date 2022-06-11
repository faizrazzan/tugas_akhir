package Controller;

import Entity.MakananEntity;
import Model.MakananModel;

public class MakananController {


    public void insertMakanan(int id_jenisMakanan, String nama_makanan, float harga_makanan, int stok_makanan) {
        MakananModel makananModel = new MakananModel();
        MakananEntity makananEntity = new MakananEntity(0,id_jenisMakanan,nama_makanan,harga_makanan,stok_makanan);
        makananModel.insertMakanan(makananEntity);
    }
    public void updateMakanan(int id_makanan,int id_jenisMakanan,String nama_makanan,float harga_makanan,int stok_makanan){
        MakananModel makananModel = new MakananModel();
        makananModel.updateMakanan(id_makanan,id_jenisMakanan,nama_makanan,harga_makanan,stok_makanan);
    }

    public void deleteMakanan(int currentId) {
        MakananModel makananModel = new MakananModel();
        makananModel.deleteMakanan(currentId);
    }
    public static void viewMakanan() {
        MakananModel.viewMakanan();
    }

    public void updateStock(MakananEntity makanan) {

    }
}
