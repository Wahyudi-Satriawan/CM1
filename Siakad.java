import java.util.Scanner;

public class Siakad {
    static Penilaian[] data = new Penilaian[5];

    public static void main(String[] args) {
        isiData();
        Scanner scanner = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n===== MENU SIAKAD =====");
            System.out.println("1. Tampilkan Data");
            System.out.println("2. Tampilkan Data (Sorted by Nilai Akhir)");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilih = scanner.nextInt(); scanner.nextLine();

            switch (pilih) {
                case 1: tampilData(); break;
                case 2: urutkanData(); tampilData(); break;
                case 3:
                    System.out.print("Masukkan NIM: ");
                    String cari = scanner.nextLine();
                    cariMahasiswa(cari);
                    break;
                case 0: System.out.println("Terima kasih."); break;
                default: System.out.println("Menu tidak valid.");
            }
        } while (pilih != 0);

        scanner.close();
    }

    static void isiData() {
        Mahasiswa m1 = new Mahasiswa("22001", "Ali Rahman");
        Mahasiswa m2 = new Mahasiswa("22002", "Budi Santoso");
        Mahasiswa m3 = new Mahasiswa("22003", "Citra Dewi");

        MataKuliah mk1 = new MataKuliah("MK001", "Struktur Data");
        MataKuliah mk2 = new MataKuliah("MK002", "Basis Data");
        MataKuliah mk3 = new MataKuliah("MK003", "Desain Web");

        data[0] = new Penilaian(m1, mk1, 80, 85, 90);
        data[1] = new Penilaian(m1, mk2, 60, 75, 70);
        data[2] = new Penilaian(m2, mk1, 75, 70, 80);
        data[3] = new Penilaian(m3, mk2, 85, 90, 95);
        data[4] = new Penilaian(m3, mk3, 80, 90, 65);
    }

    static void tampilData() {
        System.out.printf("\n%-6s %-15s %-6s %-15s %-6s %-6s %-6s %-10s\n",
                "NIM", "Nama", "Kode", "Mata Kuliah", "Tugas", "UTS", "UAS", "NilAkhir");
        for (Penilaian p : data) {
            System.out.printf("%-6s %-15s %-6s %-15s %-6d %-6d %-6d %-10.2f\n",
                    p.mahasiswa.nim, p.mahasiswa.nama, p.matkul.kodeMK,
                    p.matkul.namaMK, p.tugas, p.uts, p.uas, p.nilaiAkhir);
        }
    }

    static void urutkanData() {
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

    static void cariMahasiswa(String nim) {
        boolean ditemukan = false;
        for (Penilaian p : data) {
            if (p.mahasiswa.nim.equals(nim)) {
                if (!ditemukan) {
                    System.out.printf("\n%-6s %-15s %-6s %-15s %-6s %-6s %-6s %-10s\n",
                            "NIM", "Nama", "Kode", "Mata Kuliah", "Tugas", "UTS", "UAS", "NilAkhir");
                    ditemukan = true;
                }
                System.out.printf("%-6s %-15s %-6s %-15s %-6d %-6d %-6d %-10.2f\n",
                        p.mahasiswa.nim, p.mahasiswa.nama, p.matkul.kodeMK,
                        p.matkul.namaMK, p.tugas, p.uts, p.uas, p.nilaiAkhir);
            }
        }
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }
}