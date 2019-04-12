package JPHomeWork4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class NetChatElements extends JFrame {

    public NetChatElements() {
        setTitle("Net Chat");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200,500,500);

        setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JTextArea chatWindow = new JTextArea(20,30);
        chatWindow.setText("Чатик");
        chatWindow.setEditable(false);
        panel1.setBackground(Color.gray);

        JTextField enterWindow = new JTextField(20);
        enterWindow.setText("");

        JButton enterBtn = new JButton("Нажми меня");


        panel1.add(chatWindow,BorderLayout.CENTER);
        panel2.add(enterWindow,BorderLayout.SOUTH);
        panel2.add(enterBtn,BorderLayout.SOUTH);

        add(panel1, BorderLayout.CENTER);
        add(panel2,BorderLayout.SOUTH);

        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!enterWindow.getText().isEmpty()){
                    chatWindow.setText(enterWindow.getText());
                }
            }
        });

//Пробуем на вкус новый способ

        int condition = JComponent.WHEN_FOCUSED;
        InputMap iMap = enterWindow.getInputMap(condition);
        ActionMap aMap = enterWindow.getActionMap();

        String enter = "enter";
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
        aMap.put(enter, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatWindow.setText(enterWindow.getText());
            }
        });

    }


}
