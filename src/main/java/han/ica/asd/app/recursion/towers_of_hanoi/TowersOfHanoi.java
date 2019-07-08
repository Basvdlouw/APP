package han.ica.asd.app.recursion.towers_of_hanoi;

import han.ica.asd.app.data_structures.stack.HANStack;

import java.util.stream.IntStream;

public class TowersOfHanoi {

    final static int DEFAULT_AMOUNT_OF_DISKS = 3;

    public static void solvePuzzleUsingStack(HANStack<Disk> firstStack, HANStack<Disk> secondStack, HANStack<Disk> thirdStack, int amountOfDisks) {
        IntStream
                .iterate(amountOfDisks, i -> i > 0, i -> i - 1)
                .mapToObj(Disk::new)
                .forEach(firstStack::push);
        display(amountOfDisks, firstStack, secondStack, thirdStack);
        solveRecursively(amountOfDisks, firstStack, secondStack, thirdStack, amountOfDisks);
    }

    private static void solveRecursively(int amountOfDisks, HANStack<Disk> firstStack, HANStack<Disk> secondStack, HANStack<Disk> thirdStack, final int startingAmountOfDisks) {
        if (amountOfDisks > 0)
        {
            solveRecursively(amountOfDisks-1, firstStack, thirdStack, secondStack, startingAmountOfDisks);
            thirdStack.push(firstStack.pop());
            display(startingAmountOfDisks, firstStack, secondStack, thirdStack);
            solveRecursively(amountOfDisks-1, secondStack, firstStack, thirdStack, startingAmountOfDisks);
        }
    }

    

    private static void display(int amountOfDisks, HANStack<Disk> firstStack, HANStack<Disk> secondStack, HANStack<Disk> thirdStack)
    {
        System.out.println("  1  |  2  |  3");
        System.out.println("---------------");
        for(int i = amountOfDisks; i >= 0; i--)
        {
            String d1 = " ", d2 = " ", d3 = " ";
            try
            {
                d1 = String.valueOf(firstStack.get(i).getDiskNumber());
            }
            catch (Exception ignored){ }
            try
            {
                d2 = String.valueOf(secondStack.get(i).getDiskNumber());
            }
            catch(Exception ignored) {}
            try
            {
                d3 = String.valueOf(thirdStack.get(i).getDiskNumber());
            }
            catch (Exception ignored){}
            if((d1.equals(" ") && d2.equals(" ") && d3.equals(" ")))
                continue;
            System.out.println("  "+ d1 +"  |  "+ d2 +"  |  "+ d3);

        }
        System.out.println("\n");
    }


    public static void solvePuzzleUsingStack(HANStack<Disk> firstStack, HANStack<Disk> secondStack, HANStack<Disk> thirdStack) {
        solvePuzzleUsingStack(firstStack, secondStack, thirdStack, DEFAULT_AMOUNT_OF_DISKS);
    }
}
