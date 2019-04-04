/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queijo;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author lab211
 */
public class Queijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu Nome PorFavor");
        String _NOME = sc.nextLine();
        
        if(_NOME.equals("")){
            
            for(int i =0; i < 1;){
                System.out.println("Digite um nome válido !");
                _NOME = sc.nextLine();
                
                if(!_NOME.equals("")){
                    i++;
                }
                
            }
            
        }
        
        boolean continuar = true;
        while(continuar){
            System.out.println("\n\n" + _NOME + ", Digite: \n--- 0 - para Sair ---"
                    + "\n--- 1 - para Fazer a média de 10 numeros ---"
                    + "\n--- 2 - para saber se um número é Par ou Impar ---");
            
            int _NUMERO = sc.nextInt();
            
            switch(_NUMERO){
                
                case 0:
                    continuar = false;
                break;
                
                case 1:                    
                    int numeros;
                    int i2 = 0;
                    int media = 0;
                    
                    System.out.println("\n\nColoque 10 números, para indicarmos a média entre eles:");
                    
                    while(i2<10){
                        
                        System.out.print("Digite o " + (i2+1) + "º numero: ");
                        
                        numeros = sc.nextInt();
                        media += numeros;
                        i2++;                        
                    }
                    
                    System.out.println("A média dentre esses 10 numeros é " + media/10);
                    
                break;
                
                case 2:
                    
                    System.out.println("\n\nColoque 1 numero para verificar se é par ou não:");
                                        
                    int par_impar = sc.nextInt();
                    
                    if(par_impar %2 == 0){
                        System.out.println("O numero é Par");
                    }else{
                        System.out.println("O numero é Impar");
                    }
                    
                break;
                
                default:
                    System.out.println("utilize um dos numeros informados acima");
                break;
            }
            
        }
        
    }
    
    
}