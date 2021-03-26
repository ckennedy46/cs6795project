import java.util.*;

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
