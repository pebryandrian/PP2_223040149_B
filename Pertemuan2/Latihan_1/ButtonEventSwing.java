import java.awt.event.*;
import javax.swing.*;

public class ButtonEventSwing extends JFrame {

    private JButton button;  // Inisialisasi button
    private JLabel label;    // Inisialisasi label

    public ButtonEventSwing() {
        // Mengatur properti JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat label dan mengatur posisi serta ukuran
        label = new JLabel("Hello World");
        label.setBounds(130, 40, 200, 30);

        // Membuat button dan mengatur posisi serta ukuran
        button = new JButton("Click Me");
        button.setBounds(130, 100, 100, 30);

        // Menambahkan event listener untuk button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengubah teks label ketika button diklik
                label.setText("Hello Pemrograman");
            }
        });

        // Menambahkan button dan label ke JFrame
        this.add(button);
        this.add(label);

        // Mengatur ukuran JFrame dan layout
        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi Swing di thread event-dispatching
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ButtonEventSwing b = new ButtonEventSwing();
                b.setVisible(true);
            }
        });
    }
}
