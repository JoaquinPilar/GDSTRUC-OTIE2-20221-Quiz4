package com.Quiz4;

// This is the simplehashtable class
public class SimpleHashtable
{
    private final StoredPlayer[] hashtable;
    public SimpleHashtable() {
        hashtable = new StoredPlayer[10];
    }
    public void put(String Key, Player value)
    {
        int hashedKey = hashKey(Key);

        // This applies linear probing
        if (isOccupied(hashedKey))
        {
            int stoppingIndex = hashedKey;

            // This hashedkey points at the last element
            if (hashedKey == hashtable.length - 1)
            {
                hashedKey = 0;
            }

            else
            {
                hashedKey++;
            }

            // This searches the array for the next vacant slot
            while (isOccupied(hashedKey) && hashedKey != stoppingIndex)
            {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        // If an element is occupying a slot
        if (isOccupied(hashedKey))
        {
            System.out.println(hashedKey + "THIS ELEMENT IS ALREADY OCCUPIED...");
        }

        // Else if an element is not occupying a slot
        else
        {
            hashtable[hashedKey] = new StoredPlayer(Key, value);
        }
    }

    // This function gets a key
    public Player get(String Key)
    {
        int hashedKey = findKey(Key);

        // If a named player does not exist
        if (hashedKey == -1)
        {
            System.out.println("THIS PLAYER DOES NOT EXIST...");
            return null;
        }

        return hashtable[hashedKey].value;
    }

    // This function removes a key
    public Player remove(String Key)
    {
        int hashedKey = findKey(Key);

        // If a named player does not exist
        if (hashedKey == -1)
        {
            System.out.println("THIS PLAYER DOES NOT EXIST...");
            return null;
        }

        Player removedPlayer = hashtable[hashedKey].value;
        hashtable[hashedKey] = null;
        return removedPlayer;
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }
    private boolean isOccupied(int Index) {
        return hashtable[Index] != null;
    }
    private int findKey(String key)
    {
        int hashedKey = hashKey(key);

        // If the right key has been found
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
        {
            return hashedKey;
        }

        // This applies linear probing
        if (isOccupied(hashedKey))
        {
            int stoppingIndex = hashedKey;

            // This hashedkey points at the last element
            if (hashedKey == hashtable.length - 1)
            {
                hashedKey = 0;
            }

            else
            {
                hashedKey++;
            }

            // This searches the array for the next vacant slot
            while (hashedKey != stoppingIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key))
            {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }

            // This returns the index that corresponds to the key
            if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
            {
                return hashedKey;
            }

            return -1;
        }
        return hashedKey;
    }

    // This functions prints the contents of the hashtable
    public void  printHashtable()
    {
        for (int i=0; i < hashtable.length; i++)
        {
            System.out.println("Element " + i + " " + hashtable[i]);
        }
    }
}