package src;

import controller.UserController;
import model.MyBatisUtil;
import model.UserMapper;
import view.UserView;

import org.apache.ibatis.session.SqlSession;

public class Main {
    public static void main(String[] args) {
        // Membuka sesi dengan MyBatis
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            // Mengambil mapper untuk interaksi dengan database
            UserMapper mapper = session.getMapper(UserMapper.class);

            // Membuat instance dari tampilan (view)
            UserView view = new UserView();

            // Membuat controller yang menghubungkan tampilan dan data
            new UserController(view, mapper);

            // Menampilkan tampilan
            view.setVisible(true);
        } catch (Exception e) {
            // Menangani error jika terjadi
            e.printStackTrace();
        }
    }
}
