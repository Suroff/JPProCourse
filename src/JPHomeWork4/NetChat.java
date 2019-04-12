package JPHomeWork4;

import javax.swing.*;

public class NetChat {

    private static NetChatElements mainWindow2;

    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainWindow2 = new NetChatElements();
            }
        });
    }


}
