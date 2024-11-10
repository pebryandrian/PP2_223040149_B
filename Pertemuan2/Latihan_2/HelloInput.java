import java.awt.event.*;
import javax.swing.*;

public class HelloInput extends JFrame {

    public HelloInput() {
        // Mengatur properti JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat label input
        JLabel labelInput = new JLabel("Input Nama");
        labelInput.setBounds(130, 40, 100, 30);

        // Membuat JTextField untuk input
        JTextField textField = new JTextField();
        textField.setBounds(130, 80, 150, 30);

        // Membuat JButton
        JButton button = new JButton("Klik");
        button.setBounds(130, 120, 100, 40);

        // Membuat label output
        JLabel labelOutput = new JLabel("");
        labelOutput.setBounds(130, 180, 200, 30); // Perbesar ukuran agar teks bisa terlihat

        // Menambahkan ActionListener pada button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                labelOutput.setText("Halo, " + nama);
            }
        });

        // Menambahkan komponen ke JFrame
        this.add(button);
        this.add(textField);
        this.add(labelInput);
        this.add(labelOutput);

        // Mengatur ukuran JFrame dan layout
        this.setSize(400, 300);  // Ubah ukuran menjadi angka yang valid
        this.setLayout(null);
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi di thread event-dispatching
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloInput h = new HelloInput();
                h.setVisible(true);
            }
        });
    }
}
