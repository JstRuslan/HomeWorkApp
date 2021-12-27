package less8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ApplicationForm extends JFrame {

    private JTextField inputField;
    private String resultExp;

    public ApplicationForm() throws HeadlessException {
        setTitle("Calculator v.1.0");
        setBounds(100, 100, 250,350);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setJMenuBar(createMenu());
        setLayout(new BorderLayout());


        add(createTop(), BorderLayout.NORTH);
        add(createBottom(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);
        JMenuItem clear = menuFile.add(new JMenuItem("Clear"));
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });
        JMenuItem exit = menuFile.add(new JMenuItem("Exit"));
        exit.addActionListener(new ExitButtonActionListener());
        return menuBar;
    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);
        return top;
    }

    private JPanel createBottom() {
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        //digits
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4,3));
        ActionListener buttonsListener = new ButtonListener(inputField);

        for (int i = 1; i <=10 ; i++) {
            String buttonTitle = (i==10 ? "0" : String.valueOf(i));
            JButton btn = new JButton(buttonTitle);
            btn.addActionListener(buttonsListener);
            digitsPanel.add(btn);
        }
        JButton clear = new JButton("C");
        clear.setBackground(Color.RED);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });
        digitsPanel.add(clear);

        JButton calc = new JButton("=");
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = 0;
                String[] strList = inputField.getText().split("(\\s)");
                String strResult = "";
                String[] strList2;

                for (int i=0; i<strList.length; i++) {
                    int temp;
                    if (i%2!=0)
                     switch (strList[i]) {
                        case "X":
                            temp = Integer.valueOf(strList[i-1]) * Integer.valueOf(strList[i+1]);
                            strList[i+1] = String.valueOf(temp);
                            strList[i-1] = "null";
                            strList[i] = "null";
                            break;
                         case "/":
                             temp = Integer.valueOf(strList[i-1]) / Integer.valueOf(strList[i+1]);
                             strList[i+1] = String.valueOf(temp);
                             strList[i-1] = "null";
                             strList[i] = "null";
                             break;
                    }

                }

                for (int i=0; i<strList.length; i++){   //remove nullItems
                    if(strList[i].equals("null"))
                        continue;
                    else strResult += strList[i]+" ";
                }

                strList2 = strResult.split("(\\s)");

                if (strList2.length==1) {
                    inputField.setText(strList2[0]);
                }
                else {
                    for (int i = 0; i < strList2.length; i++) {
                        if (i % 2 != 0)
                            switch (strList2[i]) {
                                case "-":
                                    result = Integer.valueOf(strList2[i - 1]) - Integer.valueOf(strList2[i + 1]);
                                    break;
                                case "+":
                                    result = Integer.valueOf(strList2[i - 1]) + Integer.valueOf(strList2[i + 1]);
                                    break;
                            }
                    }
                    inputField.setText(String.valueOf(result));

                }
            }
        });

        digitsPanel.add(calc);
            


        bottom.add(digitsPanel, BorderLayout.CENTER);

        //operators
        JPanel advPanel = new JPanel();
        advPanel.setLayout(new GridLayout(4,1));

        JButton plus = new JButton("+");
        plus.setBackground(Color.LIGHT_GRAY);
        plus.addActionListener(buttonsListener);
        advPanel.add(plus);

        JButton minus = new JButton("-");
        minus.setBackground(Color.LIGHT_GRAY);
        minus.addActionListener(buttonsListener);
        advPanel.add(minus);


        JButton multiply = new JButton("X");
        multiply.setBackground(Color.LIGHT_GRAY);
        multiply.addActionListener(buttonsListener);
        advPanel.add(multiply);

        JButton divide = new JButton("/");
        divide.setBackground(Color.LIGHT_GRAY);
        divide.addActionListener(buttonsListener);
        advPanel.add(divide);

        bottom.add(advPanel, BorderLayout.WEST);


        return bottom;
    }
}
