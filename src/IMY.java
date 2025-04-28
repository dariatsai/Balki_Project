import javax.swing.*;
import java.awt.*;

public class IMY { // класс с методом main()

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

        JPanel buttonsPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000); // размеры окна
        frame.setLocationRelativeTo(null); // окно - в центре экрана
        frame.setVisible(true);
        while (true) {
            frame.repaint();
        }
    }
}