package gf2.progettoOOP.SpringBootApp.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.IconUIResource;

import gf2.progettoOOP.SpringBootApp.Model.Frequenze;
import gf2.progettoOOP.SpringBootApp.Model.Metadata;
import gf2.progettoOOP.SpringBootApp.Model.ModelloStatistiche;
import gf2.progettoOOP.SpringBootApp.Model.Tweet;
import gf2.progettoOOP.SpringBootApp.Utils.*;
import gf2.progettoOOP.SpringBootApp.Service.*;


/**
 * Classe dove ho strutturato la GUI
 * 
 * @author Margherita Galeazzi
 *
 */
public class GUI {

	public GUI() {
		/* creo la finestra */
		JFrame MiaGUI = new JFrame("Global Tweets");
		/* gli passo posizione e dimensioni e la rendo non ridimensionabile */
		MiaGUI.setBounds(550, 250, 500, 400);
		MiaGUI.setResizable(false);
		
		
		/* colore di sfondo */
		Container contenuto = MiaGUI.getContentPane();
		contenuto.setBackground(new Color(171, 218, 236));
		contenuto.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		/* aggiunge il logo */
		ImageIcon logo = new ImageIcon(GUI.class.getResource("logo1.png"));
		JLabel foto = new JLabel(logo);
		c.gridx = 0;
		c.gridy = 0;
		c.insets.bottom = 10;
		MiaGUI.add(foto, c);

		/* aggiunge l'etichetta */
		JLabel titolo = new JLabel("<html>Vuoi conoscere meglio<br>la geolocalizzazione dei tweet?</html>");
		titolo.setForeground(new Color(0, 112, 155));
		Font f = new Font("Forte", Font.PLAIN, 18);
		titolo.setFont(f);
		c.gridx = 1;
		c.gridy = 0;
		MiaGUI.add(titolo, c);

		/* lascia uno spazio tra il titolo e i tasti */
		JLabel spazio = new JLabel("<html><br></html>");
		c.gridx = 1;
		c.gridy = 1;
		MiaGUI.add(spazio, c);

		

		/* Aggiunge bottone per sapere quanti tweet hanno il luogo */
		JButton bottone1 = new JButton("JSON dati");
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		MiaGUI.add(bottone1, c);
		bottone1.addActionListener(new clicB1());

		/* Aggiunge bottone per sapere la frequenza del luogo */
		JButton bottone2 = new JButton("JSON metadati");
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		MiaGUI.add(bottone2, c);
		bottone2.addActionListener(new clicB2());

		/* Aggiunge bottone per sapere numero tweet con location */
		JButton bottone3 = new JButton("JSON numero tweet con location");
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		MiaGUI.add(bottone3, c);
		bottone3.addActionListener(new clicB3());
		
		/* Aggiunge bottone per sapere la frequenza del luogo */
		JButton bottone4 = new JButton("JSON frequenza per utente");
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;
		MiaGUI.add(bottone4, c);
		bottone4.addActionListener(new clicB4());
		
		/* Aggiunge bottone per filtrare la timeline */
		JButton bottone5 = new JButton("Filtra JSON");
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 2;
		MiaGUI.add(bottone5, c);
		bottone5.addActionListener(new clicB5());
	
		
		/* rende visibile la finestra */
		MiaGUI.setVisible(true);

		/* chiude la finestra altrimenti il suo processo rimane in background */
		MiaGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UIManager.put("OptionPane.background", new ColorUIResource(171, 218, 236));
		UIManager.put("Panel.background", new ColorUIResource(171, 218, 236));
		UIManager.put("OptionPane.inputDialogTitle", "Inserisci...");
		ImageIcon ic = new ImageIcon(GUI.class.getResource("icon.png"));
		UIManager.put("OptionPane.questionIcon", new IconUIResource(ic));
		ImageIcon inf=new ImageIcon(GUI.class.getResource("twe.png"));
		UIManager.put("OptionPane.informationIcon", new IconUIResource(inf));
		UIManager.put("OptionPane.warningIcon", new IconUIResource(inf));
		UIManager.put("OptionPane.errorIcon", new IconUIResource(inf));
	}

	/**
	 * Inner class che implementa ActionListener e permette il funzionamento del
	 * bottone1
	 * 
	 * @see ActionListener
	 * @author Margherita Galeazzi
	 *
	 */
	private class clicB1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String appoggio;
			ArrayList<Tweet> st = JSONParser.parsaJson(JSONDownloader.JSONDownloadato());
			
			appoggio="[\n";
			for (Tweet t : st) {
				
						appoggio+="{\n" + "\"created_at\":" + t.getCreated_at() + "\n\"text\":"
						+ t.getText().replace("\n", " ") + "\n\"id\":" + t.getId() + "\n\"user\": {"
						+ "\n\"name_user\":" + t.getName_user()
						+ "\n\"screen_name\":" + t.getScreen_name()
						+ "\n\"location_user\":" + t.getLocation_user()
						+ "\n\"id_user\":" + t.getId_user() + "\n}" + "\n}, \n";
			}
			
			appoggio+="]";
			
			JTextArea textArea = new JTextArea(appoggio);
			JScrollPane scrollPane = new JScrollPane(textArea);  
			textArea.setLineWrap(true);  
			textArea.setWrapStyleWord(true); 
			textArea.setEditable(false);
			textArea.setEnabled(true);
			scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
			JOptionPane.showMessageDialog(null, scrollPane, "Dati JSON",  
			                                       JOptionPane.YES_NO_OPTION);
			
			
		}

	}

	/**
	 * Inner class che implementa ActionListener e permette il funzionamento del
	 * bottone2
	 * 
	 * @see ActionListener
	 * @author Margherita Galeazzi
	 *
	 */
	private class clicB2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String appoggio;
			ArrayList<Metadata> mt = caricatoreMetadati.getMetadata();
			
			appoggio="[\n";
			for (Metadata m : mt) {
				
				appoggio+=("{ \n" + "\"nome\":" + m.getNome() + "\n\"descrizione\":"
						+ m.getDescrizione() + "\n\"tipo\":" + m.getTipo() + "\n}\n");
			}
			
			appoggio+="]";
			
			JTextArea textArea = new JTextArea(appoggio);
			JScrollPane scrollPane = new JScrollPane(textArea);  
			textArea.setLineWrap(true);  
			textArea.setWrapStyleWord(true); 
			textArea.setEditable(false);
			textArea.setEnabled(true);
			scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
			JOptionPane.showMessageDialog(null, scrollPane, "Metadati JSON",  
			                                       JOptionPane.YES_NO_OPTION);

		}

	}

	/**
	 * Inner class che implementa ActionListener e permette il funzionamento del
	 * bottone3
	 * 
	 * @see ActionListener
	 * @author Margherita Galeazzi
	 *
	 */
	private class clicB3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
				
				
				ModelloStatistiche m = caricatoreStatistiche.getStats();
				String appoggio="{\n" + "\"tweloc\":" + m.getTweloc() + "\n} \n";
				
				JTextArea textArea = new JTextArea(appoggio);
				JScrollPane scrollPane = new JScrollPane(textArea);  
				textArea.setLineWrap(true);  
				textArea.setWrapStyleWord(true); 
				textArea.setEditable(false);
				textArea.setEnabled(true);
				scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
				JOptionPane.showMessageDialog(null, scrollPane, "Tweet con location JSON",  
				                                       JOptionPane.YES_NO_OPTION);
			

		}

	}
	
	/**
	 * Inner class che implementa ActionListener e permette il funzionamento del
	 * bottone4
	 * 
	 * @see ActionListener
	 * @author Margherita Galeazzi
	 *
	 */
	 class clicB4 implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
				
				String ut=JOptionPane.showInputDialog("Inserisci il nome dell'utente di cui vuoi la frequenza:");
				
				if(ut!=null) {
					
					String appoggio="";
					ArrayList<Frequenze> fre = new ArrayList<Frequenze>();
					ArrayList<Tweet> twe = JSONParser.parsaJson(JSONDownloader.JSONDownloadato());
					ArrayList<Tweet> cor =new ArrayList<Tweet>();
					for(Tweet t: twe) {
						if(t.getName_user().equals(ut))
							cor.add(t);
					}
					if(!cor.isEmpty()) {
				

					fre = Statistiche.freqLocUt(cor);
					appoggio="[\n";
					for (Frequenze f : fre) {
						appoggio+="{ \n" + "\"nvisite\":" + f.getNvisite() + "\n\"citta\":"
								+ f.getCitta() + "\n}";
					}
					appoggio+="\n]";
					JTextArea textArea = new JTextArea(appoggio);
					JScrollPane scrollPane = new JScrollPane(textArea);  
					textArea.setLineWrap(true);  
					textArea.setWrapStyleWord(true); 
					textArea.setEditable(false);
					textArea.setEnabled(true);
					scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
					JOptionPane.showMessageDialog(null, scrollPane, "Frequenza per utente JSON",  
					                                       JOptionPane.YES_NO_OPTION);
					} 
					else {
						appoggio+="L'utente non esiste";
						JTextArea textArea = new JTextArea(appoggio);
						JScrollPane scrollPane = new JScrollPane(textArea);  
						textArea.setLineWrap(true);  
						textArea.setWrapStyleWord(true); 
						textArea.setEditable(false);
						textArea.setEnabled(true);
						scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
						JOptionPane.showMessageDialog(null, scrollPane, "Frequenza per utente JSON",  
						                                       JOptionPane.YES_NO_OPTION);
					}
				
				}
				else {
					
					String appoggio="";
					appoggio+="Non hai passato un utente";
					JTextArea textArea = new JTextArea(appoggio);
					JScrollPane scrollPane = new JScrollPane(textArea);  
					textArea.setLineWrap(true);  
					textArea.setWrapStyleWord(true); 
					textArea.setEditable(false);
					textArea.setEnabled(true);
					scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
					JOptionPane.showMessageDialog(null, scrollPane, "Frequenza per utente JSON",  
					                                       JOptionPane.YES_NO_OPTION);
					
				}
				
					

		}

	}
	 
	 /**
		 * Inner class che implementa ActionListener e permette il funzionamento del
		 * bottone5
		 * 
		 * @see ActionListener
		 * @author Margherita Galeazzi
		 *
		 */
		 class clicB5 implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
					ArrayList<Tweet> twe = JSONParser.parsaJson(JSONDownloader.JSONDownloadato());
					ArrayList<Tweet> stampaIn= new ArrayList<Tweet>();
					ArrayList<Tweet> stampaNin= new ArrayList<Tweet>();
					
					String appoggio="";
					String ut=JOptionPane.showInputDialog("Filtri possibili:\n"
							+ "LocationInc:nome della location -> per stampare i tweet con quella location\n"
							+ "LocationNin:nome della location -> per stampare i filtri senza quella location\n"
							+ "UsernameInc:nome dell'utente -> per stampare i tweet di quell'utente\n"
							+ "UsernameNIn:nome dell'utente-> per stampare i tweet non di quell'utente\n");
					
					if((ut!=null) &&(ut.length()>=12)) {
						String campo=ut.substring(0, 8);
						String filtro=ut.substring(8, 11);
						String parametro=ut.substring(12);
						
						
						if(campo.equals("Location")){
							for(Tweet t: twe) {
								if(t.getLocation_user().equals(parametro)) {
									stampaIn.add(t);
								} else {
									stampaNin.add(t);
								}
							}
							if(filtro.equals("Inc")) {
								appoggio="[\n";
								for (Tweet t : stampaIn) {
									appoggio+="{ \n" + "\"created_at\":" + t.getCreated_at() + "\n\"text\":"
											+ t.getText().replace("\n", " ") + "\n\"id\":" + t.getId() + "\n\"user\": {"
											+ "\n\"name_user\":" + t.getName_user()
											+ "\n\"screen_name\":" + t.getScreen_name()
											+ "\n\"location_user\":" + t.getLocation_user()
											+ "\n\"id_user\":" + t.getId_user() + "\n}" + "\n}, \n";
								}
								appoggio+="\n]";
								
							} else if(filtro.equals("Nin")) {
								appoggio+="[\n";
								for (Tweet t : stampaNin) {
									appoggio+="	{\n" + "\"created_at\":" + t.getCreated_at() + "\n\"text\":"
											+ t.getText().replace("\n", " ") + "\n\"id\":" + t.getId() + "\n\"user\": {"
											+ "\n\"name_user\":" + t.getName_user()
											+ "\n\"screen_name\":" + t.getScreen_name()
											+ "\n\"location_user\":" + t.getLocation_user()
											+ "\n\"id_user\":" + t.getId_user() + "\n}" + "\n}, \n";
								}
								appoggio+="\n]";
								
							}else{appoggio="Filtro invalido!";}
							
						} else if(campo.equals("Username")){
							for(Tweet t: twe) {
								if(t.getName_user().equals(parametro)) {
									stampaIn.add(t);
								} else {
									stampaNin.add(t);
								}
							}
							if(filtro.equals("Inc")) {
								appoggio+="[\n";
								for (Tweet t : stampaIn) {
									appoggio+="{\n" + "\"created_at\":" + t.getCreated_at() + "\n\"text\":"
											+ t.getText().replace("\n", " ") + "\n\"id\":" + t.getId() + "\n\"user\": {"
											+ "\n\"name_user\":" + t.getName_user()
											+ "\n\"screen_name\":" + t.getScreen_name()
											+ "\n\"location_user\":" + t.getLocation_user()
											+ "\n\"id_user\":" + t.getId_user() + "\n}" + "\n}, \n";
								}
								appoggio+="\n]";
								
							
							} else if(filtro.equals("Nin")){
								appoggio+="[\n";
								for (Tweet t : stampaNin) {
									appoggio+="	{\n" + "\"created_at\":" + t.getCreated_at() + "\n\"text\":"
											+ t.getText().replace("\n", " ") + "\n\"id\":" + t.getId() + "\n\"user\": {"
											+ "\n\"name_user\":" + t.getName_user()
											+ "\n\"screen_name\":" + t.getScreen_name()
											+ "\n\"location_user\":" + t.getLocation_user()
											+ "\n\"id_user\":" + t.getId_user() + "\n}" + "\n}, \n";
								}
								appoggio+="\n]";
								
							} else{appoggio="Filtro invalido!";}
							
						}
						else {appoggio="Filtro invalido!";
						
			
					}
					
						JTextArea textArea = new JTextArea(appoggio);
						JScrollPane scrollPane = new JScrollPane(textArea);  
						textArea.setLineWrap(true);  
						textArea.setWrapStyleWord(true); 
						textArea.setEditable(false);
						textArea.setEnabled(true);
						scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
						JOptionPane.showMessageDialog(null, scrollPane, "Frequenza per utente JSON",  
						                                       JOptionPane.YES_NO_OPTION);
					
					}}}}
