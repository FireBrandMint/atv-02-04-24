package org.atividade24.binarytree;

public class BTNode<T>
{
    public long Key;
    public T Value;

    BTNode<T> Lower = null;
    BTNode<T> Higher = null;

    public BTNode(long key, T value)
    {
        Key = key;
        Value = value;
    }
}
