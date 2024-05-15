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
        JPanel mainPanel = new JPanel();
        NewTask newFrame = new NewTask(frame, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbTitle = new JLabel();
        lbTitle.setText("Lista de Tarefas:");

        JPanel pnList = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnList.add(lbTitle);

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

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(pnButton);
        mainPanel.add(pnList);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}