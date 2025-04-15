import java.util.Scanner;

public class Siakad {
    public static Penilaian[] data = new Penilaian[5];
    public static Mahasiswa[] daftarMahasiswa = new Mahasiswa[3];
    public static MataKuliah[] daftarMK = new MataKuliah[3];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        isiData();
        int pilihan;
        do {
            System.out.println("\n=== MENU SISTEM AKADEMIK ===");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 
            switch (pilihan) {
                case 1: for (Mahasiswa m : daftarMahasiswa) {
                            m.tampilMahasiswa();
                        }
                    break;
                case 2: for (MataKuliah mk : daftarMK) {
                            mk.tampilMataKuliah();
                        }
                    break;
                case 3: tampilData();
                    break;
                case 4: urutkanData(); tampilData();
                    break;
                case 5: System.out.print("Masukkan NIM: ");
                        String cari = scanner.nextLine();
                        cariMahasiswa(cari);
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
        scanner.close();
    }

    public static void isiData() {
        daftarMahasiswa[0] = new Mahasiswa("22001", "Ali Rahman", "Informatika");
        daftarMahasiswa[1] = new Mahasiswa("22002", "Budi Santoso", "Informatika");
        daftarMahasiswa[2] = new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis");

        daftarMK [0] = new MataKuliah("MK001", "Struktur Data", 3);
        daftarMK [1] = new MataKuliah("MK002", "Basis Data", 3);
        daftarMK [2] = new MataKuliah("MK003", "Desain Web", 3);

        data[0] = new Penilaian(daftarMahasiswa[0], daftarMK [0], 80, 85, 90);
        data[1] = new Penilaian(daftarMahasiswa[0], daftarMK [1], 60, 75, 70);
        data[2] = new Penilaian(daftarMahasiswa[1], daftarMK [0], 75, 70, 80);
        data[3] = new Penilaian(daftarMahasiswa[2], daftarMK [1], 85, 90, 95);
        data[4] = new Penilaian(daftarMahasiswa[2], daftarMK [2], 80, 90, 65);
    }

    public static void tampilData() {
        System.out.println("\nNIM     Nama             Kode  Mata Kuliah     Tugas UTS UAS NilAkhir");
        for (Penilaian p : data) {
            System.out.println(p.mahasiswa.nim + " " +
                            p.mahasiswa.nama + " " +
                            p.mataKuliah.kodeMK + " " +
                            p.mataKuliah.namaMK + " " +
                            p.nilaiTugas + " " +
                            p.nilaiUTS + " " +
                            p.nilaiUAS + " " +
                            p.nilaiAkhir);
        }
    }

    public static void urutkanData() {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].nilaiAkhir < data[j + 1].nilaiAkhir) {
                    Penilaian temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void cariMahasiswa(String nim) {
        boolean ditemukan = false;
        for (Penilaian p : data) {
            if (p.mahasiswa.nim.equals(nim)) {
                if (!ditemukan) {
                    System.out.println("\nNIM     Nama             Kode  Mata Kuliah     Tugas UTS UAS NilAkhir");
                    ditemukan = true;
                }
                System.out.println(p.mahasiswa.nim + " " +
                                   p.mahasiswa.nama + " " +
                                   p.mataKuliah.kodeMK + " " +
                                   p.mataKuliah.namaMK + " " +
                                   p.nilaiTugas + " " +
                                   p.nilaiUTS + " " +
                                   p.nilaiUAS + " " +
                                   p.nilaiAkhir);
            }
        }
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }
}