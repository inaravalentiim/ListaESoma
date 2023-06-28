import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        testList2File();
        testSumStacks();
    }

    public static void testList2File() {
        List<Double> lista = new ArrayList<>();
        lista.add(1.5);
        lista.add(2.7);
        lista.add(3.2);
        lista.add(4.8);

        ListaESoma.list2File(lista);
    }

    public static void testSumStacks() {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        try {
            Stack<Integer> sumStack = ListaESoma.sumStacks(stack1, stack2);
            System.out.println("Soma das pilhas: " + sumStack);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}