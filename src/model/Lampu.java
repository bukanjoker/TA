/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import util.Posisi;
import util.Warna;

/**
 *
 * @author bukanjoker
 */
public class Lampu {
    private Warna warna;
    private Posisi posisi;
    private long durasi;

    public Lampu(Posisi posisi)
    {
        this.warna = warna.merah;
        this.posisi = posisi;
    }

    public Warna getWarna() {
        return warna;
    }

    public void setWarna(Warna warna) {
        this.warna = warna;
    }

    public long getDurasi() {
        return durasi;
    }

    public void setDurasi(long durasi) {
        this.durasi = durasi;
    }
    
    
}
