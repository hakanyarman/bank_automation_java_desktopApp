
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

public class GirisYap {

    public GirisYap(ArrayList<Hesap> accounts, Database database, int lastaccid) {

        JFrame frame = Main.Frame(500, 300);
        JLabel title = Main.Label("Hakan Bank'a Hoşgeldiniz!", 23);
        JLabel text = Main.Label("test kullanıcısı: id=2, şifre=123", 10);
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel label1 = Main.Label("Hesap IDsi", 20);
        JTextField id = Main.TextField(20);
        JLabel label2 = Main.Label("Şifre", 20);
        JPasswordField passcode = Main.PasswordField(20);
        panel.add(label1);
        panel.add(id);
        panel.add(label2);
        panel.add(passcode);
        JPanel panel2 = new JPanel(new GridLayout(1, 2, 10, 10));
        panel2.setBackground(null);
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton login = Main.Button("Giriş Yap", 19);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id0 = id.getText().toString();
                @SuppressWarnings("deprecation")
                String passcode0 = passcode.getText().toString();
                try {
                    Integer.parseInt(id0);
                } catch (Exception w) {
                    JOptionPane.showMessageDialog(frame, "Hesap IDsi sayı olmalı!");
                    return;
                }
                try {
                    Integer.parseInt(passcode0);
                } catch (Exception w) {
                    JOptionPane.showMessageDialog(frame, "Şifre Sayı cinsinden olmalı");
                    return;
                }
                int id = Integer.parseInt(id0);
                int passcode = Integer.parseInt(passcode0);
                Hesap account = new Hesap();
                boolean exist = false;
                for (Hesap acc : accounts) {
                    if ((acc.getAccid() == id && acc.getPasscode() == passcode)) {
                        exist = true;
                        account = acc;
                    }
                }
                if (exist) {
                    new Menu(account, database, accounts);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Böyle Bir Hesap Bulunmuyor.Lütfen Tekrar deneyiniz veya hesap oluşturunuz.");
                }
            }
        });
        JButton createacc = Main.Button("Müşteri Kaydı Yap", 19);
        createacc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HesapOlustur(lastaccid, accounts, database);
                frame.dispose();
            }
        });
        panel2.add(login);
        panel2.add(createacc);
        frame.add(title, BorderLayout.NORTH);
        frame.add(text, BorderLayout.WEST);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}
