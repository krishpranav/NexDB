package org.nex.util;

public class MigrationFileParser {

    private String content;

    public MigrationFileParser(String content){
        this.content = content.replaceAll("(\\/\\*([\\s\\S]*?)\\*\\/)|(--(.)*)|(\n)","");
    }

    public String[] getStatements(){
        return this.content.split(";");
    }

}