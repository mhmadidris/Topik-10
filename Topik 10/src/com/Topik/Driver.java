package com.Topik;

public class Driver extends Kendaraan {
    public String nik, nama, telepon;
    public int saldo;

    Driver (String nik, String nama, String telepon, String plat, String jenis) {
        super(plat, jenis);
        this.nik = nik;
        this.nama = nama;
        this.telepon = telepon;
    }

    public void setSaldo (int saldo){
        this.saldo = saldo;
    }

    public int getSaldo(){
        return saldo;
    }

    @Override
    public String toString(){
        return "NIK : " + nik +
                " | Nama : " + nama +
                " | Nomor Telepon : " + telepon;
    }
}
