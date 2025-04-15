class Penilaian {
    Mahasiswa mahasiswa;
    MataKuliah matkul;
    int tugas, uts, uas;
    double nilaiAkhir;

    Penilaian(Mahasiswa mhs, MataKuliah mk, int tugas, int uts, int uas) {
        this.mahasiswa = mhs;
        this.matkul = mk;
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
        hitungNilaiAkhir();
    }

    void hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);
    }
}