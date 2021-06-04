import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Configuration extends JPanel
{
	public Configuration(Grid grid)
	{
		setLayout(new GridLayout(0, 1));
		
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
        
		intro.setText("");
        sliderText.setLabelFor(speed);
		add(intro);
		add(settings);
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
			@Override
			public void actionPerformed(ActionEvent e) {
				if(clicked == 0) 
				{
					playStop.setText("Stop");
					step.setEnabled(false);
					clicked++;
				}
				else if(clicked == 1)
				{
					playStop.setText("Play");
					step.setEnabled(true);
					clicked--;
				}
				
			}
        	
        });
	}
}
