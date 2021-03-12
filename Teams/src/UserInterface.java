import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ecs100.UI;
import java.util.ArrayList;
import java.util.ArrayList;

public class UserInterface {
	private ArrayList<Team> teams = new ArrayList<Team>();
	private ArrayList<Player> players = new ArrayList<Player>();

	public void listTeams() {
		for (Team c : teams) {
			UI.println("List of teams : " + c.getTeamN());
		}
	}

	public void listTeamsWithCoaches() {
		for (Team a : teams) {
			UI.println("Team name : " + a.getTeamN() + ", Coach name : " + a.getCoachesN());
		}
	}

	public void listTeamPlayers() {
		String team = UI.askString("Which team?");
		for (Team a : teams) {
			if (a.getTeamN().equalsIgnoreCase(team)) {
				UI.println("Team players in this team : ");
				a.displayAllPlayers();

			}
		}
	}

	public void listPositionPlayersOnTeam() {
		String team = UI.askString("Which team?");
		String position = UI.askString("Which position?");
		for (Team t : teams) {
			if (t.getTeamN().equalsIgnoreCase(team)) {
				for(Player p : t.getPlayers()) {
					if(p.getPosition().contains(position)) {
						UI.println(p.getPlayerN());
					}
				}
			}
		}
	}

	public void listHeights() {
		int min = UI.askInt("Taller than?");
		int max = UI.askInt("Shorter than?");
		for (Player p : players) {
			if (p.getHeight() > min && p.getHeight() < max) {
				UI.println("The players who fit into this height range : " + p.getPlayerN());
			}
		}
	}

	public void checkSelection() {

	}

	public void graphHeights() {
     int graphX= 20;
     int graphY=320;
     UI.setColor(Color.black);
    // UI.drawLine(graphX, graphY, graphX+ players.size(), graphY+ players.get);
    // UI.drawLine(graphX, graphY, graphX + (players arraylist size ), graphY+ (players height);
     
	}

	public UserInterface() {
		UI.initialise();
		UI.addButton("List teams", this::listTeams);
		UI.addButton("List coaches", this::listTeamsWithCoaches);
		UI.addButton("List team players", this::listTeamPlayers);
		UI.addButton("List players by position", this::listPositionPlayersOnTeam);
		UI.addButton("Search by height", this::listHeights);
//		UI.addButton("Check team lineup", this::checkSelection);
//		UI.addButton("Graph player heights", this::graphHeights);
		// This is the file with no player data listed.
		// When you extend your system to include players,
		// change it to "teams.txt" and update the parsing
		// code below.
		String fileName = "teams.txt";
		// You may want to use this, or move it somewhere else,
		// or write your own version.
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {
				// .trim() removes whitespace from the ends
				// of strings - takes the "\n" away that
				// .nextLine() left on the end.
				String teamName = scanner.nextLine().trim();
				String coachName = scanner.nextLine().trim();
				int numPlayers = scanner.nextInt();
				// This discards the rest of the line after
				// the number - needed because otherwise the
				// *next* nextLine() would give an empty
				// string.
				// You will want this any time you read an int.
				scanner.nextLine();

				Team t = new Team(teamName, coachName, numPlayers);

				/*-----------------------------------------------------------
				 * YOUR CODE HERE: handling the team data - put it somewhere sensible to use
				 * elsewhere. Use the teamName and coachName variables above.
				 * 
				 * Tip: You will want to have made at least one class by this point,
				 * and at least one ArrayList.
				 * -----------------------------------------------------------
				 */

				for (int i = 0; i < numPlayers; i++) {
					String s = scanner.next();
					Scanner sc = new Scanner(s);
					sc.useDelimiter(",");
					ArrayList<String> position = new ArrayList<String>();
					while (sc.hasNext()) {
						position.add(sc.next());
					}

					String playerName = scanner.nextLine().trim();
					int playerHeight = scanner.nextInt();
					scanner.nextLine();
					String PoB = scanner.nextLine().trim();
					Player p = new Player(playerName, playerHeight, PoB, position);
					players.add(p);
					t.addPlayers(p);

					//
					//
					// while (sc.hasNext()) {

					/*
					 * YOUR CODE HERE **LATER**: - loading the player information from the full
					 * teams.txt. There will be numPlayers sets of player data right after the team
					 * information finishes.
					 * 
					 * You will consume three lines of text for each player, in the format below.
					 * 
					 * Hint: you can use a Scanner to split a string apart into pieces, using a
					 * different delimiter instead of whitespace with the "useDelimiter" method. For
					 * example: String s = "ABCxDEFxGHI"; Scanner sc = new Scanner(s);
					 * sc.useDelimiter("x"); a = sc.next(); // "ABC" b = sc.next(); // "DEF"
					 */
					// File format for players:
					// AB,CD Morgan Matthews
					// 177
					// Wellington
				}
				teams.add(t);
			}

			scanner.close();

		} catch (

		FileNotFoundException e) {
			UI.printf("Error loading file: %s%n", e);
		}
	}

	public static void main(String[] args) {
		new UserInterface();
	}
}
