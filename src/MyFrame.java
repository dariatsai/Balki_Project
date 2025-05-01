import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame {
    boolean text = false;
    String arr[] = new String[4];
    TextField textField;
    JTextField LengthField;
    JTextField WeightField;

    JTextField CoordinateField;
    List<JTextField> textFieldList = new ArrayList<>();
    String s = "";
    String zakrep="";
    String number="";
    double length;
    double weight;
    double coordinate;
    int nomer;
    String[] namber1 = {
            "10", "12", "14", "16", "18", "18a", "20", "20a", "22", "22a", "24", "24a",
            "27", "27a", "30", "30a", "33","36", "40", "45", "50", "55", "60"};
    int[] momentinertsii={
            198,350,572,873,1290,1430,1840,2030,2550,2790,3460,3800,5010,
            5500,7080,7780,9840,13380,19062,27696,39727,55962,76806};

    public MyFrame() {
        JTabbedPane tabsLeft = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        for (int i = 1; i <= 3; i++) {
            JPanel panel = new JPanel(new FlowLayout());


            if (i == 1) {
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
                JButton button1 = new JButton("Выбрать");
                panel.add(BorderLayout.WEST, button1);// Добавление вкладки
                button1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        number = (String) editComboBox.getSelectedItem();
                    }
                });
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

                JLabel namezakreplenie = new JLabel("   Закрепление: ");
                panel.add(namezakreplenie);

                String[] zakreplenie = {
                        "Шарнир",
                        "Защемление"
                };
                JComboBox editComboBox = new JComboBox(zakreplenie);
                editComboBox.setEditable(true);
                panel.add(editComboBox);
                JButton button2 = new JButton("Выбрать");
                panel.add(BorderLayout.WEST, button2);
                button2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        zakrep = (String) editComboBox.getSelectedItem();
                    }
                });


                tabsLeft.addTab("Закрепление", panel);                // Подключение мнемоники
                tabsLeft.setMnemonicAt(i - 1, String.valueOf(i).charAt(0));

                ImageIcon imageIcon = new ImageIcon("закрепление.jpg");
                JLabel label = new JLabel(imageIcon);
                panel.add(label);
            }


            if (i == 3) {


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


                JButton tek = new JButton("Обработка");
                panel.add(tek);


                tek.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        length = Double.parseDouble(lenthfield.getText());
                        weight = Double.parseDouble(weightfield.getText());
                        coordinate = Double.parseDouble(coordinatefield.getText());
                        Grath be = new Grath();
                        be.paint(length, weight, coordinate, zakrep);
                        panel.add(tek);

                        if(zakrep.equals("Шарнир")){
                            for(int i=0;i<namber1.length;i++){
                                if(number.equals(namber1[i])){
                                    nomer=i;
                                    break;
                                }

                            }

                        }else if (zakrep.equals("Защемление")){

                        }
                        JLabel progibLabel = new JLabel("Прогиб ="+nomer);
                        progibLabel.setVerticalAlignment(JLabel.CENTER);
                        progibLabel.setHorizontalAlignment(JLabel.CENTER);
                        progibLabel.setForeground(Color.GREEN);
                        panel.add(progibLabel);
                    }
                });


                tabsLeft.addTab("Нагрузка", panel);// Подключение мнемоники
                tabsLeft.setMnemonicAt(i - 1, String.valueOf(i).charAt(0));
            }

        }

        getContentPane().setLayout(new GridLayout());
        getContentPane().add(tabsLeft);
        this.textField = new TextField("value");
    }

}

