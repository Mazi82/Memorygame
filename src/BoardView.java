import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.*;

public class BoardView  extends javax.swing.JFrame implements ActionListener{
    // Variables declaration
    int seconds = 0;
    Player player = new Player();
    Visibility[] tiles = new Visibility[16];
    ImageIcon[] icons = new ImageIcon[12];
    int status, score1,score2;
    Visibility predict1, predict2;
    private boolean won;
    JFrame frame = new JFrame();
    JPanel bPanel = new JPanel();
    JLabel play1 = new JLabel();
    JLabel play2 = new JLabel();
    JButton btnPlay1 = new JButton();
    JButton btnPlay2 = new JButton();
    JButton btnClose = new JButton();
    JButton btnNew = new JButton();
    JLabel Time_label = new JLabel();
    JLabel seconds_left = new JLabel();

    Timer timer = new Timer(5000, e -> {
        seconds++;
        seconds_left.setText(String.valueOf(seconds));
        if(seconds == 30){
            JOptionPane.showMessageDialog(bPanel, "Sorry! Time's UP");
            initGame();
            btnPlay1.setText(String.valueOf(0));
            btnPlay2.setText(String.valueOf(0));
            seconds = 0;
        }
    });
    public BoardView() {
        if(player.isPlayer1_turn()){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
                btnPlay1.setBackground(Color.YELLOW);
                btnPlay2.setBackground(null);
        }else {
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
               btnPlay2.setBackground(Color.YELLOW);
               btnPlay1.setBackground(null);
        }
       // timer.start();
        initComponents();
        addToFrame();
        initIcons();
        initGame();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        frame.setTitle("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(233, 236, 236));
        frame.setSize(702, 728);
        frame.setLayout(null);
        frame.setResizable(false);

        bPanel.setLayout(new GridLayout(4, 4));
        bPanel.setBackground(new Color(238, 238, 238));
        bPanel.setBounds(162, 0, 540, 600);

        play1.setBounds(2, 50, 160, 25);
        play1.setBackground(new Color(50, 50, 60));
        play1.setForeground(new Color(0, 0, 0, 253));
        play1.setFont(new Font("MV Boli", Font.PLAIN, 25));
        play1.setHorizontalAlignment(JTextField.CENTER);
        play1.setText("Player 1");

        btnPlay1.setBounds(2, 0, 160, 300);
        btnPlay1.setFont(new Font("MV Boli", Font.BOLD, 35));
        btnPlay1.setForeground(new Color(0, 0, 0, 253));
        //btnPlay1.setOpaque(true);
        btnPlay1.setFocusable(false);
        btnPlay1.setText(String.valueOf(score1));
        btnPlay1.setToolTipText("Score for Player one");
        btnPlay1.setBorder(BorderFactory.createBevelBorder(1));
        btnPlay1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            }
        });

        play2.setBounds(2, 350, 160, 25);
        play2.setBackground(new Color(50, 50, 60));
        play2.setForeground(new Color(0, 0, 0, 253));
        play2.setFont(new Font("MV Boli", Font.PLAIN, 25));
        play2.setHorizontalAlignment(JTextField.CENTER);
        play2.setText("Player 2");

        btnPlay2.setBounds(2, 300, 160, 300);
        btnPlay2.setFont(new Font("MV Boli", Font.BOLD, 35));
        btnPlay2.setForeground(new Color(0, 0, 0, 253));
        //tnPlay2.setOpaque(true);
        btnPlay2.setFocusable(false);
        btnPlay2.setText(String.valueOf(score1));
        btnPlay2.setToolTipText("Score for Player two");
        btnPlay2.setBorder(BorderFactory.createBevelBorder(1));
        btnPlay2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            }
        });

        btnNew.setBounds(228, 615, 125, 50);
        btnNew.setBackground(new Color(238, 238, 238));
        btnNew.setFont(new Font("MV Boli", 0, 18));
        btnNew.setForeground(new Color(153, 153, 255));
        btnNew.setText("New");
        btnNew.setToolTipText("Play new Game");
        btnNew.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newActionPerformed();
            }
        });
        btnClose.setBounds(353, 615, 125, 50);
        btnClose.setBackground(new Color(238, 238, 238));
        btnClose.setFont(new Font("MV Boli", 0, 18));
        btnClose.setForeground(new Color(153, 153, 255));
        btnClose.setText("Close");
        btnClose.setToolTipText("Close the Game");
        btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        seconds_left.setBounds(582, 627, 110, 70);
        seconds_left.setBackground(new Color(0, 0, 0, 181));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Ink Free", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setToolTipText("Timer");
        seconds_left.setText(String.valueOf(seconds));

        Time_label.setBounds(584, 602, 100, 20);
        Time_label.setBackground(new Color(50, 50, 50));
        Time_label.setForeground(new Color(255, 0, 0));
        Time_label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        Time_label.setHorizontalAlignment(JTextField.CENTER);
        Time_label.setText("Timer >:D");
        pack();
    }
    private void addToFrame(){
        frame.add(Time_label);
        frame.add(bPanel);
        frame.add(btnClose);
        frame.add(seconds_left);
        frame.add(btnPlay1);
        frame.add(btnPlay2);
        frame.add(play1);
        frame.add(play2);
        frame.add(btnNew);
        frame.setVisible(true);
    }
    private void closeActionPerformed(ActionEvent evt) {
        this.dispose();
        frame.dispose();
    }
    private void newActionPerformed() {
        initGame();
        btnPlay1.setText(String.valueOf(0));
        btnPlay2.setText(String.valueOf(0));
        seconds = 0;
    }

    void initGame() {
        score1 = 0;
        score2 = 0;
        int x = 0;
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Visibility(icons[x], new ImageIcon(getClass().getResource("/images/Diamond.png")));
            tiles[i].addActionListener(this);
            bPanel.add(tiles[i]);
            if ((i + 1) % 2 == 0) {
                x++;
            }

        }
        shuffle();
    }
    void initIcons() {
        Image img;
        for (int i = 0; i < icons.length; i++) {
            img = new ImageIcon(getClass().getResource("/images/img" + i + ".png")).getImage();
            icons[i] = createIcon(img);
        }
    }
    private ImageIcon createIcon(Image img) {
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        bi.createGraphics().drawImage(img, 0, 0, null);
        img = bi.getScaledInstance(80, 80, 1);
        return new ImageIcon(img);
    }

    private void check() {
        if(player.isPlayer1_turn()){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            btnPlay1.setBackground(Color.YELLOW);
            btnPlay2.setBackground(null);
        }else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            btnPlay2.setBackground(Color.YELLOW);
            btnPlay1.setBackground(null);
        }
        if (predict1 != predict2 && predict1.getImage() == predict2.getImage()) {
            new Thread() {
                @Override
                public void run() {
                    Sound sound = null;
                    try {
                        sound
                                = new Sound(getClass().getResource("/sounds/guess.wav"));
                    } catch (Exception e) {
                    }
                    InputStream stream
                            = new ByteArrayInputStream(sound.getSamples());
                    sound.play(stream);
                }
            }.start();//sound
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 3; i++) {
                        try {
                            predict1.hideTile();
                            predict2.hideTile();
                            Thread.sleep(100);
                            predict1.showTile();
                            predict2.showTile();
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }
                    predict1.setNoIcon();
                    predict2.setNoIcon();
                    for (int i = 0; i < tiles.length; i++) {
                        if (!tiles[i].isNoIcon()) {
                            won = false;
                            break;
                        } else {
                            won = true;
                        }
                    }
                    if (won) {
                        new Thread() {
                            @Override
                            public void run() {
                                Sound sound = null;
                                try {
                                    sound
                                            = new Sound(getClass().getResource("/sounds/won.wav"));
                                } catch (Exception e) {
                                }
                                InputStream stream
                                        = new ByteArrayInputStream(sound.getSamples());
                                sound.play(stream);
                            }
                        }.start();//won sound
                        if (score1 > score2) {
                            JOptionPane.showMessageDialog(bPanel, "Player1 Won! Score is " + score1 + "\nClick ok to play again");
                        }
                        else if(score1 == score2) {
                            JOptionPane.showMessageDialog(bPanel, "You have same Score" + "\nClick ok to play again");
                        }
                        else {
                            JOptionPane.showMessageDialog(bPanel, "Player2 Won! Score is " + score2 + "\nClick ok to play again");
                        }
                        initGame();
                        btnPlay1.setText(String.valueOf(0));
                        btnPlay2.setText(String.valueOf(0));
                        seconds = 0;
                    }
                    }
            }.start();
            predict1.removeActionListener(this);
            predict2.removeActionListener(this);
            if(player.isPlayer1_turn()){
                score1+=50;
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                btnPlay1.setBackground(Color.YELLOW);
                btnPlay2.setBackground(null);
                btnPlay1.setText(String.valueOf(score1));

            }else {
                score2+=50;
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                btnPlay2.setBackground(Color.YELLOW);
                btnPlay1.setBackground(null);
                btnPlay2.setText(String.valueOf(score2));
            }

        } else {
            predict1.hideTile();
            predict2.hideTile();
            if(player.isPlayer1_turn()){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                btnPlay1.setBackground(Color.YELLOW);
                btnPlay2.setBackground(null);

            }else {
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                btnPlay2.setBackground(Color.YELLOW);
                btnPlay1.setBackground(null);
            }

        }
    }

    private void shuffle() {
        bPanel.removeAll();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 16;) {
            int x = (int) (Math.random() * 16);
            if (!list.contains(x)) {
                list.add(x);
                i++;
            }
        }
        for (int i = 0; i < 16; i++) {
            bPanel.add(tiles[list.get(i)]);
            tiles[list.get(i)].hideTile();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (status == 0) {
            predict1 = (Visibility) e.getSource();
            predict1.showTile();
            status++;
        } else if (status == 1) {
            status++;
            predict2 = (Visibility) e.getSource();
            new Thread() {
                @Override
                public void run() {
                    try {
                        predict2.showTile();
                        Thread.sleep(500);
                        check();
                        Thread.sleep(600);
                        status = 0;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }.start();
        }
    }
}