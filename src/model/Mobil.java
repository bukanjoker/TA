/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import jdistlib.Gamma;
import jdistlib.InvGamma;
import jdistlib.Logistic;
import jdistlib.evd.GeneralizedPareto;
import util.Posisi;

/**
 *
 * @author bukanjoker
 */
public class Mobil {
    private long intervalDatang, intervalKeluar;
    private long waktuDatang;
    private Posisi posisi;
    
    private double alpha,beta,gamma,delta,lamda,xi,miu,sigma,k;
    private String waktu;

    public Mobil(Posisi posisi, String waktu) 
    {
        this.posisi = posisi;
        this.waktu = waktu;
        
        setRandomDatang();
        setRandomKeluar();
//        System.out.println(posisi+", "+intervalDatang+", "+intervalKeluar);
    }
    
    public long random(String pil)
    {
        long val = 0;
        if (pil == "default")
        {
            val = (new Random().nextInt(30)+1)*100;
        }
        else if (pil == "beta")
        {
            //shape = alpha, scale = beta
            val = Math.round(new Gamma(alpha, beta).random()*1000);
        }
        else if (pil == "gen.pareto")
        {
            //shape = k, scale = sigma, location = miu
            val = Math.round(new GeneralizedPareto(miu, sigma, k).random()*1000);
        }
        else if (pil == "log.logistic")
        {
            //shape = alpha, scale = beta
            val = Math.round(new Logistic(alpha, beta).random()*1000);
        }
        else if (pil == "inv.gaussian")
        {
            Random rand = new Random();
            double v = rand.nextGaussian();
            double y = v*v;
            double x = miu + (miu*miu*y)/(2*lamda) - (miu/(2*lamda)) * Math.sqrt(4*miu*lamda*y + miu*miu*y*y);
            double test = rand.nextDouble();
            if (test <= (miu)/(miu+x)) 
            {
                val = Math.round(x*1000);
            }
            else
            {
                val = Math.round(((miu*miu)/x)*1000);
            }
        }
        else if (pil == "person5")
        {
            //personV == invGamma, shape = alpha, scale = beta
            val = Math.round(new InvGamma(alpha, beta).random()*1000);
        }
        
        return val;
    }
    
    public void setRandomDatang()
    {
        String random = "default";
        
        if (waktu == "pagi") 
        {
            if (posisi == Posisi.atas) 
            {
                lamda = 4.0928;
                miu = 4.9426;
                gamma = -0.09513;
                random = "default";
            }
            else if (posisi == Posisi.bawah)
            {
                //johnson sb
                random = "default";
            }
            else if (posisi == Posisi.kanan)
            {
                //pert
                random = "default";
            }
            else if (posisi == Posisi.kiri)
            {
                alpha = 1.4325;
                beta = 1.6291;
                gamma = 0;
                random = "gamma";
            }
        }
        else if (waktu == "siang")
        {
            if (posisi == Posisi.atas) 
            {
                //gen. gamma
                random = "default";
            }
            else if (posisi == Posisi.bawah)
            {
                alpha = 3.3977;
                beta = 2.2618;
                gamma = 0;
                random = "default";
            }
            else if (posisi == Posisi.kanan)
            {
                //burr
                random = "default";
            }
            else if (posisi == Posisi.kiri)
            {
                k = 0.31958;
                sigma = 0.55925;
                miu = 0.34322;
                random = "gen.pareto";
            }
        }
        else if (waktu == "sore")
        {
            if (posisi == Posisi.atas) 
            {
                //johnson sb
                random = "default";
            }
            else if (posisi == Posisi.bawah)
            {
                //burr
                random = "default";
            }
            else if (posisi == Posisi.kanan)
            {
                k = -0.20781;
                sigma = 1.122;
                miu = 0.33447;
                random = "gen.pareto";
            }
            else if (posisi == Posisi.kiri)
            {
                //pert
                random = "default";
            }
        }
        
        intervalDatang = random(random);
    }
    
    public void setRandomKeluar()
    {
        String random = "default";
        
        if (waktu == "pagi") 
        {
            if (posisi == Posisi.atas) 
            {
                k = -0.04889;
                sigma = 0.97756;
                miu = 0.60407;
                random = "gen.pareto";
            }
            else if (posisi == Posisi.bawah)
            {
                //johnson sb
                random = "default";
            }
            else if (posisi == Posisi.kanan)
            {
                //dagum
                random = "default";
            }
            else if (posisi == Posisi.kiri)
            {
                //burr
                random = "default";
            }
        }
        else if (waktu == "siang")
        {
            if (posisi == Posisi.atas) 
            {
                alpha = 3.1271;
                beta = 1.3587;
                gamma = 0;
                random = "log.logistic";
            }
            else if (posisi == Posisi.bawah)
            {
                k = -0.186612;
                sigma = 0.63721;
                miu = 0.26535;
                random = "gen.pareto";
            }
            else if (posisi == Posisi.kanan)
            {
                alpha = 1.1639;
                beta = 0.92674;
                gamma = 0.1852;
                random = "gamma";
            }
            else if (posisi == Posisi.kiri)
            {
                //burr
                random = "default";
            }
        }
        else if (waktu == "sore")
        {
            if (posisi == Posisi.atas) 
            {
                lamda = 6.9353;
                miu = 1.6307;
                gamma = -0.3898;
                random = "default";
            }
            else if (posisi == Posisi.bawah)
            {
                //johnson sb
                random = "default";
            }
            else if (posisi == Posisi.kanan)
            {
                //johnson sb
                random = "default";
            }
            else if (posisi == Posisi.kiri)
            {
                k = -0.26058;
                sigma = 0.94208;
                miu = 0.26639;
                random = "gen.pareto";
            }
        }
        
        intervalKeluar = Math.abs(random(random));
    }

    public long getIntervalDatang() {
        return intervalDatang;
    }

    public void setIntervalDatang(long intervalDatang) {
        this.intervalDatang = intervalDatang;
    }

    public long getIntervalKeluar() {
        return intervalKeluar;
    }

    public void setIntervalKeluar(long intervalKeluar) {
        this.intervalKeluar = intervalKeluar;
    }

    public long getWaktuDatang() {
        return waktuDatang;
    }

    public void setWaktuDatang(long waktuDatang) {
        this.waktuDatang = waktuDatang;
    }
    
    
}
