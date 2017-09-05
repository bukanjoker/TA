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
public class ThreadRemoveMobil extends Thread {
    private Jalan jalan;

    public ThreadRemoveMobil(Jalan jalan) {
        this.jalan = jalan;
    }
    
    @Override
    public void run()
    {
        while (true)
        {
            jalan.remove();
        }
    }
    
}
