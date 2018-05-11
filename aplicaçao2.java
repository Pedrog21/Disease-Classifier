package teste1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class aplicaçao2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aplicaçao2 window = new aplicaçao2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public aplicaçao2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(49, 96, 145, 29);
		frame.getContentPane().add(textArea);
		
		JButton btnClassify = new JButton("Classify");
		btnClassify.setBackground(Color.DARK_GRAY);
		btnClassify.setForeground(Color.ORANGE);
		btnClassify.setBounds(255, 97, 152, 23);
		btnClassify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] aux = textArea.getText().split(",");
				List<Integer> T=new ArrayList<>();
				for(int j=0;j<aux.length;j++) {
					T.add(Integer.parseInt(aux[j]));
				}
				//System.out.println(T);
			}
		});
		frame.getContentPane().add(btnClassify);
		
		JButton btnResetTextArea = new JButton("Reset Text Area");
		btnResetTextArea.setForeground(Color.ORANGE);
		btnResetTextArea.setBackground(Color.DARK_GRAY);
		btnResetTextArea.setBounds(255, 147, 152, 23);
		btnResetTextArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});
		frame.getContentPane().add(btnResetTextArea);
		
		JLabel lblMedicalClassifier = new JLabel("Medical Classifier");
		lblMedicalClassifier.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblMedicalClassifier.setBounds(147, 11, 306, 42);
		frame.getContentPane().add(lblMedicalClassifier);
		
		
		
		
	}
}
