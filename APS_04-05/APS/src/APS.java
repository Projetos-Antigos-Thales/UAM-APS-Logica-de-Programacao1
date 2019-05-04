import java.util.*;

public class APS {
	
	// Variaveis Auxiliares
	static boolean repetiu = false;
	static boolean um = false, um_jogador = false, um_comp = false;
	static boolean dois = false, dois_jogador = false, dois_comp = false;
	static boolean tres = false, tres_jogador = false, tres_comp = false;
	static boolean quatro = false, quatro_jogador = false, quatro_comp = false;
	static boolean cinco = false, cinco_jogador = false, cinco_comp = false;
	static boolean seis = false, seis_jogador = false, seis_comp = false;
	static boolean sete = false, sete_jogador = false, sete_comp = false;
	static boolean oito = false, oito_jogador = false, oito_comp = false;
	static boolean nove = false, nove_jogador = false, nove_comp = false;
	static boolean fim = false;
	
	static boolean aux = true;
	static boolean cancelar = false;
	
	static String Movimentos_Jogador = "";
	static String Movimentos_BOT = ""; 
	
	static String Resposta_JogoDaMemoria = "";
	static int Contagem_Acertos = 0;
	static String respostaJogador = "";

	
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
        	
        	System.out.println("\n\n" + _NOME + ", Digite: \n--- 0 - para Sair ---"
                    + "\n--- 1 - para Jogar Jogo da Velha (contra o Computador)"
                    + "\n--- 2 - para Jogar Jogo da Velha (contra outro Jogador)"
                    + "\n--- 3 - para Jogar Jogo da Memoria");
        	
        	System.out.print("-->");
            
            int _NUMERO = sc.nextInt();
            System.out.println("");
            
            String jogo = "1 | 2 | 3\n"
        			+ "----------\n"
        			+ "4 | 5 | 6\n"
        			+ "----------\n"
        			+ "7 | 8 | 9\n";
            
            switch(_NUMERO){
            
            
                
                case 0:
                    System.out.println("Obrigado e Volte sempre ;)");
                	continuar = false;
                break;
                
                
                
                case 1:
                	
                	String numero_selecionadoString = "";
                	String numero_selecionadoString_BOT = "";
                    
                    while(!fim) {
                    	
						numero_selecionadoString = Jogador_Marcar();
						
						switch (numero_selecionadoString) {
						
							case "cancelar": cancelar = true; break;
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
						
						if(cancelar) {
                			fim= true;
                			System.out.println("Jogo Cancelado");
                		}else {
                			
                			numero_selecionadoString_BOT = Computador_Marcar();
    						
    						System.out.println("\nVoce Marcou " + numero_selecionadoString);
    						System.out.println("O PC Marcou " + numero_selecionadoString_BOT + "\n");
    						
    						jogo = jogo.replace(numero_selecionadoString, "X");
    						Movimentos_Jogador += numero_selecionadoString;
    						jogo = jogo.replace(numero_selecionadoString_BOT, "O");
    						Movimentos_BOT += numero_selecionadoString_BOT;
    						System.out.println(jogo);		
                		}
								
						
						if(Jogador_Vitoria()) {
							Ganhou(_NOME); 
						}else if(Computador_Vitoria()) {
							Perdeu(_NOME); 
						}else if(um == true && dois  == true && tres  == true && quatro  == true && cinco == true && seis == true && sete == true && oito == true && nove){
							Empate();
						}
						
					}
                    
                    cancelar = false;
                    Movimentos_BOT = "";
					Movimentos_Jogador = "";
                    fim = false; um = false; dois = false; tres = false;  quatro = false;  cinco = false;  seis = false;  sete = false;  oito = false;  nove = false; aux = true; 
                    um_jogador = false; dois_jogador = false; tres_jogador = false;  quatro_jogador = false;  cinco_jogador = false;  seis_jogador = false;  sete_jogador = false;  oito_jogador = false;  nove_jogador = false;
                    
                    
                break;
                
                case 2:
                    
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
                	
                	cancelar = false;
                	Movimentos_BOT = "";
					Movimentos_Jogador = "";                	
                	fim = false; um = false; dois = false; tres = false;  quatro = false;  cinco = false;  seis = false;  sete = false;  oito = false;  nove = false;
                	um_jogador = false; dois_jogador = false; tres_jogador = false;  quatro_jogador = false;  cinco_jogador = false;  seis_jogador = false;  sete_jogador = false;  oito_jogador = false;  nove_jogador = false;
                	
                break;
                
                case 3:
                	
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
	
	
	// Este metodo só é utilizado quando o Jogador vence o Jogo
	public static void Ganhou(String NOME) {
		System.out.println("PARABENS " + NOME + ", VOCÊ GANHOU !!");
		fim = true;
	}
	// Este metodo só é utilizado quando o Jogador perde o Jogo
	public static void Perdeu(String NOME) {
		System.out.println("INFELIZMENTE VOCE PERDEU " + NOME + " :(");
		fim = true;
	}
	// Este metodo só é utilizado quando o Jogo termina empatado
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
	
	
	// COMPUTADOR
	// Esse metodo serve para saber se o Computador Ganhou o Jogo (Ele verifica os numeros que foram escolhidos pelo PC)
	public static boolean Computador_Vitoria() {
		
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
	// Esse metodo serve para fazer o Computador Escolher um numero para Marcar e verificar se esse numero ja foi selecionado
	public static String Computador_Marcar() {
		
		String numero = "nulo";
		String n1 = Computador_VerificarJogadasDoJogador();
		String n2 = Computador_VerificarJogadasDoComputador();
		
		if(!n2.equals("nulo")) {
			
			numero = n2;
			//System.out.println("NAO VAI GANHAR NAO " + numero);
			
		}else if(!n1.equals("nulo")){
			
			numero = n1;
			//System.out.println("NAO VAI GANHAR NAO " + numero);
			
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
		
		switch (numero) {
		case "1": um = true; um_comp = true; break;
		case "2": dois = true; dois_comp = true; break;
		case "3": tres = true; tres_comp = true; break;
		case "4": quatro = true; quatro_comp = true; break;
		case "5": cinco = true; cinco_comp = true; break;
		case "6": seis = true; seis_comp = true; break;
		case "7": sete = true; sete_comp = true; break;
		case "8": oito = true; oito_comp = true; break;
		case "9": nove = true; nove_comp = true; break;
		default: break;
		
		}
		
		return numero;
	}
	// Esse metodo serve para o Computador Verificar quais numeros o Jogador ja Marcou para poder impediri voce de vencer
	public static String Computador_VerificarJogadasDoJogador() {
			
			String numero = "nulo";
			
			
			if(dois_jogador == true && tres_jogador == true && um_jogador == false && um == false) {
				numero = "1";
			}else if(um_jogador == true && tres_jogador == true && dois_jogador == false && dois == false) {
				numero = "2";
			}else if(um_jogador == true && dois_jogador == true && tres_jogador == false && tres == false) {
				numero = "3";
			}
			
			
			
			else if(cinco_jogador == true && seis_jogador == true && quatro_jogador == false && quatro == false) {
				numero = "4";
			}else if(quatro_jogador == true && seis_jogador == true && cinco_jogador == false && cinco == false) {
				numero = "5";
			}else if(quatro_jogador == true && cinco_jogador == true && seis_jogador == false && seis == false) {
				numero = "6";
			}
			
			
			
			else if(oito_jogador == true && nove_jogador == true && sete_jogador == false && sete == false) {
				numero = "7";
			}else if(sete_jogador == true && nove_jogador == true && oito_jogador == false && oito == false) {
				numero = "8";
			}else if(sete_jogador == true && oito_jogador == true && nove_jogador == false && nove == false) {
				numero = "9";
			}
			
			
			
			else if(um_jogador == true && quatro_jogador == true && sete_jogador == false && sete == false) {
				numero = "7";
			}else if(um_jogador == true && sete_jogador == true && quatro_jogador == false && quatro == false) {
				numero = "4";
			}else if(sete_jogador == true && quatro_jogador == true && um_jogador == false && um == false) {
				numero = "1";
			}
			
			
			
			else if(dois_jogador == true && cinco_jogador == true && oito_jogador == false && oito == false) {
				numero = "8";
			}else if(dois_jogador == true && oito_jogador == true && cinco_jogador == false && cinco == false) {
				numero = "5";
			}else if(oito_jogador == true && cinco_jogador == true && dois_jogador == false && dois == false) {
				numero = "2";
			}
			
			
			
			else if(tres_jogador == true && seis_jogador == true && nove_jogador == false && nove == false) {
				numero = "9";
			}else if(tres_jogador == true && nove_jogador == true && seis_jogador == false && seis == false) {
				numero = "6";
			}else if(nove_jogador == true && seis_jogador == true && tres_jogador == false && tres == false) {
				numero = "3";
			}
			
			
			
			else if(um_jogador == true && cinco_jogador == true && nove_jogador == false && nove == false) {
				numero = "9";
			}else if(um_jogador == true && nove_jogador == true && cinco_jogador == false && cinco == false) {
				numero = "5";
			}else if(nove_jogador == true && cinco_jogador == true && um_jogador == false && um == false) {
				numero = "1";
			}
			
			
			
			else if(tres_jogador == true && cinco_jogador == true && sete_jogador == false && sete == false) {
				numero = "7";
			}else if(tres_jogador == true && sete_jogador == true && cinco_jogador == false && cinco == false) {
				numero = "5";
			}else if(sete_jogador == true && cinco_jogador == true && tres_jogador == false && tres == false) {
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
	// Esse metodo serve para o Computador Verificar quais numeros o Jogador ja Marcou para poder impediri voce de vencer
	public static String Computador_VerificarJogadasDoComputador() {
				
				String numero = "nulo";
				
				
				if(dois_comp == true && tres_comp == true && um_comp == false && um == false) {
					numero = "1";
				}else if(um_comp == true && tres_comp == true && dois_comp == false && dois == false) {
					numero = "2";
				}else if(um_comp == true && dois_comp == true && tres_comp == false && tres == false) {
					numero = "3";
				}
				
				
				
				else if(cinco_comp == true && seis_comp == true && quatro_comp == false && quatro == false) {
					numero = "4";
				}else if(quatro_comp == true && seis_comp == true && cinco_comp == false && cinco == false) {
					numero = "5";
				}else if(quatro_comp == true && cinco_comp == true && seis_comp == false && seis == false) {
					numero = "6";
				}
				
				
				
				else if(oito_comp == true && nove_comp == true && sete_comp == false && sete == false) {
					numero = "7";
				}else if(sete_comp == true && nove_comp == true && oito_comp == false && oito == false) {
					numero = "8";
				}else if(sete_comp == true && oito_comp == true && nove_comp == false && nove == false) {
					numero = "9";
				}
				
				
				
				else if(um_comp == true && quatro_comp == true && sete_comp == false && sete == false) {
					numero = "7";
				}else if(um_comp == true && sete_comp == true && quatro_comp == false && quatro == false) {
					numero = "4";
				}else if(sete_comp == true && quatro_comp == true && um_comp == false && um == false) {
					numero = "1";
				}
				
				
				
				else if(dois_comp == true && cinco_comp == true && oito_comp == false && oito == false) {
					numero = "8";
				}else if(dois_comp == true && oito_comp == true && cinco_comp == false && cinco == false) {
					numero = "5";
				}else if(oito_comp == true && cinco_comp == true && dois_comp == false && dois == false) {
					numero = "2";
				}
				
				
				
				else if(tres_comp == true && seis_comp == true && nove_comp == false && nove == false) {
					numero = "9";
				}else if(tres_comp == true && nove_comp == true && seis_comp == false && seis == false) {
					numero = "6";
				}else if(nove_comp == true && seis_comp == true && tres_comp == false && tres == false) {
					numero = "3";
				}
				
				
				
				else if(um_comp == true && cinco_comp == true && nove_comp == false && nove == false) {
					numero = "9";
				}else if(um_comp == true && nove_comp == true && cinco_comp == false && cinco == false) {
					numero = "5";
				}else if(nove_comp == true && cinco_comp == true && um_comp == false && um == false) {
					numero = "1";
				}
				
				
				
				else if(tres_comp == true && cinco_comp == true && sete_comp == false && sete == false) {
					numero = "7";
				}else if(tres_comp == true && sete_comp == true && cinco_comp == false && cinco == false) {
					numero = "5";
				}else if(sete_comp == true && cinco_comp == true && tres_comp == false && tres == false) {
					numero = "3";
				}


				
				switch (numero) {
				case "1": um = true; um_comp = true; break;
				case "2": dois = true; dois_comp = true; break;
				case "3": tres = true; tres_comp = true; break;
				case "4": quatro = true; quatro_comp = true; break;
				case "5": cinco = true; cinco_comp = true; break;
				case "6": seis = true; seis_comp = true; break;
				case "7": sete = true; sete_comp = true; break;
				case "8": oito = true; oito_comp = true; break;
				case "9": nove = true; nove_comp = true; break;
				default: break;
				
				}
				
				return numero;
				
			}
			
	
	// JOGADOR X JOGADOR
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
	// Esse metodo verifica se o Jogador1 Venceu o Jogo	
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
		
		Movimentos_BOT += numero;
				
		if(Jogador2_Vitoria()) {
			System.out.println(jogo_atual.replace(numero, "O"));
		}
		
		
		return numero;

	}
	// Esse metodo verifica se o Jogador2 Venceu o Jogo
	public static boolean Jogador2_Vitoria() {
		
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


	
	// -- JOGO DA VELHA ------------------------------------------------------------------------------------------------------------

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
	
	
	// -- JOGO DA MEMORIA ------------------------------------------------------------------------------------------------------------
	
	
	// -- Ajuda ------------------------------------------------------------------------------------------------------------	
	public static void LimparTela() {
		for (int i = 99999; i > 0; i--) {
			System.out.println("");
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
