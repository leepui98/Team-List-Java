import ecs100.UI;
import java.util.ArrayList;

public class Player {
	private String playerN;
	private int height;
	private String PoB;
	private ArrayList<String> position = new ArrayList<String>();

	public ArrayList<String> getPosition() {
		return position;
	}

	public void setPosition(ArrayList<String> position) {
		this.position = position;
	}

	public Player(String playerN, int height, String PoB, ArrayList<String> position) {
		this.playerN = playerN;
		this.height = height;
		this.PoB = PoB;
		this.position = position;
	}

	public String getPlayerN() {
		return playerN;
	}

	public void setPlayerN(String playerN) {
		this.playerN = playerN;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getPoB() {
		return PoB;
	}

	public void setPoB(String poB) {
		PoB = poB;
	}

	public void displayP() {	
		for(String a : position) {
			UI.println(a);
			}
		UI.printf("Player name: " + playerN );
	}

    public void displayAllData() {		
    	for(String a : position) {
			UI.println(a);
			}
	UI.printf("Player name: " + playerN + ", Player height : " + height + ", Place of birth : " + PoB,
		"Playing positions :" + position );
    }
    }
