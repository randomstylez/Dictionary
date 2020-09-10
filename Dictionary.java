
import javax.swing.JOptionPane;
/**
 *
 * @author Joey
 */

public class Dictionary {


    public static void main(String[] args) {
        WordList words = new WordList();
        WordList deletedWords = new WordList();
        String menu="1. Add word\n"
                + "2. Display words & meanings\n"
                + "3. Delete word\n"
                + "4. Display deleted words\n"
                + "5. Quit";
        String choice ="";
        while(!choice.equals("5")) {
          choice = JOptionPane.showInputDialog(null,
                 menu, "Enter your menu choice",3);   
          if (choice==null) continue;
          choice = choice.trim();
          switch(choice) {
              case "1":addWord(words);
                break;
              case "2":System.out.println("Words in the dictionary:");
                  System.out.println(words.toString(true));
                break;
              case "3": deleteWord(words, deletedWords);
                break;
              case "4":System.out.println("Words in the obsolete dictionary:");
                  System.out.println(deletedWords);
                break;
              case "5":JOptionPane.showMessageDialog(null, 
                  "Bye!"); 
                break;
              default: JOptionPane.showMessageDialog(null, 
                  "Invalid choice","Error", JOptionPane.ERROR_MESSAGE); 
          }
        }

    }
    public static void addWord(WordList words) {
        String word = getString("Enter word please");
        String meaning = getString("Enter meaning of "+word+" please");
        WordMeaning w = new WordMeaning(word, meaning);
        words.insert(w);                
    }
    public static void deleteWord(WordList words, WordList deletedWords) {
        String word = getString("Enter word please");
        if(words.exists(word))
        {
          WordMeaning w = new WordMeaning(word, "");   
          words.delete(w);
          deletedWords.insert(w);
          JOptionPane.showMessageDialog(null, 
                  "Word "+word +" has been deleted from dictionary","Success", 
                  JOptionPane.INFORMATION_MESSAGE);
        } else 
        {
            JOptionPane.showMessageDialog(null, 
                  "Word "+word +" doesn't exist in the dictionary","Error", 
                  JOptionPane.ERROR_MESSAGE);
        }
                 
    }
    public static String getString(String info) {
        String tempString = JOptionPane.showInputDialog(null,info,
                "Input is required", 3); 
        
        while(tempString==null || tempString.trim().length()==0) {
        JOptionPane.showMessageDialog(null, 
                  "Please, enter proper string","Error", 
                  JOptionPane.ERROR_MESSAGE);  
        tempString = JOptionPane.showInputDialog(null,info, 
                "Input is required",3); 
        }
        return tempString;
    }
    
}
