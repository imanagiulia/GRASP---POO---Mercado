package View;

import java.util.List;
import java.util.Scanner;
import Controller.*;

public class Main {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        Main view = new Main();
        MercadoController controller = new MercadoController(view);
        controller.iniciar();
    }

    public int exibirMenuPrincipal(){
        System.out.println("-- Menu --");
        System.out.println("1. Adicionar Item");
        System.out.println("2. Ver carrinho");
        System.out.println("3. Remover Item");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        int op = scanner.nextInt();

        scanner.nextLine();

        return op;
    }

    public void exibirMensagem(String msg){
        System.out.println(msg);
    }

    public String solicitarCodigo(){
        System.out.print("Digite o código do produto: ");
        String cod = scanner.nextLine();

        return cod;
    }

    public void exibirCarrinho(List<String> itensFormatados, float total){

        System.out.println("--- Seu Carrinho ---");
        if (itensFormatados.isEmpty()){
            exibirMensagem("Seu carrinho está vazio!");
        } 
        else{
            for (String item : itensFormatados){
                System.out.println("- " + item);
            }
            System.out.println("--------------");
            System.out.println("Total: R$ "+ String.format("%.2f", total));
        }
    }
}

