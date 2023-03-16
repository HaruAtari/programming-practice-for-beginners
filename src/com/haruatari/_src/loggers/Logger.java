package com.haruatari._src.loggers;

abstract public class Logger {
    final static protected String COLOUR_ERROR = "\u001B[31m";
    final static protected String COLOUR_SUCCESS = "\u001B[32m";
    final static protected String COLOUR_HIGHLIGHT = "\u001B[34m";
    final static protected String BACKGROUND_ERROR = "\u001B[41m";
    final static protected String BACKGROUND_SUCCESS = "\u001B[42m";
    final static protected String BACKGROUND_WHITE = "\u001B[47m";
    final static protected String RESET_STYLE = "\u001B[0m";

    final static protected String separator = "\n====================================================================================================\n\n";
}
