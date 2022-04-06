package modele;

/**
 * Interface pour l'ajout et le retrait d'EcouteurModele
 */
public interface ModeleEcoutable {

  /**
   * Ajouter e à une list ou un set
   * @param e : EcouteurModele
   */
  void ajoutEcouteur(EcouteurModele e);

  /**
   * Supprimer e depuis une liste ou un set
   * @param e : EcouteurModele
   */
  void retraitEcouteur(EcouteurModele e);

}
