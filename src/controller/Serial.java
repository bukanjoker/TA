/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author bukanjoker
 */
import gnu.io.*;
import java.awt.HeadlessException;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.UI;

public class Serial implements SerialPortEventListener {
    UI window = null;
    private Enumeration port = null;
    private final HashMap portMap = new HashMap();
    private CommPortIdentifier portIdentifier = null;
    private SerialPort serialPort = null;
    private InputStream inPut = null;
    private OutputStream outPut = null;
    private boolean serialConnected = false;
    final static int TIMEOUT = 2000;
    String dataIn = "";
    String statusPort = "";
    char dataSerial = ' ';
//    String dataComplete;
    int val;

    public Serial(UI window) {
        this.window = window;
    }
    
    public void cekSerialPort() {
        port = CommPortIdentifier.getPortIdentifiers();
        while (port.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier) port.nextElement();
            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                window.jCommPort.addItem(curPort.getName());
                portMap.put(curPort.getName(), curPort);
            }
        }
    }

    final public boolean getConnected() {
        return serialConnected;
    }

    public void setConnected(boolean serialConnected) {
        this.serialConnected = serialConnected;
    }

    public void connect() {
        String selectedPort = (String) window.jCommPort.getSelectedItem();
        portIdentifier = (CommPortIdentifier) portMap.get(selectedPort);
        CommPort commPort = null;
        try {
            commPort = portIdentifier.open(null, TIMEOUT);
            serialPort = (SerialPort) commPort;
            setConnected(true);
            statusPort = "PORT connect successfully";            
            JOptionPane.showMessageDialog(null, statusPort);
            window.bConn.setText("Disconnect");
        } catch (PortInUseException e) {
            statusPort = selectedPort + " is in use. (" + e.toString() + ")";
            JOptionPane.showMessageDialog(null, statusPort);
        } catch (Exception e) {
//            statusPort = "Failed to open " + selectedPort + "(" + e.toString() + ")";
            statusPort = "No PORT Selected";
            JOptionPane.showMessageDialog(null, statusPort);
        }
    }

    public void disconnect() {
         try {
            serialPort.removeEventListener();
            serialPort.close();
            inPut.close();
            setConnected(false);
            statusPort = "PORT disconnect successfully";            
            JOptionPane.showMessageDialog(null, statusPort);
            window.bConn.setText("Connect");
        } catch (IOException e) {
            statusPort = "Failed to close " + serialPort.getName() + "(" + e.toString() + ")";
            JOptionPane.showMessageDialog(null, statusPort);
        } catch (HeadlessException e) {
            statusPort = "Failed to close " + serialPort.getName() + "(" + e.toString() + ")";
            JOptionPane.showMessageDialog(null, statusPort);
        }
    }

    public boolean initIOStream() {
        boolean successful = false;
        try {
            inPut = serialPort.getInputStream();
            outPut = serialPort.getOutputStream();
            
            successful = true;
            return successful;
        } catch (IOException e) {
            statusPort = "I/O Streams failed to open. (" + e.toString() + ")";
            JOptionPane.showMessageDialog(null, statusPort);
            return successful;
        }
    }

    public void sendChar(Byte a){
        try {
            outPut.write(a);
            outPut.flush();
        } catch (IOException ex) {
            System.out.println("Kirim Gagal");
        }
    }
    
    public void kirimData(String str){
        for(int i=0; i<str.length();i++){
            sendChar((byte)str.charAt(i));
        }        
        
        try{
            outPut.write(10);
            outPut.flush();
        }
        catch(IOException ex){
            System.out.println("Kirim Gagal");
        }
    }
    
    public void initListener() {
        try {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        UI main = new UI();
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                if (dataSerial != '\n') {
                    dataSerial = (char) inPut.read();
                    if (dataSerial != '-') {
                        
//                        System.out.print(dataSerial);
                        dataIn = dataIn + dataSerial;
//                        System.out.println("length: "+dataIn.length());
                        val = Character.getNumericValue(dataSerial);
                        if (dataIn.length() == 1) {
                            System.out.println("pos: "+val);
                        }
                        else if (dataIn.length() < 5) {
                            System.out.println("led: "+val);
                        }
                    }
                    else {
                        dataSerial = ' ';
                    }
                }
                else {
                    dataIn = "";
                    dataSerial = ' ';
                }
            } catch (IOException ex) {
                Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
}
