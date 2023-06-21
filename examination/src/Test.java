public class Test{

    static class CPU{
        public int speed;

        public CPU(int speed) {
            this.speed = speed;
        }

        public void setSpeed(int m){
            this.speed = m;
        }
        public int getSpeed(){
            return speed;
        }
    }
    static class HardDisk{
        public int amount;

        public HardDisk(int amount) {
            this.amount = amount;
        }

        public void setAmount(int m){
            this.amount = m;
        }
        public int getAmount(){
            return amount;
        }

    }

    static class PC{
        public void setCPU(CPU c){

        }
    }
    public static void main(String[] args) {
        CPU cpu = new CPU(2200);
        HardDisk disk = new HardDisk(200);
        PC pc = new PC();
        pc.setCPU(cpu);
    }
}