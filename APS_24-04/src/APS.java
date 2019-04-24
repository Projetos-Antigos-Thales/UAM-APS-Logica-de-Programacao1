import java.util.*;

public class APS {
	
	static boolean repetiu = false;
	static boolean um = false;
	static boolean dois = false;
	static boolean tres = false;
	static boolean quatro = false;
	static boolean cinco = false;
	static boolean seis = false;
	static boolean sete = false;
	static boolean oito = false;
	static boolean nove = false;
	static boolean fim = false;

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
        
        do {
        	
        	System.out.println("\n\n" + _NOME + ", Digite: \n--- 0 - para Sair ---"
                    + "\n--- 1 - para Jogar Jogo da Velha\n\n");
            
            int _NUMERO = sc.nextInt();
            
            String jogo = "1 | 2 | 3\n"
        			+ "----------\n"
        			+ "4 | 5 | 6\n"
        			+ "----------\n"
        			+ "7 | 8 | 9\n";
            
            switch(_NUMERO){
            
            
                
                case 0:
                    continuar = false;
                break;
                
                case 1:
                	System.out.println(jogo);
                	String numero_selecionadoString = "";
                    
                    
                    while(!fim) {
                    	
						numero_selecionadoString = Marcar();
						
						if(numero_selecionadoString.equals("nulo")) {
							
							numero_selecionadoString = Marcar();
							
							if(!repetiu) {
								
							}else {
								jogo = jogo.replace(numero_selecionadoString, "X");
								System.out.println(jogo);	
							}
							
							repetiu = false;
							
						}else {
							jogo = jogo.replace(numero_selecionadoString, "X");
							System.out.println(jogo);							
						}
						
						if(um == true && dois == true && tres == true) {
							Ganhou(_NOME); 
						}else if(quatro == true && cinco == true && seis == true) {
							Ganhou(_NOME); 
						}else if(sete == true && oito == true && nove == true) {
							Ganhou(_NOME); 
						}else if(um == true && quatro == true && sete == true) {
							Ganhou(_NOME); 
						}else if(dois == true && cinco == true && oito == true) {
							Ganhou(_NOME); 
						}else if(tres == true && seis == true && nove == true) {
							Ganhou(_NOME); 
						}else if(um == true && cinco == true && nove == true) {
							Ganhou(_NOME); 
						}else if(tres == true && cinco == true && sete == true) {
							Ganhou(_NOME); 
						}
						
					}
                    
                    fim = false; um = false; dois = false; tres = false;  quatro = false;  cinco = false;  seis = false;  sete = false;  oito = false;  nove = false; 
                	
                break;
                
                default:
                	System.out.println("utilize um dos numeros informados acima\n");
                break;
                
            }
        	
        }while(continuar);

	}
	
	public static void Ganhou(String NOME) {
		System.out.println("PARABENS " + NOME + ", VOCÊ GANHOU !!");
		fim = true;
	}
	
	public static String Marcar() {
		
		int posicao = 0;
		System.out.println("Digite o numero que corresponda ao lugar em que deseja marcar");
		Scanner sc = new Scanner(System.in);
        posicao = sc.nextInt();
		
		
		
		
		String numero = "nulo";
		
		
		
		switch (posicao) {
		
		case 1:
			if(!um) {
				um = true;
				numero = "1";
			}else {
				System.out.println("Este numero ja foi utilizado");
				repetiu = true;
			}
		break;
		
			
		case 2:
			if(!dois) {
				dois = true;
				numero = "2";
			}else {
				System.out.println("Este numero ja foi utilizado");
				repetiu = true;
			}
		break;
		
		
		case 3:
			if(!tres) {
				tres = true;
				numero = "3";
			}else {
				System.out.println("Este numero ja foi utilizado");
				repetiu = true;
			}
		break;
		
		
		case 4:
			if(!quatro) {
				quatro = true;
				numero = "4";
			}else {
				System.out.println("Este numero ja foi utilizado");
				repetiu = true;
			}
		break;
		
		
		case 5:
			if(!cinco) {
				cinco = true;
				numero = "5";
			}else {
				System.out.println("Este numero ja foi utilizado");
				repetiu = true;
			}
		break;
		
		
		case 6:
			if(!seis) {
				seis = true;
				numero = "6";
			}else {
				System.out.println("Este numero ja foi utilizado");
				repetiu = true;
			}
		break;
		
		
		case 7:
			if(!sete) {
				sete = true;
				numero = "7";
			}else {
				System.out.println("Este numero ja foi utilizado");
				repetiu = true;
			}
		break;
		
		
		case 8:
			if(!oito) {
				oito = true;
				numero = "8";
			}else {
				System.out.println("Este numero ja foi utilizado");
				repetiu = true;
			}
		break;
		
		
		case 9:
			if(!nove) {
				nove = true;
				numero = "9";
			}else {
				System.out.println("Este numero ja foi utilizado");
				repetiu = true;
			}
		break;
		

		default:
			System.out.println("Digite um numero de 1 a 9");
		break;
		}
		
		return numero;

	}

}
