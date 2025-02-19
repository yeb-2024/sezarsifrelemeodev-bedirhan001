import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SifreCozmeEkrani implements ActionListener {
    private JFrame frame;
    private JTextField anahtarAlani;
    private JTextField mesajAlani;
    private JTextField sonucAlani;
    private JButton cozButonu;
    private JButton geriButonu;

    public SifreCozmeEkrani() {
        frame = new JFrame("Şifre Çözme Ekranı");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel anahtarLabel = new JLabel("Anahtar (0-25):");
        anahtarLabel.setBounds(30, 30, 100, 20);
        frame.add(anahtarLabel);

        anahtarAlani = new JTextField();
        anahtarAlani.setBounds(140, 30, 200, 25);
        frame.add(anahtarAlani);

        JLabel mesajLabel = new JLabel("Şifreli Mesaj:");
        mesajLabel.setBounds(30, 70, 100, 20);
        frame.add(mesajLabel);

        mesajAlani = new JTextField();
        mesajAlani.setBounds(140, 70, 200, 25);
        frame.add(mesajAlani);

        cozButonu = new JButton("Çöz");
        cozButonu.setBounds(140, 110, 100, 30);
        cozButonu.addActionListener(this);
        frame.add(cozButonu);

        JLabel sonucLabel = new JLabel("Orijinal Metin:");
        sonucLabel.setBounds(30, 160, 150, 20);
        frame.add(sonucLabel);

        sonucAlani = new JTextField();
        sonucAlani.setBounds(140, 160, 200, 25);
        sonucAlani.setEditable(false);
        frame.add(sonucAlani);

        geriButonu = new JButton("Geri");
        geriButonu.setBounds(140, 200, 100, 30);
        geriButonu.addActionListener(this);
        frame.add(geriButonu);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cozButonu) {
            int anahtar = Integer.parseInt(anahtarAlani.getText());
            String sifreliMesaj = mesajAlani.getText();
            sonucAlani.setText(sifreCoz(sifreliMesaj, anahtar));
        } else if (e.getSource() == geriButonu) {
            new AnaEkran();
            frame.dispose();
        }
    }

    private String sifreCoz(String metin, int anahtar) {
        return new SifrelemeEkrani().sifrele(metin, 52 - anahtar);
    }
}
