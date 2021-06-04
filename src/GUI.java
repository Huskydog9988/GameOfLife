import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class GUI extends JFrame {

    private Grid grid = new Grid();
    private JPanel config = new JPanel();
    private JLabel counter = new JLabel("Cycles: 0");

//    why does java lack state management??
//    this project would have taken a quarter of the time, and way less stress

    public GUI() {
        // set the title
        super("Conway's Game of Life");

        Logger.info("Started Game");

        // set bounds
        setBounds(100,100,1200,600);
        // disable resize
        setResizable(true);


        // make background black
//        setBackground(Color.BLACK);
        setLayout(new GridLayout(0, 2));
//        Grid grid = new Grid();
        // add grid
        add(grid);
//        this.pack();
//        setBackground(Color.BLACK);


//        Configuration config = new Configuration(grid);
        createConfig();
        add(config);
        
        // show window
        setVisible(true);
        // allow for closing
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
    }

    private void createConfig() {
        config.setLayout(new GridLayout(0, 1));

        JLabel intro = new JLabel();
        JLabel sliderText = new JLabel("Play Speed", SwingConstants.CENTER);
        JLabel underPopulation = new JLabel("Underpopulation Value: ");
        underPopulation.setBounds(10, 0, 150, 30);
        JLabel overPopulation = new JLabel("Overpopulation Value: ");
        overPopulation.setBounds(300, 0, 150, 30);
        JPanel settings = new JPanel();
        JPanel settingsLD = new JPanel();
        JPanel settingsPS = new JPanel();
        JButton playStop = new JButton("Play");
        JButton step = new JButton("Step");
        JSlider speed = new JSlider();
        JTextField underPop = new JTextField(1);
        underPop.setBounds(160, 7, 50, 20);
        JTextField overPop = new JTextField(1);
        overPop.setBounds(450, 7, 50, 20);
//        JLabel stateManagement = new JLabel("Why oh why god of the heavenly above does this wretched program not have state management??");

        intro.setText("");
        sliderText.setLabelFor(speed);
        config.add(counter);
        config.add(intro);
        config.add(settings);
//        config.add(stateManagement);
        settings.setLayout(new GridLayout(4, 1));
        settings.add(sliderText);
        settings.add(speed);
        settings.add(settingsLD);
        settings.add(settingsPS);

        settingsLD.setLayout(null);
        settingsLD.add(underPop);
        settingsLD.add(overPop);
        settingsLD.add(underPopulation);
        settingsLD.add(overPopulation);

        settingsPS.add(playStop);
        settingsPS.add(step);

        playStop.addActionListener(new ActionListener() {
            private int clicked = 0;
//            private Timer timer = new Timer("Game of life clock", true);
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            ScheduledFuture<?> future;

            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked == 0)
                {
                    Logger.info("Playing..");
                    playStop.setText("Stop");
                    step.setEnabled(false);
                    clicked++;

//                    TimerTask cycleTask = new TimerTask() {
//                        public void run() {
//                            nextCycle();
//                        }
//                    };

//                    timer.scheduleAtFixedRate(cycleTask, 1, 100);

                    future = scheduledExecutorService.scheduleAtFixedRate(() -> nextCycle(), 1, 100, TimeUnit.MILLISECONDS);

                }
                else if(clicked == 1)
                {
                    Logger.info("Stopping..");
                    playStop.setText("Play");
                    step.setEnabled(true);
                    clicked--;

//                    if (timer != null) timer.cancel();
                    if (future != null) future.cancel(false);
                }

            }

        });

        step.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logger.info("Step");

//				getGrid().;
//				GUI.this.getBoard()

                nextCycle();
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }

    private void nextCycle() {
        Logger.info("Auto playing next cycle");

        grid.nextCycle();

        counter.setText("Cycles: " + grid.getCycles());
    }
}