package os.ransj.task;

/**
 * Created by ranshengju on 20/06/2017.
 */

public class Test {
    public static void main(String[] args){
        TaskDispather.newTask()
                .execute(new Job() {

                    @Override
                    public Object execute(Object[] params) {
                        System.out.println("T1 " + System.currentTimeMillis() +", on "+Thread.currentThread());
                        return null;
                    }
                }, 1000)
                .then(new Job() {
                    @Override
                    public Object execute(Object[] params) {
                        System.out.println("T2 " + System.currentTimeMillis() +", on "+Thread.currentThread());
                        return null;
                    }
                }, 1000)
                .then(new Job() {

                    @Override
                    public Object execute(Object[] params) {
                        System.out.println("T3 " + System.currentTimeMillis() +", on "+Thread.currentThread());
                        return null;
                    }
                }, 500)
                .end().dispatch();
    }
}
