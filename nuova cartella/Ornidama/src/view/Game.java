package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


//import controller.Move;
import controller.SolvedChecker;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;


public class Game extends JFrame {
	private static final int HEIGHT = 720;
    private static final int WIDTH = 720;
    private  Scacchiera scacchiera;
    private final CommandWindow commands = new CommandWindow();
    private Giocatore user;
    private Giocatore cpu;

	final Icon nera= new ImageIcon("nera.jpg");
    
    
    public Game(Scacchiera scacchiera) {
        super("Dama");

        this.scacchiera = scacchiera;

        setLayout(new GridLayout(8, 8));
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        

        showBoard(1,0);
    }
    
    
    
    public void setVisible(boolean isVisible) {
        super.setVisible(isVisible);

        //commands.setVisible(isVisible);
    }
    
    
    
    private void showBoard(int x, int y) {
        for (int y1 = 0; y1 < 8 ; y1++)
                for (int x1 = 7; x1 >= 0; x1--)
                        if (scacchiera.scacchiera[x1][y1]!=null){
                        	if (scacchiera.scacchiera[x1][y1].colore==0)
                        		if (scacchiera.scacchiera[x1][y1].damone==true)
                        			addCasella(new damoneNero(scacchiera.scacchiera[x1][y1]),x1,y1);
                        		else
                        			addCasella(new pedinaNera(scacchiera.scacchiera[x1][y1]),x1,y1);
                        	else 
                        		if (scacchiera.scacchiera[x1][y1].damone==true)
                        			addCasella(new damoneBianco(scacchiera.scacchiera[x1][y1]),x1,y1);
                        		else
                        			addCasella(new pedinaBianca(scacchiera.scacchiera[x1][y1]),x1,y1);
                      
                        }
                        else {
                        	if (scacchiera.scacchiera[x][y].canMove(x1,y1,scacchiera))
                        		addCasella(new CasellaColorata(x1,y1),x1,y1);
                        	
                        	else
                                addCasella(new CasellaVuota(x1,y1),x1,y1);    
                        }        
    }
    private void addCasella(final Casella casella, final int x, final int y) {
        add(casella);

        if (this.scacchiera.scacchiera[x][y]!=null)
        	
        	casella.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                        if (!isFinished()) {
                        		CasellaPiena casellaAsCasellaPiena = (CasellaPiena) casella;
                                if (casellaAsCasellaPiena.pedina.movable(scacchiera)) {
                                        
                                        showBoard(casella.getX(),casella.getY());

                                        if (isFinished())
                                                commands.setMessage("bravo!");
                                        else
                                                commands.setMessage("mossa legale");

                                        invalidate();
                                        validate();
                                        
                                }
                                else
                                        commands.setMessage("mossa illegale");
                        }
                }
        	});
    }
    
	private boolean isFinished() {
    	return new SolvedChecker(user, cpu).isSolved();
    }
	
	public static void main(String[] args) {
        
		new Game(new Scacchiera(1)).setVisible(true);
		
     
        
    }

	
}
