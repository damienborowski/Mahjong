import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class Main {

	static HashMap<String, Player> map = new HashMap<String, Player>();
	static HashMap<Integer, Integer> baseValues = new HashMap<Integer, Integer>();
	static Scanner user = new Scanner(System.in);
	static int integerInput;
	static String textInput;

	public static void main(String[] args) {
		try {
			new Menu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void StartGame() {
		do {
			System.out.println("Enter what you want to do");

			System.out.println("Enter 1 to add new player");
			System.out.println("Enter 2 to read from file");
			System.out.println("Enter 3 to view ELO");
			System.out.println("Enter 4 to enter match result");
			System.out.println("Enter 5 to Exit");

			integerInput = user.nextInt();

			if (integerInput == 1) {
				AddPlayer();
			}

			if (integerInput == 2) {
				try {
					ReadFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (integerInput == 3) {
				PrintElo();
			}

			if (integerInput == 4) {
				AddMatch();
			}

		} while (integerInput != 5);
		WriteFile();
		System.out.println("Successful Quit.");
	}

	public static void AddPlayer() {
		System.out.println("Enter name of new player");

		textInput = user.next();
		textInput = textInput.toLowerCase();
		map.put(textInput, new Player(textInput));
	}

	// Reads line by line from file
	public static void ReadFile() throws FileNotFoundException, IOException {

		System.out.println("Enters ReadFile()");

		// ELO Scoring based on ranking in a given game
		baseValues.put(1, 30);
		baseValues.put(2, 10);
		baseValues.put(3, -10);
		baseValues.put(4, -30);

		Scanner scanner = new Scanner(new File("src/mahjong.txt"));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] arr = line.split("\t");

			String name = arr[0];
			int elo = Integer.parseInt(arr[1]);
			int gamesPlayed = Integer.parseInt(arr[2]);
			int wins = Integer.parseInt(arr[3]);

			map.put(name, new Player(name, elo, gamesPlayed, wins));
		}
		scanner.close();
	}

	// Write to the file
	public static void WriteFile() {
		try {
			File file = new File("src/mahjong.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			for (Map.Entry<String, Player> entry : map.entrySet()) {
				String name = entry.getValue().name;
				int elo = entry.getValue().elo;
				int gamesPlayed = entry.getValue().gamesPlayed;
				int wins = entry.getValue().wins;

				bw.write(name.toLowerCase() + "\t" + elo + "\t" + gamesPlayed + "\t" + wins + "\n");
			}

			bw.close();

			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void PrintElo() {
		System.out.println();

		int x;
		int y = 170;

		for (Map.Entry<String, Player> entry : map.entrySet()) {
			String name = entry.getValue().name;
			x = 15;
			try {
				Statistics_menu.printGui(name, x, y);
				int elo = entry.getValue().elo;
				x = 180;
				Statistics_menu.printGui(Integer.toString(elo), x, y);
				int gamesPlayed = entry.getValue().gamesPlayed;
				x = 345;
				Statistics_menu.printGui(Integer.toString(gamesPlayed), x, y);
				x = 470;
				int wins = entry.getValue().wins;
				Statistics_menu.printGui(Integer.toString(wins), x, y);
				y += 25;
				System.out.println(name + "\t" + elo + "\t" + gamesPlayed + "\t"+ wins);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println();
	}

	public static void AddMatch() {

		String[] arr = new String[4];
		int average = 0;

		for (int i = 0; i < 4; i++) {
			do {
				System.out.println("Enter name players at table in order of winner to loser");
				textInput = user.next();

			} while (!map.containsKey(textInput));
			arr[i] = textInput;
			average += map.get(textInput).elo;
		}

		average /= 4;
		System.out.println("AVG: " + average);

		for (int i = 1; i < 5; i++) {

			textInput = arr[i - 1];

			System.out.println(textInput);

			map.get(textInput).addGamesPlayed();

			double adjustment = 1 - (map.get(textInput).gamesPlayed * 0.002);
			System.out.println("ADJ: " + adjustment);
			double change = adjustment * (baseValues.get(i) + (average - map.get(textInput).elo) / 40);
			System.out.println("CHANGE: " + change);

			map.get(textInput).elo += (int) change;
			map.put(textInput, map.get(textInput));
		}
	}
}
