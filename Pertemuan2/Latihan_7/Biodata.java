import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class Biodata extends JFrame {

    private JTextField textFieldName;
    private JTextField textFieldPhone;
    private JRadioButton radioMale;
    private JRadioButton radioFemale;
    private JCheckBox checkBoxForeign;
    private JList<String> accountTypeList;
    private JSpinner spinnerTransactionFrequency;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextArea txtOutput;
    private JSpinner spinnerDateOfBirth;

    public Biodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("User Information Form");

        // Mengatur layout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Membuat Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuReset = new JMenuItem("Reset");
        JMenuItem menuExit = new JMenuItem("Exit");

        menuFile.add(menuReset);
        menuFile.add(menuExit);
        menuBar.add(menuFile);
        this.setJMenuBar(menuBar);

        menuReset.addActionListener(e -> resetForm());
        menuExit.addActionListener(e -> System.exit(0));

        // Label dan Text Field untuk Nama
        JLabel labelName = new JLabel("Nama:");
        textFieldName = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(labelName, gbc);
        gbc.gridx = 1;
        this.add(textFieldName, gbc);

        // Label dan Text Field untuk Nomor HP
        JLabel labelPhone = new JLabel("No HP:");
        textFieldPhone = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(labelPhone, gbc);
        gbc.gridx = 1;
        this.add(textFieldPhone, gbc);

        // Label untuk Tanggal Lahir
        JLabel labelDateOfBirth = new JLabel("Tanggal Lahir:");
        spinnerDateOfBirth = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerDateOfBirth, "dd-MM-yyyy");
        spinnerDateOfBirth.setEditor(dateEditor);
        spinnerDateOfBirth.setValue(new Date());

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(labelDateOfBirth, gbc);
        gbc.gridx = 1;
        this.add(spinnerDateOfBirth, gbc);

        // Label untuk Jenis Kelamin
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        radioMale = new JRadioButton("Laki-laki", true);
        radioFemale = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(labelGender, gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        genderPanel.add(radioMale);
        genderPanel.add(radioFemale);
        this.add(genderPanel, gbc);

        // Checkbox untuk Warga Negara Asing
        checkBoxForeign = new JCheckBox("Warga Negara Asing");

        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(checkBoxForeign, gbc);

        // Label untuk Jenis Tabungan
        JLabel labelAccountType = new JLabel("Jenis Tabungan:");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Tabungan Regular");
        listModel.addElement("Tabungan Bisnis");
        listModel.addElement("Tabungan Haji");
        listModel.addElement("Tabungan Pendidikan");

        accountTypeList = new JList<>(listModel);
        accountTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane accountTypeScrollPane = new JScrollPane(accountTypeList);
        accountTypeScrollPane.setPreferredSize(new Dimension(150, 80));

        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(labelAccountType, gbc);
        gbc.gridx = 1;
        this.add(accountTypeScrollPane, gbc);

        // Label untuk Frekuensi Transaksi
        JLabel labelTransactionFrequency = new JLabel("Frekuensi Transaksi/Bulan:");
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
        spinnerTransactionFrequency = new JSpinner(spinnerModel);

        gbc.gridx = 0;
        gbc.gridy = 6;
        this.add(labelTransactionFrequency, gbc);
        gbc.gridx = 1;
        this.add(spinnerTransactionFrequency, gbc);

        // Label dan Password Field untuk Password
        JLabel labelPassword = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        gbc.gridx = 0;
        gbc.gridy = 7;
        this.add(labelPassword, gbc);
        gbc.gridx = 1;
        this.add(passwordField, gbc);

        // Label dan Password Field untuk Confirm Password
        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField(20);

        gbc.gridx = 0;
        gbc.gridy = 8;
        this.add(labelConfirmPassword, gbc);
        gbc.gridx = 1;
        this.add(confirmPasswordField, gbc);

        // Tombol Simpan
        JButton buttonSave = new JButton("Simpan");
        buttonSave.addActionListener(e -> saveData());

        gbc.gridx = 1;
        gbc.gridy = 9;
        this.add(buttonSave, gbc);

        // Area untuk Menampilkan Output
txtOutput = new JTextArea();
txtOutput.setEditable(false);
txtOutput.setLineWrap(true); // Membuat teks otomatis terwrap
txtOutput.setWrapStyleWord(true); // Membuat teks wrap pada kata, bukan karakter

JScrollPane outputScrollPane = new JScrollPane(txtOutput);
outputScrollPane.setPreferredSize(new Dimension(350, 100));

gbc.gridx = 0;
gbc.gridy = 10;
gbc.gridwidth = 2;
gbc.fill = GridBagConstraints.HORIZONTAL; // Mengubah pengaturan GridBagConstraints menjadi HORIZONTAL
this.add(outputScrollPane, gbc);


        // Mengatur ukuran JFrame
        this.setSize(450, 600);
        this.setVisible(true);
    }

    private void saveData() {
        String name = textFieldName.getText();
        String phone = textFieldPhone.getText();
        Date dateOfBirth = (Date) spinnerDateOfBirth.getValue();
        String gender = radioMale.isSelected() ? "Laki-laki" : "Perempuan";
        boolean isForeign = checkBoxForeign.isSelected();
        String accountType = accountTypeList.getSelectedValue();
        int transactionFrequency = (int) spinnerTransactionFrequency.getValue();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        StringBuilder output = new StringBuilder();
        output.append("Nama: ").append(name).append("\n")
              .append("No HP: ").append(phone).append("\n")
              .append("Tanggal Lahir: ").append(new java.text.SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth)).append("\n")
              .append("Jenis Kelamin: ").append(gender).append("\n")
              .append("Warga Negara Asing: ").append(isForeign ? "Ya" : "Tidak").append("\n")
              .append("Jenis Tabungan: ").append(accountType != null ? accountType : "Belum dipilih").append("\n")
              .append("Frekuensi Transaksi/Bulan: ").append(transactionFrequency).append("\n");

        if (password.equals(confirmPassword)) {
            output.append("Password: Valid\n");
        } else {
            output.append("Password dan Confirm Password tidak cocok\n");
        }

        txtOutput.setText(output.toString());
    }

    private void resetForm() {
        textFieldName.setText("");
        textFieldPhone.setText("");
        spinnerDateOfBirth.setValue(new Date());
        radioMale.setSelected(true);
        checkBoxForeign.setSelected(false);
        accountTypeList.clearSelection();
        spinnerTransactionFrequency.setValue(1);
        passwordField.setText("");
        confirmPasswordField.setText("");
        txtOutput.setText("");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Biodata::new);
    }
}
