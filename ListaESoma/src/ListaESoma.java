import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListaESoma {

	    public static void main(String[] args) {
	        List<Double> lista = new ArrayList<>();
	        lista.add(1.5);
	        lista.add(2.7);
	        lista.add(3.2);
	        lista.add(4.8);

	        list2File(lista);

	        Stack<Integer> stack1 = new Stack<>();
	        stack1.push(1);
	        stack1.push(2);
	        stack1.push(3);

	        Stack<Integer> stack2 = new Stack<>();
	        stack2.push(4);
	        stack2.push(5);
	        stack2.push(6);

	        try {
	            Stack<Integer> sumStack = sumStacks(stack1, stack2);
	            System.out.println("Soma das pilhas: " + sumStack);
	        } catch (Exception e) {
	            System.out.println("Erro: " + e.getMessage());
	        }
	    }

	    public static void list2File(List<Double> lista) {
	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter("listaInvertida.txt"));
	            for (int i = lista.size() - 1; i >= 0; i--) {
	                writer.write(lista.get(i).toString());
	                if (i > 0) {
	                    writer.write(" | ");
	                }
	            }
	            writer.close();
	            System.out.println("Arquivo 'listaInvertida.txt' criado com sucesso!");
	        } catch (IOException e) {
	            System.out.println("Erro ao escrever o arquivo: " + e.getMessage());
	        }
	    }

	    public static Stack<Integer> sumStacks(Stack<Integer> stack1, Stack<Integer> stack2) throws Exception {
	        if (stack1.size() != stack2.size()) {
	            throw new Exception("As pilhas não contêm o mesmo número de elementos.");
	        }

	        Stack<Integer> sumStack = new Stack<>();
	        Stack<Integer> tempStack1 = new Stack<>();
	        Stack<Integer> tempStack2 = new Stack<>();

	        while (!stack1.isEmpty()) {
	            tempStack1.push(stack1.pop());
	            tempStack2.push(stack2.pop());
	        }

	        while (!tempStack1.isEmpty()) {
	            int sum = tempStack1.pop() + tempStack2.pop();
	            sumStack.push(sum);
	        }

	        Stack<Integer> invertedStack = invert(sumStack);
	        return invertedStack;
	    }

	    public static <T> Stack<T> invert(Stack<T> stack) {
	        Stack<T> invertedStack = new Stack<>();
	        while (!stack.isEmpty()) {
	            invertedStack.push(stack.pop());
	        }
	        return invertedStack;
	    }
	}


