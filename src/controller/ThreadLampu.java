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
    private int iterasi;
    private long time;
    private int[] urutan;

    public ThreadLampu(Jalan[] jalan, String kondisi, int[] urutan) 
    {
        this.jalan = jalan;
        this.kondisi = kondisi;
        this.urutan = urutan;
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
                System.out.println("["+jalan[i].getPosisi()+"] "+jalan[i].getLampu().getWarna());
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
        double interval = jalan[current].getListMobil().get(0).getIntervalKeluar();
        double durasi = jalan[current].getLampu().getDurasi();
        
        if (durasi-interval > 0)
        {
            
        }
        else
        {
            
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
    
    @Override
    public void run()
    {
        while (true)
        {
            if (jalan[current].getListMobil().size() != 0) 
            {
                setWarnaLampu();
                timer(jalan[current].getLampu().getDurasi());
                setCurrent();
            }
            else
            {
                jalan[0].setStatus(false);
                jalan[1].setStatus(false);
                jalan[2].setStatus(false);
                jalan[3].setStatus(false);
            }
            
//            tesThread();
        }
    }
    
    public void tesThread()
    {
        try {
            System.out.println("thread jalan1");
            sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadLampu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
