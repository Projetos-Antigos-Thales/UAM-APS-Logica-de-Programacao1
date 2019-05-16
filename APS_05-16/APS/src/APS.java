import java.util.*;

public class APS {
	
	// Variaveis Auxiliares para o funcionamento geral
	static boolean repetiu = false, aux = true, cancelar = false, fim = false;
	
	static boolean um = false, dois = false, tres = false, quatro = false;
	static boolean cinco = false, seis = false, sete = false, oito = false, nove = false;

	
	static String Movimentos_Jogador = "";
	static String Movimentos_Computador = ""; 
	static String Resposta_JogoDaMemoria = "";
	static String respostaJogador = "";
	static int Contagem_Acertos = 0;

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu Nome PorFavor");
        System.out.print("-->");
        String _NOME = sc.nextLine();
        
        if(_NOME.equals("")){
            
            for(int i =0; i < 1;){
                System.out.println("Digite um nome válido !");
                System.out.print("-->");
                _NOME = sc.nextLine();
                
                if(!_NOME.equals("")){
                    i++;
                }
                
            }
            
        }
        
        boolean continuar = true;
        
        do {
        	
        	System.out.println("\n\n" + _NOME + ", Digite: \n--- 0 - para Sair a qualquer momento ---"
                    + "\n--- 1 - para Jogar Jogo da Velha (contra o Computador)"
                    + "\n--- 2 - para Jogar Jogo da Velha (contra outro Jogador)"
                    + "\n--- 3 - para Jogar Jogo da Memoria");
        	
        	System.out.print("-->");
            
            String _NUMERO = sc.nextLine();
            System.out.println("");
            
            String jogo = "1 | 2 | 3\n"
        			+ "----------\n"
        			+ "4 | 5 | 6\n"
        			+ "----------\n"
        			+ "7 | 8 | 9\n";
            
            switch(_NUMERO){
            
            
                
                case "0":
                    System.out.println("Obrigado e Volte sempre ;)");
                	continuar = false;
                break;
                
                
                
                case "1":
                	
                	String numeroSelecionado_Jogador = "";
                	String numeroSelecionado_Computador = "";
                    
                    while(!fim) {
                    	
                    	if(Computador_Vitoria()) {
							Perdeu(_NOME); 
						}else {
							
							numeroSelecionado_Jogador = Jogador_Marcar();
	                    	
							if(numeroSelecionado_Jogador.equals("cancelar")) {
	                			fim = true;
	                			System.out.println("Jogo Cancelado");
	                		}else if(Jogador_Vitoria()) {   
                				System.out.println(jogo);	
    							Ganhou(_NOME); 
    						}else if(um == true && dois  == true && tres  == true && quatro  == true && cinco == true && seis == true && sete == true && oito == true && nove){
    							System.out.println(jogo);	
    							Empate();
    						}else {
    							
    							numeroSelecionado_Computador = Computador_Marcar();
        						        						
        						jogo = jogo.replace(numeroSelecionado_Jogador, "X");
        						jogo = jogo.replace(numeroSelecionado_Computador, "O");        						
        						System.out.println(jogo);		
	                			
    						}
						}
                    	
					}
                    
                    cancelar = false; fim = false; 
                    Movimentos_Computador = ""; Movimentos_Jogador = "";
                    um = false; dois = false; tres = false;  quatro = false;  cinco = false;  seis = false;  sete = false;  oito = false;  nove = false; aux = true; 
                    
                    
                break;
                
                case "2":
                    
                	System.out.println("Insira o nome do Segundo Jogador:");
                	Scanner sc2 = new Scanner(System.in);
                	System.out.print("-->");                	
                	String jogador1 = _NOME , jogador2 = sc2.nextLine();
                	                	
                	System.out.println("");
                	
                	String numero_Jogador1 = "", numero_Jogador2 = ""; 
                	String jogo_JxJ = "1 | 2 | 3\n"
                					+ "----------\n"
                					+ "4 | 5 | 6\n"
                					+ "----------\n"
                					+ "7 | 8 | 9\n";
                	
                	
                	
                	while(!fim) {

                		numero_Jogador1 = Jogador1_Marcar(jogo_JxJ, jogador1);
                		
                		if(numero_Jogador1.equals("cancelar")) {
                			cancelar = true;
                			System.out.println("Jogo Cancelado");
                		}
                		
                		jogo_JxJ = jogo_JxJ.replace(numero_Jogador1, "X");
                		
                		
                		if(cancelar) {
                			fim= true;
                		}else if(Jogador1_Vitoria()) {
                			JxJ_Ganhou(jogador1, jogador2);
                		}else if(Jogador2_Vitoria()) {
                			JxJ_Ganhou(jogador2, jogador1);
                		}else if(um == true && dois  == true && tres  == true && quatro  == true && cinco == true && seis == true && sete == true && oito == true && nove){
                			JxJEmpate(jogador1, jogador2);
                		}else {
                			numero_Jogador2 = Jogador2_Marcar(jogo_JxJ, jogador2);
                			if(numero_Jogador2.equals("cancelar")) {
                				cancelar = true;
                				System.out.println("Jogo Cancelado");
                    		}
                    		jogo_JxJ = jogo_JxJ.replace(numero_Jogador2, "O");          
                		}
                		
                		
                		      	              
                		
                		if(cancelar) {
                			fim= true;
                		}if(Jogador2_Vitoria()) {
                			JxJ_Ganhou(jogador2, jogador1);
                		}else if(Jogador1_Vitoria()) {
                			
                		}else if(um == true && dois  == true && tres  == true && quatro  == true && cinco == true && seis == true && sete == true && oito == true && nove){
                			JxJEmpate(jogador1, jogador2);
                		}
                		
                		
                	}
                	
                	cancelar = false; fim = false; 
                	Movimentos_Computador = ""; Movimentos_Jogador = "";
                    um = false; dois = false; tres = false;  quatro = false;  cinco = false;  seis = false;  sete = false;  oito = false;  nove = false; aux = true; 
                	
                break;
                
                case "3":
                	
                	String jogoMemoria = 	   ("-------------\n"
           				 					  + "| 1 | 2 | 3 |\n"
           				 					  + "-------------\n"
           				 					  + "| 4 |   | 5 |\n"
           				 					  + "-------------\n"
           				 					  + "| 6 | 7 | 8 |\n"
           				 					  + "-------------\n");                	
                	
                	AparecerCartas(jogoMemoria, _NOME);      
                	
                	String[] respoxta = Resposta_JogoDaMemoria.split("/");
                	
                	System.out.println(Resposta_JogoDaMemoria);
                	
                	while(Contagem_Acertos != 4) {
                		
                		Marcar();
                    	
                		for (int i = 0; i < (4 - Contagem_Acertos); i++) {
                			
                			if(respostaJogador.equals("0")) {
                				System.out.println("Jogo Cancelado");
                				Contagem_Acertos = 0;
                				respostaJogador = "";
                				Resposta_JogoDaMemoria = "";
                			}
                			
                			else if(respoxta[i].equals(respostaJogador)) {
                				System.out.println("VOCE ACERTOU !");
                				
                				Contagem_Acertos++;
                				
                				RevelarAcerto();
                				
                			}else if(i == (4 - Contagem_Acertos)) {
                				System.out.println("Infelizmente voce errou");
                			}
						}
                		
                	}
                	
                	
                break;
                
                default:
                	System.out.println("utilize um dos numeros informados acima\n");
                break;
                
            }
        	
        }while(continuar);

        System.exit(0);
        
	}
	
	
	
	// -- JOGO DA VELHA ------------------------------------------------------------------------------------------------------------
	
	// Este metodo só é utilizado quando o Jogador vence o Jogo contra o computador 
	public static void Ganhou(String NOME) {
		System.out.println("PARABENS " + NOME + ", VOCÊ GANHOU !!");
		fim = true;
	}
	// Este metodo só é utilizado quando o Jogador perde o Jogo contra o computador
	public static void Perdeu(String NOME) {
		System.out.println("INFELIZMENTE VOCE PERDEU " + NOME + " :(");
		fim = true;
	}
	// Este metodo só é utilizado quando o Jogo termina empatado contra o computador
	public static void Empate() {
		System.out.println("JOGO EMPATADO xD");
		fim = true;
	}
	
	
	// JOGADOR
	// Esse metodo serve para saber se o Jogador Ganhou o Jogo (Ele verifica os numeros que foram escolhidos pelo Jogador)
	public static boolean Jogador_Vitoria() {
		
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
	// Esse metodo serve para fazer o Usuario Marcar o numero que deseja e verificar se esse numero ja foi selecionado
	public static String Jogador_Marcar() {
		
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
			System.out.print("-->");
	        posicao = sc.nextInt();
			
			switch (posicao) {
			
			case 0:
				numero = "cancelar";
				repetiu = false;
			break;
			case 1:
				if(!um) {
					numero = "1"; repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado"); repetiu = true;
				}
			break;
			case 2:
				if(!dois) {
					numero = "2"; repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado"); repetiu = true;
				}
			break;
			case 3:
				if(!tres) {
					numero = "3"; repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado"); repetiu = true;
				}
			break;
			case 4:
				if(!quatro) {
					numero = "4"; repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado"); repetiu = true;
				}
			break;
			case 5:
				if(!cinco) {
					numero = "5"; repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado"); repetiu = true;
				}
			break;
			case 6:
				if(!seis) {
					numero = "6"; repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado"); repetiu = true;
				}
			break;
			case 7:
				if(!sete) {
					numero = "7"; repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado"); repetiu = true;
				}
			break;
			case 8:
				if(!oito) {
					numero = "8"; repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado"); repetiu = true;
				}
			break;
			case 9:
				if(!nove) {
					numero = "9"; repetiu = false;
				}else {
					System.out.println("Este numero ja foi utilizado"); repetiu = true;
				}
			break;
			default:
				System.out.println("Digite um numero de 1 a 9");
			break;
			}
		}
		
		
		
		switch (numero) {
		case "1": um = true; Movimentos_Jogador += numero; break;
		case "2": dois = true; Movimentos_Jogador += numero; break;
		case "3": tres = true; Movimentos_Jogador += numero; break;
		case "4": quatro = true; Movimentos_Jogador += numero; break;
		case "5": cinco = true; Movimentos_Jogador += numero; break;
		case "6": seis = true; Movimentos_Jogador += numero; break;
		case "7": sete = true; Movimentos_Jogador += numero; break;
		case "8": oito = true; Movimentos_Jogador += numero; break;
		case "9": nove = true; Movimentos_Jogador += numero; break;
		default: break;
		
		}
		
		return numero;

	}
	
	
	// COMPUTADOR
	// Esse metodo serve para saber se o Computador Ganhou o Jogo (Ele verifica os numeros que foram escolhidos pelo PC)
	public static boolean Computador_Vitoria() {
		
		boolean vitoria = false;
		
		if(Movimentos_Computador.contains("1") && Movimentos_Computador.contains("2") && Movimentos_Computador.contains("3")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("4") && Movimentos_Computador.contains("5") && Movimentos_Computador.contains("6")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("7") && Movimentos_Computador.contains("8") && Movimentos_Computador.contains("9")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("1") && Movimentos_Computador.contains("4") && Movimentos_Computador.contains("7")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("2") && Movimentos_Computador.contains("5") && Movimentos_Computador.contains("8")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("3") && Movimentos_Computador.contains("6") && Movimentos_Computador.contains("9")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("1") && Movimentos_Computador.contains("5") && Movimentos_Computador.contains("9")) {
			vitoria = true; 
		}else if(Movimentos_Computador.contains("3") && Movimentos_Computador.contains("5") && Movimentos_Computador.contains("7")) {
			vitoria = true;
		}else {
			vitoria = false;
		}

		
		
		return vitoria;
		
	}	
	// Esse metodo serve para fazer o Computador Escolher um numero para Marcar e verificar se esse numero ja foi selecionado
	public static String Computador_Marcar() {
		
		String numero = "nulo";
		String defesa = Computador_Defender();
		String ataque = Computador_Atacar();
		
		if(!ataque.equals("nulo")) {
			
			numero = ataque;
			System.out.println("Atacando no numero " + numero);
			
		}else if(!defesa.equals("nulo")){
			
			numero = defesa;
			System.out.println("Defendendo no numero " + numero);
			
		}else {
			
			int aleatorio = 0;
			boolean disponivel = false;
			
			do {
				Random random = new Random();
				aleatorio = random.nextInt(11);
				//System.out.println(aleatorio + "aleeee");
				
				if(aleatorio == 1) {
					if(!um) {
						numero = "1"; disponivel = true;
					}
				}else if(aleatorio == 2) {
					if(!dois) {
						numero = "2"; disponivel = true;
					}
				}else if(aleatorio == 3) {
					if(!tres) {
						numero = "3"; disponivel = true;
					}
				}else if(aleatorio == 4) {
					if(!quatro) {
						numero = "4"; disponivel = true;
					}
				}else if(aleatorio == 5) {
					if(!cinco) {
						numero = "5"; disponivel = true;
					}
				}else if(aleatorio == 6) {
					if(!seis) {
						numero = "6"; disponivel = true;
					}
				}else if(aleatorio == 7) {
					if(!sete) {
						numero = "7"; disponivel = true;
					}
				}else if(aleatorio == 8) {
					if(!oito) {
						numero = "8"; disponivel = true;
					}
				}else if(aleatorio == 9) {
					if(!nove) {
						numero = "9"; disponivel = true;
					}
				}
				
				
				
				System.out.println("Jogando um numero Aleatorio -> " + numero);
				
			}while(!disponivel);
			
			
			
		}
		
		switch (numero) {
		case "1": um = true; Movimentos_Computador += numero; break;
		case "2": dois = true; Movimentos_Computador += numero; break;
		case "3": tres = true; Movimentos_Computador += numero; break;
		case "4": quatro = true; Movimentos_Computador += numero; break;
		case "5": cinco = true; Movimentos_Computador += numero; break;
		case "6": seis = true; Movimentos_Computador += numero; break;
		case "7": sete = true; Movimentos_Computador += numero; break;
		case "8": oito = true; Movimentos_Computador += numero; break;
		case "9": nove = true; Movimentos_Computador += numero; break;
		default: break;
		
		}
		
		return numero;
	}
	// Esse metodo serve para o Computador Verificar quais numeros o Jogador ja Marcou para poder impediri voce de vencer
	public static String Computador_Defender() {
			
			String numero = "nulo";
			
			
			
			if(!(Movimentos_Jogador.contains("1")) && (Movimentos_Jogador.contains("2") && Movimentos_Jogador.contains("3")) && !um){
				numero = "1";
			}else if(!(Movimentos_Jogador.contains("2")) && (Movimentos_Jogador.contains("1") && Movimentos_Jogador.contains("3")) && !dois){
				numero = "2";
			}else if(!(Movimentos_Jogador.contains("3")) && (Movimentos_Jogador.contains("1") && Movimentos_Jogador.contains("2")) && !tres){
				numero = "3";
			}
			
			
			
			else if(!(Movimentos_Jogador.contains("4")) && (Movimentos_Jogador.contains("5") && Movimentos_Jogador.contains("6")) && !quatro){
				numero = "4";
			}else if(!(Movimentos_Jogador.contains("5")) && (Movimentos_Jogador.contains("4") && Movimentos_Jogador.contains("6")) && !cinco){
				numero = "5";
			}else if(!(Movimentos_Jogador.contains("6")) && (Movimentos_Jogador.contains("4") && Movimentos_Jogador.contains("5")) && !seis){
				numero = "6";
			}
			
			
			
			else if(!(Movimentos_Jogador.contains("7")) && (Movimentos_Jogador.contains("8") && Movimentos_Jogador.contains("9")) && !sete){
				numero = "7";
			}else if(!(Movimentos_Jogador.contains("8")) && (Movimentos_Jogador.contains("7") && Movimentos_Jogador.contains("9")) && !oito){
				numero = "8";
			}else if(!(Movimentos_Jogador.contains("9")) && (Movimentos_Jogador.contains("7") && Movimentos_Jogador.contains("8")) && !nove){
				numero = "9";
			}
			
			
			
			else if(!(Movimentos_Jogador.contains("7")) && (Movimentos_Jogador.contains("4") && Movimentos_Jogador.contains("1")) && !sete){
				numero = "7";
			}else if(!(Movimentos_Jogador.contains("4")) && (Movimentos_Jogador.contains("7") && Movimentos_Jogador.contains("1")) && !quatro){
				numero = "4";
			}else if(!(Movimentos_Jogador.contains("1")) && (Movimentos_Jogador.contains("7") && Movimentos_Jogador.contains("4")) && !um){
				numero = "1";
			}
			
			
			
			else if(!(Movimentos_Jogador.contains("8")) && (Movimentos_Jogador.contains("5") && Movimentos_Jogador.contains("2")) && !oito){
				numero = "8";
			}else if(!(Movimentos_Jogador.contains("5")) && (Movimentos_Jogador.contains("8") && Movimentos_Jogador.contains("2")) && !cinco){
				numero = "5";
			}else if(!(Movimentos_Jogador.contains("2")) && (Movimentos_Jogador.contains("5") && Movimentos_Jogador.contains("8")) && !dois){
				numero = "2";
			}
			
			
			
			else if(!(Movimentos_Jogador.contains("9")) && (Movimentos_Jogador.contains("6") && Movimentos_Jogador.contains("3")) && !nove){
				numero = "9";
			}else if(!(Movimentos_Jogador.contains("6")) && (Movimentos_Jogador.contains("9") && Movimentos_Jogador.contains("3")) && !seis){
				numero = "6";
			}else if(!(Movimentos_Jogador.contains("3")) && (Movimentos_Jogador.contains("6") && Movimentos_Jogador.contains("9")) && !tres){
				numero = "3";
			}
			
			
			
			else if(!(Movimentos_Jogador.contains("9")) && (Movimentos_Jogador.contains("5") && Movimentos_Jogador.contains("1")) && !nove){
				numero = "9";
			}else if(!(Movimentos_Jogador.contains("5")) && (Movimentos_Jogador.contains("9") && Movimentos_Jogador.contains("1")) && !cinco){
				numero = "5";
			}else if(!(Movimentos_Jogador.contains("1")) && (Movimentos_Jogador.contains("9") && Movimentos_Jogador.contains("5")) && !um){
				numero = "1";
			}
			
			
			
			else if(!(Movimentos_Jogador.contains("7")) && (Movimentos_Jogador.contains("5") && Movimentos_Jogador.contains("3")) && !sete){
				numero = "7";
			}else if(!(Movimentos_Jogador.contains("5")) && (Movimentos_Jogador.contains("7") && Movimentos_Jogador.contains("3")) && !cinco){
				numero = "5";
			}else if(!(Movimentos_Jogador.contains("3")) && (Movimentos_Jogador.contains("7") && Movimentos_Jogador.contains("5")) && !tres){
				numero = "3";
			}





			
			return numero;
			
	}
	// Esse metodo serve para o Computador Verificar quais numeros o Jogador ja Marcou para poder impediri voce de vencer
	public static String Computador_Atacar() {
				
				String numero = "nulo";
				
				
				if(!(Movimentos_Computador.contains("1")) && (Movimentos_Computador.contains("2") && Movimentos_Computador.contains("3")) && !um){
					numero = "1";
				}else if(!(Movimentos_Computador.contains("2")) && (Movimentos_Computador.contains("1") && Movimentos_Computador.contains("3")) && !dois){
					numero = "2";
				}else if(!(Movimentos_Computador.contains("3")) && (Movimentos_Computador.contains("1") && Movimentos_Computador.contains("2")) && !tres){
					numero = "3";
				}
				
				
				
				else if(!(Movimentos_Computador.contains("4")) && (Movimentos_Computador.contains("5") && Movimentos_Computador.contains("6")) && !quatro){
					numero = "4";
				}else if(!(Movimentos_Computador.contains("5")) && (Movimentos_Computador.contains("4") && Movimentos_Computador.contains("6")) && !cinco){
					numero = "5";
				}else if(!(Movimentos_Computador.contains("6")) && (Movimentos_Computador.contains("4") && Movimentos_Computador.contains("5")) && !seis){
					numero = "6";
				}
				
				
				
				else if(!(Movimentos_Computador.contains("7")) && (Movimentos_Computador.contains("8") && Movimentos_Computador.contains("9")) && !sete){
					numero = "7";
				}else if(!(Movimentos_Computador.contains("8")) && (Movimentos_Computador.contains("7") && Movimentos_Computador.contains("9")) && !oito){
					numero = "8";
				}else if(!(Movimentos_Computador.contains("9")) && (Movimentos_Computador.contains("7") && Movimentos_Computador.contains("8")) && !nove){
					numero = "9";
				}
				
				
				
				else if(!(Movimentos_Computador.contains("7")) && (Movimentos_Computador.contains("4") && Movimentos_Computador.contains("1")) && !sete){
					numero = "7";
				}else if(!(Movimentos_Computador.contains("4")) && (Movimentos_Computador.contains("7") && Movimentos_Computador.contains("1")) && !quatro){
					numero = "4";
				}else if(!(Movimentos_Computador.contains("1")) && (Movimentos_Computador.contains("7") && Movimentos_Computador.contains("4")) && !um){
					numero = "1";
				}
				
				
				
				else if(!(Movimentos_Computador.contains("8")) && (Movimentos_Computador.contains("5") && Movimentos_Computador.contains("2")) && !oito){
					numero = "8";
				}else if(!(Movimentos_Computador.contains("5")) && (Movimentos_Computador.contains("8") && Movimentos_Computador.contains("2")) && !cinco){
					numero = "5";
				}else if(!(Movimentos_Computador.contains("2")) && (Movimentos_Computador.contains("5") && Movimentos_Computador.contains("8")) && !dois){
					numero = "2";
				}
				
				
				
				else if(!(Movimentos_Computador.contains("9")) && (Movimentos_Computador.contains("6") && Movimentos_Computador.contains("3")) && !nove){
					numero = "9";
				}else if(!(Movimentos_Computador.contains("6")) && (Movimentos_Computador.contains("9") && Movimentos_Computador.contains("3")) && !seis){
					numero = "6";
				}else if(!(Movimentos_Computador.contains("3")) && (Movimentos_Computador.contains("6") && Movimentos_Computador.contains("9")) && !tres){
					numero = "3";
				}
				
				
				
				else if(!(Movimentos_Computador.contains("9")) && (Movimentos_Computador.contains("5") && Movimentos_Computador.contains("1")) && !nove){
					numero = "9";
				}else if(!(Movimentos_Computador.contains("5")) && (Movimentos_Computador.contains("9") && Movimentos_Computador.contains("1")) && !cinco){
					numero = "5";
				}else if(!(Movimentos_Computador.contains("1")) && (Movimentos_Computador.contains("9") && Movimentos_Computador.contains("5")) && !um){
					numero = "1";
				}
				
				
				
				else if(!(Movimentos_Computador.contains("7")) && (Movimentos_Computador.contains("5") && Movimentos_Computador.contains("3")) && !sete){
					numero = "7";
				}else if(!(Movimentos_Computador.contains("5")) && (Movimentos_Computador.contains("7") && Movimentos_Computador.contains("3")) && !cinco){
					numero = "5";
				}else if(!(Movimentos_Computador.contains("3")) && (Movimentos_Computador.contains("7") && Movimentos_Computador.contains("5")) && !tres){
					numero = "3";
				}

				
				return numero;
				
	}
			
	
	
	
	
	
	// -- JOGO DA VELHA JOGADOR x JOGADOR -------------------------------------------------------------------------------------------

	// Quando um Jogador Vencer
	public static void JxJ_Ganhou(String VENCEDOR , String PERDEDOR) {
			System.out.println("PARABENS " + VENCEDOR + ", VOCÊ VENCEU DE " + PERDEDOR);
			fim = true;
	}
	// Quando o Jogo Empatar
	public static void JxJEmpate(String JOGADOR1 , String JOGADOR2) {
		System.out.println("Houve um EMPATE entre " + JOGADOR1 + " e " + JOGADOR2);
		fim = true;
	}
	
	
	// -- JOGADOR 1
	// Esse metodo serve para fazer o Jogador1 Marcar o numero que deseja e verificar se esse numero ja foi selecionado
	public static String Jogador1_Marcar(String jogo_atual, String jogador1) {
		
		int posicao = 0;
		
		String numero = "nulo";
		
		
		repetiu = true;
		
		System.out.println(jogador1 + ", Digite o numero que corresponda ao lugar em que deseja marcar: \n" + jogo_atual);
		
		Scanner sc = new Scanner(System.in);
        
		
		
		while(repetiu) {
			
			System.out.print("-->");
			posicao = sc.nextInt();
			
			switch (posicao) {
			
			case 0:
				numero = "cancelar";
				repetiu = false;
			break;
			
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
				System.out.println(jogador1 + ", Digite um numero de 1 a 9:");
			break;
			}
		}
		
		
		Movimentos_Jogador += numero;
		
		if(Jogador1_Vitoria()) {
			System.out.println(jogo_atual.replace(numero, "X"));
		}
		
		return numero;

	}
	// Esse metodo verifica se o Jogador1 Venceu o Jogo	(Ele verifica os numeros que foram escolhidos pelo Jogador)
	public static boolean Jogador1_Vitoria() {
		
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
	
	
	// -- JOGADOR 2
	// Esse metodo serve para fazer o Jogador2 Marcar o numero que deseja e verificar se esse numero ja foi selecionado
	public static String Jogador2_Marcar(String jogo_atual, String jogador2) {
		
		int posicao = 0;
		String numero = "nulo";
		
		
		repetiu = true;
		
		System.out.println(jogador2 + ", Digite o numero que corresponda ao lugar em que deseja marcar: \n" + jogo_atual);
		Scanner sc = new Scanner(System.in);
        
		
		while(repetiu) {
			
		posicao = sc.nextInt();	
			
			switch (posicao) {
			
			case 0:
				numero = "cancelar";
				repetiu = false;
			break;
			
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
				System.out.println(jogador2 + ", Digite um numero de 1 a 9:");
			break;
			}
		}
		
		Movimentos_Computador += numero;
				
		if(Jogador2_Vitoria()) {
			System.out.println(jogo_atual.replace(numero, "O"));
		}
		
		
		return numero;

	}
	// Esse metodo verifica se o Jogador2 Venceu o Jogo (Ele verifica os numeros que foram escolhidos pelo Jogador)	
	public static boolean Jogador2_Vitoria() {
		
		boolean vitoria = false;
		
		if(Movimentos_Computador.contains("1") && Movimentos_Computador.contains("2") && Movimentos_Computador.contains("3")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("4") && Movimentos_Computador.contains("5") && Movimentos_Computador.contains("6")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("7") && Movimentos_Computador.contains("8") && Movimentos_Computador.contains("9")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("1") && Movimentos_Computador.contains("4") && Movimentos_Computador.contains("7")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("2") && Movimentos_Computador.contains("5") && Movimentos_Computador.contains("8")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("3") && Movimentos_Computador.contains("6") && Movimentos_Computador.contains("9")) {
			vitoria = true;
		}else if(Movimentos_Computador.contains("1") && Movimentos_Computador.contains("5") && Movimentos_Computador.contains("9")) {
			vitoria = true; 
		}else if(Movimentos_Computador.contains("3") && Movimentos_Computador.contains("5") && Movimentos_Computador.contains("7")) {
			vitoria = true;
		}else {
			vitoria = false;
		}

		
		
		return vitoria;
		
	}	



	// -- JOGO DA MEMORIA ------------------------------------------------------------------------------------------------------------
	
	// Esse metodo inicia o Jogo: Ele cria as Cartas e seus pares, ja criando a resposta
	public static void AparecerCartas(String jogo_Memoria,String nome){
		
		String jogo_Memoria_Revelado = jogo_Memoria;
		
		String letrasSelecionadas = ""; 
		String numerosSelecionados = "";
		
		String letras_NumerosSelecionados = "";
		
		try {			
			for(int i = 0; i<5; i++) {
				System.out.println("O Jogo começará em " + (5-i) + " segundos, preste atencao!");
				Thread.sleep(1000);				
			}			
		}catch (InterruptedException e) {}
		
		System.out.println("\n");

		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		
		String numeroUtilizados = "";	
		Random random = new Random();
		int numeroRandom=0;
		
		
		for(int i = 0; i < 4; ) {
			
			numeroRandom = random.nextInt(26);

			if(numeroUtilizados.contains(numeroRandom + "")) {}
			else {
				
				numeroUtilizados += numeroRandom;
				letrasSelecionadas += letras.substring((numeroRandom), (numeroRandom + 1));
				
				i++;
			}
			
			
			
		}
		
		
		numeroUtilizados = "";
		
		for(int i = 0; i < 8;) {
			
			numeroRandom = random.nextInt(9);

			if(numeroRandom != 0) {
				if(numeroUtilizados.contains(numeroRandom + "")) {}
				else {
					
					numeroUtilizados += numeroRandom;
					numerosSelecionados += numeroRandom;
					//System.out.println(numeroRandom);
					
					i++;
				}
			}
			
			
		}
		
		letrasSelecionadas += letrasSelecionadas;
		
		//System.out.println(letrasSelecionadas + "/" + numerosSelecionados);
		
		for (int i = 0; i < 8; i++) {
			
			letras_NumerosSelecionados += letrasSelecionadas.substring(i,(i+1)) + "-" + numerosSelecionados.substring(i,(i+1)) + "/";
			
		}
		
		//System.out.println(letras_NumerosSelecionados);
		//	
		
		
		String[] posicoesJuntas = letras_NumerosSelecionados.split("/");
		String resposta1 = "",resposta2 = "",resposta3 = "",resposta4 = "";
		
		
		
		for (int i = 0; i <= 7; i++) {
			//System.out.println(posicoesJuntas[i]);
			
			if(posicoesJuntas[i].contains("1")) {
				jogo_Memoria_Revelado = jogo_Memoria_Revelado.replace("1", posicoesJuntas[i].substring(0,1));				
			}
			if(posicoesJuntas[i].contains("2")) {
				jogo_Memoria_Revelado = jogo_Memoria_Revelado.replace("2", posicoesJuntas[i].substring(0,1));
			}
			if(posicoesJuntas[i].contains("3")) {
				jogo_Memoria_Revelado = jogo_Memoria_Revelado.replace("3", posicoesJuntas[i].substring(0,1));
			}
			if(posicoesJuntas[i].contains("4")) {
				jogo_Memoria_Revelado = jogo_Memoria_Revelado.replace("4", posicoesJuntas[i].substring(0,1));
			}
			if(posicoesJuntas[i].contains("5")) {
				jogo_Memoria_Revelado = jogo_Memoria_Revelado.replace("5", posicoesJuntas[i].substring(0,1));
			}
			if(posicoesJuntas[i].contains("6")) {
				jogo_Memoria_Revelado = jogo_Memoria_Revelado.replace("6", posicoesJuntas[i].substring(0,1));
			}
			if(posicoesJuntas[i].contains("7")) {
				jogo_Memoria_Revelado = jogo_Memoria_Revelado.replace("7", posicoesJuntas[i].substring(0,1));
			}
			if(posicoesJuntas[i].contains("8")) {
				jogo_Memoria_Revelado = jogo_Memoria_Revelado.replace("8", posicoesJuntas[i].substring(0,1));
			}
			
			
			
			if(posicoesJuntas[i].contains(letrasSelecionadas.substring(0,1))) {
				resposta1 += posicoesJuntas[i].substring(2,3);		
			}
			if(posicoesJuntas[i].contains(letrasSelecionadas.substring(1,2))) {
				resposta2 += posicoesJuntas[i].substring(2,3);		
			}
			if(posicoesJuntas[i].contains(letrasSelecionadas.substring(2,3))) {
				resposta3 += posicoesJuntas[i].substring(2,3);		
			}
			if(posicoesJuntas[i].contains(letrasSelecionadas.substring(3,4))) {
				resposta4 += posicoesJuntas[i].substring(2,3);		
			}

			
			
			Resposta_JogoDaMemoria = resposta1 + "/" + resposta2 + "/" + resposta3 + "/" + resposta4;
			
		}
		
		//System.out.println(Resposta_JogoDaMemoria);
		System.out.println(jogo_Memoria_Revelado);
		System.out.println("MEMORIZE " + nome + " !!!");
		
		try {
			Thread.sleep(2000);	
			LimparTela();
			System.out.println(jogo_Memoria);	
		} catch (InterruptedException e) {
			
		}
		
	}
	// Esse metodo ira ser chamado quando o Usuario acertar alguma vez
	public static void RevelarAcerto() {
		
	}
	// Esse metodo sera chamado toda vez que o Usuario fizer uma jogada
	public static void Marcar() {
		
		Scanner sc = new Scanner(System.in);
		String resposta = "";
		
		while(respostaJogador == "") {
			System.out.print("Digite o 1º numero: "); 
			respostaJogador = sc.nextLine();
			
			if(respostaJogador != "1" || respostaJogador != "2" || respostaJogador != "3" || respostaJogador != "4" || respostaJogador != "5" || respostaJogador != "6" || respostaJogador != "7" || respostaJogador != "8") {
				System.out.println("Prencha apenas com numeros entre 1 e 8");
				respostaJogador = "";
			}
		}
		
		while(respostaJogador == "") {
			System.out.print(" Digite o 2º numero: ");
			respostaJogador += sc.nextLine();
			
			if(respostaJogador != "1" || respostaJogador != "2" || respostaJogador != "3" || respostaJogador != "4" || respostaJogador != "5" || respostaJogador != "6" || respostaJogador != "7" || respostaJogador != "8") {
				System.out.println("Prencha apenas com numeros entre 1 e 8");
				respostaJogador = "";
			}
		}
		
		respostaJogador = resposta;
	}
	
	
	
	
	// -- Ajuda ------------------------------------------------------------------------------------------------------------	
	public static void LimparTela() {
		for (int i = 99999; i > 0; i--) {
			System.out.println("");
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
