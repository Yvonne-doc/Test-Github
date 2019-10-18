package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarzahlungsWerkzeugUI extends JDialog
{

    /**
     * 
     */
    

    private int _Platzpreis;
    
    // private JDialog _dialog;
    public JDialog _frame;
    
    private JPanel _preisPanel;
    private JLabel _preis;
    private JTextField _anzeigePreis;
    
    private JPanel _betragPanel;
    private JLabel _betrag;
    private JTextField _eingabeBetrag;
    
    private JPanel _restbetragPanel;
    private JLabel _restbetrag;
    private JTextField _eingabeRestbetrag;
    
    private JPanel _buttonPanel;
    private JButton _okay;
    private JButton _abbrechen;
    
    
    /**
     * Erzeugt nach und nach das GUI.
     * @param preis: Preis, der im PlatzVerkaufsWerkzeug errechnet wird
     */
    
    public BarzahlungsWerkzeugUI(int preis)
    {
        
        _Platzpreis = preis;
        // Erzeugt den Frame   
        _frame = new JDialog(this,"Barzahlung", !false);
        
        _frame.setLayout(new BoxLayout(_frame.getContentPane(),BoxLayout.Y_AXIS));

        // Erzeugt die Textfelder für den Preis
        erzeugeTextfelderPreis();

        // Erzeugt die Textfelder für den Betrag
        erzeugeTextfelderBetrag();

        // Erzeugt die Textfelder für den Restbetrag
        erzeugeTextfelderRestbetrag();
        
        // Erzeugt das Buttonpanel und die Buttons
        erzeugeButtonPanel();

        // Zeigt die GUI an
        zeigeGUIan();
    }
    
    /**
     * zeigt die GUI an
     */

    private void zeigeGUIan()
    {
        _frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        _frame.pack();
    }
    /**
     * Erzeugt das ButtonPanel sowie die Buttons und fügt alles dem Frame hinzu
     */
    private void erzeugeButtonPanel()
    {
        _buttonPanel = new JPanel();
        erzeugeOkay();
        erzeugeAbbrechen();
        _frame.add(_buttonPanel);
    }
    
    /**
     * Erzeugt die Anzeige des Textfelds "Restbetrag:" und das Textfeld für die Ausgabe des Restbetrags
     */
    
    private void erzeugeTextfelderRestbetrag()
    {
        _restbetragPanel = new JPanel();
        _restbetrag = new JLabel();
        _restbetrag.setText("Restbetrag: ");
        _restbetragPanel.add(_restbetrag);

        _eingabeRestbetrag = new JTextField(10);
        _eingabeRestbetrag.setEditable(false);
        _restbetragPanel.add(_eingabeRestbetrag);
        _frame.add(_restbetragPanel);
    }
    
    /**
     * Erzeugt die Anzeige des Textfelds "Betrag:" und das Textfeld für die Eingabe des Betrags
     */
    private void erzeugeTextfelderBetrag()
    {
        _betragPanel = new JPanel();
        _betrag = new JLabel();
        _betrag.setText("Betrag: ");
        _betragPanel.add(_betrag);

        _eingabeBetrag = new JTextField(10);
        _betragPanel.add(_eingabeBetrag);
        _frame.add(_betragPanel);
    }
    
    /**
     * Erzeugt die Anzeige des Textfelds "Preis:" und das Textfeld für die Ausgabe des Preises
     */
    private void erzeugeTextfelderPreis()
    {
        _preisPanel = new JPanel();
        _preis = new JLabel();
        _preis.setText("Preis: ");
        _preisPanel.add(_preis);
        
        _anzeigePreis = new JTextField(10);
        _anzeigePreis.setText(""+_Platzpreis);
        _anzeigePreis.setEditable(false);
        _preisPanel.add(_anzeigePreis);
        _frame.add(_preisPanel);
    }

    /**
     * Erzeugt den Okay-Button
     */
    public void erzeugeOkay()
    {
        _okay = new JButton("Okay");
        _okay.setEnabled(false);
        _buttonPanel.add(_okay);
    }

    /**
     * Erzeugt den Abbrechen-Button
     * 
     */
    public void erzeugeAbbrechen()
    {
        _abbrechen = new JButton("Abbrechen");
        _buttonPanel.add(_abbrechen);
    }

    /**
     * 
     * @return den Frame
     */
    public JDialog getFrame()
    {
        return _frame;
    }

    /**
     * 
     * @return den okayButton
     */
    public JButton getOkay()
    {
        return _okay;
    }

    /**
     * 
     * @return den AbbrechenButton
     */
    public JButton getAbbrechen()
    {
        return _abbrechen;

    }
    
    /**
     * 
     * @return das JTextFeld zum Eingeben des Betrags
     */

    public JTextField getEingabeBetrag()
    {
        return _eingabeBetrag;
    }
    
    /**
     * 
     * @return das JTextFeld, das den Preis anzeigt
     */
    public JTextField getAnzeigePreis()
    {
        return _anzeigePreis;
    }
    
    /**
     * 
     * @return das JTextFeld, das den Restbetrag anzeigt
     */
    
    public JTextField getRestbetrag()
    {
        return _eingabeRestbetrag;
    }
    
    
    /**
     * Gibt den eingegebene Betrag in das TextField _eingabeBetrag als integer zurück
     * @return int eingabeBetrag
     */
    public int getBetrag()
    {
        
        //_eingabeBetrag.getText();
        return Integer.parseInt(_eingabeBetrag.getText());
    }
    
    /**
     * Sorgt dafür, dass der Dialog sichtbar wird. Als extra Methode, da in
     * BarzahlungsWerkzeug aufgerufen werden soll, sonst werden die
     * ActionListener nicht angenommen, solang Fenster geöffnet ist, da modal.
     */
    
    public void macheDialogSichtbar()
    {
        _frame.setVisible(true);
    }
    
}
