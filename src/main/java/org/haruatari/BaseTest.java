package org.haruatari;

abstract public class BaseTest {
    protected String errorMessage(String expected, String actual){
        return "\n\nTEST FAILED!\nExpected result: "+expected+"\nActual result: "+actual+"\n\n";
    }
}
