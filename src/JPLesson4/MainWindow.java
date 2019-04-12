package JPLesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        setTitle("Application");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200,500,500);

        setLayout(new BorderLayout());
//        setLayout(new FlowLayout());
        JPanel panel1 = new JPanel();

        JButton button1 = new JButton("Button1");
        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainWindow.this,"Hell");
            }
        });
        JButton button2 = new JButton("Button2");
        JButton button3 = new JButton("Button3");
        JButton button4 = new JButton("Button4");
        JButton button5 = new JButton("Button5");

        panel1.add(button1,BorderLayout.CENTER);
        panel1.add(button2,BorderLayout.EAST);
        panel1.add(button3,BorderLayout.WEST);
        panel1.add(button4,BorderLayout.NORTH);
        panel1.add(button5,BorderLayout.SOUTH);

        add(panel1, BorderLayout.CENTER);
        JPanel panel2 = new JPanel();

        add(panel2, BorderLayout.NORTH);
    }
}
