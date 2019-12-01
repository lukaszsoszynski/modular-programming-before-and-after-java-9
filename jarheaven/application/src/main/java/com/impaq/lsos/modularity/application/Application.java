package com.impaq.lsos.modularity.application;

import com.impaq.lsos.modularity.library.LibraryClass;

import java.util.stream.IntStream;

public class Application {

    public static void main(String[] argc) {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("!!! --- Application started, lets try invoke function from library. --- !!!");
        System.out.println("----------------------------------------------------------------------------");
        IntStream
                .range(0, 3)
                .forEach(i -> System.out.println());

        LibraryClass libraryClass = new LibraryClass();
        String messageFromLibrary = libraryClass.liblaryFunction();
        System.out.println("Message from library: " + messageFromLibrary);
    }
}
