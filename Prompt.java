import java.util.*;

public class Prompt {
    private String genre;
    private String timeSetting;
    private String plot;
    private String villain;
    private String villainAction;
    private String event;
    private List<String> characters = new ArrayList<String>();
    private String location;

    private Random rand = new Random();

    private HashMap<String, List<String>> whatEvents = new HashMap<>();
    private HashMap<String, List<String>> whenTime = new HashMap<>();
    private HashMap<String, List<String>> whoVillains = new HashMap<>();
    private List<String> allVillainActions;// = new ArrayList<String>();
    private List<String> allPlots;// = new ArrayList<String>();
    private List<String> allLocations;
    private HashMap<Integer, List<String>> traitsByAffects = new HashMap<>();
    

    public Prompt(String genre) {
        this.genre = genre;

        whatEvents.put("romance", new ArrayList<String>(Arrays.asList("forbidden love", "love at first sight", "former enemies", "arranged marriage", "best friends", "ill-fated love", "summer romance", "they broke their heart in the past", "their cultures clash", "one person started dating the other because of a bet")));
        whatEvents.put("fantasy", new ArrayList<String>(Arrays.asList("find buried treasure", "avenge your father's murder", "save your kidnapped friends", "learn long-lost magical skills", "save the village from destruction", "destroy the evil artifact", "go through a mysterious portal", "harness your new superpower", "defeat the oppressive rulerr", "discover a foreign world")));
        whatEvents.put("mystery", new ArrayList<String>(Arrays.asList("investigate a murder", "recover a ruby", "find a missingg heiress", "uncover a spy", "follow a treasurer map", "identify a serial killer", "solve a puzzle", "expose a secret plot", "outwit the antagonist", "arrest the antagonist")));
        whatEvents.put("horror", new ArrayList<String>(Arrays.asList("kill the villain", "outwit the villain", "escape", "get help", "survive", "incite a rebellion", "expose the villain", "dispossess the villain", "thward the villain", "cast a spell")));
        whatEvents.put("science fiction", new ArrayList<String>(Arrays.asList("brain surgery allows telekinesis", "a pandemic kills everyone over the age of 65", "climate change forces humans to abandon Earth", "alternate universe where Germany won WWII", "time travel", "superheros emerge", "kidnapped by aliens", "medical procedure to stop aging", "assigned job at birth", "pollution creates man-eating monster")));

        whenTime.put("romance", new ArrayList<String>(Arrays.asList("summer break in 2005", "revolutionary war", "medieval ages", "3020", "1974", "Renaissance Era", "during University", "during a music festival", "during COVID-19 pandemic", "during a wedding")));
        whenTime.put("fantasy", new ArrayList<String>(Arrays.asList("Age of Dragons", "Age of Empires", "Steampunk Era", "End of Golden Age", "Ice Age", "post-apocalyptic era", "dawning of the Magical Era", "Age of Fairies", "Age of Giants", "Age of Elves")));
        whenTime.put("mystery", new ArrayList<String>(Arrays.asList("WWII", "1920s", "during the pandemic", "Renaissance Era", "the best of times", "the worst of times", "the Old West", "Victorian Era", "during university", "alternate reality")));
        whenTime.put("science fiction", new ArrayList<String>(Arrays.asList("3030", "2012", "end of the millenium", "WWII", "end of life as we know it", "in the near future", "far into the future", "next ice age", "23rd century", "ancient times")));
        whenTime.put("horror", new ArrayList<String>(Arrays.asList("1888", "Renaissance Era", "Victorian Era", "1930s/40s Film Noir", "Friday the 13th", "Primordial Era", "winter", "Medieval", "Cold War", "the time of Cholera")));

        //whoVillains.put("romance", new ArrayList<String>(Arrays.asList("the jealous ex-girlfriend", "the disapproving mother", "the evil king", "the bully", "the competing love interest", "the powerful witch", "the corrupt CEO", "the abusive ex-husband", "the kidnapper", "the greedy politician")));
        whoVillains.put("romance", new ArrayList<String>(Arrays.asList("a jealous ex-girlfriend", "a disapproving mother", "an evil king", "a bully", "a competing love interest", "a powerful witch", "a corrupt CEO", "an abusive ex-husband", "a kidnapper", "a greedy politician")));
        //whoVillains.put("fantasy", new ArrayList<String>(Arrays.asList("evil queen", "sorcerer", "troll", "pirates", "gang of outlaws", "dragons", "ancient evil force", "the dark lord", "the traitor", "the beast")));
        whoVillains.put("fantasy", new ArrayList<String>(Arrays.asList("an evil queen", "a sorcerer", "a troll", "a pirate", "a gang of outlaws", "a dragon", "an ancient evil force", "a dark lord", "a traitor", "a beast")));
        //whoVillains.put("mystery", new ArrayList<String>(Arrays.asList("moriarty", "serial killer", "psychotic techno-wizard", "artificial super intelligence", "immoral lawyer", "corrupt cop", "scorned lover", "charismatic, but racist bigot", "deep state actor", "mob/gang boss")));
        whoVillains.put("mystery", new ArrayList<String>(Arrays.asList("moriarty", "a serial killer", "a psychotic techno-wizard", "an artificial super intelligence", "an immoral lawyer", "a corrupt cop", "a scorned lover", "a charismatic, but racist bigot", "a deep state actor", "a mob/gang boss")));
        //whoVillains.put("science fiction", new ArrayList<String>(Arrays.asList("dictator", "evil twin", "alien king", "deadly robot", "evil cyborg", "mad scientist", "supervillain", "controlling regime", "evil doctor", "invasive bacteria")));
        whoVillains.put("science fiction", new ArrayList<String>(Arrays.asList("a dictator", "an evil twin", "an alien king", "a deadly robot", "an evil cyborg", "a mad scientist", "a supervillain", "a controlling regime", "an evil doctor", "an invasive bacteria")));
        //whoVillains.put("horror", new ArrayList<String>(Arrays.asList("Jack the Ripper", "a humongous shark", "murderous pupper", "the Fates", "split personality", "evil clown", "cannibal", "possessed child", "psychotic vampire", "evil surgeon")));
        whoVillains.put("horror", new ArrayList<String>(Arrays.asList("Jack the Ripper", "a humongous shark", "a murderous pupper", "the Fates", "a split personality", "an evil clown", "a cannibal", "a possessed child", "a psychotic vampire", "an evil surgeon")));


        allVillainActions = new ArrayList<String>(Arrays.asList("killed your family", "restricted your freedoms", "seduced your ex", "stole your identity", "kidnapped your sibling", "framed you for robbery", "broke the law", "hurt your friends", "took advantage of minorities", "embezzled money"));
        allPlots = new ArrayList<String>(Arrays.asList("to go on a quest", "to go on an adventure", "to pursue or evade the villain", "to complete a rescue", "to escape", "to gain revenge", "to solve a riddle", "to rival the villain", "to overcome a disadvantage", "to resist temptation", "coming of age", "to transform your identity", "middle life crisis", "to fall in love", "to pursue forbidden love", "to sacrifice", "to discover a secret/treasure", "to become the villain", "to ascend to a higherr status", "to descend to a lower status"));
        allLocations = new ArrayList<String>(Arrays.asList("midwest", "beach", "Appalachian Mountains", "Paris", "New Zealand", "United States of Pangea", "Tokyo", "the Ghetto", "East Asia", "Los Angelos"));

        traitsByAffects.put(1, new ArrayList<String>(Arrays.asList("confident", "competent", "disciplined", "respectful", "artistic", "shy", "eccentric", "expressive", "naive", "thrill-seeking")));
        traitsByAffects.put(2, new ArrayList<String>(Arrays.asList("ruthless", "abusive", "inflexible", "secretly kinky", "oblivious", "fearful", "isolated", "superficial", "histrionic", "explosive anger")));

    }

    public void setGenre(String input) {
        genre = input;
    }

    public void setTimeSetting() {
        int num = rand.nextInt(10);
        timeSetting = whenTime.get(genre).get(num);
    }

    public void setPlot() {
        int num = rand.nextInt(20);
        plot = allPlots.get(num);
    }

    public void setVillain() {
        int num = rand.nextInt(10);
        villain = whoVillains.get(genre).get(num);
    }

    public void setVillainAction() {
        int num = rand.nextInt(10);
        villainAction = allVillainActions.get(num);
    }

    public void setEvent(String input) {
        if (input.isEmpty() || input == null) {
            int num = rand.nextInt(10);
            event = whatEvents.get(genre).get(num);
        } else {
            event = input;
        }
    }

    public void setCharacters(int numCharacters, List<String> input, String gender, String economic, int affect) {
        if (numCharacters == 0) {
            int num = rand.nextInt(10);
            String trait = traitsByAffects.get(affect).get(num);

            String character = economic + " " + trait +  " " + gender;
            characters.add(character);
        } else {
            characters = new ArrayList<String>(input);
        }
    }

    public void setLocation(String currCountry, String birthCountry, String expLocation) {
        int num = rand.nextInt(3);
        if (num == 0 && !currCountry.isEmpty()) {
            location = currCountry;
        } else if (num == 1 && !birthCountry.isEmpty()) {
            location = birthCountry;
        } else if (num == 2 && !expLocation.isEmpty()) {
            location = expLocation;
        } else {
            int newNum = rand.nextInt(10);
            location = allLocations.get(newNum);
        }
    }

    public String getGenre() {
        return genre;
    }

    public String getTimeSetting() {
        return timeSetting;
    }

    public String getPlot() {
        return plot;
    }

    public String getVillain() {
        return villain;
    }

    public String getVillainAction() {
        return villainAction;
    }

    public String getEvent() {
        return event;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public String getLocation() {
        return location;
    }

    
}