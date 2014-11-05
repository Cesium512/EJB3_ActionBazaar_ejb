package negocio;

import javax.ejb.Local;


@Local(UserAccountCreatorLocal.class)
public interface UserAccountCreatorLocal extends UserAccountCreatorOper {

}
