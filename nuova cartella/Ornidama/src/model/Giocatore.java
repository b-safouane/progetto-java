package model;

public class Giocatore {
	
	public Pedina [] pedine;
	boolean soffio;

	public Giocatore(Pedina[][] scacchiera, int colore, int giocatore){
		this.pedine= new Pedina [12];
		int i=0;
		int x,y;
		if (giocatore==0)
			for(y=0; y<3;y++)
				if (y==1)
					for(x=0;x<8;x+=2)
						pedine[i++]=scacchiera[x][y];
				else
					for(x=1; x<8; x+=2)
						pedine[i++]=scacchiera[x][y];
		else 
			for(y=5; y<8;y++)
				if (y==6)
					for(x=1;x<8;x+=2)
						pedine[i++]=scacchiera[x][y];
				else
					for(x=0; x<8; x+=2)
						pedine[i++]=scacchiera[x][y];
						
		this.soffio=false;
	}
	
	public void setSoffio(boolean soffio){
		this.soffio=soffio;
	}
	
	
}
