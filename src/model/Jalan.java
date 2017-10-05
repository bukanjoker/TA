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
    private double wait,servis;
    private String value;
    private long inv;
    private int out=0,in=0;
    private String waktu;

    public Jalan(Posisi posisi, boolean status)
    {
        this.posisi = posisi;
        this.status = status;
        
        lampu = new Lampu();
        
        listMobil = new ArrayList<Mobil>();
    }
    
    public void HRRN()
    {
//        long now = System.currentTimeMillis();
//        wait = now - listMobil.get(0).getWaktuDatang();
        
        servis = lampu.getDurasi();
        
        ratio = (wait + servis)/servis;
        
//        System.out.println(posisi);
//        System.out.println("now:"+now);
//        System.out.println("waktu datang:"+listMobil.get(0).getWaktuDatang());
//        System.out.println("wait:"+wait);
//        System.out.println("jumlah:"+listMobil.size());
    }
    
    public synchronized void add(int jml)
    {
            if (listMobil.size() < jml) 
            {
                Mobil m = new Mobil(posisi,waktu);
                
                long interval = m.getIntervalDatang();

                try 
                {
                    Thread.sleep(interval);
                    m.setWaktuDatang(System.currentTimeMillis());
                    listMobil.add(m);
                    in = in +1;
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
//                    System.out.println("["+posisi+"]add loading...");
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
                    Thread.sleep(interval);
                    listMobil.remove(0);
                    out = out +1;
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
//                    System.out.println("["+posisi+"]remove loading...");
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
        return wait/1000;
    }

    public void setWait() 
    {
        if (listMobil.size() != 0)
        {
            this.wait = System.currentTimeMillis() - listMobil.get(0).getWaktuDatang();
        }
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getInv() {
        return inv;
    }

    public void setInv(long inv) {
        this.inv = inv;
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
}
