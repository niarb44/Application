package com.company;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Timer;
import com.toedter.calendar.JCalendar;

/**
 * Center of frame(in first view) - with clock and calender.
 */
public class TimePanel extends JPanel {
    private final JLabel timeLabel = new JLabel();
    private final JPanel timePanel = new JPanel();
    private final JCalendar jCalender = new JCalendar();

    TimePanel(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){

        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        this.setPreferredSize(new Dimension(280, 250));
        timeLabel.setPreferredSize(new Dimension(280, 50));
        timePanel.setPreferredSize(new Dimension(280, 200));
        jCalender.setPreferredSize(new Dimension(280, 200));


        timePanel.add(jCalender, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(timeLabel, BorderLayout.PAGE_START);
        this.add(timePanel, BorderLayout.PAGE_END);
    }

    public void updateClock(){
        String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        timeLabel.setText(time);
    }
}
