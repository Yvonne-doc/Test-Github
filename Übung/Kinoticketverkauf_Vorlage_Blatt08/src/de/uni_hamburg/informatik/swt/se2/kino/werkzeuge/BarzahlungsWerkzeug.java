package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BarzahlungsWerkzeug implements ActionListener
{
    
    private BarzahlungsWerkzeugUI _ui;
    public int _preis;
    private boolean _bezahlt;
    
    /**
     * Erstellt neues Objekt des GUI, registriert die Listener, initialisiert die Felder und
     * macht dann das GUI sichtbar. Warum erst dann, siehe bei entsprechender Methode
     * @param preis: Preis, der im PlatzVerkaufsWerkzeug errechnet wird
     */
    public BarzahlungsWerkzeug(int preis)
    {
        
        _ui = new BarzahlungsWerkzeugUI(preis);
        registriereListener();
        _preis = preis;
        _bezahlt = false;
        _ui.macheDialogSichtbar();
    }
    
    /**
     * registriert die Listener. Hier: Die 2 Buttons und das Feld zur Eingabe des Betrags
     */
    
    private void registriereListener()
    {
        _ui.getOkay().addActionListener(this);
        _ui.getAbbrechen().addActionListener(this);
        _ui.getEingabeBetrag().addActionListener(this);
    }
    
    /**
     * Es wird überprüft, ob der eingegebene Betrag >= dem Preis ist. Falls dem so ist,
     * wird der OkayButton aktiviert. Bei Druck darauf, werden die ausgewählten
     * Plätze verkauft.
     * Der AbbrechenButton ist permanent aktiviert. Wird er gedrückt, schließt sich
     * der Frame aka das Fenster.
     */
    
    public void actionPerformed(ActionEvent event)
    {
        
        if (event.getSource() == _ui.getOkay())
        {
            _bezahlt = true;
            _ui._frame.dispose();
        }
        else if (event.getSource() == _ui.getAbbrechen())
        {
          _ui._frame.dispose();
        }
        else 
        {
            _ui.getRestbetrag().setText(""+(_ui.getBetrag()-_preis));
            if (_ui.getBetrag() >= _preis)
            {
                _ui.getOkay().setEnabled(true);
            }
            else
            {
                _ui.getOkay().setEnabled(false);
            }
        }
     
        
    }

    
    /**
     * Gibt zurück, ob der zu zahlende Preis bezahlt wurde
     * @return boolean _bezahlt: Wurde der Preis bezahlt ja/nein?
     */
    public boolean BetragWurdeBezahlt()
    {
        return _bezahlt;
    }
}
