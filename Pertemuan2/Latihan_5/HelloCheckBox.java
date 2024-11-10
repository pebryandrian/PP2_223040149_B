import java.awt.event.*;
import javax.swing.*;

public class HelloCheckBox extends JFrame {

    private boolean checkBoxSelected;

    public HelloCheckBox() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk input nama
        JLabel labelInput = new JLabel("Input Nama:");
        labelInput.setBounds(15, 40, 350, 30); // Lebih besar ukurannya

        // TextField untuk input teks
        JTextField textField = new JTextField();
        textField.setBounds(15, 80, 350, 30);

        // CheckBox untuk menyetujui syarat dan ketentuan
        JCheckBox checkBox = new JCheckBox("Saya Menyetujui syarat dan ketentuan yang berlaku");
        checkBox.setBounds(15, 120, 350, 30);   

        // Tombol untuk simpan data
        JButton button = new JButton("Simpan");
        button.setBounds(15, 170, 350, 40);

        // TextArea untuk output
        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(15, 230, 350, 200); // Mengubah posisi agar tidak menumpuk

        // Listener untuk perubahan state di CheckBox
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == ItemEvent.SELECTED;
            }
        });

        // ActionListener untuk tombol simpan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBoxSelected) {
                    String nama = textField.getText();
                    txtOutput.append("Hello, " + nama + "\n");
                    textField.setText(""); // Kosongkan TextField setelah klik
                } else {
                    txtOutput.append("Anda tidak mencentang kotak persetujuan\n");
                }
            }
        });

        // Menambahkan komponen ke JFrame
        this.add(button);
        this.add(textField);
        this.add(checkBox);
        this.add(labelInput);   
        this.add(txtOutput);

        // Mengatur ukuran dan layout JFrame
        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloCheckBox h = new HelloCheckBox();
                h.setVisible(true);
            }
        });
    }
}
