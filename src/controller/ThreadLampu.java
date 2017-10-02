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
            delay(jalan[current].getLampu().getDurasi());
//            lampuWork();
            setCurrent();
        }
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
            jalan[i].setWait();
        }
    }
    
    public void setCurrent()
    {
        //dinamis
        if (kondisi == "dinamis")
        {
            double ratioMax = 0;
            
            for (int i = 0; i < jalan.length; i++)
            {
                if (i != current)
                {
                    //hrrn calculation
                    jalan[i].HRRN();
                    //sort MaxRatio
                    if (jalan[i].getRatio() > ratioMax) 
                    {
                        ratioMax = jalan[i].getRatio();
                        nextCurr = i;
                    }
                }
            }
        }
        
        //statis
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
        long durasi = jalan[current].getLampu().getDurasi();
        long interval = 0;
        
        if (jalan[current].getListMobil().size() == 0)
        {
            delay(durasi);
        }
        else
        {
            while (durasi > 0)
            {
                interval = jalan[current].getListMobil().get(0).getIntervalKeluar();
                if (durasi - interval > 0)
                {
                    delay(interval);
                    durasi = durasi - interval;
                    jalan[current].getListMobil().remove(0);
//                    System.out.println("Mobil["+jalan[current].getPosisi()+"]KELUAR. Jumlah:"+jalan[current].getListMobil().size());
                }
                else
                {
                    delay(durasi);
                    durasi = 0;
                }
            }
        }
        
    }
    
    public void delay(long durasi)
    {
        try {
            sleep(durasi);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadLampu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
