package model;

public class Scacchiera {
	public Pedina [][] scacchiera;
	
	public Scacchiera(int colore){
		this.scacchiera = new Pedina[8][8];
		int x, y;
		if (colore==0){
			
			for(y=0; y<3; y++)
				if (y==1)
					for(x=0;x<8;x+=2)
						scacchiera[x][y]= new Pedina(x,y,1,0);
				else
					for(x=1; x<8; x+=2)
						scacchiera[x][y]= new Pedina(x,y,1,0);
			for(y=5; y<8;y++)
				if (y==6)
					for(x=1;x<8;x+=2)
						scacchiera[x][y]= new Pedina(x,y,0,1);
				else
					for(x=0; x<8; x+=2)
						scacchiera[x][y]= new Pedina(x,y,0,1);
		}			
		
		else {
			
			for(y=0; y<3; y++)
				if (y==1)
					for(x=0;x<8;x+=2)
						scacchiera[x][y]= new Pedina(x,y,1,1);
				else
					for(x=1; x<8; x+=2)
						scacchiera[x][y]= new Pedina(x,y,1,1);
			for(y=5; y<8;y++)
				if (y==6)
					for(x=1;x<8;x+=2)
						scacchiera[x][y]= new Pedina(x,y,0,0);
				else
					for(x=0; x<8; x+=2)
						scacchiera[x][y]= new Pedina(x,y,0,0);
		}			
			
				
						
	}
}
