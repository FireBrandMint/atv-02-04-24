package org.atividade24;

import org.atividade24.binarytree.BinaryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        BinaryTree<String> tree = new BinaryTree<String>();

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            String input = scanner.nextLine();
            String[] carg = input.split(" ");

            if(carg[0].equals("sair")) break;

            //inserção, remoção, listar

            try
            {
                long l;
                switch (carg[0]) {
                    case "inserir":
                        l = Long.parseLong(carg[1]);
                        if(tree.Has(l))
                            System.out.println("Arvore já tem este nó.");
                        else
                        {
                            tree.Add(l, "");
                            System.out.println("Nó adicionado.");
                        }

                        break;
                    case "remover":
                        l = Long.parseLong(carg[1]);
                        if(tree.Has(l))
                            System.out.println("Arvore já tem este nó.");
                        else
                        {
                            tree.Remove(l);
                            System.out.println("Nó removido.");
                        }
                        break;
                    case "listar":
                        System.out.println(tree.toString());
                        break;
                    case "help":
                        System.out.println("Comandos:\ninserir <long>\nremover <long>\nlistar");
                }
            }
            catch (Exception e)
            {
                System.out.println("Erro.");
                for(int i = 0; i < carg.length; ++i)
                {
                    System.out.println(carg[i]);
                }
            }
        }
    }
}