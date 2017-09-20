/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Manager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Jalan;
import view.GUI;
import view.UI;

/**
 *
 * @author bukanjoker
 */
public class Main {
    public static void main(String[] args) 
    {
        Manager main = new Manager();
        UI gui = new UI();
        gui.setManager(main);
        gui.setVisible(true);
    }
}
