
public class Player {
	
	String name;
	int elo;
	int gamesPlayed;
	int wins;
	
	public Player(String name) {
		this.name = name;
		this.elo = 1500;
		this.gamesPlayed = 0;
		this.wins = 0;
	}
	
	public Player(String name, int elo, int gamesPlayed, int wins) {
		this.name = name;
		this.elo = elo;
		this.gamesPlayed = gamesPlayed;
		this.wins = wins;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getElo() {
		return this.elo;
	}
	
	public void addElo(int elo) {
		this.elo += elo;
	}
	
	public int getGamesPlayed() {
		return this.gamesPlayed;
	}
	
	public void addGamesPlayed() {
		this.gamesPlayed += 1; 
	}
}
