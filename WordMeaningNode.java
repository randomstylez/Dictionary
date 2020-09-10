
public class WordMeaningNode {
    WordMeaning word;
    WordMeaningNode next;

    WordMeaningNode(WordMeaning w)
    {
            word = w;
            next = null;
    } 
    WordMeaningNode(WordMeaning w, WordMeaningNode n)
    {
            word = w;
            next = n;
    } 

    public WordMeaning getWord() {
        return word;
    }

    public WordMeaningNode getNext() {
        return next;
    }
    
}
