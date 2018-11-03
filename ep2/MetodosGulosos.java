package ep2;

/*********************************************************************/
/** ACH 2002 - Introducao a Ciencia da Computacao II                **/
/** EACH-USP - Segundo Semestre de 2010                             **/
/**                                                                 **/
/** <turma> - <nome do professor>                                   **/
/**                                                                 **/
/** Terceiro Exercicio-Programa                                     **/
/**                                                                 **/
/** <nome do(a) aluno(a)> <numero USP>                              **/
/**                                                                 **/
/*********************************************************************/


/**
	COMENTARIOS GERAIS

	Seguindo os criterios de selecao, um objeto só poderá ser colocado na
	mochila caso ela suporte o total de peso.

	O total de peso ao se colocar um objeto (do tipo Objeto) é dado por
	mochila.getPesoUsado() + objeto.getPeso()

	Colocar um objeto na mochila significa alterar os seguintes campos da mochila:

	pesoUsado,

	valorDentroDaMochila, e

	numObjetosNaMochila.
*/
public abstract class MetodosGulosos {

	static final int menorPeso = 0;
	static final int maiorValor = 1;
	static final int melhorRelacao = 2;

//----------------------------- Método para visualizar a lista de objetos -----------------------

public static void verLista (Objeto[] lista){

for(int i = 0; i<lista.length; i++)
System.out.println("Peso: " + lista[i].getPeso() + " Valor: " + lista[i].getValor() + " Ratio: " + lista[i].getValor()/lista[i].getPeso());

}

//----------------------------- Organiza os objetos pelo menor peso -----------------------------

	public static void sortMenorPeso (Objeto[] objs){
				int fim = objs.length;
				while(fim>0){
			for(int i = 0; i<fim-1; i++){
					if(objs[i].getPeso()>=objs[i+1].getPeso()){
						Objeto aux = objs[i];
							objs[i] = objs[i+1];
							objs[i+1] = aux;

					}
					if(objs[i].getPeso()==objs[i+1].getPeso()){
						if(objs[i].getValor()<objs[i+1].getValor()){
							Objeto aux = objs[i];
								objs[i] = objs[i+1];
								objs[i+1] = aux;
						}
					}
				}
			 fim--;
			}

}

//----------------------------- Organiza os objetos pelo maior valor -----------------------------

public static void sortMaiorValor (Objeto[] objs){
			int fim = objs.length;
			while(fim>0){
		for(int i = 0; i<fim-1; i++){
				if(objs[i].getValor()<=objs[i+1].getValor()){
					Objeto aux = objs[i];
						objs[i] = objs[i+1];
						objs[i+1] = aux;

				}
				if(objs[i].getValor()==objs[i+1].getValor()){
					if(objs[i].getPeso()>objs[i+1].getPeso()){
						Objeto aux = objs[i];
							objs[i] = objs[i+1];
							objs[i+1] = aux;
					}
				}
			}
		 fim--;
		}

}

//----------------------------- Organiza os objetos pela melhor relação valor / peso -----------------------------

public static void sortMelhorRelacao (Objeto[] objs){
			int fim = objs.length;
			while(fim>0){
		for(int i = 0; i<fim-1; i++){
				if(objs[i].getValor()/objs[i].getPeso()<=objs[i+1].getValor()/objs[i+1].getPeso()){
					Objeto aux = objs[i];
						objs[i] = objs[i+1];
						objs[i+1] = aux;

				}
				if(objs[i].getValor()/objs[i].getPeso()==objs[i+1].getValor()/objs[i+1].getPeso()){
					if(objs[i].getPeso()<objs[i+1].getPeso()){
						Objeto aux = objs[i];
							objs[i] = objs[i+1];
							objs[i+1] = aux;
					}
				}
			}
		 fim--;
		}


}

//----------------------------- Método que enche a mochila de acordo com o tipo de algoritmo guloso ------------------------

	public static void lotarMochila(Mochila mochila, int METODO, Objeto[] listaDeObjetosDisponiveis){

		int numObjs = 0;
		double valorObjs = 0;
		double pesoObjs = 0;

		switch(METODO){
			case menorPeso:
 			sortMenorPeso(listaDeObjetosDisponiveis);
			break;
			case maiorValor:
 			sortMaiorValor(listaDeObjetosDisponiveis);
			break;
			case melhorRelacao:
 			sortMelhorRelacao(listaDeObjetosDisponiveis);
			break;
		}

		for(int i = 0; i<listaDeObjetosDisponiveis.length; i++){

			if(mochila.getPesoMaximo()>=pesoObjs + listaDeObjetosDisponiveis[i].getPeso()){

				 valorObjs+=listaDeObjetosDisponiveis[i].getValor();
				 pesoObjs+=listaDeObjetosDisponiveis[i].getPeso();
				 numObjs++;}
		}
		mochila.setPesoUsado(pesoObjs);
			mochila.setValorDentroDaMochila(valorObjs);
				mochila.setNumObjetosNaMochila(numObjs);


	}



	/**
		Este método deve implementar um algoritmo guloso que selecione objetos
		da listaDeObjetosDisponiveis a serem colocados na mochila, de acordo
		com o critério 'objetos de menor peso primeiro'. Caso dois objetos
		tenham o mesmo peso, o critério de desempate será 'objetos de maior
		valor primeiro' (apenas para os empates em peso).

		@param pesoMaximoDaMochila Peso máximo suportado pela mochila
		@param listaDeObjetosDisponiveis Arranjo de objetos considerados no problema

		@return Mochila carregada conforme essa estratégia
	 */
	public static Mochila utilizaMenorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);
		lotarMochila(mochila, menorPeso, listaDeObjetosDisponiveis);
		//verLista(listaDeObjetosDisponiveis);
		return mochila;

	}


	/**
		Este método deve implementar um algoritmo guloso que selecione objetos
		da listaDeObjetosDisponiveis a serem colocados na mochila, de acordo
		com o critério 'objetos de maior valor primeiro'. Caso dois objetos
		tenham o mesmo valor, o critério de desempate sera 'objetos de menor peso
		primeiro' (apenas para os empates em valor).

		@param pesoMaximoDaMochila Peso máximo suportado pela mochila
		@param listaDeObjetosDisponiveis Arranjo de objetos considerados no problema

		@return Mochila carregada conforme essa estratégia
	 */
	public static Mochila utilizaMaiorValor(double pesoMaximoDaMochila,	Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);
		lotarMochila(mochila, maiorValor, listaDeObjetosDisponiveis);
	//	verLista(listaDeObjetosDisponiveis);
		return mochila;

	}


	/**
		Este método deve implementar um algoritmo guloso que selecione objetos
		da listaDeObjetosDisponiveis a serem colocados na mochila, de acordo
		com o critério 'objetos de maior valor/peso primeiro (valor dividido por
		peso primeiro)'. Caso dois objetos tenham o mesmo valor/peso, o critério
		de desempate sera 'objetos de maior peso primeiro' (apenas para os empates).

		@param pesoMaximoDaMochila Peso máximo suportado pela mochila
		@param listaDeObjetosDisponiveis Arranjo de objetos considerados no problema

		@return Mochila carregada conforme essa estratégia
	 */
	public static Mochila utilizaMaiorValorDivididoPorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);
		lotarMochila(mochila, melhorRelacao, listaDeObjetosDisponiveis);
		//verLista(listaDeObjetosDisponiveis);
return mochila;
	}


}
