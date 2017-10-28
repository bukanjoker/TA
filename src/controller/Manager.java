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
import model.Lampu;
import util.Posisi;
import util.Warna;
import view.UI;

/**
 *
 * @author bukanjoker
 */
public class Manager extends Thread {
    private Jalan[] jalan;
    private Lampu[] lampu;
    private int[] urutan = {1,0,3,2};
    private int size;
    private String kondisi;
    private int current = 0;
    private int iterasi = 0;
    private int nextCur;
    private long durasi = 0;

    public Manager()
    {
        //inisiasi 4 jalan
        jalan = new Jalan[4];
        jalan[0] = new Jalan(Posisi.bawah, "siang");
        jalan[1] = new Jalan(Posisi.atas, "siang");
        jalan[2] = new Jalan(Posisi.kanan, "siang");
        jalan[3] = new Jalan(Posisi.kiri, "siang");
        
        lampu = new Lampu[4];
        lampu[0] = new Lampu(Posisi.bawah);
        lampu[1] = new Lampu(Posisi.atas);
        lampu[2] = new Lampu(Posisi.kanan);
        lampu[3] = new Lampu(Posisi.kiri);
    }
    
    public void run()
    {
        //adding cars
        jalan[0].start();
        jalan[1].start();
        jalan[2].start();
        jalan[3].start();
        
        //changing lamps
        while (true) 
        {
            //set lampu warna merah/hijau
            for (int i = 0; i < jalan.length; i++) 
            {
                if (i != current) 
                {
                    lampu[i].setWarna(Warna.merah);
                }
                else
                {
                    lampu[i].setWarna(Warna.HIJAU);
                }
            }

            //set delay
            durasi = lampu[current].getDurasi();
            long interval = 0;
            delay(durasi);
            
//            while (durasi > 0)
//            {
//                if (jalan[current].getListMobil().size() != 0) 
//                {
//                    interval = Math.round(jalan[current].getListMobil().get(0).getIntervalKeluar()*1000);
////                        System.out.println(jalan[current].getListMobil().get(0).getIntervalKeluar()*1000);
//                    if (durasi - interval > 0) 
//                    {
//                        delay(interval);
//                        durasi = durasi - interval;
//                        jalan[current].getListMobil().remove(0);
//                        jalan[current].setOut(jalan[current].getOut()+1);
//                        System.out.println("REMOVED "+jalan[current].getPosisi()+" jumlah: "+jalan[current].getListMobil().size());
//                    }
//                    else
//                    {
//                        delay(durasi);
//                        durasi = 0;
//                    }
//                }
//                else
//                {
//                    System.out.println(jalan[current].getPosisi()+" KOSONG");
//                    delay(durasi);
//                    durasi = 0;
//                }
//            }
            
//            if (jalan[current].getListMobil().size() == 0) 
//            {
//                delay(durasi);
//            }
//            else
//            {
//                
//                
//                
//            }
            
            //set current
            if (kondisi == "dinamis") 
            {
                double ratioMax = 0;

                for (int i = 0; i < jalan.length; i++) 
                {
                    jalan[i].setWait();
                    if (i != current)
                    {
                        //HRRN Calculation
                        jalan[i].HRRN();
                        //sort max ratio
                        if (jalan[i].getRatio() > ratioMax) 
                        {
                            ratioMax = jalan[i].getRatio();
                            nextCur = i;
                        }
                    }
                }
            }
            else 
            {
                if (iterasi < jalan.length-1) 
                {
                    iterasi++;
                }
                else
                {
                    iterasi = 0;
                }
                nextCur = iterasi;
            }

            current = nextCur;
//            print();
        }
        
//        ThreadLampu tLampu = new ThreadLampu(jalan, kondisi, urutan);
        
        //jalan 1
//        ThreadAddMobil add1 = new ThreadAddMobil(jalan[0], size);
//        ThreadRemoveMobil remove1 = new ThreadRemoveMobil(jalan[0]);
//        
//        //jalan 2
//        ThreadAddMobil add2 = new ThreadAddMobil(jalan[1], size);
//        ThreadRemoveMobil remove2 = new ThreadRemoveMobil(jalan[1]);
//        
//        //jalan 3
//        ThreadAddMobil add3 = new ThreadAddMobil(jalan[2], size);
//        ThreadRemoveMobil remove3 = new ThreadRemoveMobil(jalan[2]);
//        
//        //jalan 4
//        ThreadAddMobil add4 = new ThreadAddMobil(jalan[3], size);
//        ThreadRemoveMobil remove4 = new ThreadRemoveMobil(jalan[3]);
        
        //threads start
//        tLampu.start();
//        add1.start();
//        add2.start();
//        add3.start();
//        add4.start();
//        remove1.start();
//        remove2.start();
//        remove3.start();
//        remove4.start();
        
//        while (true)
//        {
//            int current = 0;
            
//            
//            try 
//            {
//                long durasi = jalan[current].getLampu().getDurasi();
//                System.out.print("Durasi: "+durasi/1000+"detik");
//                System.out.println(" Rata-rata menunggu: "+(jalan[0].getWait()+jalan[1].getWait()+jalan[2].getWait()+jalan[3].getWait())/4);
//                System.out.println("");
//                sleep(durasi);
//            } 
//            catch (InterruptedException ex) {
//                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
    
    public void print()
    {
        for (int i = 0; i < jalan.length; i++) 
        {
            double rasio = 0;
            double wait = 0;
            int listSize = 0;
            int outSize = 0;

            if (!jalan[i].getListMobil().isEmpty())
            {
                rasio = jalan[i].getRatio();
                wait = jalan[i].getWait();
                listSize = jalan[i].getListMobil().size();
                outSize = jalan[i].getOut();
            }

            System.out.print("["+jalan[i].getPosisi()+"]");
            System.out.print("["+lampu[i].getWarna()+"]");
            System.out.print("[Ratio:"+rasio+"]");
            System.out.print("[Waktu Tunggu:"+wait+"]");
            System.out.print("[Jumlah Mobil: "+listSize+"]");
            System.out.println("[Mobil keluar: "+outSize+"]");
        }
        
        double rataTunggu = (jalan[0].getWait()+jalan[1].getWait()+jalan[2].getWait()+jalan[3].getWait())/4;
        
        System.out.println("  durasi:"+durasi/1000+"detik rata-rata waktu tunggu:"+rataTunggu);
        System.out.println("");
        
    }
    
    public void setDurasi(long jalan1, long jalan2, long jalan3, long jalan4)
    {
        lampu[0].setDurasi(jalan1*1000);
        lampu[1].setDurasi(jalan2*1000);
        lampu[2].setDurasi(jalan3*1000);
        lampu[3].setDurasi(jalan4*1000);
    }
    
    public void setInterval(String value, int inv1, int inv2, int inv3, int inv4)
    {
        jalan[0].setValue(value);
        jalan[1].setValue(value);
        jalan[2].setValue(value);
        jalan[3].setValue(value);
        
        jalan[0].setInv(inv1*1000);
        jalan[1].setInv(inv2*1000);
        jalan[2].setInv(inv3*1000);
        jalan[3].setInv(inv4*1000);
    }
    
    public void delay(long time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public Lampu[] getLampu() {
        return lampu;
    }

    public void setLampu(Lampu[] lampu) {
        this.lampu = lampu;
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
