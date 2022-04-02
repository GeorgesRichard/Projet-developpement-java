package modele;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractModeleEcoutable implements ModeleEcoutable {

  protected List<EcouteurModele> ecouteurs;

  public AbstractModeleEcoutable(){
    this.ecouteurs = new ArrayList<>();
  }

  @Override
  public void ajoutEcouteur(EcouteurModele e){
    this.ecouteurs.add(e);
  }

  @Override
  public void retraitEcouteur(EcouteurModele e){
    this.ecouteurs.remove(e);
  }

  public void fireChangement(){
    for(EcouteurModele e : this.ecouteurs)
      e.modeleMisAJour();
  }

}
