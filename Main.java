import java.util.*;

class Main {
	public enum Genre {
  		ROMANCE ("romance"),
  		MYSTERY ("mystery"),
  		SCIENCE_FICTION ("science fiction"),
  		FANTASY ("fantasy"),
  		HORROR ("horror");

  		private String name;
  			Genre(String name) {
    		this.name = name;
  		}

  		public String getName() {
    		return this.name;
  		}
	}

	public enum Gender {
  		MAN ("Man"),
  		WOMAN ("Woman"),
  		TRANSGENDER ("Transgender"),
  		NONBINARY ("Non-Binary"),
  		OTHER ("Other");

  		private String name3;
  		Gender(String name3) { this.name3 = name3;}

  		public String getName() { return this.name3; }
	}

	public enum Socioeconomic {
  		POOR ("Poor"),
  		MIDDLE_CLASS ("Middle Class"),
  		RICH ("Rich");

  		private String name2;
  		Socioeconomic (String name2) {
    		this.name2 = name2;
  		}

  		public String getName() {
    		return this.name2;
  		}
	}

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		int genre = -1;
		String action;
		int numCharacters = -1;
		List<String> charactersList = new ArrayList<String>();
		String location;
		int genderNum = -1;
		int socioecNum = -1;
		String birthCountry;
		String currentCountry;
		int childhoodNum = -1;
		Random rand = new Random();

		//genre user input
		while (genre == -1) {
			System.out.println("Please type a number for your genre: \n1. Romance\n2. Mystery\n3. Science Fiction\n4. Fantasy\n5. Horror");
			String genreString = myObj.nextLine();
			if (genreString.equals("")) {
				genre = -1;
			}
			else {
				try {
					genre = Integer.parseInt(genreString);
				}
				catch (Exception e) {
					genre = -1;
					System.out.println("Please type a NUMBER");
				}
				
			}
		}


		//action user input
		System.out.println();
		System.out.println("Now please describe your experience on which to base the story.\nFirst input the action/event in no more than a couple sentences:");
		action = myObj.nextLine();

		//character user input
		while (numCharacters == -1) {
			System.out.println("How many characters were involved in your experience?");
			String numCharString = myObj.nextLine();
			if (numCharString.equals("")) {
				numCharacters = 0;
			}
			else {
				try {
					numCharacters = Integer.parseInt(numCharString);
				}
				catch (Exception e){
					numCharacters = -1;
					System.out.println("Please type a NUMBER");
				}
			}
		}
		for (int i = 0; i < numCharacters; i++) {
			System.out.println("Describe character " + (i + 1) + " in your experience:");
			charactersList.add(myObj.nextLine());
		}

		//location user input
		System.out.println("What was the location of your event/action:");
		location = myObj.nextLine();

		//gender user input
		System.out.println();
		while (genderNum == -1) {
			System.out.println("Now we will ask you about your background.\nWhat is your gender? (please select a number)\n1. Male\n2. Female\n3. Transgender\n4. Nonbinary\n5. Other");
			String genderString = myObj.nextLine();
			if (genderString.equals("") || genderString.equals("5")) {
				genderNum = rand.nextInt(4) + 1;
			}
			else {
				try {
					genderNum = Integer.parseInt(genderString);
				}
				catch (Exception e) {
					genderNum = -1;
					System.out.println("Please type a NUMBER");
				}
			}
		}

		//socioeconomic level user input
		while (socioecNum == -1) {
			System.out.println("What would you define your socioeconomic level as growing up? (please select a number)\n1. Poor\n2. Middle Class\n3. Rich");
			String socioec = myObj.nextLine();
			if (socioec.equals("")) {
				socioecNum = rand.nextInt(3) + 1;
			}
			else {
				try {
					socioecNum = Integer.parseInt(socioec);
				}
				catch (Exception e) {
					socioecNum = -1;
					System.out.println("Please type a NUMBER");
				}
			}
			
		}

		//birth country user input
		System.out.println("Birth Country: ");
		birthCountry = myObj.nextLine();

		//current country user input
		System.out.println("Current Country:");
		currentCountry = myObj.nextLine();

		//childen affect user input
		while (childhoodNum == -1) {
			System.out.println("Do you define your childhood as generally positive or negative? (please enter the number)\n1. Positive\n2. Negative");
			String childhood = myObj.nextLine();
			if (childhood.equals("")) {
				childhoodNum = rand.nextInt(2) + 1;
			}
			else {
				try {
					childhoodNum = Integer.parseInt(childhood);
				}
				catch (Exception e) {
					childhoodNum = -1;
					System.out.println("Please type a NUMBER");
				}
			}
		}

		//probably some logic here for getting the object
		Genre gen[] = Genre.values();
		String genreString = gen[genre - 1].getName();
		Prompt prompt = new Prompt(genreString);
		
		System.out.println("\n\n\n");
		System.out.println("*** Story Prompt ***");


		//output genre
		System.out.println();
		System.out.println("Genre: " + genreString);
		System.out.println();

		//output characters
		System.out.println("Who - protagonists");
		Gender gend[] = Gender.values();
		String genderString = gend[genderNum - 1].getName();

		Socioeconomic socio[] = Socioeconomic.values();
		String economic = socio[socioecNum - 1].getName();

		prompt.setCharacters(numCharacters, charactersList, genderString, economic, childhoodNum);
		List<String> chars = prompt.getCharacters();
		for(int i = 0; i < chars.size(); i ++) {
			int n = i + 1;
			System.out.println("Charcter " + n + ": " + chars.get(i));
		}
		System.out.println();
		System.out.println("Who - villain");
		prompt.setVillain();
		prompt.setVillainAction();
		String villain = prompt.getVillain();
		String villainAction = prompt.getVillainAction();
		System.out.println(villain + " who " + villainAction);
		System.out.println();

		//output events
		System.out.println("What");
		prompt.setEvent(action);
		String event = prompt.getEvent();
		System.out.println(event);
		System.out.println();

		//output time
		System.out.println("When");
		prompt.setTimeSetting();
		String time = prompt.getTimeSetting();
		System.out.println(time);
		System.out.println();

		//ourput location
		System.out.println("Where");
		prompt.setLocation(currentCountry, birthCountry, location);
		String locationOutput = prompt.getLocation();
		System.out.println(locationOutput);
		System.out.println();

		//output plot type
		System.out.println("Why");
		prompt.setPlot();
		String plot = prompt.getPlot();
		System.out.println(plot);


		System.out.println();
		String output = "";
		if (chars.size() == 1) {
			output += "The protagonist, ";
		}
		else {
			output += "The " + chars.size() + " protagonists, ";
		}

		String first = chars.get(0);
		if (first.length() >= 2 && first.substring(0, 2).equals("a ") || first.length() >= 3 && first.substring(0, 3).equals("an ")) {
			output += first;
		}
		else {
			if (first.substring(0, 1).equals("a") || first.substring(0, 1).equals("e") || first.substring(0, 1).equals("i") || first.substring(0, 1).equals("o") || first.substring(0, 1).equals("u")) {
				output += "an " + first;
			}
			else {
				output += "a " + first;
			}
		}

		if (chars.size() == 2) {
			output += " and ";
			String second = chars.get(1);
			if (second.length() >= 2 && second.substring(0, 2).equals("a ") || second.length() >= 3 && second.substring(0, 3).equals("an ")) {
				output += second;
			}
			else {
				if (second.substring(0, 1).equals("a") || second.substring(0, 1).equals("e") || second.substring(0, 1).equals("i") || second.substring(0, 1).equals("o") || second.substring(0, 1).equals("u")) {
					output += "an " + second;
				}
				else {
					output += "a " + second;
				}
			}
		}
		else if (chars.size() > 2) {
			for (int i = 1; i < chars.size() - 1; i++) {
				String curr = chars.get(i);
				if (curr.length() >= 2 && curr.substring(0, 2).equals("a ") || curr.length() >= 3 && curr.substring(0, 3).equals("an ")) {
					output += ", " + curr;
				}
				else {
					if (curr.substring(0, 1).equals("a") || curr.substring(0, 1).equals("e") || curr.substring(0, 1).equals("i") || curr.substring(0, 1).equals("o") || curr.substring(0, 1).equals("u")) {
						output += ", an " + curr;
					}
					else {
						output += ", a " + curr;
					}
				}
			}
			String lastOne = chars.get(chars.size() - 1);
			if (lastOne.length() >= 2 && lastOne.substring(0, 2).equals("a ") || lastOne.length() >= 3 && lastOne.substring(0, 3).equals("an ")) {
				output += ", and " + lastOne;
			}
			else {
				if (lastOne.substring(0, 1).equals("a") || lastOne.substring(0, 1).equals("e") || lastOne.substring(0, 1).equals("i") || lastOne.substring(0, 1).equals("o") || lastOne.substring(0, 1).equals("u")) {
					output += ", and an " + lastOne;
				}
				else {
					output += ", and a " + lastOne;
				}
			}
		}
		System.out.print(output);

		System.out.print(", fought against the villain, " + villain + " who " + villainAction + ", in " + locationOutput + " during " + time + " " + plot + " because " + event);
		System.out.println();
	}
}