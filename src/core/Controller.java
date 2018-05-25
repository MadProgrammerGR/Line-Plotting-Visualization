package core;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class Controller extends JFrame {
	private static final long serialVersionUID = 1L;
	private JSlider slider;
	private JCheckBox checkbox1, checkbox2, checkbox3, checkbox4;
	private LinePlotter plotter;

	public Controller(LinePlotter plotter) {
		this.plotter = plotter;
		add(new JLabel("Resolution"));
		
		slider = new JSlider(5, plotter.width, 10);
		slider.setMajorTickSpacing((slider.getMaximum() - slider.getMinimum())/3);
		slider.setMinorTickSpacing((slider.getMaximum() - slider.getMinimum())/15);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener((e) -> plotter.redraw());
		add(slider);

		checkbox1 = new JCheckBox("Title", true);
		checkbox1.addActionListener((e) -> plotter.redraw());
		add(checkbox1);
		
		checkbox2 = new JCheckBox("Grid", true);
		checkbox2.addActionListener((e) -> plotter.redraw());
		add(checkbox2);
		
		checkbox3 = new JCheckBox("Real Line", false);
		checkbox3.addActionListener((e) -> plotter.redraw());
		add(checkbox3);
		
		checkbox4 = new JCheckBox("Hint", true);
		checkbox4.addActionListener((e) -> plotter.redraw());
		add(checkbox4);
		
		setLayout(new FlowLayout());
		
		setTitle("Controller");
		setSize(280, 140);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int getPixelSize(){
		return (int)Math.ceil((float)plotter.width/slider.getValue());
	}
	
	public boolean titleEnabled() {
		return checkbox1.isSelected();
	}

	public boolean gridEnabled() {
		return checkbox2.isSelected();
	}
	
	public boolean realLineEnabled() {
		return checkbox3.isSelected();
	}

	public boolean hintEnabled() {
		return checkbox4.isSelected();
	}

}
