import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HelloTextArea extends JFrame {
    
    public HelloTextArea () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk input nama
        JLabel labelInput = new JLabel("Input Nama:");
        labelInput.setBounds(130, 40, 100, 30); // Ukuran label disesuaikan

        // TextField untuk input teks
        JTextField textField = new JTextField();
        textField.setBounds(130, 80, 150, 30); // Ukuran diperbesar

        // Button untuk memproses input
        JButton button = new JButton("Klik");
        button.setBounds(130, 120, 100, 40);

        // TextArea untuk menampilkan output
        JTextArea txOutput = new JTextArea();
        txOutput.setBounds(130, 180, 200, 100); // Ukuran diperbesar

        // ActionListener untuk menangani event tombol
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                txOutput.setText("Halo, " + nama);
                textField.setText(""); // Kosongkan TextField setelah klik
            }
        });

        // Menambahkan komponen ke JFrame
        this.add(button);
        this.add(textField);
        this.add(labelInput);
        this.add(txOutput);

        // Pengaturan JFrame
        this.setSize(400, 400);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloTextArea h = new HelloTextArea();
                h.setVisible(true);
            }
        });
    }
}
