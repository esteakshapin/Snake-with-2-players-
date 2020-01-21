import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Container extends JPanel{
	private Frame frame, frame2;
	private Timer timer;
	private int delay = 100;
	
	public Container() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
	    frame = new Frame(1);
	    frame2 = new Frame(2);
	      
	    this.add(frame);
	    this.add(frame2);
	
	}
	
	public Frame getFrame()
	{
		return frame;
	}
	public Frame getFrame2()
	{
		return frame2;
	}

}
