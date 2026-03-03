package board;

import exceptions.OutOfBoardException;

/**
 * Représente le plateau de jeu.
 * <p>
 * Le plateau est constitué d'un nombre fixe de cases.
 * Il sert à suivre la progression du perso sur le terrain.
 * </p>
 */
public class Board {

    /** Nombre total de cases */
    private final int size = 64;

    /**
     * Retourne le nombre de cases du plateau.
     *
     * @return le nombre de cases (64)
     */
    public int getSize(){
        return size;
    }

    //vérifie si la position est valide (pas de dépassement)
    public void checkPosition(int position) throws OutOfBoardException {
        if (position > size) {
            throw new OutOfBoardException("Position " + position + " dépasse la taille du plateau (" + size + ")");
        }

    }
}
