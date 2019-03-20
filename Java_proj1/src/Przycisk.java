import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class Przycisk extends JFrame
{
    private JButton przycisk = null;
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
        przycisk.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent me)
            {
                przycisk.setBounds(r.nextInt(800),r.nextInt(600),150,40);
            }
        });
        setVisible(true);
    }
}
