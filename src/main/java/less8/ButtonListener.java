package less8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField inputField;

    public ButtonListener(JTextField inputField) {

        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();
           if ((inputField.getText().length()==0)&&((btn.getText()=="-")||(btn.getText()=="+")||(btn.getText()=="X")||(btn.getText()=="/")))
               inputField.setText("");
           else {
               if ((btn.getText()=="-")||(btn.getText()=="+")||(btn.getText()=="X")||(btn.getText()=="/"))
               inputField.setText(inputField.getText()+' '+btn.getText()+' ');
               else
               inputField.setText(inputField.getText()+btn.getText());
           }
    }
}
