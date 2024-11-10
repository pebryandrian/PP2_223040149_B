import java.awt.event.*;
import javax.swing.*;  

public class HelloRadioButton extends JFrame {

    public HelloRadioButton () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk input nama
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 40, 350, 30);
        
        // TextField untuk input nama
        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        // Label untuk jenis member
        JLabel labelRadio = new JLabel("Jenis Member :");
        labelRadio.setBounds(15, 100, 350, 30);

        // RadioButton untuk pilihan jenis member
        JRadioButton radioButton1 = new JRadioButton("Silver", true);
        radioButton1.setBounds(15, 130, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Gold");
        radioButton2.setBounds(15, 160, 350, 30);

        JRadioButton radioButton3 = new JRadioButton("Platinum");
        radioButton3.setBounds(15, 190, 350, 30);

        // ButtonGroup untuk mengelompokkan RadioButton
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

        // Tombol untuk menyimpan input
        JButton button = new JButton("Simpan");
        button.setBounds(15, 230, 100, 40);

        // TextArea untuk output
        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(15, 280, 350, 150);

        // Event handling untuk tombol simpan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisMember = "";
                if (radioButton1.isSelected()) {
                    jenisMember = radioButton1.getText();
                } else if (radioButton2.isSelected()) {
                    jenisMember = radioButton2.getText();
                } else if (radioButton3.isSelected()) {
                    jenisMember = radioButton3.getText();
                }

                String nama = textField.getText();
                txtOutput.append("Hello, " + nama + "\n");
                txtOutput.append("Anda adalah member " + jenisMember + "\n");
                textField.setText(""); // Kosongkan TextField setelah klik
            }
        });

        // Menambahkan komponen ke JFrame
        this.add(button);
        this.add(textField);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelInput);   
        this.add(txtOutput);

        // Mengatur ukuran JFrame dan layout
        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloRadioButton h = new HelloRadioButton();
                h.setVisible(true);
            }
        });
    }
}
