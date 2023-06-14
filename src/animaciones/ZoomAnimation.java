package animaciones;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ZoomAnimation implements ActionListener {
	private Component component;
	private Timer timer;
	private boolean zoomingIn;

	public ZoomAnimation(Component component) {
		this.component = component;

		// Crear el timer con un retraso de 100 ms y un ActionListener que ejecutará la
		// animación
		timer = new Timer(47, this);
		zoomingIn = true;
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Tamaño actual de la fuente
		int currentFontSize = component.getFont().getSize();

		// Indica si se está haciendo zoom o volviendo al tamaño original

		// Calcular el nuevo tamaño de la fuente
		int fontSize = currentFontSize + (zoomingIn ? 1 : -1);

		// Si el tamaño de la fuente ha alcanzado el límite, cambiar la dirección de la
		// animación
		if (fontSize >= 40) {
			zoomingIn = false;
		} else if (fontSize <= 20) {
			zoomingIn = true;
		}

		// Actualizar la fuente del JLabel con el nuevo tamaño
		Font font = component.getFont().deriveFont((float) fontSize);
		component.setFont(font);

		// Actualizar el tamaño actual de la fuente
		currentFontSize = fontSize;

	}

	public void start() {
		timer.start();

	}

	public void stop() {
		timer.stop();

	}
}
