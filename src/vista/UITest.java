package vista;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import control.ParaUI;

class UITest {

	@Test
	void test() {
		new Runnable() {
			boolean seguir = false;
			@Override
			public void run() {
				do {
					if (!seguir) {
						new Runnable() {
							public void run() {
								try {
									UI frame = new UI();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}.run();
						seguir=true;
					}
				} while (seguir);
			}
		}.run();
	}

}
