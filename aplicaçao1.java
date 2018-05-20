package Projecto;

import java.awt.EventQueue;
import java.util.Random;

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
import javax.swing.JPanel;

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
		scrollPane.setBounds(150, 69, 150, 100);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		JButton btnLerAmostra = new JButton("Read Sample");
		btnLerAmostra.setForeground(Color.ORANGE);
		btnLerAmostra.setBackground(Color.DARK_GRAY);
		btnLerAmostra.setBounds(160, 181, 130, 55);
		btnLerAmostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream fos;
				int returnValue=fileChooser.showOpenDialog((Component)e.getSource());
				if (returnValue==JFileChooser.APPROVE_OPTION){
					textArea.setText(fileChooser.getSelectedFile().toString());
				
				try {
					List<String> lines = Files.readAllLines(fileChooser.getSelectedFile().toPath(), Charset.defaultCharset());
					List<Integer> t=new ArrayList<>();
					Amostra amostra = new Amostra();
					for (int i=0; i<lines.size();i++){
						textArea.setText(textArea.getText()+"\n"+lines.get(i));
						String[] aux = lines.get(i).split(",");
						t.clear();
						for(int j=0;j<aux.length;j++) {
							t.add(Integer.parseInt(aux[j]));
						}
						List<Integer> d=new ArrayList<Integer>();
						for(int k=0;k<t.size();k++) d.add(t.get(k));
						amostra.add(d);
			       	}
					
					WGraph2 WGraph = new WGraph2(t.size()-1);
				
					ArrayList<ArrayList<Integer>> dom = new ArrayList<ArrayList<Integer>>();
					for(int i=0;i<t.size();i++) dom.add(amostra.domain(i));
					
					double w=0;
					double aux1=0;
					double aux2=0;
					double aux3=0;
					double aux4=0;
					ArrayList<Integer> l1= new ArrayList<Integer>();
					ArrayList<Integer> l2= new ArrayList<Integer>();
					
					for(int i=0;i<t.size()-1;i++) {
						for(int j=0;j<t.size()-1;j++) {
							if(i!=j) {
								w=0;
								for(int k1=0;k1<dom.get(i).size();k1++) {
									for(int k2=0;k2<dom.get(j).size();k2++) {
										for(int k3=0;k3<dom.get(t.size()-1).size();k3++) {
											l1.clear();l2.clear();
											l1.add(t.size()-1);l2.add(dom.get(t.size()-1).get(k3));
											aux3=amostra.count(l1, l2)*1.0/(amostra.length()*1.0);
											l1.add(0,j);l2.add(0,dom.get(j).get(k2));
											aux2=amostra.count(l1, l2)*1.0/(amostra.length()*1.0);
											l1.add(0,i);l2.add(0,dom.get(i).get(k1));
											aux1=amostra.count(l1, l2)*1.0/(amostra.length()*1.0);
											l1.remove(1);l2.remove(1);
											aux4=amostra.count(l1, l2)*1.0/(amostra.length()*1.0);
											if(aux1!=0 && aux2!=0 && aux4!=0) w=w + aux1*Math.log(aux1*aux3/(aux4*aux2));
										}
									}
								}
								WGraph.add_edge(i, j, w);
							}
						}
					}
					
					
					Random rand = new Random();
					int  n = rand.nextInt(t.size()-1);
					DGraph DGraph = WGraph.MST(n);
					
					BN c = new BN(DGraph,amostra,0.5);
					
					System.out.println(c);
					
					fos = new FileOutputStream("BayesNetwork.ser");
					ObjectOutputStream oos;
					oos = new ObjectOutputStream(fos);
					oos.writeObject(c);
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
		lblMedicalDiagnosisApp.setForeground(Color.BLACK);
		lblMedicalDiagnosisApp.setFont(new Font("Open Sans Semibold", Font.PLAIN, 20));
		lblMedicalDiagnosisApp.setBounds(123, 11, 332, 46);
		frame.getContentPane().add(lblMedicalDiagnosisApp);
	
		
		
		
		
	}
}