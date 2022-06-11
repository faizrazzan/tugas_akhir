package Controller;

import Entity.MengelolaEntity;
import Model.MengelolaModel;

public class MengelolaController {
    public void insertMengelola(int id_transaksiMengelola, int id_makanan) {
        MengelolaModel mengelolaModel = new MengelolaModel();
        MengelolaEntity mengelolaEntity = new MengelolaEntity (id_transaksiMengelola, id_makanan);
        mengelolaModel.insertMengelola(mengelolaEntity);
    }
}
