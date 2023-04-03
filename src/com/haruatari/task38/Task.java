package com.haruatari.task38;

import com.haruatari.task38.excetions.*;

public class Task {

    /*
    Call method1()
    in the case of CanNotCreateFileException print "can not create file: <exception's message>"
    in the case of FileNotFoundException print "file not found: <exception's message>"
     */

    /*
    Call method2()
    on any exception print "error: <exception's message>"
     */

    /*
    Call method3()
    in the case of InvalidDataException print "invalid: <exception's message>"
    for any other exception print "problem with the size of data: <exception's message>"
     */
    /*
    - print "Hello!"
    - Call method4() then method5()
    - print "Hello again!
     */
    /*
    - call method4()
    - handle its exception and print its message
    - throw that exception again
     */
    /*
    - call method4()
    - handle its exception and print its message
    - throw BaseException instead
     */
    public void main(String[] args) {
    }

    private void method1() throws CanNotCreateFileException, FileNotFoundException {
        if (Math.random() > 0.5) {
            throw new FileNotFoundException("Test message 1");
        } else {
            throw new CanNotCreateFileException("Test message 1.1");
        }
    }

    private void method2() throws FileException {
        if (Math.random() > 0.5) {
            throw new FileNotFoundException("Test message 1");
        } else {
            throw new FileException("Test message 1.1");
        }
    }

    private void method3() throws InvalidDataException, DataIsTooLongException, EmptyDataException {
        var rand = Math.random();

        if (rand < 0.3) {
            throw new InvalidDataException("Test message 1");
        } else if (rand < 0.7) {
            throw new DataIsTooLongException("Test message 1.1");
        } else {
            throw new EmptyDataException("Test message 1.2");
        }
    }

    private void method4() throws FileNotFoundException {
        throw new FileNotFoundException("Test message 1");
    }

    private void method5() throws InvalidDataException {
        throw new InvalidDataException("Test message 1");
    }
}
