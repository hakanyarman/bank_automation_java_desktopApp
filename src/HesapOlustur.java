
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class HesapOlustur {

    public HesapOlustur(int lastaccid, ArrayList<Hesap> accounts, Database database) {

        JFrame frame = Main.Frame(500, 400);
        JLabel title = Main.Label("Müşteri Kaydı Yap", 23);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label1 = Main.Label("İsim", 20);
        JLabel label2 = Main.Label("Soyisim", 20);
        JLabel label3 = Main.Label("Bakiye", 20);
        JLabel label4 = Main.Label("Şifre(Sayı Olarak)", 20);
        JLabel label5 = Main.Label("Şifreyi Onayla", 20);

        JTextField firstName = Main.TextField(20);
        JTextField lastName = Main.TextField(20);
        JTextField balance = Main.TextField(20);
        JPasswordField passcode = Main.PasswordField(20);
        JPasswordField passcode2 = Main.PasswordField(20);

        panel.add(label1);
        panel.add(firstName);
        panel.add(label2);
        panel.add(lastName);
        panel.add(label3);
        panel.add(balance);
        panel.add(label4);
        panel.add(passcode);
        panel.add(label5);
        panel.add(passcode2);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setBackground(null);
        JButton createacc = Main.Button("Hesap Oluştur", 19);

        createacc.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstName.getText().toString().equals("")) {
                    JOptionPane.showMessageDialog(frame, "İsim Boş Bırakılamaz");
                    return;
                }
                if (lastName.getText().toString().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Soyisim Boş Bırakılamaz");
                    return;
                }
                try {
                    Double.parseDouble(balance.getText().toString());
                } catch (Exception n1) {
                    JOptionPane.showMessageDialog(frame, "Bakiye Sayı olarak girilmeli.");
                    return;
                }
                try {
                    Integer.parseInt(passcode.getText().toString());
                } catch (Exception n1) {
                    JOptionPane.showMessageDialog(frame, "Şİfre Sayı olarak Girilmeli");
                    return;
                }
                if (!passcode.getText().toString().equals(passcode2.getText().toString())) {
                    JOptionPane.showMessageDialog(frame, "Yanlış Şifre, Tekrar Deneyiniz.");
                    return;
                }
                Hesap acc = new Hesap(
                        firstName.getText().toString(),
                        lastName.getText().toString(), lastaccid,
                        Double.parseDouble(balance.getText().toString()),
                        Integer.parseInt(passcode.getText().toString()));
                accounts.add(acc);
                JOptionPane.showMessageDialog(frame, "Hesabınız Oluşturuldu! Hesap Numaranız:" + lastaccid);
                database.saveAccounts(accounts);
                new Menu(acc, database, accounts);
                frame.dispose();
            }
        });

        panel2.add(createacc, BorderLayout.CENTER);
        frame.add(title, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}
