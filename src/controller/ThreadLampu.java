/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Jalan;
import util.Warna;

/**
 *
 * @author bukanjoker
 */
public class ThreadLampu extends Thread {
    private Jalan[] jalan;
    private String kondisi;
    private int current = 0;
    private int nextCurr;
    private int iterasi = 1;
    private long time;
    private int[] urutan;

    public ThreadLampu(Jalan[] jalan, String kondisi, int[] urutan) 
    {
        this.jalan = jalan;
        this.kondisi = kondisi;
        this.urutan = urutan;
    }
    
    @Override
    public void run()
    {
        while (true)
        {
            setWarnaLampu();
            timer(jalan[current].getLampu().getDurasi());
            setCurrent();
            
        }
    }
    
    public double HRRN(double wait, long servis)
    {
        double ratio = (wait+servis)/servis;
        return ratio;
    }
    
    public void setWarnaLampu()
    {
        for (int i = 0; i < jalan.length; i++) 
        {
            if (i != current)
            {
                jalan[i].setStatus(false);
            }
            else
            {
                jalan[i].setStatus(true);
//                System.out.println("Lampu ["+jalan[i].getPosisi()+"] "+jalan[i].getLampu().getWarna()+" "+jalan[i].getLampu().getDurasi()/1000+"detik");
            }
        }
    }
    
    public void setCurrent()
    {
        if (kondisi == "dinamis")
        {
            double ratioMax = 0;
            
            for (int i = 0; i < jalan.length; i++)
            {
                if (i != current)
                {
                    //hrrn calculation
                    jalan[i].setWait(jalan[i].getListMobil().get(0).getWaktuDatang());
                    jalan[i].setRatio(HRRN(jalan[i].getWait(), jalan[i].getLampu().getDurasi()));
                    //sort MaxRatio
                    if (jalan[i].getRatio() > ratioMax) 
                    {
                        ratioMax = jalan[i].getRatio();
                        nextCurr = i;
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
            nextCurr = urutan[iterasi];
        }
        
        current = nextCurr;
    }
    
    public void lampuWork()
    {
        long interval = jalan[current].getListMobil().get(0).getIntervalKeluar();
        long durasi = jalan[current].getLampu().getDurasi();
        
        if (durasi-interval > 0)
        {
            durasi = durasi - interval;
            time = interval;
            jalan[current].getListMobil().remove(0);
            interval = jalan[current].getListMobil().get(0).getIntervalKeluar();
        }
        else
        {
            time = durasi;
            durasi = 0;
        }
        
        timer(time);
    }
    
    public void timer(long durasi)
    {
        try {
            sleep(durasi);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadLampu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
