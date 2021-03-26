import java.util.*;

class Main {
	public enum Genre {
  		ROMANCE ("Romance"),
  		MYSTERY ("Mystery"),
  		SCIENCE_FICTION ("Science Fiction"),
  		FANTASY ("Fantasy"),
  		HORROR ("Horror");

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
				numCharacters = 1;
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
		
		
		//output characters
		System.out.println("Who - protagonists");
		System.out.println("Who - villain");
		//output events
		System.out.println("What");
		//output time
		System.out.println("When");
		//ourput location
		System.out.println("Where");
		//outpur plot type
		System.out.println("Why");
	}
}