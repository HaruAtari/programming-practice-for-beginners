package org.haruatari;

abstract public class BaseTest {
    protected String equalityErrorMessage(String expected, String actual){
        return errorMessage("Expected result: "+expected+"\nActual result: "+actual);
    }

    protected String errorMessage(String message){
        return "\n\nTEST FAILED!\n"+message+"\n\n";
    }
}
