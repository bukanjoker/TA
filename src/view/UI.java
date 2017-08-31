/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.Jalan;
import model.Lampu;
import util.Warna;

/**
 *
 * @author bukanjoker
 */
public class UI extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    Object txtDataIn;
    JLabel[][] cars;
    JLabel[][] trafficlight;
    private Timer timer;
    private Jalan[] jalan;
    private int[] buffer = new int[4];
    private Manager manager;
    
    public UI(Manager manager) 
    {
        initComponents();
        this.manager = manager;
        init();
    }
    
    public void init()
    {
//        manager = new Manager();
        jalan = manager.getJalan();
        cars();
        trafficlight();
        this.setLocationRelativeTo(null);
        
        if (String.valueOf(jComboBox9.getSelectedItem()) == "default")
        {
            text1.setEditable(false);
            text2.setEditable(false);
            text3.setEditable(false);
            text4.setEditable(false);
        }
        else
        {
            text1.setEditable(true);
            text2.setEditable(true);
            text3.setEditable(true);
            text4.setEditable(true);
        }
    }
    
    public void cars() 
    {
        cars = new JLabel[4][11];
        
        cars[3][0] = carL1;
        cars[3][1] = carL2;
        cars[3][2] = carL3;
        cars[3][3] = carL4;
        cars[3][4] = carL5;
        cars[3][5] = carL6;
        cars[3][6] = carL7;
        cars[3][7] = carL8;
        cars[3][8] = carL9;
        cars[3][9] = carL10;
        cars[3][10] = carL11;
        
        cars[2][0] = carU1;
        cars[2][1] = carU2;
        cars[2][2] = carU3;
        cars[2][3] = carU4;
        cars[2][4] = carU5;
        cars[2][5] = carU6;
        cars[2][6] = carU7;
        cars[2][7] = carU8;
        cars[2][8] = carU9;
        cars[2][9] = carU10;
        cars[2][10] = carU11;
        
        cars[1][0] = carR1;
        cars[1][1] = carR2;
        cars[1][2] = carR3;
        cars[1][3] = carR4;
        cars[1][4] = carR5;
        cars[1][5] = carR6;
        cars[1][6] = carR7;
        cars[1][7] = carR8;
        cars[1][8] = carR9;
        cars[1][9] = carR10;
        cars[1][10] = carR11;
        
        cars[0][0] = carB1;
        cars[0][1] = carB2;
        cars[0][2] = carB3;
        cars[0][3] = carB4;
        cars[0][4] = carB5;
        cars[0][5] = carB6;
        cars[0][6] = carB7;
        cars[0][7] = carB8;
        cars[0][8] = carB9;
        cars[0][9] = carB10;
        cars[0][10] = carB11;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 11; j++) {
                cars[i][j].setVisible(false);
            }
        }
    }
    
    public void trafficlight() 
    {
        trafficlight = new JLabel[3][4];
        
        trafficlight[0][0] = redB;
        trafficlight[0][1] = redR;
        trafficlight[0][2] = redU;
        trafficlight[0][3] = redL;
        
        trafficlight[1][0] = yelB;
        trafficlight[1][1] = yelR;
        trafficlight[1][2] = yelU;
        trafficlight[1][3] = yelL;
        
        trafficlight[2][0] = grenB;
        trafficlight[2][1] = grenR;
        trafficlight[2][2] = grenU;
        trafficlight[2][3] = grenL;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0) {
                    trafficlight[i][j].setVisible(true);
                }
                else {
                    trafficlight[i][j].setVisible(false);
                }
            }
        }
    }
    
    public void mobil()
    {
        for (int i = 0; i < jalan.length; i++) 
        {
            for (int j = 0; j < jalan[i].getListMobil().size(); j++) 
            {   
                if (buffer[i] > jalan[i].getListMobil().size()) 
                {
                    cars[i][buffer[i]-1].setVisible(false);
                    buffer[i] = jalan[i].getListMobil().size();
                }
                else 
                {
                    cars[i][j].setVisible(true);
                    buffer[i] = jalan[i].getListMobil().size();
                }
                
            }
        }
    }
    
    public void lampu()
    {
        int tmp = 0;
        
        for (int i = 0; i < jalan.length; i++)
        {
            if (jalan[i].getLampu().getWarna() == Warna.HIJAU) 
            {
                tmp = i;
            }
            else
            {
                trafficlight[2][i].setVisible(false);
                trafficlight[0][i].setVisible(true);
            }
        }
        
        trafficlight[0][tmp].setVisible(false);
        trafficlight[2][tmp].setVisible(true);
    }

    public Jalan[] getJalan() {
        return jalan;
    }

    public void setJalan(Jalan[] jalan) {
        this.jalan = jalan;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        carL1 = new javax.swing.JLabel();
        carL2 = new javax.swing.JLabel();
        carL3 = new javax.swing.JLabel();
        carU1 = new javax.swing.JLabel();
        carU2 = new javax.swing.JLabel();
        carU3 = new javax.swing.JLabel();
        carR1 = new javax.swing.JLabel();
        carR2 = new javax.swing.JLabel();
        carR3 = new javax.swing.JLabel();
        carB1 = new javax.swing.JLabel();
        carB2 = new javax.swing.JLabel();
        carB3 = new javax.swing.JLabel();
        carL4 = new javax.swing.JLabel();
        carL5 = new javax.swing.JLabel();
        carL6 = new javax.swing.JLabel();
        carB4 = new javax.swing.JLabel();
        carB5 = new javax.swing.JLabel();
        carB6 = new javax.swing.JLabel();
        carR4 = new javax.swing.JLabel();
        carR5 = new javax.swing.JLabel();
        carR6 = new javax.swing.JLabel();
        carU4 = new javax.swing.JLabel();
        carU5 = new javax.swing.JLabel();
        carU6 = new javax.swing.JLabel();
        redL = new javax.swing.JLabel();
        grenL = new javax.swing.JLabel();
        yelL = new javax.swing.JLabel();
        grenB = new javax.swing.JLabel();
        yelB = new javax.swing.JLabel();
        redB = new javax.swing.JLabel();
        grenU = new javax.swing.JLabel();
        yelU = new javax.swing.JLabel();
        redU = new javax.swing.JLabel();
        grenR = new javax.swing.JLabel();
        yelR = new javax.swing.JLabel();
        redR = new javax.swing.JLabel();
        carL7 = new javax.swing.JLabel();
        carL8 = new javax.swing.JLabel();
        carL9 = new javax.swing.JLabel();
        carL10 = new javax.swing.JLabel();
        carL11 = new javax.swing.JLabel();
        carB7 = new javax.swing.JLabel();
        carB8 = new javax.swing.JLabel();
        carB9 = new javax.swing.JLabel();
        carB10 = new javax.swing.JLabel();
        carB11 = new javax.swing.JLabel();
        carR7 = new javax.swing.JLabel();
        carR8 = new javax.swing.JLabel();
        carR9 = new javax.swing.JLabel();
        carR10 = new javax.swing.JLabel();
        carR11 = new javax.swing.JLabel();
        carU7 = new javax.swing.JLabel();
        carU8 = new javax.swing.JLabel();
        carU9 = new javax.swing.JLabel();
        carU10 = new javax.swing.JLabel();
        carU11 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        text4 = new javax.swing.JTextField();
        text1 = new javax.swing.JTextField();
        text2 = new javax.swing.JTextField();
        text3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        statis = new javax.swing.JRadioButton();
        dinamis = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulasi Lalu Lintas Perempatan Seokarno Hatta");
        setFocusCycleRoot(false);
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(1000, 630));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        carL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        carL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        carL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        carU1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        carU2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        carU3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        carR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        carR2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        carR3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        carB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        carB2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        carB3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, -1, -1));

        carL4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        carL5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        carL6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        carB4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        carB5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        carB6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, -1, -1));

        carR4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        carR5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, -1, -1));

        carR6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        carU4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        carU5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        carU6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        redL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/red.png"))); // NOI18N
        getContentPane().add(redL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        grenL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/green.png"))); // NOI18N
        getContentPane().add(grenL, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 30, 30));

        yelL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/yellow.png"))); // NOI18N
        getContentPane().add(yelL, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 160, 30, 30));

        grenB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/green.png"))); // NOI18N
        getContentPane().add(grenB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 30, 30));

        yelB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/yellow.png"))); // NOI18N
        getContentPane().add(yelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 30, 40));

        redB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/red.png"))); // NOI18N
        getContentPane().add(redB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));

        grenU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/green.png"))); // NOI18N
        getContentPane().add(grenU, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 30, 30));

        yelU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/yellow.png"))); // NOI18N
        getContentPane().add(yelU, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 30, 40));

        redU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/red.png"))); // NOI18N
        getContentPane().add(redU, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        grenR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/green.png"))); // NOI18N
        getContentPane().add(grenR, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 30, 30));

        yelR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/yellow.png"))); // NOI18N
        getContentPane().add(yelR, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 410, 30, 30));

        redR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/red.png"))); // NOI18N
        getContentPane().add(redR, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 410, -1, 30));

        carL7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        carL8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        carL9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        carL10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        carL11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carL11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, -1));

        carB7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, -1, -1));

        carB8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, -1));

        carB9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, -1, -1));

        carB10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, -1, -1));

        carB11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carB11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, -1, -1));

        carR7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        carR8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        carR9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        carR10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        carR11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carLeftRight.png"))); // NOI18N
        getContentPane().add(carR11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, -1));

        carU7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        carU8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        carU9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        carU10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        carU11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/carUpDown.png"))); // NOI18N
        getContentPane().add(carU11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        getContentPane().add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 480, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rsc/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        start.setText("START");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        getContentPane().add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 80, 30));

        text4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text4ActionPerformed(evt);
            }
        });
        getContentPane().add(text4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 50, -1));

        text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text1ActionPerformed(evt);
            }
        });
        getContentPane().add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 50, -1));

        text2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text2ActionPerformed(evt);
            }
        });
        getContentPane().add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 50, -1));

        text3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text3ActionPerformed(evt);
            }
        });
        getContentPane().add(text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 50, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("SET RANDOM");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, -1, -1));

        jLabel3.setText("Jalan 4");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, -1, -1));

        jLabel4.setText("Jalan 1");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        jLabel5.setText("Jalan 2");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        jLabel6.setText("Jalan 3");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel7.setText("detik");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel8.setText("detik");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel9.setText("detik");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel10.setText("detik");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setText("TIPE LAMPU :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>", "random 1", "random 2", "random 3" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>", "random 1", "random 2", "random 3" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>", "random 1", "random 2", "random 3" }));
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, -1, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>", "random 1", "random 2", "random 3" }));
        getContentPane().add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, -1, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>", "random 1", "random 2", "random 3" }));
        getContentPane().add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, -1, -1));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>", "random 1", "random 2", "random 3" }));
        getContentPane().add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, -1, -1));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>", "random 1", "random 2", "random 3" }));
        getContentPane().add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, -1, -1));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>", "random 1", "random 2", "random 3" }));
        getContentPane().add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setText("OUT");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel13.setText("IN");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, -1, -1));

        buttonGroup1.add(statis);
        statis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statis.setSelected(true);
        statis.setText("statis");
        getContentPane().add(statis, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        buttonGroup1.add(dinamis);
        dinamis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dinamis.setText("dinamis");
        getContentPane().add(dinamis, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setText("SET DURASI LAMPU");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default", "Edit" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        lampu();
        mobil();
    }//GEN-LAST:event_refreshActionPerformed

    private void text4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text4ActionPerformed

    private void text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text1ActionPerformed

    private void text2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text2ActionPerformed

    private void text3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text3ActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        if (String.valueOf(jComboBox9.getSelectedItem()) == "edit") 
        {
            if (
                text1.getText().equals("") || 
                text2.getText().equals("") ||
                text3.getText().equals("") ||
                text4.getText().equals("")
                ) 
            {
                JOptionPane.showMessageDialog(null, "Sorry can't run while its empty, check your input panel");
            }
            else
            {
                //set durasi lampu
                manager.setDurasi(
                    Integer.parseInt(text1.getText()), 
                    Integer.parseInt(text2.getText()), 
                    Integer.parseInt(text3.getText()), 
                    Integer.parseInt(text4.getText())
                );
            }
        }
        else
        {
            //jalan 1, jalan 2, jalan 3, jalan 4
            manager.setDurasi(5, 5, 5, 5);
        }
        
        //set statis/dinamis
        if (!dinamis.isSelected()) 
        {
            manager.setKondisi("statis");
        }
        else
        {
            manager.setKondisi("dinamis");
        }

        //set buffer
        manager.setSize(10);
        manager.start();
    }//GEN-LAST:event_startActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        if (String.valueOf(jComboBox9.getSelectedItem()) == "default")
        {
            text1.setEditable(false);
            text2.setEditable(false);
            text3.setEditable(false);
            text4.setEditable(false);
        }
        else
        {
            text1.setEditable(true);
            text2.setEditable(true);
            text3.setEditable(true);
            text4.setEditable(true);
        }
    }//GEN-LAST:event_jComboBox9ActionPerformed

    /**
     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UI().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel carB1;
    private javax.swing.JLabel carB10;
    private javax.swing.JLabel carB11;
    private javax.swing.JLabel carB2;
    private javax.swing.JLabel carB3;
    private javax.swing.JLabel carB4;
    private javax.swing.JLabel carB5;
    private javax.swing.JLabel carB6;
    private javax.swing.JLabel carB7;
    private javax.swing.JLabel carB8;
    private javax.swing.JLabel carB9;
    private javax.swing.JLabel carL1;
    private javax.swing.JLabel carL10;
    private javax.swing.JLabel carL11;
    private javax.swing.JLabel carL2;
    private javax.swing.JLabel carL3;
    private javax.swing.JLabel carL4;
    private javax.swing.JLabel carL5;
    private javax.swing.JLabel carL6;
    private javax.swing.JLabel carL7;
    private javax.swing.JLabel carL8;
    private javax.swing.JLabel carL9;
    private javax.swing.JLabel carR1;
    private javax.swing.JLabel carR10;
    private javax.swing.JLabel carR11;
    private javax.swing.JLabel carR2;
    private javax.swing.JLabel carR3;
    private javax.swing.JLabel carR4;
    private javax.swing.JLabel carR5;
    private javax.swing.JLabel carR6;
    private javax.swing.JLabel carR7;
    private javax.swing.JLabel carR8;
    private javax.swing.JLabel carR9;
    private javax.swing.JLabel carU1;
    private javax.swing.JLabel carU10;
    private javax.swing.JLabel carU11;
    private javax.swing.JLabel carU2;
    private javax.swing.JLabel carU3;
    private javax.swing.JLabel carU4;
    private javax.swing.JLabel carU5;
    private javax.swing.JLabel carU6;
    private javax.swing.JLabel carU7;
    private javax.swing.JLabel carU8;
    private javax.swing.JLabel carU9;
    private javax.swing.JRadioButton dinamis;
    private javax.swing.JLabel grenB;
    private javax.swing.JLabel grenL;
    private javax.swing.JLabel grenR;
    private javax.swing.JLabel grenU;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel redB;
    private javax.swing.JLabel redL;
    private javax.swing.JLabel redR;
    private javax.swing.JLabel redU;
    private javax.swing.JButton refresh;
    private javax.swing.JButton start;
    private javax.swing.JRadioButton statis;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    private javax.swing.JTextField text3;
    private javax.swing.JTextField text4;
    private javax.swing.JLabel yelB;
    private javax.swing.JLabel yelL;
    private javax.swing.JLabel yelR;
    private javax.swing.JLabel yelU;
    // End of variables declaration//GEN-END:variables
}
