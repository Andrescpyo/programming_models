package Bingo.Players;

import Bingo.Core.Card;
import Bingo.Patterns.Behavioral.Observer;

public class Player implements Observer {
    private String name;  //Nombre del jugador
    private Card card;    //Cartón del jugador

    /**
     * Constructor de la clase Player.
     * Inicializa el nombre y el cartón del jugador.
     * @param name Nombre del jugador.
     * @param card Cartón del jugador.
     */
    public Player(String name, Card card) {
        this.name = name;
        this.card = card;
    }

    /**
     * Método para obtener el nombre del jugador.
     * @return Nombre del jugador.     
     */
    public String getName() {
        return name;
    }

    /**
     * Método para obtener el cartón del jugador.
     * @return Cartón del jugador.
     */
    public Card getCard() {
        return card;
    }

    /**
     * Método para actualizar el estado del jugador.
     * @param ball Número llamado.
     */
    @Override
    public void update(int ball) { 
        if (card.markNumber(ball)) { //Si el número está en el cartón
            System.out.println(name + ": ¡El número " + ball + " está en mi cartón!");
            card.display(); // Mostrar el cartón actualizado
        }
    }

    /**
     * Método para verificar si el jugador ha ganado.
     * @return true si el jugador ha ganado, false en caso contrario.
     */
    public boolean checkBingo() {  
        return card.checkHorizontalBingo(); //Verificar si el cartón está en un bingo horizontal
    }
}