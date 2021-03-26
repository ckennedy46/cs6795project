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
		int numCharacters;
		List<String> charactersList = new ArrayList<String>();
		String location;
		int genderNum;
		int socioecNum;
		String birthCountry;
		String currentCountry;
		int childhoodNum;

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
		System.out.println("How many characters were involved in your experience?");
		numCharacters = Integer.parseInt(myObj.nextLine());
		for (int i = 0; i < numCharacters; i++) {
			System.out.println("Describe character " + (i + 1) + " in your experience:");
			charactersList.add(myObj.nextLine());
		}

		//location user input
		System.out.println("What was the location of your event/action:");
		location = myObj.nextLine();

		//gender user input
		System.out.println();
		System.out.println("Now we will ask you about your background.\nWhat is your gender? (please select a number)\n1. Male\n2. Female\n3. Transgender\n4. Nonbinary\n5. Other");
		genderNum = Integer.parseInt(myObj.nextLine());

		//socioeconomic level user input
		System.out.println("What would you define your socioeconomic level as growing up? (please select a number)\n1. Poor\n2. Middle Class\n3. Rich");
		socioecNum = Integer.parseInt(myObj.nextLine());

		//birth country user input
		System.out.println("Birth Country: ");
		birthCountry = myObj.nextLine();

		//current country user input
		System.out.println("Current Country:");
		currentCountry = myObj.nextLine();

		//childen affect user input
		System.out.println("Do you define your childhood as generally positive or negative? (please enter the number)\n1. Positive\n2. Negative");
		childhoodNum = Integer.parseInt(myObj.nextLine());

		//probably some logic here for getting the object

		//output here whenever we do that
	}
}