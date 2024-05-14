package Files;

import java.util.ArrayList;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewTask extends JFrame {
    private ArrayList<String> tasks = new ArrayList<>();

    public NewTask(JFrame frame) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

                // Criar função para atualizar o Main e aparecer a lista de tarefas completa toda vez que apertar esse botão.

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
        this.setVisible(true);
    }

    public String getTask(int index) {
        return tasks.get(index);
    }
    
    public void setTask(String newTask) {
        tasks.add(newTask);
    }

    public int getSizeTask() {
        return tasks.size();
    }
}