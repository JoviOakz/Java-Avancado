import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Files.NewTask;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        NewTask newFrame = new NewTask(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbTitle = new JLabel();
        lbTitle.setText("Lista de Tarefas:");

        JLabel lbList = new JLabel();
        if (newFrame.getTask(0) == null || newFrame.getTask(0) == "") {
            lbList.setText("");
        } else {
            for (int i = 0; i < newFrame.getSizeTask(); i++) {
                
            }
        }

        JPanel pnList = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnList.add(lbTitle);
        pnList.add(lbList);

        pnList.setLayout(new BoxLayout(pnList, BoxLayout.Y_AXIS));

        JButton btNewTask = new JButton("Add Task");
        btNewTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                newFrame.setVisible(true);
            }
        });

        JPanel pnButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnButton.add(btNewTask);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(pnList);
        mainPanel.add(pnButton);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}