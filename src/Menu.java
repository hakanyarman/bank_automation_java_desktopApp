
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

public class Menu {

    public Menu(Hesap acc, Database database, ArrayList<Hesap> accounts) {



        JFrame frame = Main.Frame(600, 300);
        JLabel title = Main.Label("Hoşgeldiniz! " + acc.getFirstName() + " " + acc.getLastName(), 23);
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton deposit = Main.Button("Para Yatır", 22);
        JButton withdraw = Main.Button("Para Çek", 22);
        JButton balance = Main.Button("Bakiye", 22);
        JButton krediBasvurusu = Main.Button("Kredi Başvurusu", 22);
        JButton dolaraCevir = Main.Button("Bakiyeyi Dolara Çevir", 22);
        JButton cikisYap = Main.Button("Çıkış Yap", 22);


        panel.add(deposit);
        panel.add(withdraw);
        panel.add(balance);
        panel.add(krediBasvurusu);
        panel.add(dolaraCevir);
        panel.add(cikisYap);


        cikisYap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        dolaraCevir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,  "Bakiyeniz dolar cinsinden:" + ( acc.getBalance()/20) + " $");
            }
        });


        krediBasvurusu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acc.getBalance() < 500) {
                    JOptionPane.showMessageDialog(frame,  "kredi başvurusu yapabilmek için bakiyeniz en az 500 tl olmalı. eksik bakiyeniz:" + (500- acc.getBalance()) + " TL");
                }else {
                    JOptionPane.showMessageDialog(frame,  "kredi başvurunuz onay bekliyor.");

                }
            }
        });


        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ParaYatir(acc, database, accounts);
            }
        });

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ParaCek(acc, database, accounts);
            }
        });

        balance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"Bakiyeniz:: " + acc.getBalance() + " TL");
            }
        });

        frame.add(title, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

}
