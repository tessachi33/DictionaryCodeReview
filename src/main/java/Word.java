import java.util.ArrayList;

public class Word{
  private static ArrayList<Word> instances = new ArrayList<Word>();

private String mUserWord;
private int mId;
private ArrayList<Definition> mDefinition;

public Word(String userWord){

  mUserWord = userWord;
  instances.add(this);
  mId = instances.size();
  mDefinition = new ArrayList<Definition>();
}

public String getUserWord(){
  return mUserWord;
}


}
