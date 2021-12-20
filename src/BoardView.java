import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class BoardView implements ActionListener {
    Random random  = new Random();
    JFrame frame = new JFrame();
    JPanel fPanel = new JPanel();
    JPanel pPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JLabel jLabel = new JLabel();
    JButton[] buttons = new JButton[16];
    JButton btnPlay1 = new JButton();
    JButton btnPlay2 = new JButton();
    JButton btnNew = new JButton();
    JButton btnClose = new JButton();
    boolean player1 ;
    boolean player2 ;


    public BoardView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(new Color(240,244,244));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        pPanel.setLayout(new BorderLayout());
        pPanel.setBackground(new Color(150,150,150));
        //pPanel.setBounds(0,0,180,650);

        bPanel.setLayout(new GridLayout(4,4));
        bPanel.setBackground(new Color(150,150,150));
        //bPanel.setSize(650,650);
        bPanel.setBounds(160,0,540,600);

        btnPlay1.setBounds(0, 0, 160, 300);
        btnPlay1.setFont(new Font("MV Boli", Font.BOLD, 35));
        btnPlay1.setFocusable(false);
        btnPlay1.addActionListener(this);
        btnPlay1.setText("Player 1");
        frame.add(btnPlay1);

        btnPlay2.setBounds(0, 300, 160, 300);
        btnPlay2.setFont(new Font("MV Boli", Font.BOLD, 35));
        btnPlay2.setFocusable(false);
        btnPlay2.addActionListener(this);
        btnPlay2.setText("Player 2");
        frame.add(btnPlay2);

        btnNew.setBounds(250,615, 125, 50);
        btnNew.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnNew.setFocusable(false);
        btnNew.addActionListener(this);
        btnNew.setText("New");

        btnClose.setBounds(375, 615, 125, 50);
        btnClose.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnClose.setFocusable(false);
        btnClose.addActionListener(this);
        btnClose.setText("Close");

        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            bPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }
        //fPanel.add(pPanel);
        frame.add(bPanel);
        frame.add(btnNew);
        frame.add(btnClose);
        //frame.add(pPanel, BorderLayout.WEST);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

