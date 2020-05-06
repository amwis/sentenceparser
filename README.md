## Goal

Create methods that parse string input, isolate longest/shortest words from the input and give the length of the shortest/longest words

#### Assumptions

* Input will be a string of any length containing any ascii characters
* Letters, numbers and underscores will constitute words (as per \\W+ pattern, it will ignore non-latin letters)
* Parsers will be able to handle scenarios where with multiple longest/shortest words with same amount of characters and/or duplicates
* Parsing methods are going to return a map consisting of list of strings containing appropriate words and an integer holding the length value
* Java's String class comes with a length method, which returns the number of characters in the string, there is no need to re-test it, so tests will only cover the correct longest/shortest words scenarios

#### How to run
This is a maven project with surefire plugin as dependency

* Easiest option is to run it inside an IDE (tested in Intellij)
* Alternatively go to project root and run `mvn test`