package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

public class PanelCenter extends JPanel {

    protected JTextField textCenter1 = new JTextField("Title");
    private JTextField textCenter2 = new JTextField("Contents");

    private Timer timer;
    private DateFormat fmt = DateFormat.getTimeInstance(DateFormat.LONG);
    private Calendar calendar = Calendar.getInstance();
    JLabel testLabel = new JLabel();


    PanelCenter(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){

        testLabel.setHorizontalAlignment(SwingConstants.CENTER);
        testLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        timer = new Timer(1000, e -> updateClock());
        timer.start();

        this.setPreferredSize(new Dimension(280, 250));
        textCenter1.setPreferredSize(new Dimension(280, 50));
        testLabel.setPreferredSize(new Dimension(280, 50));
        textCenter2.setPreferredSize(new Dimension(280, 200));

        this.setLayout(new BorderLayout());
        this.add(testLabel, BorderLayout.PAGE_START);
        this.add(textCenter2, BorderLayout.PAGE_END);

    }

    public void updateClock(){
        String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        testLabel.setText(time);
    }

}
