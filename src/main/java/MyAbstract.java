public abstract class MyAbstract {
    private String name;

    public MyAbstract(){}
    MyAbstract myAbstract = new MyAbstract() {
        @Override
        void doIt() {
            System.out.println(name);
        }
    };
    abstract void doIt();
    public void doThat(){
        doIt();
    }
    public static  void doThis(){}

}
