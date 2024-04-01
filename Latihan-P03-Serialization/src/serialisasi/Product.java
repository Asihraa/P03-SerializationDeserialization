/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serialisasi;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ASIHRAA
 */
public class Product implements Serializable {
    private static final long serialVersionUID=1L; //Using static & final keyword
    private String id;
    private String nama;
    private List<ProductItem> items;
    private transient int counter;  //Using transient keyword

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setItems(List<ProductItem> items) {
        this.items = items;
    }
    
    @Override
    public String toString(){
        String produk, item = "";
        produk = "Produk: \r\n"
                + "Id" + id + "\r\n"
                + "Nama=" + nama + "\r\n"
                + "==========================\r\n"
                + "Product Item:\r\n";
        item = items.stream().map((obj)->
        obj.toString()).reduce(item, String::concat);
        return produk + item;
    }
}

//Jawaban Latihan no 2:

//Perbedaan antara Data Member yang Menggunakan dan Tidak Menggunakan Modifier
//transient: Variabel yang dideklarasikan sebagai transient tidak akan di-serialisasi, artinya nilainya tidak akan disimpan dalam proses serialisasi dan akan diabaikan saat deserialisasi.
//static: Variabel static bersifat global dan nilainya akan sama di semua instance objek kelas. Namun, variabel static tidak disertakan dalam serialisasi karena mereka tidak melekat pada objek spesifik.
//final: Variabel final tidak dapat diubah setelah diinisialisasi, sehingga nilainya tetap konstan. Dalam konteks serialisasi, variabel final dapat diserialisasi namun bersifat "read-only" setelah deserialisasi.
//Dengan menambahkan dan menggunakan keyword/access modifier yang tepat pada data member kelas, Anda dapat mengatur pengaturan serialisasi objek sesuai kebutuhan dan memahami perbedaan penting antara variabel yang menggunakan atau tidak menggunakan modifier tersebut.