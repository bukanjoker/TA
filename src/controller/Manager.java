/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Jalan;
import util.Posisi;
import view.UI;

/**
 *
 * @author bukanjoker
 */
public class Manager extends Thread {
    private Jalan[] jalan;
    private int[] urutan = {1,0,2,3};
    private int size;
    private String kondisi;

    public Manager()
    {
        //inisiasi 4 jalan
        jalan = new Jalan[4];
        jalan[0] = new Jalan(Posisi.bawah, false);
        jalan[1] = new Jalan(Posisi.kanan, false);
        jalan[2] = new Jalan(Posisi.atas, false);
        jalan[3] = new Jalan(Posisi.kiri, false);
    }
    
    public void run()
    {
        ThreadLampu tLampu = new ThreadLampu(jalan, kondisi, urutan);
        
        //jalan 1
        ThreadAddMobil add1 = new ThreadAddMobil(jalan[0], size);
        ThreadRemoveMobil remove1 = new ThreadRemoveMobil(jalan[0]);
        
        //jalan 2
        ThreadAddMobil add2 = new ThreadAddMobil(jalan[1], size);
        ThreadRemoveMobil remove2 = new ThreadRemoveMobil(jalan[1]);
        
        //jalan 3
        ThreadAddMobil add3 = new ThreadAddMobil(jalan[2], size);
        ThreadRemoveMobil remove3 = new ThreadRemoveMobil(jalan[2]);
        
        //jalan 4
        ThreadAddMobil add4 = new ThreadAddMobil(jalan[3], size);
        ThreadRemoveMobil remove4 = new ThreadRemoveMobil(jalan[3]);
        
        //threads start
        tLampu.start();
        add1.start();
        add2.start();
        add3.start();
        add4.start();
        remove1.start();
        remove2.start();
        remove3.start();
        remove4.start();
        
    }
    
    public double HRRN(double wait, long servis)
    {
        double ratio = (wait+servis)/servis;
        return ratio;
    }
    
    public void print(int i)
    {
        System.out.print("["+jalan[i].getPosisi()+"]");
        System.out.print("["+jalan[i].getLampu().getWarna()+"]");
        System.out.print("[Ratio:"+jalan[i].getRatio()+"]");
        System.out.print("[Waktu Tunggu:"+jalan[i].getWait()/1000+"]");
        System.out.print("[Jumlah Mobil: "+jalan[i].getListMobil().size()+"]");
        System.out.println("");
        try {
            sleep(jalan[i].getLampu().getDurasi());
        } catch (InterruptedException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setDurasi(long jalan1, long jalan2, long jalan3, long jalan4)
    {
        jalan[0].getLampu().setDurasi(jalan1);
        jalan[1].getLampu().setDurasi(jalan2);
        jalan[2].getLampu().setDurasi(jalan3);
        jalan[3].getLampu().setDurasi(jalan4);
    }
    
    public void setRandom(int i, String randomIN, String randomOUT)
    {
        jalan[i].setRandom(randomIN, randomOUT);
    }
            
    public Jalan[] getJalan() {
        return jalan;
    }
    
    public Jalan getJalan(int i)
    {
        return jalan[i];
    }

    public void setJalan(Jalan[] jalan) {
        this.jalan = jalan;
    }
    
    public void setSize(int size) {
        this.size = size;
    }

    public int[] getUrutan() {
        return urutan;
    }

    public void setUrutan(int[] urutan) {
        this.urutan = urutan;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }
}
