package Bingo.Core;

import Bingo.Players.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el juego de Bingo.
 * Contiene un objeto BallCaller para llamar números aleatorios y un listado de jugadores.
 */
public class Game {
    private BallCaller ballCaller;  //Objeto que llama números aleatorios
    private List<Player> players;   //Listado de jugadores

    /**
     * Constructor de la clase Game.
     * Inicializa el objeto BallCaller y el listado de jugadores.
     */
    public Game() {
        this.ballCaller = BallCaller.getInstance(1, 75);
        this.players = new ArrayList<>();
    }

    /**
     * Método para añadir un jugador al listado de jugadores.
     * @param player Jugador a añadir al listado de jugadores.
     */
    public void addPlayer(Player player) {
        this.players.add(player);  //Añadir el jugador al listado de jugadores
        ballCaller.attach(player); // Registrar al jugador como observador
    }

    /**
     * Método para jugar una ronda del juego.
     */
    public void playRound() {
        ballCaller.callBall(); // La notificación a los jugadores ocurre dentro de BallCaller
        for (Player player : players) { //Recorrer todos los jugadores
            if (player.checkBingo()) { //Si el jugador ha ganado
                System.out.println("¡BINGO! El jugador " + player.getName() + " ha ganado.");
                return; // Terminar el juego
            }
        }
    }

    /**
     * Método para iniciar el juego.
     */
    public void startGame() {
        System.out.println("¡Comienza el juego de Bingo!");
        while (true) {
            playRound();
            if (players.stream().anyMatch(Player::checkBingo)) { //Si algún jugador ha ganado
                break;
            }
            if (ballCaller.getCalledBalls().size() == 75) {
                System.out.println("¡Fin del juego! Nadie hizo Bingo."); //Si se han llamado 75 números, se termina el juego
                break;
            }
            try {
                Thread.sleep(1000); //Pausa de 1 segundo
            } catch (InterruptedException e) { 
                Thread.currentThread().interrupt(); //Se interrumpe la pausa
            }
        }
        System.out.println("¡Juego terminado!");
    }
}