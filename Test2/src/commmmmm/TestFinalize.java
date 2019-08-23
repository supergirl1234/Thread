package commmmmm;


//finalize()方法是对象逃脱死亡的最后一次机会
//如果对象在finalize()中成功拯救自己(只需要重新与引用链上的任何一个对象建立起关联关系即可)，那在第二次标记
//时它将会被移除出"即将回收"的集合；如果对象这时候还是没有逃脱，那基本上它就是真的被回收了。
//finalize()方法只能自救一次
public class TestFinalize {
    private static TestFinalize testFinalize;
    public boolean isLive() {
        if (testFinalize != null) {
            return true;
        }
        return false;
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("逃离死亡");
        testFinalize = this;
    }
    public static void main(String[] args) {
        testFinalize = new TestFinalize();
        testFinalize = null;
        System.gc();//此次testFinalize对象回收失败，finalize自救
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(testFinalize!=null){
           testFinalize.isLive();
        }else {
            System.out.println("死亡");
        }


        testFinalize = null;
        System.gc();//finalize()方法只能自救一次，此时testFinalize对象就会被回收
        if(testFinalize!=null){
            testFinalize.isLive();

        }else {
            System.out.println("死亡");
        }

    }
}
