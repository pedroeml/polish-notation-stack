package def;

import java.util.Scanner;
import java.io.*;

public class StackTest {
	private static PolishNotationStack stack = new PolishNotationStack();
	
	public static void main( String[] args ) {
        
    	System.out.println("PILHA CRIADA");
    	lerArquivo();
        /*Scanner input = new Scanner(System.in);
        
        while ( input.hasNext() ) {
            String temp = input.next();

            if(temp.equals("quit")) System.exit(0);
            else if(temp.matches("[0-9]+")) {
            	Double toStack = new Double(Integer.parseInt(temp));
            	stack.push(toStack);
            }
            else if(temp.equals("+")) stack.add();
            else if(temp.equals("-")) stack.sub();
            else if(temp.equals("*")) stack.mult();
            else if(temp.equals("/")) stack.div();
            else if(temp.equals("pop")) stack.pop();
            else if(temp.equals("dup")) stack.dup();
            else if(temp.equals("swap")) stack.swap();
            else if(temp.equals("sin")) stack.sin();
            else if(temp.equals("cos")) stack.cos();
            else if(temp.equals("atan")) stack.atan();
            stack.print();
        }*/
    }
    
    
    public static void lerArquivo(){
    /* Vamos buscar do usuário o nome do arquivo que queremos ler */      
        Scanner leitorTerminal = new Scanner(System.in);
        
        /* 
        Temos que ter o nome completo do diretório onde iremos buscar o 
        arquivo, para isso iremos criar uma String para armazenar o caminho
        
        Observações:
        A chamada de função do comando System.getProperty("user.name") vai 
        retornar o nome do usuário atenticado na máquina.       
        */
        
        
        String caminhoDoArquivo = "C:\\Users\\" + System.getProperty("user.name").toString();
        		
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Informe o caminho e nome do arquivo (com a extensão) que deseja ler no disco:");
        System.out.println("-------------------------------------------------------");
        
        caminhoDoArquivo = leitorTerminal.nextLine();
        

        try {
            /* 
            Aqui criamos um objeto de identificação do arquivo de texto e trazer
            o conteúdo do mesmo para memória
            */
            FileReader arquivoParaLeitura = new FileReader(caminhoDoArquivo);
            
            /*
            Criando um objeto de buffer/memória para armazena o conteúdo do arquivo
            que será lido
            */
            BufferedReader leitorArquivo = new BufferedReader(arquivoParaLeitura);
            
            /* 
            Aqui iremos ler a primeira linha do arquivo de texto.
            Ao final da leitura a variável linha receberá o valor null, portanto
            podemos fazer um laço de repetição onde buscaremos todo o restante do
            conteúdo.
            */
            String linha;
            
            
            while((linha = leitorArquivo.readLine()) != null) { // Armazenamos na variável linha a próxima linha do arquivo e verificamos se ela não está vazia
            	fileToStack(linha);
            }
            System.out.println("\n");
            
            /* 
            Encerramos a leitura e limpamos o cache deixando para que o
            Garbage Collector termine o trabalho depois 
            */
            leitorArquivo.close();
        }
        catch(IOException e) {
            /* Em caso de erro imprime no terminal o erro ocorrido para o usuário */
            System.out.println(e.getMessage());
        }
    }
    
    public static void fileToStack(String temp) {
        if(temp.equals("quit")) System.exit(0);
        else if(temp.matches("[0-9]+")) {
        	Double toStack = new Double(Integer.parseInt(temp));
        	stack.push(toStack);
        }
        else if(temp.equals("+")) stack.add();
        else if(temp.equals("-")) stack.sub();
        else if(temp.equals("*")) stack.mult();
        else if(temp.equals("/")) stack.div();
        else if(temp.equals("pop")) stack.pop();
        else if(temp.equals("dup")) stack.dup();
        else if(temp.equals("swap")) stack.swap();
        else if(temp.equals("sin")) stack.sin();
        else if(temp.equals("cos")) stack.cos();
        else if(temp.equals("atan")) stack.atan();
        stack.print();
    }
}