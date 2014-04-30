package model;

import model.ListaMosse;

public class Pedina {

	//coordinate sulla scacchiera
	int x; 
	int y;
	
	//indica il giocatore 0=pc, 1=umano
	public int giocatore; 
	
	
	//0=nero 1=bianco
	public int colore; 
	
	//indica il numero di mangiate che può fare
	int potenziale;
	
	public boolean damone; //if true è un damone

	ListaMosse next;
	
	
	public Pedina(int x, int y, int giocatore, int colore){
		
		this.x=x;
		this.y=y;
		this.giocatore=giocatore;
		this.colore=colore;
		potenziale=0;
	}
	
	public boolean move(int destX, int destY, Scacchiera scacchiera){
		
		
		if ((destX<0||destX>7) ||(destY<0||destY>7))//esco dalla scacchiera
			return false;
		
		if (damone==false){//se sei giocatore umano controlla e muove in alto
		
			if(giocatore==1){
				if ((x-destX==1||destX-x==1) && (destY-y==1) && scacchiera.scacchiera[destX][destY]==null){ // sposto la pedina
			
					scacchiera.scacchiera[destX][destY]=this; 
					scacchiera.scacchiera[x][y]=null;			//muovo
			
					x=destX;
					y=destY;
						
					return true;
				}
				if (((((x-destX==2||destX-x==2)&&(destY-y==2))&&scacchiera.scacchiera[destX][destY]==null)
						&&(scacchiera.scacchiera[(destX+x)/2][(y+destY)/2]!=null
						&&scacchiera.scacchiera[(destX+x)/2][(y+destY)/2].giocatore!=giocatore))){
					
					scacchiera.scacchiera[destX][destY]=this;
					scacchiera.scacchiera[(destX+x)/2][(y+destY)/2]=null;  //mangio
					scacchiera.scacchiera[x][y]=null;
						
					x=destX;
					y=destY;
					
					return true;
				}	
			}
			
				if(giocatore==0){
					if ((x-destX==1||destX-x==1) && (destY-y==-1) && scacchiera.scacchiera[destX][destY]==null){ // sposto la pedina
				
						scacchiera.scacchiera[destX][destY]=this; 
						scacchiera.scacchiera[x][y]=null;			//muovo
				
						x=destX;
						y=destY;
							
						return true;
					}
					if (((((x-destX==2||destX-x==2)&&(destY-y==-2))&&scacchiera.scacchiera[destX][destY]==null)
							&&(scacchiera.scacchiera[(destX+x)/2][(y+destY)/2]!=null
							&&scacchiera.scacchiera[(destX+x)/2][(y+destY)/2].giocatore!=giocatore))){
						
						scacchiera.scacchiera[destX][destY]=this;
						scacchiera.scacchiera[(destX+x)/2][(y+destY)/2]=null;  //mangio
						scacchiera.scacchiera[x][y]=null;
							
						x=destX;
						y=destY;
						
						return true;
					}	
				}	
		
		else if (damone==true){
				if ((x-destX==1||destX-x==1) && ((destY-y==1)||(destY-y==-1)) && scacchiera.scacchiera[destX][destY]==null){
					
					scacchiera.scacchiera[destX][destY]=this; 
					scacchiera.scacchiera[x][y]=null;
					
					x=destX;
					y=destY;
								
					return true;
				}
				if (((((x-destX==2||destX-x==2)&&(destY-y==2)||(destY-y==-2))&&scacchiera.scacchiera[destX][destY]==null)
						&&(scacchiera.scacchiera[(destX+x)/2][(y+destY)/2]!=null
						&&scacchiera.scacchiera[(destX+x)/2][(y+destY)/2].giocatore!=giocatore))){
					
					scacchiera.scacchiera[destX][destY]=this;
					scacchiera.scacchiera[(destX+x)/2][(y+destY)/2]=null;
					scacchiera.scacchiera[x][y]=null;
						
					x=destX;
					y=destY;
					
					return true;
					}
		}	
		}
		return false;
	}
	
	public void eseguiMosse(Scacchiera scacchiera){
		while(next!=null)
			this.move(next.x, next.y, scacchiera);
				
	}
	
	public boolean movable(Scacchiera scacchiera){
		
		return canMove(x+1,y+1, scacchiera)||canMove(x-1,y+1, scacchiera)||canMove(x+1,y-1, scacchiera)||canMove(x-1,y-1, scacchiera)||canMove(x+2,y+2, scacchiera)||canMove(x+2,y-2, scacchiera)||canMove(x-2,y+2, scacchiera)||canMove(x-2,y-2, scacchiera);
		
	}

	public boolean canMove(int destX, int destY, Scacchiera scacchiera) {

		if ((destX<0||destX>7) ||(destY<0||destY>7))//esco dalla scacchiera
			return false;
		
		if (damone==false){//se sei giocatore umano controlla e muove in alto
		
			if(giocatore==1){
				if ((x-destX==1||destX-x==1) && (destY-y==1) && scacchiera.scacchiera[destX][destY]==null){ // sposto la pedina
			
					return true;
				}
				if (((((x-destX==2||destX-x==2)&&(destY-y==2))&&scacchiera.scacchiera[destX][destY]==null)
						&&(scacchiera.scacchiera[(destX+x)/2][(y+destY)/2]!=null
						&&scacchiera.scacchiera[(destX+x)/2][(y+destY)/2].giocatore!=giocatore))){
					
					return true;
				}	
			}
			
				if(giocatore==0){
					if ((x-destX==1||destX-x==1) && (destY-y==-1) && scacchiera.scacchiera[destX][destY]==null){ // sposto la pedina
							
						return true;
					}
					if (((((x-destX==2||destX-x==2)&&(destY-y==-2))&&scacchiera.scacchiera[destX][destY]==null)
							&&(scacchiera.scacchiera[(destX+x)/2][(y+destY)/2]!=null
							&&scacchiera.scacchiera[(destX+x)/2][(y+destY)/2].giocatore!=giocatore))){
				
						return true;
					}	
				}	
		
		else if (damone==true){
				if ((x-destX==1||destX-x==1) && ((destY-y==1)||(destY-y==-1)) && scacchiera.scacchiera[destX][destY]==null){
							
					return true;
				}
				if (((((x-destX==2||destX-x==2)&&(destY-y==2)||(destY-y==-2))&&scacchiera.scacchiera[destX][destY]==null)
						&&(scacchiera.scacchiera[(destX+x)/2][(y+destY)/2]!=null
						&&scacchiera.scacchiera[(destX+x)/2][(y+destY)/2].giocatore!=giocatore))){

					return true;
					}
		}	
		}
		return false;
	}
	
}