/**
 * Created by lucaskc on 2017/5/11.
 */
import java.util.WeakHashMap;
class KeyHolder {
    int i;

    public KeyHolder(int i) {
        this.i = i;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("I am over from key");
        super.finalize();
    }
}
class ValueHolder {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("I am over from value");
        super.finalize();
    }
}
public class RefTest {
    public static void main(String[] args) {
        WeakHashMap<KeyHolder, ValueHolder> weakMap = new WeakHashMap<KeyHolder, ValueHolder>();
        KeyHolder [] kh = new KeyHolder[10];

        for (int i=0; i<10;i++){
            kh[i] = new KeyHolder(i);
            ValueHolder vh = new ValueHolder();
            weakMap.put(kh[i], vh);
        }

        while (true) {
            for (KeyHolder key : weakMap.keySet()) {
                System.out.println(key + " : " + weakMap.get(key));
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("here...");
            //这里把kh设为null，这样一来就只有弱引用指向kh指向的对象
            kh = null;
            System.gc();
        }
    }
}
