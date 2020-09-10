
public class WordList {
    private WordMeaningNode list;

    WordList()  
    {
        list = null;  
    }

    void insert(WordMeaning w) // Insert in proper place -- Sorting
    {
        WordMeaningNode temp = new WordMeaningNode(w);  

        if (list == null) list = temp;
        else // It is not the first node
        {
            WordMeaningNode current = list; 
            WordMeaningNode  previous = null;
            boolean found = false;

            while(current != null && !found) 
                if( temp.word.getWord().equalsIgnoreCase(current.word.getWord())) 
                {
                    current.word.addMeaning(w.getMeaning());
                    return;
                } else                       
                if( temp.word.getWord().compareTo(current.word.getWord())<  0)
                        found = true;
                else
                {
                    previous = current;
                    current = current.next;
                }

            temp.next = current;

            if (previous == null)
                list = temp;
            else
                previous.next = temp;
        }
    }
    void delete(WordMeaning w) 
    {      

        if (list == null) return;
        if(list.word.getWord().equals(w.getWord())) list=list.next;
        else // It is not the first node
        {
            WordMeaningNode current = list; 
            WordMeaningNode  previous = null;
            boolean found = false;

            while(current != null && !found) 
                if( w.getWord().equalsIgnoreCase(current.word.getWord())) found = true;                
                else
                {
                    previous = current;
                    current = current.next;
                }

            if(found) previous.next = current.next;           
        }
    }
    boolean exists(String w) 
    {   
        if (list == null) return false;
        
        WordMeaningNode current = list;         
        while(current != null) 
            if(current.word.getWord().equalsIgnoreCase(w)) return true;
                else current = current.next;
        
         return false;         
    }
    public String toString()
    {
        String result = "";
        WordMeaningNode current = list;

        while (current != null)
        {
            result += current.word.getWord() + "\n";
            current = current.next;
        }
        return result;
    }
    public String toString(boolean withMeaning)
    {
        if(!withMeaning) return toString();
        String result = "";
        WordMeaningNode current = list;

        while (current != null)
        {
            result += current.word.toString() + "\n";
            current = current.next;
        }
        return result;
    } 
}
