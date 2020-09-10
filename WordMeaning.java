
public class WordMeaning {
  private String word;
  private String meaning;

    public WordMeaning(String w, String m) {
        this.word = w;
        this.meaning = m;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }
    public void addMeaning(String m){
        this.meaning+="\n - "+m;
    }
    public String toString(){
        return word+" - "+meaning;
    }
}
