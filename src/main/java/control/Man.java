package control;

import java.awt.EventQueue;

import view.LoginFrame;

public class Man {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
