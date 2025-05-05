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
    double progib;
    int E=2000;
    int prochnost0=225;
    double prochnost;

    String[] namber1 = {
            "10", "12", "14", "16", "18", "18a", "20", "20a", "22", "22a", "24", "24a",
            "27", "27a", "30", "30a", "33","36", "40", "45", "50", "55", "60"};
    double[] momentinertsii={
            198,350,572,873,1290,1430,1840,2030,2550,2790,3460,3800,5010,
            5500,7080,7780,9840,13380,19062,27696,39727,55962,76806};
    double [] Wx={
            39.7,58.4,81.7,109,143,159,184,203,232,254,289,
            317,371,407,472,518,597,743,953,1231,1589,2035,2560};

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

                JLabel weightLabel = new JLabel("Вес груза(м): ");
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
                        weight = 9.81 * Double.parseDouble(weightfield.getText());
                        coordinate = Double.parseDouble(coordinatefield.getText());
                        Grath be = new Grath();
                        be.paint(length, weight, coordinate, zakrep);
                        panel.add(tek);


                        if (zakrep.equals("Шарнир")) {
                            for (int i = 0; i < namber1.length; i++) {
                                if (number.equals(namber1[i])) {
                                    nomer = i;
                                    break;
                                }
                            }
                            double b = Math.max(coordinate,length-coordinate);
                            progib =-1*weight*b*(length*length-b*b)/9/length/E/momentinertsii[nomer]*Math.pow((length*length-b*b)/3,0.5);
                            double ra=(length-coordinate)*weight/length;
                            double maxM=ra*coordinate;
                            prochnost=maxM/Wx[nomer];



                        } else if (zakrep.equals("Защемление")) {
                            for (int i = 0; i < namber1.length; i++) {
                                if (number.equals(namber1[i])) {
                                    nomer = i;
                                    break;
                                }
                            }
                            double b=length-coordinate;
                            progib=-1*weight*Math.pow(coordinate*b/length,3)/3/E/momentinertsii[nomer];

                        }
                        JLabel progibLabel = new JLabel("                                                       ПРОГИБ =" + progib+" м");
                        progibLabel.setVerticalAlignment(JLabel.CENTER);
                        progibLabel.setHorizontalAlignment(JLabel.CENTER);
                        progibLabel.setForeground(Color.BLUE);
                        panel.add(progibLabel);
                        JLabel prochnostLabel = new JLabel("                                                       ПРОЧНОСТЬ =" + prochnost);
                        prochnostLabel.setVerticalAlignment(JLabel.NORTH);
                        prochnostLabel.setHorizontalAlignment(JLabel.CENTER);
                        if(prochnost<prochnost0){
                            prochnostLabel.setForeground(Color.green);
                            panel.add(prochnostLabel);
                            ImageIcon imageIcon4 = new ImageIcon("норма.jpg");
                            JLabel label4 = new JLabel(imageIcon4);
                            panel.add(label4);
                        }else{
                            prochnostLabel.setForeground(Color.RED);
                            panel.add(prochnostLabel);
                            ImageIcon imageIcon3 = new ImageIcon("перегруз.jpg");
                            JLabel label3 = new JLabel(imageIcon3);
                            panel.add(label3);

                        }

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

