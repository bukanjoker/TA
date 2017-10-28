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
    private double intervalDatang, intervalKeluar;
    private long waktuDatang;
    private Posisi posisi;
    
    private double alpha,beta,gamma,delta,lamda,xi,miu,sigma,k,m,a,b;
    private String waktu;

    public Mobil(Posisi posisi, String waktu) 
    {
        this.posisi = posisi;
        this.waktu = waktu;
        
        setRandomDatang();
        setRandomKeluar();
//        System.out.println(posisi+", "+intervalDatang+", "+intervalKeluar);
    }
    
    public double random(String pil)
    {
        double val = 0;
        if (pil == "default")
        {
            val = ((new Random().nextInt(300))+1)*0.01;
        }
        else if (pil == "gamma")
        {
            //shape = alpha, scale = beta
            val = new Gamma(alpha, beta).random();
        }
        else if (pil == "gen.pareto")
        {
            //shape = k, scale = sigma, location = miu
            val = new GeneralizedPareto(miu, sigma, k).random();
        }
        else if (pil == "log.logistic")
        {
            //shape = alpha, scale = beta
            val = new Logistic(alpha, beta).random();
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
                val = x;
            }
            else
            {
                val = (miu*miu)/x;
            }
        }
        else if (pil == "person5")
        {
            //personV == invGamma, shape = alpha, scale = beta
            val = new InvGamma(alpha, beta).random();
        }
        
        return Math.abs(val);
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
                random = "inv.gaussian";
            }
            else if (posisi == Posisi.bawah)
            {
                //johnson sb
                gamma = 1.6618;
                sigma = 0.49968;
                lamda = 10.173;
                xi = 0.71194;
                random = "default";
            }
            else if (posisi == Posisi.kanan)
            {
                //pert
                m = 0.41292;
                a = 0.22572;
                b = 4.1709;
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
                k = 0.80681;
                alpha = 1.082;
                beta = 1.5251;
                gamma = 0.43;
                random = "default";
            }
            else if (posisi == Posisi.bawah)
            {
                alpha = 3.3977;
                beta = 2.2618;
                gamma = 0;
                random = "pearson5";
            }
            else if (posisi == Posisi.kanan)
            {
                //burr
                k = 0.2782;
                alpha = 36.805;
                beta = 3.6639;
                gamma = -3.0226;
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
                gamma = 1.7744;
                sigma = 0.68039;
                lamda = 29.963;
                xi = 0.06613;
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
                m = 0.58489;
                a = 0.1942;
                b = 2.984;
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
                gamma = 3.0738;
                sigma = 1.3066;
                lamda = 13.227;
                xi = 0.05014;
                random = "default";
            }
            else if (posisi == Posisi.kanan)
            {
                //dagum
                k = 0.23758;
                alpha = 3.5235;
                beta = 1.5848;
                gamma = 0.31;
                random = "default";
            }
            else if (posisi == Posisi.kiri)
            {
                //burr
                k = 1.4804;
                alpha = 1.8852;
                beta = 0.64317;
                gamma = 0.41488;
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
                gamma = 1.6802;
                sigma = 0.67487;
                lamda = 4.3649;
                xi = 0.36214;
                random = "default";
            }
            else if (posisi == Posisi.kanan)
            {
                //johnson sb
                gamma = 1.8197;
                sigma = 1.5718;
                lamda = 5.3834;
                xi = -0.23763;
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
        
        intervalKeluar = random(random);
    }

    public double getIntervalDatang() {
        return intervalDatang;
    }

    public void setIntervalDatang(long intervalDatang) {
        this.intervalDatang = intervalDatang;
    }

    public double getIntervalKeluar() {
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
