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
    String s = "";

    public MyFrame() {
        JTabbedPane tabsLeft = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        for (int i = 1; i <= 3; i++) {
            JPanel panel = new JPanel();



            if (i == 1) {
                JButton button1 = new JButton("Выбрать");
                panel.add(BorderLayout.WEST,button1);// Добавление вкладки
                String[] namber = {
                        "10",
                        "12",
                        "14",
                        "16",
                        "18",
                        "18a",
                        "20",
                        "20a",
                        "22",
                        "22a",
                        "24",
                        "24a",
                        "27",
                        "27a",
                        "30",
                        "30a",
                        "33",
                        "33",
                        "36",
                        "40",
                        "45",
                        "50",
                        "55",
                        "60"
                };
                JComboBox editComboBox = new JComboBox(namber);
                editComboBox.setEditable(true);
                panel.add(editComboBox);
                ImageIcon imageIcon1 = new ImageIcon("двутаврпараметры.jpg");
                JLabel label1 = new JLabel(imageIcon1);
                panel.add(label1);
                ImageIcon imageIcon2 = new ImageIcon("двутаврномер.jpg");
                JLabel label2 = new JLabel(imageIcon2);
                panel.add(label2);
                tabsLeft.addTab("Сечения", panel);                // Подключение мнемоники
                tabsLeft.setMnemonicAt(i - 1, String.valueOf(i).charAt(0));
            }

            if (i == 2) {


                tabsLeft.addTab("Закрепление", panel);                // Подключение мнемоники
                tabsLeft.setMnemonicAt(i - 1, String.valueOf(i).charAt(0));

                ImageIcon imageIcon = new ImageIcon("закрепление.jpg");
                JLabel label = new JLabel(imageIcon);
                panel.add(label);
            }


            if (i==3){


                JLabel lengthLabel = new JLabel("Длина(м): ");
                lengthLabel.setLabelFor(LengthField);
                JTextField lenthfield = new JTextField(10);
                panel.add(lengthLabel);
                panel.add(lenthfield);

                JLabel weightLabel = new JLabel("Вес груза(т): ");
                weightLabel.setLabelFor(WeightField);
                JTextField weightfield = new JTextField(10);
                panel.add(weightLabel);
                panel.add(weightfield);

                JLabel coordinateLabel = new JLabel("Координата груза(м): ");
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


                        Grath be = new Grath();
                        be.paint(length,weight,coordinate,zakrep);
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