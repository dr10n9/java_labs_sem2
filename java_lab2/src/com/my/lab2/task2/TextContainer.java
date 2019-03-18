package com.my.lab2.task2;

import java.util.*;

public class TextContainer {
    private List<String> text;

    /**
     * Constructor that takes in a string
     * and converts it into a list of normalized words
     * @param rawStringData initial string text
     */
    public TextContainer(String rawStringData){
        if(rawStringData.equals("")){
            throw new IllegalArgumentException("Cannot construct text from an empty string");
        }
        text = Arrays.asList(removePunctuation(rawStringData).split(" "));
    }

    /**
     * Returns a slice of the list that consists of words
     * where first letter equals last
     * @return new list of words
     */
    public List<String> getUniqueWhereFirstEqualsLast(){
        List<String>operationalList = new ArrayList<>();
        for(String word : text){
            if(firstLetterEqualsLast(word))
                operationalList.add(word);
        }
        return new ArrayList<>(new HashSet<>(operationalList));
    }

    /**
     * Inserts a token after a word that ends with a given substring
     * @param substring substring that the word ends with
     * @param token token to insert after found words
     * @return new list of words
     */
    public List<String> putTokenWhenSubstringOccurs(String substring, String token){
        List<String>resultingList = new ArrayList<>();
        for(String word : text){
            if(word.endsWith(substring))
                resultingList.add(word +  token);
            else resultingList.add(word);
        }
        return resultingList;
    }


    /**
     * Checks if the first letter of the word equals last
     * @param word the item to analyze letters
     * @return boolean result of comparison
     */
    private boolean firstLetterEqualsLast(String word){
        return word.charAt(0) == word.charAt(word.length() - 1);
    }

    /**
     * Removes all punctuation from text
     * @param rawData raw string text
     * @return clean text
     */
    private String removePunctuation(String rawData){
        return rawData.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }

    /**
     * Checks if contained list of the object
     * contains the same strings as another object's
     * contained list
     * @param t object to analyze content
     * @return boolean result of analysis
     */
    public boolean equals(TextContainer t) {
        int i = 0;
        for(String word : t.text){
            if(!word.equals(text.get(i)))
                return false;
        }
        return true;
    }

    /**
     * Returns hashcode for the object
     * @return object's hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    /**
     * Converts object into string
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "Text{" +
                "text=" + text +
                '}';
    }

    /**
     * Compares links to objects
     * @param o object to compare(links)
     * @return boolean result of comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextContainer text1 = (TextContainer) o;
        return Objects.equals(text, text1.text);
    }
}
