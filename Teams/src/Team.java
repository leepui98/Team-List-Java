import java.util.ArrayList;

import ecs100.UI;

public class Team {
	private String teamN;
	private String coachesN;
	private int numPlayers;
	private ArrayList<Player> players = new ArrayList<Player>();

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public Team(String teamN, String coachesN, int numPlayers) {
		this.teamN = teamN;
		this.coachesN = coachesN;
		this.numPlayers = numPlayers;

	}

	public String getTeamN() {
		return teamN;
	}

	public void setTeamN(String teamN) {
		this.teamN = teamN;
	}

	public String getCoachesN() {
		return coachesN;
	}

	public void setCoachesN(String coachesN) {
		this.coachesN = coachesN;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public void displayT() {
		UI.println("Team name: " + teamN + ", Coach name : " + coachesN + ", number of players : " + numPlayers);

	}

	public void addPlayers(String playerN, int height, String PoB,ArrayList<String> position) {
		Player p = new Player(playerN, height, PoB,position);
		this.players.add(p);
	}

	public void addPlayers(Player p) {
		this.players.add(p);
	}

	public void displayTeamplayers(String Name) {
		for (Player w : players) {
			if (w.getPlayerN().equals(Name)) {
				w.displayP();
			}
		}
	}
	public void displayAllPlayers() {
		for(Player a : players) {
			UI.println(a.getPlayerN());
		}
	}
}
