
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  
    private static int qtdNumeros = 0;
    private static int totalDeThreads = 1;
    private static boolean numeroLivre = true;
    private static final Set<Integer> numCompartilhado = new HashSet<>();
	private static Scanner scanner;
  
    public static void main(String[] args) {
  
    	scanner = new Scanner(System.in);
    	
    	System.out.println("Informe o número de threads a serem utilizados no processo: ");
    	
    	totalDeThreads = scanner.nextInt();
    	
    	System.out.println("Informe a quantidade de números a processar: ");
    	
    	qtdNumeros = scanner.nextInt();
    	
    		   
    	for(int x = 1; x <= totalDeThreads; x++) 
    	{
    		new Thread(new Runnable() {
                @Override
                public void run() {
                	for (int i = 1 ; i <= qtdNumeros; i++) {
                       numeroLivre = numCompartilhado.add(i);
                        if (numeroLivre) {
                        	int valor = 0;

                            for (int k = 1; k <= i; k++) {
                                if (i % k == 0) ++valor;
                            }
                            if (valor == 2) {
                                System.out.println("Thread "+ Thread.currentThread().getId() + ": O número " + i + " é primo ") ;
                            } else {
                            	System.out.println("Thread "+ Thread.currentThread().getId() + ": O número "+ i + " não é primo ") ;
                            }
                        }
                    }
                }
            }).start();
    		
    	}//Fim For quantidade de threads.
    	  	

    }
}
