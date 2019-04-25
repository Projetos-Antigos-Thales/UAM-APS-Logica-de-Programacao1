import java.util.*;

public class APS {
	
	static boolean repetiu = false;
	static boolean um = false, um_jogador = false;
	static boolean dois = false, dois_jogador = false;
	static boolean tres = false, tres_jogador = false;
	static boolean quatro = false, quatro_jogador = false;
	static boolean cinco = false, cinco_jogador = false;
	static boolean seis = false, seis_jogador = false;
	static boolean sete = false, sete_jogador = false;
	static boolean oito = false, oito_jogador = false;
	static boolean nove = false, nove_jogador = false;
	static boolean fim = false;
	
	static boolean aux = true;
	
	static String Movimentos_Jogador = "";
	static String Movimentos_BOT = ""; 

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
                	
                	String numero_selecionadoString = "";
                	String numero_selecionadoString_BOT = "";
                    
                    while(!fim) {
                    	
						numero_selecionadoString = Marcar();
						
						switch (numero_selecionadoString) {
						
							case "1": um_jogador = true; break;
							case "2": dois_jogador = true; break;
							case "3": tres_jogador = true; break;
							case "4": quatro_jogador = true; break;
							case "5": cinco_jogador = true; break;
							case "6": seis_jogador = true; break;
							case "7": sete_jogador = true; break;
							case "8": oito_jogador = true; break;
							case "9": nove_jogador = true; break;
							default: break;
						
						}
						
						numero_selecionadoString_BOT = Marcar_BOT();
						
						
						
						
						System.out.println("\nVoce Marcou " + numero_selecionadoString);
						System.out.println("O PC Marcou " + numero_selecionadoString_BOT + "\n");
						
						jogo = jogo.replace(numero_selecionadoString, "X");
						Movimentos_Jogador += numero_selecionadoString;
						jogo = jogo.replace(numero_selecionadoString_BOT, "O");
						Movimentos_BOT += numero_selecionadoString_BOT;
						System.out.println(jogo);				
						
						
						
						
						
						
						
						if(Vitoria_Jogador()) {
							Ganhou(_NOME); 
						}else if(Vitoria_BOT()) {
							Perdeu(_NOME); 
						}else if(um == true && dois  == true && tres  == true && quatro  == true && cinco == true && seis == true && sete == true && oito == true && nove){
							Empate();
						}
						
					}
                    
                    
                    Movimentos_BOT = "";
					Movimentos_Jogador = "";
                    fim = false; um = false; dois = false; tres = false;  quatro = false;  cinco = false;  seis = false;  sete = false;  oito = false;  nove = false; aux = true; 
                    um_jogador = false; dois_jogador = false; tres_jogador = false;  quatro_jogador = false;  cinco_jogador = false;  seis_jogador = false;  sete_jogador = false;  oito_jogador = false;  nove_jogador = false;
                    
                    
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
	public static void Perdeu(String NOME) {
		System.out.println("INFELIZMENTE VOCE PERDEU " + NOME + " :(");
		fim = true;
	}
	public static void Empate() {
		System.out.println("JOGO EMPATADO xD");
		fim = true;
	}
	
	
	
	public static boolean Vitoria_Jogador() {
		
		boolean vitoria = false;
		
		if(Movimentos_Jogador.contains("1") && Movimentos_Jogador.contains("2") && Movimentos_Jogador.contains("3")) {
			vitoria = true;
		}else if(Movimentos_Jogador.contains("4") && Movimentos_Jogador.contains("5") && Movimentos_Jogador.contains("6")) {
			vitoria = true;
		}else if(Movimentos_Jogador.contains("7") && Movimentos_Jogador.contains("8") && Movimentos_Jogador.contains("9")) {
			vitoria = true;
		}else if(Movimentos_Jogador.contains("1") && Movimentos_Jogador.contains("4") && Movimentos_Jogador.contains("7")) {
			vitoria = true;
		}else if(Movimentos_Jogador.contains("2") && Movimentos_Jogador.contains("5") && Movimentos_Jogador.contains("8")) {
			vitoria = true;
		}else if(Movimentos_Jogador.contains("3") && Movimentos_Jogador.contains("6") && Movimentos_Jogador.contains("9")) {
			vitoria = true;
		}else if(Movimentos_Jogador.contains("1") && Movimentos_Jogador.contains("5") && Movimentos_Jogador.contains("9")) {
			vitoria = true; 
		}else if(Movimentos_Jogador.contains("3") && Movimentos_Jogador.contains("5") && Movimentos_Jogador.contains("7")) {
			vitoria = true;
		}else {
			vitoria = false;
		}
		
		
		return vitoria;
	}	
	public static boolean Vitoria_BOT() {
		
		boolean vitoria = false;
		
		if(Movimentos_BOT.contains("1") && Movimentos_BOT.contains("2") && Movimentos_BOT.contains("3")) {
			vitoria = true;
		}else if(Movimentos_BOT.contains("4") && Movimentos_BOT.contains("5") && Movimentos_BOT.contains("6")) {
			vitoria = true;
		}else if(Movimentos_BOT.contains("7") && Movimentos_BOT.contains("8") && Movimentos_BOT.contains("9")) {
			vitoria = true;
		}else if(Movimentos_BOT.contains("1") && Movimentos_BOT.contains("4") && Movimentos_BOT.contains("7")) {
			vitoria = true;
		}else if(Movimentos_BOT.contains("2") && Movimentos_BOT.contains("5") && Movimentos_BOT.contains("8")) {
			vitoria = true;
		}else if(Movimentos_BOT.contains("3") && Movimentos_BOT.contains("6") && Movimentos_BOT.contains("9")) {
			vitoria = true;
		}else if(Movimentos_BOT.contains("1") && Movimentos_BOT.contains("5") && Movimentos_BOT.contains("9")) {
			vitoria = true; 
		}else if(Movimentos_BOT.contains("3") && Movimentos_BOT.contains("5") && Movimentos_BOT.contains("7")) {
			vitoria = true;
		}else {
			vitoria = false;
		}
		
		
		return vitoria;
		
	}
	
	
	
	public static String Marcar() {
		
		int posicao = 0;
		System.out.println("Digite o numero que corresponda ao lugar em que deseja marcar: \n");
		
		if(aux) {
			
			String jogo = "1 | 2 | 3\n"
        			+ "----------\n"
        			+ "4 | 5 | 6\n"
        			+ "----------\n"
        			+ "7 | 8 | 9\n";
			System.out.println(jogo + "");
			
			aux = false;
			
		}
		
		
		
		
		
		
		String numero = "nulo";
		
		
		repetiu = true;
		
		
		while(repetiu) {
			
			Scanner sc = new Scanner(System.in);
	        posicao = sc.nextInt();
			
			switch (posicao) {
			
			case 1:
				if(!um) {
					um = true;
					numero = "1";
					repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado");
					repetiu = true;
				}
			break;
			
				
			case 2:
				if(!dois) {
					dois = true;
					numero = "2";
					repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado");
					repetiu = true;
				}
			break;
			
			
			case 3:
				if(!tres) {
					tres = true;
					numero = "3";
					repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado");
					repetiu = true;
				}
			break;
			
			
			case 4:
				if(!quatro) {
					quatro = true;
					numero = "4";
					repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado");
					repetiu = true;
				}
			break;
			
			
			case 5:
				if(!cinco) {
					cinco = true;
					numero = "5";
					repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado");
					repetiu = true;
				}
			break;
			
			
			case 6:
				if(!seis) {
					seis = true;
					numero = "6";
					repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado");
					repetiu = true;
				}
			break;
			
			
			case 7:
				if(!sete) {
					sete = true;
					numero = "7";
					repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado");
					repetiu = true;
				}
			break;
			
			
			case 8:
				if(!oito) {
					oito = true;
					numero = "8";
					repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado");
					repetiu = true;
				}
			break;
			
			
			case 9:
				if(!nove) {
					nove = true;
					numero = "9";
					repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado");
					repetiu = true;
				}
			break;
			

			default:
				System.out.println("Digite um numero de 1 a 9");
			break;
			}
		}
		
		
		
		
		
		return numero;

	}
	public static String Marcar_BOT() {
		
		String numero = "nulo";
		String n1 = VerificarJogadasDoJogador();
		
		if(!n1.equals("nulo")) {
			
			numero = n1;
			System.out.println("NAO VAI GANHAR NAO " + numero);
			
		}else {
			
			int aleatorio = 0;
			boolean disponivel = false;
			
			do {
				Random random = new Random();
				aleatorio = random.nextInt(11);
				//System.out.println(aleatorio + "aleeee");
				
				if(aleatorio == 1) {
					if(!um) {
						um = true;
						numero = "1";
						disponivel = true;
					}
				}else if(aleatorio == 2) {
					if(!dois) {
						dois = true;
						numero = "2";
						disponivel = true;
					}
				}else if(aleatorio == 3) {
					if(!tres) {
						tres = true;
						numero = "3";
						disponivel = true;
					}
				}else if(aleatorio == 4) {
					if(!quatro) {
						quatro = true;
						numero = "4";
						disponivel = true;
					}
				}else if(aleatorio == 5) {
					if(!cinco) {
						cinco = true;
						numero = "5";
						disponivel = true;
					}
				}else if(aleatorio == 6) {
					if(!seis) {
						seis = true;
						numero = "6";
						disponivel = true;
					}
				}else if(aleatorio == 7) {
					if(!sete) {
						sete = true;
						numero = "7";
						disponivel = true;
					}
				}else if(aleatorio == 8) {
					if(!oito) {
						oito = true;
						numero = "8";
						disponivel = true;
					}
				}else if(aleatorio == 9) {
					if(!nove) {
						nove = true;
						numero = "9";
						disponivel = true;
					}
				}
				
				System.out.println("Aleatorio " + numero);
				
			}while(!disponivel);
			
			
			
		}
		
		
		return numero;
	}
	
	
	
	public static String VerificarJogadas() {
		String numero = "nulo";
		
		if(dois == true && tres == true && um == false) {
			numero = "1";
		}else if(um == true && tres == true && dois == false) {
			numero = "2";
		}else if(um == true && dois == true && tres == false) {
			numero = "3";
		}
		
		
		
		else if(cinco == true && seis == true && quatro == false) {
			numero = "4";
		}else if(quatro == true && seis == true && cinco == false) {
			numero = "5";
		}else if(quatro == true && cinco == true && seis == false) {
			numero = "6";
		}
		
		
		
		else if(oito == true && nove == true && sete == false) {
			numero = "7";
		}else if(sete == true && nove == true && oito == false) {
			numero = "8";
		}else if(sete == true && oito == true && nove == false) {
			numero = "9";
		}
		
		
		
		else if(um == true && quatro == true && sete == false) {
			numero = "7";
		}else if(um == true && sete == true && quatro == false) {
			numero = "4";
		}else if(sete == true && quatro == true && um == false) {
			numero = "1";
		}
		
		
		
		else if(dois == true && cinco == true && oito == false) {
			numero = "8";
			oito = true;
		}else if(dois == true && oito == true && cinco == false) {
			numero = "5";
		}else if(oito == true && cinco == true && dois == false) {
			numero = "2";
		}
		
		
		
		else if(tres == true && seis == true && nove == false) {
			numero = "9";
			nove = true;
		}else if(tres == true && nove == true && seis == false) {
			numero = "6";
			seis = true;
		}else if(nove == true && seis == true && tres == false) {
			numero = "3";
		}
		
		
		
		else if(um == true && cinco == true && nove == false) {
			numero = "9";
		}else if(um == true && nove == true && cinco == false) {
			numero = "5";
		}else if(nove == true && cinco == true && um == false) {
			numero = "1";
		}
		
		
		
		else if(tres == true && cinco == true && sete == false) {
			numero = "7";
		}else if(tres == true && sete == true && cinco == false) {
			numero = "5";
		}else if(sete == true && cinco == true && tres == false) {
			numero = "3";
		}
		
		switch (numero) {
		case "1": um = true; um_jogador = true; break;
		case "2": dois = true;dois_jogador = true; break;
		case "3": tres = true;tres_jogador = true; break;
		case "4": quatro = true;quatro_jogador = true; break;
		case "5": cinco = true;cinco_jogador = true; break;
		case "6": seis = true;seis_jogador = true; break;
		case "7": sete = true;sete_jogador = true; break;
		case "8": oito = true;oito_jogador = true; break;
		case "9": nove = true;nove_jogador = true; break;
		
		default: break;
		}
		
		
		return numero;
	}
	public static String VerificarJogadasDoJogador() {
		
		String numero = "nulo";
		
		
		if(dois_jogador == true && tres_jogador == true && um_jogador == false) {
			numero = "1";
		}else if(um_jogador == true && tres_jogador == true && dois_jogador == false) {
			numero = "2";
		}else if(um_jogador == true && dois_jogador == true && tres_jogador == false) {
			numero = "3";
		}
		
		
		
		else if(cinco_jogador == true && seis_jogador == true && quatro_jogador == false) {
			numero = "4";
		}else if(quatro_jogador == true && seis_jogador == true && cinco_jogador == false) {
			numero = "5";
		}else if(quatro_jogador == true && cinco_jogador == true && seis_jogador == false) {
			numero = "6";
		}
		
		
		
		else if(oito_jogador == true && nove_jogador == true && sete_jogador == false) {
			numero = "7";
		}else if(sete_jogador == true && nove_jogador == true && oito_jogador == false) {
			numero = "8";
		}else if(sete_jogador == true && oito_jogador == true && nove_jogador == false) {
			numero = "9";
		}
		
		
		
		else if(um_jogador == true && quatro_jogador == true && sete_jogador == false) {
			numero = "7";
		}else if(um_jogador == true && sete_jogador == true && quatro_jogador == false) {
			numero = "4";
		}else if(sete_jogador == true && quatro_jogador == true && um_jogador == false) {
			numero = "1";
		}
		
		
		
		else if(dois_jogador == true && cinco_jogador == true && oito_jogador == false) {
			numero = "8";
		}else if(dois_jogador == true && oito_jogador == true && cinco_jogador == false) {
			numero = "5";
		}else if(oito_jogador == true && cinco_jogador == true && dois_jogador == false) {
			numero = "2";
		}
		
		
		
		else if(tres_jogador == true && seis_jogador == true && nove_jogador == false) {
			numero = "9";
		}else if(tres_jogador == true && nove_jogador == true && seis_jogador == false) {
			numero = "6";
		}else if(nove_jogador == true && seis_jogador == true && tres_jogador == false) {
			numero = "3";
		}
		
		
		
		else if(um_jogador == true && cinco_jogador == true && nove_jogador == false) {
			numero = "9";
		}else if(um_jogador == true && nove_jogador == true && cinco_jogador == false) {
			numero = "5";
		}else if(nove_jogador == true && cinco_jogador == true && um_jogador == false) {
			numero = "1";
		}
		
		
		
		else if(tres_jogador == true && cinco_jogador == true && sete_jogador == false) {
			numero = "7";
		}else if(tres_jogador == true && sete_jogador == true && cinco_jogador == false) {
			numero = "5";
		}else if(sete_jogador == true && cinco_jogador == true && tres_jogador == false) {
			numero = "3";
		}
		
		switch (numero) {
		case "1": um = true; um_jogador = true; break;
		case "2": dois = true; dois_jogador = true; break;
		case "3": tres = true; tres_jogador = true; break;
		case "4": quatro = true; quatro_jogador = true; break;
		case "5": cinco = true; cinco_jogador = true; break;
		case "6": seis = true; seis_jogador = true; break;
		case "7": sete = true; sete_jogador = true; break;
		case "8": oito = true; oito_jogador = true; break;
		case "9": nove = true; nove_jogador = true; break;
		default: break;
		
		}
		
		return numero;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
