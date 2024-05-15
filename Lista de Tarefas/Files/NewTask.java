package Files;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NewTask extends JFrame {
    private ArrayList<String> tasks = new ArrayList<>();
    JList<String> lList;
    JScrollPane scpList;


    public NewTask(JFrame frame, JPanel mainPanel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scpList = new JScrollPane(lList);

        JLabel lbAddTask = new JLabel();
        lbAddTask.setText("Digite a tarefa que deseja adicionar:");

        JTextField tfAddTask = new JTextField("", 20);

        JPanel pnAddlbAddTask = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnAddlbAddTask.add(lbAddTask);
        pnAddlbAddTask.add(tfAddTask);

        JButton btConfirm = new JButton("Confirm");
        NewTask self = this;
        btConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTask(tfAddTask.getText());

                mainPanel.add(scpList);

                self.setVisible(false);
                frame.setVisible(true);
            }
        });

        JPanel pnButtonConfirm = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnButtonConfirm.add(btConfirm);

        JPanel newTaskPanel = new JPanel();
        newTaskPanel.setLayout(new BoxLayout(newTaskPanel, BoxLayout.Y_AXIS));
        newTaskPanel.add(pnAddlbAddTask);
        newTaskPanel.add(pnButtonConfirm);

        this.add(newTaskPanel);
        this.pack();
    }
    
    public void setTask(String newTask) {
        tasks.add(newTask);
        lList = new JList<>(tasks.toArray(new String[0]));
        scpList.setViewportView(lList);
    }
}