import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		int genre;
		String action;
		int numCharacters;
		List<String> charactersList = new ArrayList<String>();
		String location;
		int genderNum;
		int socioecNum;
		String birthCountry;
		String currentCountry;
		int childhoodNum;

		System.out.println("Please type a number for your genre: \n1. Romance\n2. Mystery\n3. Science Fiction\n4. Fantasy\n5. Horror");
		genre = Integer.parseInt(myObj.nextLine());

		System.out.println();
		System.out.println("Now please describe your experience on which to base the story.\nFirst input the action/event in no more than a couple sentences:");
		action = myObj.nextLine();

		System.out.println("How many characters were involved in your experience?");
		numCharacters = Integer.parseInt(myObj.nextLine());
		for (int i = 0; i < numCharacters; i++) {
			System.out.println("Describe character " + (i + 1) + " in your experience:");
			charactersList.add(myObj.nextLine());
		}

		System.out.println("What was the location of your event/action:");
		location = myObj.nextLine();

		System.out.println();
		System.out.println("Now we will ask you about your background.\nWhat is your gender? (please select a number)\n1. Male\n2. Female\n3. Transgender\n4. Nonbinary\n5. Other");
		genderNum = Integer.parseInt(myObj.nextLine());

		System.out.println("What would you define your socioeconomic level as growing up? (please select a number)\n1. Poor\n2. Middle Class\n3. Rich");
		socioecNum = Integer.parseInt(myObj.nextLine());

		System.out.println("Birth Country: ");
		birthCountry = myObj.nextLine();

		System.out.println("Current Country:");
		currentCountry = myObj.nextLine();

		System.out.println("Do you define your childhood as generally positive or negative? (please enter the number)\n1. Positive\n2. Negative");
		childhoodNum = Integer.parseInt(myObj.nextLine());

		System.out.println("save action: " + action);
	}
}