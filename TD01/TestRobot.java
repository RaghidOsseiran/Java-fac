public class TestRobot {
    public static void main(String[] args) {
        Robot r1 = new Robot(new Position(2, 2), "broski", 600, 10);
        Robot r2 = new Robot(new Position(30, 30), "cous", 200, 15);


        System.out.println(" > Main: the range of action of the robot "+r1.name+" is: "+ r1.rayonAction()+"\n");
        if (r1.peutSeDeplacer(r2.p)) System.out.println(" > Main: Our robot can in fact reach its destination\n");
    

        Robot r3 = new Robot(new Position(10, 10), "test3", 200, 15);
        Robot r4 = new Robot(new Position(20, 14), "test4", 20, 15);

        System.out.println(" > Main: the rang of action of r3 is: "+r3.rayonAction()+" \n");
        System.out.println(" > Main: the distance between r3 and r4 is:  "+r3.distance(r4.p)+"\n");
        if (r3.peutSeDeplacer(r4.p)) System.out.println(" > Main: r3 can reach r4\n");
        else System.out.println(" > Main: r3 cannot reach r4\n");
    }
}
