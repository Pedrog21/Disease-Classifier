package Projecto;

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JProgressBar;

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
		textArea.setBounds(49, 98, 362, 23);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(49, 203, 347, 22);
		frame.getContentPane().add(textArea_1);
		
		JButton btnClassify = new JButton("Classify");
		btnClassify.setBounds(147, 133, 152, 23);
		btnClassify.setBackground(Color.DARK_GRAY);
		btnClassify.setForeground(Color.ORANGE);
		btnClassify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textArea.getText().length()>0) {
				String[] aux = textArea.getText().split(",");
				List<Integer> t=new ArrayList<>();
				for(int j=0;j<aux.length;j++) {
					t.add(Integer.parseInt(aux[j]));
				}
				ArrayList<Integer> d=new ArrayList<Integer>();
				for(int k=0;k<t.size();k++) d.add(t.get(k));
				
				try {
			
					FileInputStream fis = new FileInputStream("BayesNetwork.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					BN bayes = (BN) ois.readObject();
					ois.close();
					
					d.add(1);
					double result1 = bayes.prob(d);
					d.set(d.size()-1, 0);
					double result2 = bayes.prob(d);
					
					if(result1>result2) {
						textArea_1.setText("It is likely that the patient has the disease");
					} else {
						textArea_1.setText("It is not likely that the patient has the disease");
					}
					
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}}
		});
		frame.getContentPane().add(btnClassify);
		
		JButton btnResetTextArea = new JButton("Reset Text Area");
		btnResetTextArea.setBounds(147, 237, 152, 23);
		btnResetTextArea.setForeground(Color.ORANGE);
		btnResetTextArea.setBackground(Color.DARK_GRAY);
		btnResetTextArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textArea_1.setText("");
			}
		});
		frame.getContentPane().add(btnResetTextArea);
		
		JLabel lblMedicalClassifier = new JLabel("Medical Classifier");
		lblMedicalClassifier.setBounds(147, 11, 306, 42);
		lblMedicalClassifier.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		frame.getContentPane().add(lblMedicalClassifier);
		
		JLabel lblProbabilidade = new JLabel("Result:");
		lblProbabilidade.setBounds(49, 186, 84, 14);
		frame.getContentPane().add(lblProbabilidade);
		
		JLabel lblInsertThePatient = new JLabel("Insert the patient parameters here:");
		lblInsertThePatient.setBounds(49, 81, 262, 16);
		frame.getContentPane().add(lblInsertThePatient);
		
	
		
	
			
	}
}