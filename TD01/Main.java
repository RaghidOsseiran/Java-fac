class Main {
    public static void main(String[] args) {
        int size = args.length;
        for(int i = 0; i < size; i++){
            System.out.print(args[i]+ " ");
        }
        System.out.println("");
        System.out.print("Inverse = ");
        for(int i = size-1; i >= 0; i--){
            System.out.print(args[i]+ " ");
        }
        System.out.println("");
    }
}