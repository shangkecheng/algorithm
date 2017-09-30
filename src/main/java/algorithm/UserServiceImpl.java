package algorithm;

import algorithm.UserService;

/**
 * Created by lucaskc on 2017/5/10.
 */
public class UserServiceImpl implements UserService {

    /* (non-Javadoc)
     * @see dynamic.proxy.UserService#add()
     */
    public void add() {
        System.out.println("--------------------add---------------");
    }

    @Override
    public void remove() {
        System.out.println("--------------------remove---------------");
    }
}
