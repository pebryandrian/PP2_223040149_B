
import javax.swing.*;
import java.awt.*;

public class ModifHelloWorldSwing {
    private static void createAndShowGUI() {
        // Membuat JFrame
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menambahkan JLabel dengan teks yang diperbarui
        JLabel label = new JLabel("Hello, Pebry Andrian", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Mengubah Font menjadi Arial, Bold, ukuran 16
        label.setForeground(Color.BLACK); // Mengubah warna teks menjadi hitam

        // Mengatur layout dan menambahkan label
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Mengatur ukuran frame
        frame.setSize(250, 150);
        frame.setLocationRelativeTo(null); // Memposisikan di tengah layar
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Menjalankan GUI di thread yang benar
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
