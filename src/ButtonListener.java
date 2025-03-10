import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.print(command);
        String[] arr =command.split(" ");

        Grath be = new Grath();
        be.paint(1,2,3,"");
        //Double.parseDouble(arr[3])

    }

}