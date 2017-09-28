package Model

import java.util.regex.Matcher

class Record {

    private String title
    private String name
    private String surname
    private String address1
    private String address2
    private String address3
    private String address4
    private String postal

    String getPrefix(){
        return title
    }

    String getFirst(){
        return getMiddleMatcher().replaceAll("")
    }

    String getMiddle(){
        if (getMiddleMatcher().find()){
            return getMiddleMatcher()[0].toString().replaceAll("\\s","")
        }
        return ""
    }

    private getMiddleMatcher(){
        String middleRegex = /\s+[A-Z]\.*$/
        Matcher middle = name =~ middleRegex
        return middle
    }

}
