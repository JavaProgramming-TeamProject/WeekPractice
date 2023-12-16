import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Cafeteria extends JFrame {

    public Cafeteria() {

        setTitle("학생식당 자판기");

        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();


        JLabel jl1 = new JLabel("원하는 메뉴 선택");


        JRadioButton jrb1 = new JRadioButton("정식(4000)");
        JRadioButton jrb2 = new JRadioButton("일품(4500)");
        JRadioButton jrb3 = new JRadioButton("분식(2000)");
        JRadioButton jrb4 = new JRadioButton("면류(3000)");

        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.add(jrb4);


        JLabel jl2 = new JLabel("수   량 : ");
        JTextField su = new JTextField(5);

        JLabel jl3 = new JLabel("입금액 : ");
        JTextField money = new JTextField(10);


        JTextArea jta = new JTextArea(5, 30);
        JScrollPane jsp = new JScrollPane(
                jta,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jta.setLineWrap(true);


        JButton jb1 = new JButton("계   산");
        JButton jb2 = new JButton("종   료");
        JButton jb3 = new JButton("취   소");


        jp1.add(jl1);


        jp2.add(jrb1);
        jp2.add(jrb2);
        jp2.add(jrb3);
        jp2.add(jrb4);


        jp3.add(jl2);
        jp3.add(su);
        jp3.add(jl3);
        jp3.add(money);


        jp4.add(jb1);
        jp4.add(jb2);
        jp4.add(jb3);


        JPanel pg1 = new JPanel(new BorderLayout());
        JPanel pg2 = new JPanel(new BorderLayout());


        pg1.add(jp1, BorderLayout.NORTH);
        pg1.add(jp2, BorderLayout.CENTER);


        pg2.add(jp3, BorderLayout.NORTH);
        pg2.add(jsp, BorderLayout.CENTER);
        pg2.add(jp4, BorderLayout.SOUTH);


        add(pg1, BorderLayout.NORTH);
        add(pg2, BorderLayout.CENTER);


        setBounds(200, 200, 300, 300);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);


        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String mealStr = null;
                int mealInt = 0;

                if (jrb1.isSelected()) {
                    mealStr = "정식";
                    mealInt = 4000;
                } else if (jrb2.isSelected()) {
                    mealStr = "일품";
                    mealInt = 4500;
                } else if (jrb3.isSelected()) {
                    mealStr = "분식";
                    mealInt = 2000;
                } else if (jrb4.isSelected()) {
                    mealStr = "면류";
                    mealInt = 3000;
                }

                int amount = Integer.parseInt(su.getText());

                int money1 = Integer.parseInt(money.getText());


                int sum = amount * mealInt;


                int total = sum;

                int result = money1 - total;
                if (money1 < total) {
                    Lessmoney lessmoney = new Lessmoney();
                    lessmoney.excute();
                }

                jta.append("식사종류 : " + mealStr + "\n");
                jta.append("식사금액 : " + String.format("%,d원", mealInt) + "\n");
                jta.append("수     량 : " + amount + "\n");
                jta.append("총 금 액 : " + String.format("%,d원", total) + "\n");
                jta.append("입 금 액 : " + String.format("%,d원", money1) + "\n");
                jta.append((money1 < total) ? "발권 되지 않았습니다. 다시 시도해주세요." : "거스름돈 : " + String.format("%,d원", result) + "\n");

                bg.clearSelection();
                su.setText(null);
                money.setText(null);
            }
        });

        jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        jb3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                bg.clearSelection();
                su.setText(null);
                money.setText(null);
                jta.setText(null);

            }
        });

    }


}