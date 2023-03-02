package com.company;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Timer;
import com.toedter.calendar.JCalendar;


// center of frame(in first view) - with clock and calender
public class PanelCenter extends JPanel {
    Timer timer;
    JLabel testLabel = new JLabel();
    JPanel timePanel = new JPanel();
    JCalendar jCalender = new JCalendar();

    PanelCenter(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){

        testLabel.setHorizontalAlignment(SwingConstants.CENTER);
        testLabel.setFont(new Font("Arial", Font.BOLD, 25));
        timer = new Timer(1000, e -> updateClock());
        timer.start();

        this.setPreferredSize(new Dimension(280, 250));
        testLabel.setPreferredSize(new Dimension(280, 50));
        timePanel.setPreferredSize(new Dimension(280, 200));
        jCalender.setPreferredSize(new Dimension(280, 200));


        timePanel.add(jCalender, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(testLabel, BorderLayout.PAGE_START);
        this.add(timePanel, BorderLayout.PAGE_END);
    }

    public void updateClock(){
        String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        testLabel.setText(time);
    }
}
