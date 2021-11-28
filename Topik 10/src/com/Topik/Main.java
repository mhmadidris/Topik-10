package com.Topik;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static Connection con;
    public static Statement stm;
    public static void main(String[] args){
        Scanner pilihan = new Scanner(System.in);
        // Koneksi Database
        try {
            String url ="jdbc:mysql://localhost/ojol";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();

            System.out.println("""
                    1. Insert Member
                    2. Info Member
                    3. Top Up Saldo
                    4. Transaksi""");
            System.out.print("Input : ");
            int a = pilihan.nextInt();
            switch(a) {
                // Insert Member
                case 1 -> {
                    try (Scanner scanner = new Scanner(System.in)) {
                        System.out.println("\n1. Driver" +
                                "\n2. Customer");
                        System.out.print("Pilihan : ");
                        if (scanner.nextInt() == 1) {
                            System.out.print("NIK : ");
                            String nik = scanner.next();
                            System.out.print("Name : ");
                            String name = scanner.next();
                            System.out.print("Nomor  Telepon : ");
                            String phone = scanner.next();
                            System.out.print("Plat Nomor : ");
                            String plat = scanner.next();
                            System.out.print("Jenis : ");
                            String jenis = scanner.next();
                            Driver d = new Driver(nik, name, phone, plat, jenis);
                            d.setSaldo(0);
                            String query = "INSERT INTO drivers (nik, name, no_telp, saldo, plat_nomor, jenis)" + " " +
                                    "values" +
                                    " " +
                                    "(?, ?, ?, ?, ?, ?)";
                            PreparedStatement preparedStmt = con.prepareStatement(query);
                            preparedStmt.setString (1, d.nik);
                            preparedStmt.setString (2, d.nama);
                            preparedStmt.setString (3, d.telepon);
                            preparedStmt.setInt (4, d.saldo);
                            preparedStmt.setString (5, d.plat);
                            preparedStmt.setString (6, d.jenis);
                            preparedStmt.execute();
                            con.close();
                            System.out.println("Berhasil Insert Driver");
                        }
                        else {
                            System.out.print("NIK : ");
                            String nik = scanner.next();
                            System.out.print("Name : ");
                            String name = scanner.next();
                            System.out.print("Nomor  Telepon : ");
                            String phone = scanner.next();
                            Customer c = new Customer(nik, name, phone);
                            c.setSaldo(0);
                            String query = "INSERT INTO customers (nik, name, no_telp, saldo)" + " values (?, ?, ?, ?)";
                            PreparedStatement preparedStmt = con.prepareStatement(query);
                            preparedStmt.setString (1, c.nik);
                            preparedStmt.setString (2, c.nama);
                            preparedStmt.setString (3, c.telepon);
                            preparedStmt.setInt (4, c.saldo);
                            preparedStmt.execute();
                            con.close();
                            System.out.println("Berhasil Insert Customer");
                        }
                    } catch (Exception e) {
                        System.out.println("Gagal insert");
                    }
                }
                case 2 -> {
                    // Display
                    try(Scanner pilihan1 = new Scanner(System.in)) {
                        System.out.println("\n1. Driver" +
                                "\n2. Customer");
                        System.out.print("Pilihan : ");
                        int p1 = pilihan1.nextInt();
                        String query;
                        Statement st = con.createStatement();
                        if (p1 == 1) {
                            query = "SELECT * FROM drivers";
                            ResultSet rs = st.executeQuery(query);

                            while (rs.next()) {
                                int id = rs.getInt("id");
                                String nik = rs.getString("nik");
                                String name = rs.getString("name");
                                String phone = rs.getString("no_telp");
                                int saldo = rs.getInt("saldo");
                                String plat = rs.getString("plat_nomor");
                                String jenis = rs.getString("jenis");

                                // print the results
                                System.out.println("\nInfo Customer");
                                System.out.println("NIK : " + nik +
                                        "\t| Name : " + name +
                                        "\t| Phone : " + phone +
                                        "\t| Saldo : " + saldo +
                                        "\t| Plat Nomor : " + plat +
                                        "\t| Jenis : " + jenis);
                            }
                        }
                        else {
                            query = "SELECT * FROM customers";
                            ResultSet rs = st.executeQuery(query);

                            while (rs.next()) {
                                int id = rs.getInt("id");
                                String nik = rs.getString("nik");
                                String name = rs.getString("name");
                                String phone = rs.getString("no_telp");
                                int saldo = rs.getInt("saldo");

                                // print the results
                                System.out.println("\nInfo Customer");
                                System.out.println("NIK : " + nik +
                                        "\t| Name : " + name +
                                        "\t| Phone : " + phone +
                                        "\t| Saldo : " + saldo);
                            }
                        }
                        st.close();
                    } catch (Exception e) {
                        System.out.println("Gagal Menampilkan");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Koneksi Gagal " + e.getMessage());
        }
    }
}
