package com.AchieverJournal.AchieverJournal.model;
/*
* Class was used for journal updates for initial in memory database implementation, may be ignored
*/
public class Tag {
   private final String tagName;
   public Tag(String tagName) {
        this.tagName = tagName;


   } 
   public String getTagName(){
       return tagName;
   }
}
