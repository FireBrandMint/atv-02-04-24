package org.atividade24.binarytree;

import java.util.ArrayList;

public class BinaryTree<T>
{
    BTNode<T> root = null;

    BTNode<T> middle = null;
    public BinaryTree ()
    {

    }

    public void Add(long identifier, T value)
    {
        root = AddRecursive(root, identifier, value);
    }

    private BTNode<T> AddRecursive(BTNode<T> current, long key, T value) {
        if (current == null) {
            return new BTNode<T>(key, value);
        }

        if (key < current.Key) {
            current.Lower = AddRecursive(current.Lower, key, value);
        } else if (key > current.Key) {
            current.Higher = AddRecursive(current.Higher, key, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void Remove(long identifier)
    {
        root = deleteRecursive(root, identifier);
    }

    private BTNode<T> deleteRecursive(BTNode<T> current, long key) {
        if (current == null) {
            return null;
        }

        if (key == current.Key) {
            if (current.Lower == null && current.Higher == null)
            {
                return null;
            }
            else if(current.Higher == null)
            {
                return current.Lower;
            }
            else if(current.Lower == null)
            {
                return current.Higher;
            }
            else
            {
                //fuck

                long smallestValue = FindSmallestValue(current.Higher);
                current.Key = smallestValue;
                current.Higher = deleteRecursive(current.Higher, smallestValue);
                return current;
            }
        }
        if (key < current.Key) {
            current.Lower = deleteRecursive(current.Lower, key);
            return current;
        }
        current.Higher = deleteRecursive(current.Higher, key);
        return current;
    }

    private long FindSmallestValue(BTNode<T> root) {
        return root.Lower == null ? root.Key : FindSmallestValue(root.Lower);
    }

    public BTNode<T> Get(long identifier)
    {
        return findNodeRecursive(root, identifier);
    }

    public boolean Has(long identifier)
    {
        return findNodeRecursive(root, identifier) != null;
    }

    private BTNode<T> findNodeRecursive(BTNode<T> current, long key) {
        if (current == null) {
            return null;
        }
        if (key == current.Key) {
            return current;
        }
        return key < current.Key
                ? findNodeRecursive(current.Lower, key)
                : findNodeRecursive(current.Higher, key);
    }

    public ArrayList<BTNode<T>> ToList()
    {
        ArrayList<BTNode<T>> list = new ArrayList<BTNode<T>>();

        AddTreeToList(root, list);
        return list;
    }

    @Override
    public String toString() {

        ArrayList<BTNode<T>> search = new ArrayList<BTNode<T>>();
        search.add(root);
        ArrayList<String> stringList = new ArrayList<String>();

        while(search.size() != 0)
        {
            String row = "";
            int size = search.size();
            for(int i = 0; i < size; ++i)
            {
                BTNode<T> curr = search.get(0);
                if(curr == null)
                {
                    row += "  ";
                    search.remove(0);
                    continue;
                }

                if(i == 0) row += curr.Key;
                else row += " " + curr.Key;
                search.remove(0);
                search.add(curr.Lower);
                search.add(curr.Higher);
            }

            stringList.add(row);
        }

        int size = stringList.size();

        int lastChars = size != 0? size - 1 : 0;
        int lastPadding = 0;

        for(int i = size - 1; i > 0; --i)
        {
            int idx = i-1;
            String curr = stringList.get(idx);

            int lchars = lastChars;
            lastChars = curr.length();

            int currPadding = Math.abs(lchars - curr.length()) >> 1;
            if(lchars > curr.length()) lastPadding = currPadding + lastPadding;
            else
            {
                String moarspaces = "";
                //for(int ix = lastPadding + ((curr.length() - lchars) >> 1); ix > 0; --ix)
                //    moarspaces += ' ';

                stringList.set(i, moarspaces + stringList.get(i));
            }

            String spaces = "";
            for(int i2 = lastPadding; i2 > 0; --i2) spaces += ' ';

            stringList.set(idx, spaces + curr);
        }

        String result = "";

        for(int i = 0; i < size; ++i)
        {
            if(i == 0) result += stringList.get(i);
            else result += "\n" + stringList.get(i);
        }

        return result;
    }

    public void AddTreeToList(BTNode<T> current, ArrayList<BTNode<T>> list)
    {
        if(current == null) return;

        list.add(current);

        AddTreeToList(current.Higher, list);
        AddTreeToList(current.Lower, list);
    }
}
