package com.Topik;

public class Kendaraan {
    public String plat, jenis;

    Kendaraan(String plat, String jenis) {
        this.plat = plat;
        this.jenis = jenis;
    }

    public String displayKendaraan(){
        return " | Plat Nomor : " + plat +
                " | Jenis : " + jenis;
    }
}
