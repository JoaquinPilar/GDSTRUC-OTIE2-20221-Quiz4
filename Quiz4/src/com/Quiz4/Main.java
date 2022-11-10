package com.Quiz4;

// Quiz #4
// Instructions: Create a remove() function that accepts the same key that we have used before.
// Make sure to use linear probing when necessary.

// This is the main class
public class Main
{
    public static void main(String[] args)
    {
        // This creates the keys and its values
        Player tracer = new Player("Tracer", 22);
        Player widowmaker = new Player("Widowmaker", 169);
        Player bastion = new Player("Bastion", 999);
        Player winston = new Player("Winston", 48);

        SimpleHashtable hashtable = new SimpleHashtable();

        // This adds the initial players
        hashtable.put(tracer.getName(), tracer);
        hashtable.put(widowmaker.getName(), widowmaker);
        hashtable.put(bastion.getName(), bastion);
        hashtable.put(winston.getName(), winston);

        // This prints the contents of the INITIAL hashtable
        hashtable.printHashtable();

        // This removes a named player using the remove() function
        System.out.println("\nREMOVING PLAYER...");
        System.out.println(hashtable.remove("Bastion"));
        System.out.println("\n");

        // This prints the contents of the FINAL hashtable
        hashtable.printHashtable();
    }
}