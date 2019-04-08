import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

import javax.swing.*;

public class QuickGUI extends GBFrame {
    //I have ascended past the use of instance variables. This is not even my final form.
    public QuickGUI() {
        QuickServer data = new QuickServer();
        setTitle("Quick");
        addLabel("Input", 1, 1, 1, 1);
        IntegerField input = addIntegerField(0, 1, 2, 1, 1);
        JTextArea text = addTextArea("", 3, 1, 2, 1);

        JButton search = addButton("outputSorted", 2, 2, 1, 1);
        search.addActionListener(e -> {
            if (!input.isValidNumber()) {
                messageBox("error Please input a valid number");
            } else
                text.setText(data.outPut());
            input.requestFocus();
            input.selectAll();
        });
        search.setEnabled(false);

        addButton("Input", 2, 1, 1, 1).addActionListener(e -> {
            if (!input.isValidNumber()) {
                messageBox("error Please input a valid number");
            } else {
                data.addNumber(input.getNumber());
                if (data.getSize() == 10) {
                    //an interesting way of getting around using a local variable
                    ((JButton) e.getSource()).setEnabled(false);
                }
            }
            search.setEnabled(true);
            input.requestFocus();
            input.selectAll();
        });
    }

    public static void main(String[] args) {
        QuickGUI g = new QuickGUI();
        g.setSize(400, 400);
        g.setVisible(true);
    }

    //I have also ascended past the use of the buttonClicked method. Lambdas have granted me too much power.
    public void buttonClicked(JButton button) {

    }
}