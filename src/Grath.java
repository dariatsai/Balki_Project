import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Grath {
    public void paint(double length,double weight,double coordinate,String zakrep) {
        JFrame frame1 = new JFrame("График эпюры моментов от координаты");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setSize(1100, 1100);
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                final int SCALE = 10; // шкала пискселей, размер клетки
                final int WIDTH = 101; // ширина
                int HEIGHT = 101;// высота
                double length1 = (double) Math.round(length/(WIDTH-1)*100)/10;
                g.setColor(Color.GRAY);
                for (int x = 0; x <= WIDTH * SCALE; x += SCALE) {
                    g.drawLine(x, 0, x, HEIGHT * SCALE);
                }
                for (int y = 0; y <= HEIGHT * SCALE; y += SCALE) {
                    g.drawLine(0, y, WIDTH * SCALE, y);
                }
                if(zakrep.equals("Шарнир")) {

                    double ra=(length-coordinate)*weight/length;
                    double rb=coordinate*weight/length;
                    double nagruzka=weight*ra*rb*length;
                    double maxM=ra*coordinate;

                    int coordinate1 = (int) Math.round(coordinate*(WIDTH-1)/length*100)/100;
                    int scale = 1;  // количество знаков после запятой
                    BigDecimal maxp = new BigDecimal(maxM);
                    maxp = maxp.setScale(scale, RoundingMode.HALF_UP);
                    double maxpostroenie = maxp.doubleValue();

                    g.setColor(Color.darkGray);
                    g.fillRect(10, (HEIGHT-1) / 2 * 10 +10, WIDTH*10-10, 20);

                    g.setColor(Color.RED);
                    g.drawLine(0, (HEIGHT-1) / 2 * 10+20, WIDTH * 10, (HEIGHT-1) / 2 * 10+20);
                    g.drawLine(10, 0, 10, HEIGHT * 10);
                    for (int i = 0; i < (HEIGHT-1) / 20; i++) {
                        g.drawString(""+maxpostroenie/10*((HEIGHT-1) / 20-i),10,20+i*100);
                    }
                    g.setColor(Color.RED);
                    for(int i=0;i<=WIDTH/10;i++) {
                        g.drawString("" + i*length1, 100 * i + 10, HEIGHT / 2 * 10 + 30);
                    }
                    g.drawString("Н*м",40,30);
                    g.drawString("М",(WIDTH-1)*10,HEIGHT/2*10);

                    g.setColor(Color.BLUE);
                    g.drawLine(10, (HEIGHT-1) / 2 * 10+20, coordinate1*10+10, 20);
                    g.drawLine(coordinate1*10+10, 20, WIDTH * 10, (HEIGHT-1) / 2 * 10+20);

                }else if (zakrep.equals("Защемление")){

                    double b=length-coordinate;
                    double A=weight*b*b/length/length/length*(3*coordinate+b);
                    double MA=weight*coordinate*b*b/length/length;
                    double MB=weight*coordinate*coordinate*b/length/length;
                    double Mmax=(-1)*A*coordinate+MA;

                    g.setColor(Color.darkGray);
                    g.fillRect(10, (HEIGHT-1) / 2 * 10-10, WIDTH*10-10, 20);

                    g.setColor(Color.RED);
                    g.drawLine(0, (HEIGHT-1) / 2 * 10, WIDTH * 10, (HEIGHT-1) / 2 * 10);
                    g.drawLine(10, 0, 10, HEIGHT * 10);
                    for(int i=0;i<=WIDTH/10;i++) {
                        g.drawString("" + i*length1, 100 * i + 10, HEIGHT / 2 * 10+10);
                    }

                    if(MA>MB) {
                        if (Mmax*(-1) > MB) {
                            double delenie = (double) Math.round(Mmax/5*100) / 100;
                            int coordinate1 = (int) Math.round(coordinate * (WIDTH-1) / length * 1000) / 100+10;
                            int coordinateMa= 10;
                            int coordinateMb=WIDTH*10;

                            g.setColor(Color.RED);
                            g.drawLine(0, (HEIGHT - 1) / 2 * 10, WIDTH * 10, (HEIGHT - 1) / 2 * 10);
                            g.drawLine(10, 0, 10, HEIGHT * 10);

                        }else{

                        }
                    }
                }

            }
        };
        frame1.add(panel);
        frame1.setVisible(true);
    }
}

