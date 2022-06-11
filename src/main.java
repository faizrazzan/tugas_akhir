import Controller.JenisMakananController;
import Controller.MakananController;
import Controller.MengelolaController;
import Controller.TransaksiContoller;
import Entity.*;
import Model.AdminModel;

import java.util.Scanner;

public class main {
    public static Scanner input = new Scanner(System.in);
    public static MakananEntity makananEntity = new MakananEntity();
    public static MakananController makananController = new MakananController();
    public static MengelolaEntity mengelolaEntity = new MengelolaEntity();
    public static MengelolaController mengelolaController = new MengelolaController();
    public static AdminEntity adminEntity = new AdminEntity();
    public static AdminModel adminModel = new AdminModel();
    public static TransaksiContoller transaksiController = new TransaksiContoller();
    private static boolean cekAdmin;

    public static void main(String[] args) {
        int choice;
        dataAdmin();

        System.out.print("Username : ");
        adminEntity.setNama(input.next());
        System.out.print("Password : ");
        adminEntity.setPass(input.next());
        cekAdmin = adminModel.cekAdmin(adminEntity.getNama(), adminEntity.getPass());
        while (cekAdmin) {
            do {
                System.out.println("""
                        Menu :
                        1. Setting Makanan
                        2. Setting Jenis Makanan
                        3. Transaksi
                        Enter your choices:        
                        """);
                choice = input.nextInt();
                switch (choice) {
                    case 1 -> {
                        do {
                            System.out.print("""
                                    Data Menu:
                                    1. Insert Makanan
                                    2. Update Makanan
                                    3. Delete Makanan
                                    4. View Makanan
                                    5. Exit
                                    Enter your choices:
                                    """);
                            choice = input.nextInt();
                            switch (choice) {
                                case 1 -> insertMakanan();
                                case 2 -> updateMakanan();
                                case 3 -> deleteMakanan();
                                case 4 -> viewMakanan();
                                case 5 -> System.out.println("Logging out...");
                                default -> System.out.println("Invalid Input");

                            }
                        } while (choice != 4);
                    }
                    case 2 -> {
                        do {
                            System.out.print("""
                                    Data  Menu:
                                    1. Insert Jenis Makanan
                                    2. Update Jenis Makanan
                                    3. Delete Jenis Makanan
                                    4. View Jenis Makanan
                                    5. Exit
                                    Enter your choices:
                                    """);
                            choice = input.nextInt();
                            switch (choice) {
                                case 1 -> insertJenisMakanan();
                                case 2 -> updateJenisMakanan();
                                case 3 -> deleteJenisMakanan();
                                case 4 -> viewJenisMakanan();
                                case 5 -> System.out.println("Logging out...");
                                default -> System.out.println("Invalid Input");

                            }
                        } while (choice != 5);
                    }
                    case 3 -> {
                        do {
                            System.out.print("""
                                    Data  Menu:
                                    1. Insert Transaksi
                                    2. Insert Total Makanan
                                    3. view transaksi
                                    4. Exit
                                    Enter your choices:
                                    """);
                            choice = input.nextInt();
                            switch (choice) {
                                case 1 -> insertTransaksi();
                                case 2 -> insertMengelola();
                                case 3 -> viewTransaksi();
                                case 5 -> System.out.println("Logging out...");
                                default -> System.out.println("Invalid Input");

                            }
                        } while (choice != 5);
                    }
                }
            } while (choice != 3);
        }
    }

    private static void insertMengelola() {
        System.out.print("Masukan ID Transaksi : ");
        mengelolaEntity.setId_transaksiMengelola(input.nextInt());
        System.out.print("Masukan ID Makanan : ");
        mengelolaEntity.setId_makanan(input.nextInt());

        mengelolaController.insertMengelola(mengelolaEntity.getId_transaksiMengelola(),mengelolaEntity.getId_makanan()
                );
    }

    private static void viewTransaksi() {
        transaksiController.viewTransaksi();
    }

    private static void insertTransaksi() {
        TransaksiEntity transaksiEntity = new TransaksiEntity();
        System.out.println("Masukan Tgl Transaksi : ");
        System.out.println("Masukan Total Pembayaran : ");
        transaksiEntity.setTotalPembayaran(input.nextFloat());
        System.out.println("Masukan Jumalah Pesanan : ");
        transaksiEntity.setJumlahPesanan(input.nextInt());

        TransaksiContoller transaksiController = new TransaksiContoller();
        transaksiController.insertTransaksi(transaksiEntity.getTglPesan(),transaksiEntity.getTotalPembayaran(),transaksiEntity.getJumlahPesanan());
    }

    private static void viewMakanan() {
        MakananController.viewMakanan();
    }


    private static void insertJenisMakanan() {
        JenisMakananEntity jenisMakananEntity = new JenisMakananEntity();
        System.out.print("Masukan Nama Jenis Makanan: ");
        jenisMakananEntity.setNamaJenisMakanan(input.next());

        JenisMakananController jenisMakananController = new JenisMakananController();
        jenisMakananController.insertJenisMakanan(jenisMakananEntity.getNamaJenisMakanan());
    }

    public static void insertMakanan() {
        MakananEntity makananEntity = new MakananEntity();
        System.out.print("Masukan ID Jenis Makanan: ");
        makananEntity.setId_jenisMakanan(input.nextInt());
        System.out.print("Masukan Nama Makanan: ");
        makananEntity.setNama_makanan(input.next());
        System.out.print("Masukan Harga Makanan: ");
        makananEntity.setHarga_makanan(input.nextFloat());
        System.out.print("Masukan Stok Makanan: ");
        makananEntity.setStok_makanan(input.nextInt());

        MakananController makananController = new MakananController();
        makananController.insertMakanan(makananEntity.getId_jenisMakanan(),makananEntity.getNama_makanan(), makananEntity.getHarga_makanan(),
                makananEntity.getStok_makanan());
    }

    private static void updateJenisMakanan() {
        System.out.println("Masukan ID Jenis Makanan yang ingin diupdate: ");
        int id_jenisMakanan = input.nextInt();
        System.out.println("Masukan Nama Jenis Makanan Baru: ");
        String nama_jenisMakanan = input.next();

        JenisMakananController cont = new JenisMakananController();
        cont.updateJenisMakanan(id_jenisMakanan,nama_jenisMakanan);
    }

    private static void viewJenisMakanan(){
        JenisMakananController.viewJenisMakanan();
    }

    public static void updateMakanan() {
        System.out.println("Masukan ID Makanan: ");
        int id_makanan = input.nextInt();
        System.out.println("Masukan ID Jenis Makanan Baru: ");
        int id_jenisMakanan = input.nextInt();
        System.out.println("Masukan Nama Makanan Baru: ");
        String nama_makanan = input.next();
        System.out.println("Masukan Harga Makanan Baru: ");
        float harga_makanan = input.nextFloat();
        System.out.println("Masukan Stok Makanan Baru: ");
        int stok_makanan = input.nextInt();

        MakananController cont = new MakananController();
        cont.updateMakanan(id_makanan,id_jenisMakanan,nama_makanan,harga_makanan,stok_makanan);
    }
    private static void deleteMakanan() {
        int currentId = 0;
        System.out.println("Masukan Id Makanan yang ingin dihapus : ");
        currentId = input.nextInt();
        MakananController cont = new MakananController();
        cont.deleteMakanan(currentId);
    }
    private static void deleteJenisMakanan() {
        int currentId = 0;
        System.out.println("Masukan Id Jenis Makanan yang ingin dihapus : ");
        currentId = input.nextInt();
        JenisMakananController cont = new JenisMakananController();
        cont.deleteJenisMakanan(currentId);
    }

    static void dataAdmin(){
        String nama[] = {"admin"};
        String pass[] = {"admin"};
        adminModel.insert(nama, pass);
    }
}



