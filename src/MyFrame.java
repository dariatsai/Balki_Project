import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame implements KeyEventDispatcher {
    boolean text = false;
    String arr[] = new String[4];
    TextField textField;
    JTextField LengthField;
    JTextField WeightField;
    JTextField CoordinateField;
    List<JTextField> textFieldList = new ArrayList<>();
    boolean sechen = false;
    boolean kreplenia = false;
    String s = "";

    public MyFrame() {
        JTabbedPane tabsLeft = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        for (int i = 1; i <= 3; i++) {
            JPanel panel = new JPanel();
            //GridLayout layout = new GridLayout(2, 0, 5, 12);
            //panel.setLayout(layout);


            if (i == 1) {
                JButton button1 = new JButton("Button");
                //button1.setBounds(1, 800, 200, 100);
                panel.add(BorderLayout.WEST,button1);
                //JPanel p = new JPanel(new SpringLayout());
                //panel.add(p);                // Добавление вкладки
                tabsLeft.addTab("Сечения", panel);                // Подключение мнемоники
                tabsLeft.setMnemonicAt(i - 1, String.valueOf(i).charAt(0));
            }


            if (i == 2) {


                tabsLeft.addTab("Закрепление", panel);                // Подключение мнемоники
                tabsLeft.setMnemonicAt(i - 1, String.valueOf(i).charAt(0));

                ImageIcon imageIcon = new ImageIcon("C:\\Users\\41570\\Downloads\\закрепление.jpg");
                JLabel label = new JLabel(imageIcon);
                panel.add(label);
            }


            if (i==3){
                panel.setLayout(new BorderLayout());

                JLabel lengthLabel = new JLabel("Длина: ");
                lengthLabel.setLabelFor(LengthField);
                JTextField lenthfield = new JTextField(10);
                panel.add(lengthLabel);
                panel.add(lenthfield);

                JLabel weightLabel = new JLabel("Вес груза: ");
                weightLabel.setLabelFor(WeightField);
                JTextField weightfield = new JTextField(10);
                panel.add(weightLabel);
                panel.add(weightfield);

                JLabel coordinateLabel = new JLabel("Координата груза: ");
                coordinateLabel.setLabelFor(WeightField);
                JTextField coordinatefield = new JTextField(10);
                panel.add(coordinateLabel);
                panel.add(coordinatefield);

                JLabel namezakreplenie = new JLabel("   Закрепление: ");
                panel.add(namezakreplenie);

                String[] zakreplenie = {
                        "Шарнир",
                        "Защемление"
                };
                JComboBox editComboBox = new JComboBox(zakreplenie);
                editComboBox.setEditable(true);
                panel.add(editComboBox);

                JButton tek = new JButton("Обработка");


                tek.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String zakrep =(String) editComboBox.getSelectedItem();
                        double length = Double.parseDouble(lenthfield.getText());
                        double weight = Double.parseDouble(weightfield.getText());
                        double coordinate= Double.parseDouble(coordinatefield.getText());


                        Grath be = new Grath();  be.paint(length,weight,coordinate,zakrep);
                    }
                });
                panel.add(tek);
                tabsLeft.addTab("Нагрузка", panel);                // Подключение мнемоники
                tabsLeft.setMnemonicAt(i - 1, String.valueOf(i).charAt(0));
            }

        }
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(tabsLeft);
        this.textField = new TextField("value");
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (text) {
            if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_1) {
                s += '1';
            }
        }
        return false;
    }
}