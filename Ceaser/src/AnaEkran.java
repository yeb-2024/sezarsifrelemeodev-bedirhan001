import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnaEkran implements ActionListener {
    private JFrame frame;
    private JButton sifrelemeButonu;
    private JButton sifreCozmeButonu;

    public AnaEkran() {
        frame = new JFrame("Caesar Şifreleme");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel baslik = new JLabel("Caesar Şifreleme");
        baslik.setBounds(90, 20, 150, 20);
        frame.add(baslik);

        sifrelemeButonu = new JButton("Şifreleme Yap");
        sifrelemeButonu.setBounds(75, 60, 150, 30);
        sifrelemeButonu.addActionListener(this);
        frame.add(sifrelemeButonu);

        sifreCozmeButonu = new JButton("Şifre Çöz");
        sifreCozmeButonu.setBounds(75, 100, 150, 30);
        sifreCozmeButonu.addActionListener(this);
        frame.add(sifreCozmeButonu);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sifrelemeButonu) {
            new SifrelemeEkrani();
        } else if (e.getSource() == sifreCozmeButonu) {
            new SifreCozmeEkrani();
        }
        frame.dispose();
    }
}
