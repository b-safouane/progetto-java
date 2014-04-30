package controller;

import model.Giocatore;;

public class SolvedChecker {
	
	private final boolean isSolved;
	
	public SolvedChecker(Giocatore user, Giocatore cpu) {
        this.isSolved = checkSolved(user,cpu);
	}
	
	private boolean checkSolved(Giocatore user, Giocatore cpu){
		int i, j;
		for(i=0;i<12;i++)
			if (user.pedine[i]!=null)
				for(j=0;j<12;j++){
					if (cpu.pedine[j]!=null)
						return false;
					if (j==11)
						return true;
				}
		return true;				
				
	}
	
	public boolean isSolved() {
        return isSolved;
	}
	

}
