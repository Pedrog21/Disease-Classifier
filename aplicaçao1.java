package teste1;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;

public class aplicaçao1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aplicaçao1 window = new aplicaçao1();
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
	public aplicaçao1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setForeground(Color.GREEN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFileChooser fileChooser = new JFileChooser();
		//textArea.setBounds(250, 137, 117, 41);
		//frame.getContentPane().add(textArea);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 81, 150, 100);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		JButton btnLerAmostra = new JButton("Read Sample");
		btnLerAmostra.setForeground(Color.ORANGE);
		btnLerAmostra.setBackground(Color.DARK_GRAY);
		btnLerAmostra.setBounds(248, 95, 125, 55);
		btnLerAmostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream fos;
				int returnValue=fileChooser.showOpenDialog((Component)e.getSource());
				if (returnValue==JFileChooser.APPROVE_OPTION){
					textArea.setText(fileChooser.getSelectedFile().toString());
				
				try {
					List<String> lines = Files.readAllLines(fileChooser.getSelectedFile().toPath(), Charset.defaultCharset());
					List<Integer> T=new ArrayList<>();
					Amostra amostra = new Amostra();
					for (int i=0; i<lines.size();i++){
						System.out.println(lines.get(i));
						textArea.setText(textArea.getText()+"\n"+lines.get(i));
						String[] aux = lines.get(i).split(",");
						T.clear();
						
						for(int j=0;j<aux.length;j++) {
							T.add(Integer.parseInt(aux[j]));
						}
						List<Integer> d=new ArrayList();
						for(int k=0;k<t.size();k++) d.add(t.get(k));
						amostra.add(d);
			       		}
					System.out.println(amostra);
					
					fos = new FileOutputStream("myContribuinte.ser");
					ObjectOutputStream oos;
					oos = new ObjectOutputStream(fos);
					//oos.writeObject(c);
					//a linha acima grava a rede de bayes no disco
					oos.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnLerAmostra);
		
		JLabel lblMedicalDiagnosisApp = new JLabel("Medical Diagnosis App");
		lblMedicalDiagnosisApp.setForeground(Color.DARK_GRAY);
		lblMedicalDiagnosisApp.setFont(new Font("Open Sans Semibold", Font.PLAIN, 20));
		lblMedicalDiagnosisApp.setBounds(123, 11, 332, 46);
		frame.getContentPane().add(lblMedicalDiagnosisApp);
		
	}
}
