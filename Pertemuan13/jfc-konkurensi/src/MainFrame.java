import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static void main(String[] args) {
        // Membuat Frame Utama
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contoh Konkurensi di Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            // Label Untuk Status
            JLabel statusLabel = new JLabel("Tekan Tombol Untuk Mulai Tugas Berat", JLabel.CENTER);

            // Tombol Untuk Memulai Proses
            JButton startButton = new JButton("Mulai");

            // Progress Bar
            JProgressBar progressBar = new JProgressBar(0, 60);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);

            // Tambahkan komponen ke Frame
            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(startButton, BorderLayout.CENTER);
            frame.add(progressBar, BorderLayout.SOUTH);

            // Tombol aksi
            startButton.addActionListener(e -> {
                // Disable tombol selama proses berlangsung
                startButton.setEnabled(false);
                statusLabel.setText("Proses dimulai...");

                // Gunakan SwingWorker untuk menjalankan tugas berat
                SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 1; i <= 60; i++) {
                            Thread.sleep(1000); // Simulasi tugas berat
                            publish(i); // Kirim progres saat ini
                        }
                        return null;
                    }

                    @Override
                    protected void process(java.util.List<Integer> chunks) {
                        int progress = chunks.get(chunks.size() - 1);
                        progressBar.setValue(progress);
                        statusLabel.setText("Proses berjalan... " + progress + "%");
                    }

                    @Override
                    protected void done() {
                        statusLabel.setText("Proses selesai!");
                        startButton.setEnabled(true);
                    }
                };

                worker.execute();
            });

            // Tampilkan Frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
