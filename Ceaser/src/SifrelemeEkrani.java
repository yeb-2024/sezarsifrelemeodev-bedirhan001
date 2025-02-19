import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SifrelemeEkrani implements ActionListener {
    private JFrame frame;
    private JTextField anahtarAlani;
    private JTextField mesajAlani;
    private JTextField sonucAlani;
    private JButton sifreleButonu;
    private JButton geriButonu;

    public SifrelemeEkrani() {
        frame = new JFrame("Şifreleme Ekranı");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel anahtarLabel = new JLabel("Anahtar (0-25):");
        anahtarLabel.setBounds(30, 30, 100, 20);
        frame.add(anahtarLabel);

        anahtarAlani = new JTextField();
        anahtarAlani.setBounds(140, 30, 200, 25);
        frame.add(anahtarAlani);

        JLabel mesajLabel = new JLabel("Mesaj:");
        mesajLabel.setBounds(30, 70, 100, 20);
        frame.add(mesajLabel);

        mesajAlani = new JTextField();
        mesajAlani.setBounds(140, 70, 200, 25);
        frame.add(mesajAlani);

        sifreleButonu = new JButton("Şifrele");
        sifreleButonu.setBounds(140, 110, 100, 30);
        sifreleButonu.addActionListener(this);
        frame.add(sifreleButonu);

        JLabel sonucLabel = new JLabel("Şifrelenmiş Metin:");
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
        if (e.getSource() == sifreleButonu) {
            int anahtar = Integer.parseInt(anahtarAlani.getText());
            String mesaj = mesajAlani.getText();
            sonucAlani.setText(sifrele(mesaj, anahtar));
        } else if (e.getSource() == geriButonu) {
            new AnaEkran();
            frame.dispose();
        }
    }

    String sifrele(String metin, int anahtar) {
        String alfabe = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String yeniMetin = "";
        for (int i = 0; i < metin.length(); i++) {
            char c = metin.charAt(i);
            int index = alfabe.indexOf(c);
            if (index != -1) {
                int yeniIndex = (index + anahtar) % alfabe.length();
                yeniMetin += alfabe.charAt(yeniIndex);
            } else {
                yeniMetin += c;
            }
        }
        return yeniMetin;
    }
}
