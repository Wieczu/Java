import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.*;

public class Przycisk extends JFrame
{
	private int startX;
    private int startY;
	private double dystans;
    private long startCzas;
    private double ang;
    private JButton przycisk;
    private Random r = new Random();
    //------------------------
    public static void main(String[] args)
    {
        new Przycisk();
    }
    //------------------------
    public Przycisk()
    {
    	setTitle("Uciekaj¹cy Przycisk!");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        przycisk = new JButton("z³ap mnie!!!");
        przycisk.setBounds(50,50,150,40);
        add(przycisk);
        setVisible(true);
        przycisk.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent me)
            {
            	startX = przycisk.getX();
                startY = przycisk.getY();
                startCzas = System.nanoTime();
                int px = przycisk.getX() - r.nextInt(800);
                int py = przycisk.getY() - r.nextInt(600);
                dystans = Math.sqrt(px * px + py * py);
                ang = Math.atan2(py, px);
            }
        });
        Timer timer = new Timer(1000 / 20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double czas = (System.nanoTime() - startCzas) / 1e6;
                int szybkosc = 500;// piksele na sekunde
                double pok_dystans = Math.min(szybkosc * czas / 1000, dystans);
                int x = startX - (int) (pok_dystans * Math.cos((ang)));
                int y = startY - (int) (pok_dystans * Math.sin((ang)));
                przycisk.setLocation(x, y);
            }
        });
        timer.setRepeats(true);
        timer.start();
    }}
        
       

