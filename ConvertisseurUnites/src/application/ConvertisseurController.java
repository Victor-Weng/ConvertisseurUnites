package application;
/*
* Author : victor
* Date : March. 3, 2021
* Titre : ConvertisseurUnites
* Description : Ceci est une application java qui permet d’effectuer la conversion des unités impériales en 
* unités du système métrique et vice  versa. Il peut convertir les mesures tels que : 
* la longueur, le surface, la volume, la masse, et la vitesse.
*/

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConvertisseurController implements Initializable{

		
	// Declaration des elements de scene builder
		
	@FXML
    private ComboBox<String> cboVi1;

    @FXML
    private ComboBox<String> cboVi2;

    @FXML
    private ComboBox<String> cboV1;

    @FXML
    private TextField txtL2;

    @FXML
    private TextField txtVi2;

    @FXML
    private ComboBox<String> cboV2;

    @FXML
    private TextField txtVi1;

    @FXML
    private ComboBox<String> cboS2;

    @FXML
    private TextField txtM1;

    @FXML
    private TextField txtL1;

    @FXML
    private ComboBox<String> cboS1;

    @FXML
    private TextField txtM2;

    @FXML
    private TextField txtV1;

    @FXML
    private ComboBox<String> cboL1;

    @FXML
    private TextField txtS1;

    @FXML
    private ComboBox<String> cboM2;

    @FXML
    private TextField txtS2;

    @FXML
    private ComboBox<String> cboM1;

    @FXML
    private TextField txtV2;

    @FXML
    private ComboBox<String> cboL2;
    
    @FXML
    private TextField txtTL;
    
    @FXML
    private TextField txtTS;
    
    @FXML
    private TextField txtTV;
    
    @FXML
    private TextField txtTM;
    
    @FXML
    private TextField txtTVi;
    
    
    // Action pour le bouton "quitter" qui serve a fermer le program
    @FXML
    private void fermer()
    {
    		System.exit(0);
    }
   
    // Les valeurs de conversion et les elements du comboBox
    
    // Longeur 1 = Metre
    private ObservableList<String> listeL=(ObservableList<String>)FXCollections.observableArrayList("Kilomètre", "Mètre", "Centimètre", "Millimètre", "Mile", "Yard", "Pouce","Pied");
    
    double [] tabLong= {0.001,1,100,1000,0.0006214,1.0936,39.37,3.281};

    // Surface 1 = Metre Carre
    private ObservableList<String> listeS=(ObservableList<String>)FXCollections.observableArrayList("km carré", "hectare", "mètre carré", "mile carré", "acres","pouce carré","pied carré");
    
    double [] tabSurf= {0.00000001,10000,1,0.00000259,4047,1550,10.764};

    // Volume 1 = Litre
    private ObservableList<String> listeV=(ObservableList<String>)FXCollections.observableArrayList("Gallon US", "Gallon UK", "Pint US", "Pint UK", "Oz fl US", "cu Pied", "cu Pouce", "Liter", "Milliliter", "cu Mètre ");
    double [] tabVolu= {0.265172,0.219969,2.11338,1.76,33.814,0.0353147,61.024,1,1000,0.001};
    
    // Masse 1 = Kg
    private ObservableList<String> listeM=(ObservableList<String>)FXCollections.observableArrayList("Tonne", "Kilogramme", "Gramme", "Milligramme", "Tonne US", "Tonne UK", "Livre", "Oz");
    
    double [] tabMass= {0.001,1,1000,1000000,0.00110231,0.000984207,2.20462,35.274};
    // Vitesse 1 = M/S
    private ObservableList<String> listeVi=(ObservableList<String>)FXCollections.observableArrayList("KM/H", "Mi/H", "M/S");
    
    double [] tabVite= {3.6,3.347,1};
    
    int num1=0;
    
    // Attribuer les elements de ComboBox et afficher le premiere dans la liste
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    		
    		
    		// Longeur
    		cboL1.setItems(listeL);
     		cboL1.getSelectionModel().selectFirst();
    		cboL2.setItems(listeL);
    		cboL2.getSelectionModel().selectFirst();
    		
    		// Surface
    		cboS1.setItems(listeS);
     		cboS1.getSelectionModel().selectFirst();
    		cboS2.setItems(listeS);
    		cboS2.getSelectionModel().selectFirst();
    		
    		// Volume
    		cboV1.setItems(listeV);
     		cboV1.getSelectionModel().selectFirst();
    		cboV2.setItems(listeV);
    		cboV2.getSelectionModel().selectFirst();    		
    		
    		// Masse
    		cboM1.setItems(listeM);
     		cboM1.getSelectionModel().selectFirst();
    		cboM2.setItems(listeM);
    		cboM2.getSelectionModel().selectFirst();   		
    		
    		// Vitesse
    		cboVi1.setItems(listeVi);
     		cboVi1.getSelectionModel().selectFirst();
    		cboVi2.setItems(listeVi);
    		cboVi2.getSelectionModel().selectFirst();
    		    		
    		
    		

    }
   
    // Vérifiez quel bouton est cliqué et envoyez le numéro associé à la méthode 'calculer'
    
    // Longeur
    @FXML
    void calculerL1() {calculer(1);};
    @FXML
    void calculerL2(){calculer(2);};
    // Surface
    @FXML
    void calculerS1(){calculer(3);};
    @FXML
    void calculerS2(){calculer(4);};
    // Volume
    @FXML
    void calculerV1(){calculer(5);};
    @FXML
    void calculerV2(){calculer(6);};
    // Masse
    @FXML
    void calculerM1(){calculer(7);};
    @FXML
    void calculerM2(){calculer(8);};
    // Vitesse
    @FXML
    void calculerVi1(){calculer(9);};
    @FXML
    void calculerVi2(){calculer(10);};
    
    
    // Verifier et envoyer les variables selon le case
    @FXML
    void calculer(int t)
    {
    		switch(t)
    		{
    		case 1:
    			convertir(txtL1,txtL2,cboL1,cboL2,txtTL,tabLong);break;
    		case 2:
    			convertir(txtL2,txtL1,cboL2,cboL1,txtTL,tabLong);break;
    		case 3:
    			convertir(txtS1,txtS2,cboS1,cboS2,txtTS,tabSurf);break;
    		case 4:
    			convertir(txtS2,txtS1,cboS2,cboS1,txtTS,tabSurf);break;
    		case 5:
    			convertir(txtV1,txtV2,cboV1,cboV2,txtTV,tabVolu);break;
    		case 6:
    			convertir(txtV2,txtV1,cboV2,cboV1,txtTV,tabVolu);break;
    		case 7:
    			convertir(txtM1,txtM2,cboM1,cboM2,txtTM,tabMass);break;
    		case 8:
    			convertir(txtM2,txtM1,cboM2,cboM1,txtTM,tabMass);break;
    		case 9:
    			convertir(txtVi1,txtVi2,cboVi1,cboVi2,txtTVi,tabVite);break;
    		case 10:
    			convertir(txtVi2,txtVi1,cboVi2,cboVi1,txtTVi,tabVite);break;
    		}
    			
    		
    }

    
    
    
    
   // Methode pour convertir les unites
    public void convertir(TextField txtA, TextField txtB, ComboBox boxA, ComboBox boxB, TextField txtC, double [] tab)
    {
    	// Envoyer le nombre ecrit au methode verifNum
    	verifNum(txtA);
   		int item1=boxA.getSelectionModel().getSelectedIndex();
    	int item2=boxB.getSelectionModel().getSelectedIndex();
    	// Trouve la facteur qu'on serve pour convertir le nombre
    	double taux=tab[item2]/tab[item1];
    	// Appliquer le taux au nombre
    	double res=taux*(Double.parseDouble(txtA.getText()));
    	// Afficher le nombre
    	
    	txtB.setText(Double.toString(res));
    	txtC.setText(Double.toString(taux));
   }

    //Gestion numerique - accepter des caracteres numeriques seulement
    public void verifNum(TextField a)
    	{
    		
    		
    	if(a.getText().equals("")) a.setText("0");
    	a.textProperty().addListener((observable,oldValue,newValue)->
    	{
    		if(!newValue.matches("^[0-9](\\.[0-9]+)?$"))
    		{
    			a.setText(newValue.replaceAll("[^\\d*\\.]", ""));
    		}
    		
    	});
        	
}
}
