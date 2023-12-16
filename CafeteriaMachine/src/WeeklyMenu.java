import javax.swing.*;
import java.awt.*;


public class WeeklyMenu {

    public JFrame frame;

    public int index;
    public static final String[] IMAGES = {
            "res/1.png",
            "res/2.png",
            "res/3.png",
            "res/4.png",

    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                WeeklyMenu window = new WeeklyMenu();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public WeeklyMenu() {
        initialize();
    }


    public void initialize() {
        frame = new JFrame();
        frame.setBounds(1000, 1000, 4500, 4500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JLabel lblImage = new JLabel();
        lblImage.setBounds(93, 10, 256, 256);
        frame.getContentPane().add(lblImage);

        JButton btnPrev = new JButton("이전");
        btnPrev.setBounds(56, 321, 141, 80);
        frame.getContentPane().add(btnPrev);

        JButton btnNext = new JButton("다음");
        btnNext.setBounds(245, 321, 141, 80);
        frame.getContentPane().add(btnNext);
    }

}