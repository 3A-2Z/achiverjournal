package com.JournalEntry.JournalEntry.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties; 
import java.util.Set;  
import java.util.UUID;
import edu.stanford.nlp.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;   
import edu.stanford.nlp.pipeline.StanfordCoreNLP;  
import edu.stanford.nlp.util.CoreMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JournalEntry {
    private UUID entryID;
    private String title;
    private String entryTags;
    private LocalDate date;
    private String text;
    /*
    * Helper function for setTags() in determining a word's part of speech
    */
    public boolean pos(String part){

        Set<String> desiredPos = new HashSet<String>();
        desiredPos.add("NNP");
        desiredPos.add("NNPS");
        desiredPos.add("NNS");
        desiredPos.add("NN");
        desiredPos.add("RB");
        desiredPos.add("RBR");
        desiredPos.add("RBS");
        desiredPos.add("VB");
        desiredPos.add("VBG");
        desiredPos.add("VBN");
        desiredPos.add("VBP");
        desiredPos.add("VBE");
        return desiredPos.contains(part);
        
    }
    /*
    * setTags creates tags based on the versions of nouns, verbs, and adverbs within entry text
    */
    public String setTags(String text){
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props); 
        Annotation doc = new Annotation(text);
        pipeline.annotate(doc);
        List<CoreMap> sentences = doc.get(CoreAnnotations.SentencesAnnotation.class);
        String tags = "";
        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                if(pos(pos)){
                    tags = tags + word + " ,";
                } 
            } 
        }
        return tags;
    }
    /*
    * Constructor for initial creation of a Journal Entry
    */
    public JournalEntry(@JsonProperty("ID") UUID entryID, @JsonProperty("title") String title,
             @JsonProperty("text") String text){
        this.entryID = UUID.randomUUID();
        this.title = title;
        this.text = text;
        this.date = java.time.LocalDate.now();
        this.entryTags = " ";//setTags(text);
    }
    /*
    * Constructor for retrieving a journal entry with its original date of creation
    */
    public JournalEntry(UUID entryID, LocalDate date, String title, String text){
        this.entryID = entryID;
        this.title = title;
        this.text = text;
        this.date = date;
        this.entryTags = " ";//setTags(text);
    }

    public UUID getEntryID() {
        return entryID;
    }

    public String getTitle() {
        return title;
    }


    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getEntryTags() {
        return entryTags;
    }
    public void setDate() {
        this.date = java.time.LocalDate.now();
    }

    public void setText(String newText) {
        this.text = newText;
        this.entryTags = " ";//setTags(newText); // New tags must be created on the setting of new text
   }
    public void setTitle(String newTitle) {
        this.title = newTitle;
   }
    
}