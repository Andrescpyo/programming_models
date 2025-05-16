package Bingo.Main;

import Bingo.Core.Card;
import Bingo.Core.Game;
import Bingo.Players.Player;
import Bingo.Patterns.Creational.CardFactory;

public class main {
    /**
     * Método principal de la aplicación.
     * @param args Argumentos de la aplicación.
     */
    public static void main(String[] args) {
        // Crear una instancia de la fábrica de cartones
        CardFactory cardFactory = new CardFactory();

        // Crear un cartón para el jugador usando la fábrica
        Card playerCard = cardFactory.createDefaultCard();

        // Crear un jugador con su cartón
        Player player1 = new Player("Jugador 1", playerCard);

        // Crear el juego
        Game bingoGame = new Game();

        // Añadir el jugador al juego
        bingoGame.addPlayer(player1);

        // Iniciar el juego
        bingoGame.startGame();
    }
}