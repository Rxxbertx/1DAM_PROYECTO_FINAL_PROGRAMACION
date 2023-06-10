package animaciones;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class AnimacionShake implements ActionListener {
	private int shakeDistance;
	private int shakeCount;
	private int shakeDelay;
	private int originalX;
	private int originalY;
	private Component component;
	private int count;
	private int dx;
	private int dy;
	private Timer timer;

	public AnimacionShake(Component component) {
		this.component = component;
		originalX = component.getX();
		originalY = component.getY();
		shakeDistance = 2;
		shakeCount = 20;
		shakeDelay = 30;
		count = 0;
		dx = shakeDistance;
		dy = shakeDistance;


		timer = new Timer(shakeDelay, this);
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (count % 2 == 0) {
			component.setLocation(originalX + dx, originalY + dy);

		} else {
			component.setLocation(originalX, originalY);
		}

		count++;

		if (count >= shakeCount) {
			timer.stop();
			component.setLocation(originalX, originalY);
		}

		dx = -dx;
		dy = -dy;

	}
}
