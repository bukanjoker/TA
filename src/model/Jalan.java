/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ThreadAddMobil;
import controller.ThreadRemoveMobil;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Posisi;
import util.Warna;

/**
 *
 * @author bukanjoker
 */
public class Jalan {
    private Lampu lampu;
    private ArrayList<Mobil> listMobil;
    private double ratio;
    private boolean status;
    private Posisi posisi;
    private double wait;
    private long start;
    private int size;
    private long arrival;
    private String randomIN, randomOUT;

    public Jalan(Posisi posisi, boolean status)
    {
        this.start = System.currentTimeMillis();
        this.posisi = posisi;
        this.status = status;
        
        lampu = new Lampu();
        
        listMobil = new ArrayList<>();
    }
    
    public synchronized void add(int jml)
    {
            if (listMobil.size() < jml) 
            {
                Mobil m = new Mobil(posisi);
                long interval = m.getIntervalDatang();

                try 
                {
                    wait(interval);
                    arrival = arrival + System.currentTimeMillis();
                    m.setWaktuDatang(arrival);
                    listMobil.add(m);
                    System.out.println("Mobil["+posisi+"]masuk. Jumlah:"+listMobil.size());
                } 
                catch (InterruptedException ex) {
                    Logger.getLogger(Jalan.class.getName()).log(Level.SEVERE, null, ex);
                }
//                notifyAll();
            }
            else
            {
                try {
                    System.out.println("add loading...");
                    wait(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jalan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public synchronized void remove()
    {
        while (lampu.getWarna() == Warna.HIJAU)
        {
            if (!listMobil.isEmpty())
            {
                long interval = listMobil.get(0).getIntervalKeluar();
                try 
                {
                    wait(interval);
                    listMobil.remove(0);
                    System.out.println("Mobil["+posisi+"]KELUAR. Jumlah:"+listMobil.size());
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(Jalan.class.getName()).log(Level.SEVERE, null, ex);
                }
//                notifyAll();
            }
            else
            {
                try {
                    System.out.println("remove loading...");
                    wait(1000);
//                    System.out.println("remove - out of condition: ["+posisi+"]"+listMobil.size()+" "+lampu.getWarna());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jalan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public double getWait() 
    {
        return wait;
    }

    public void setWait(long waktudatang) {
        this.wait = System.currentTimeMillis() - waktudatang;
    }

    public Lampu getLampu() {
        return lampu;
    }

    public void setLampu(Lampu lampu) {
        this.lampu = lampu;
    }

    public ArrayList<Mobil> getListMobil() {
        return listMobil;
    }

    public void setListMobil(ArrayList<Mobil> listMobil) {
        this.listMobil = listMobil;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        if (status == true) 
        {
            lampu.setWarna(Warna.HIJAU);
        }
        else   
        {
            lampu.setWarna(Warna.merah);
        }
    }

    public Posisi getPosisi() {
        return posisi;
    }

    public void setPosisi(Posisi posisi) {
        this.posisi = posisi;
    }

    public void setRandom(String randomIN, String randomOUT) {
        this.randomIN = randomIN;
        this.randomOUT = randomOUT;
    }
}
