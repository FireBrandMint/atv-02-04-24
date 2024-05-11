package org.atividade24.binarytree;

import java.util.Scanner;

public class TreeRunner
{
    public static void main(String[] args)
    {
        BinaryTree<String> tree = new BinaryTree<String>();

        long[] values = new long[]
                {
                        15,
                        10, 25,
                        7, 13, 20, 45,
                        2, 37
                };

        for(int i = 0; i < values.length; ++i) tree.Add(values[i], "");

        System.out.println(tree.toString());
        Scanner scanner = new Scanner(System.in);

        String fodder = scanner.next();
    }
}
