package Controller;

import Entity.JenisMakananEntity;
import Entity.MakananEntity;
import Model.JenisMakananModel;
import Model.MakananModel;

public class JenisMakananController {
    public void insertJenisMakanan(String nama_Jenis_makanan){
        JenisMakananModel jenisMakananModel = new JenisMakananModel();
        JenisMakananEntity jenisMakananEntity = new JenisMakananEntity(0,nama_Jenis_makanan);
        jenisMakananModel.insertJenisMakanan(jenisMakananEntity);
    }
    public void updateJenisMakanan(int id_jenisMakanan,String nama_jenisMakanan){
        JenisMakananModel jenisMakananModel = new JenisMakananModel();
        jenisMakananModel.updateJenisMakanan(id_jenisMakanan,nama_jenisMakanan);
    }
    public void deleteJenisMakanan(int currentId) {
        JenisMakananModel jenisMakananModel = new JenisMakananModel();
        jenisMakananModel.deleteJenisMakanan(currentId);
    }
    public static void viewJenisMakanan(){
        JenisMakananModel.viewJenisMakanan();
    }
}
