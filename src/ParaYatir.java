
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ParaYatir {

    public ParaYatir(Hesap acc, Database database, ArrayList<Hesap> accounts) {

        JFrame frame = Main.Frame(350, 210);
        JLabel title = Main.Label("Para Yatır", 23);
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel label = Main.Label("Miktar", 20);
        JTextField am = Main.TextField(20);
        panel.add(label);
        panel.add(am);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setBackground(null);
        JButton deposit = Main.Button("Para Yatır", 19);
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double.parseDouble(am.getText().toString());
                } catch (Exception w) {
                    JOptionPane.showMessageDialog(frame, "Miktar Sayı olarak girilmelidir.");
                    return;
                }
                double amount = Double.parseDouble(am.getText().toString());
                acc.setBalance(acc.getBalance() + amount);
                JOptionPane.showMessageDialog(frame, "İşlem Başarıyla Tamamlandı");
                database.saveAccounts(accounts);
                frame.dispose();
            }
        });
        panel2.add(deposit);
        frame.add(title, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}
