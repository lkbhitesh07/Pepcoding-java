//constructor overloading
class constructor{
    public static class RectangularPair {
        int h, w, l;

        public RectangularPair(int h, int w, int l){
            this.h = h;
            this.w = w;
            this.l = l;
        }

        public RectangularPair(){

        }

        public RectangularPair(int h){
            this.h = this.w = this.l = h;
        }

        public int volume(){
            return h * w * l;
        }

        public int surfaceArea(){
            return 2 * (l*w + l*h + h*w);
        }
    }

    public static void testRectangle(){
        RectangularPair val1 = new RectangularPair(10, 5, 6);
        System.out.println(val1.volume());
        System.out.println(val1.surfaceArea());

        RectangularPair val2 = new RectangularPair();
        System.out.println(val2.volume());
        System.out.println(val2.surfaceArea());

        RectangularPair val3 = new RectangularPair(10);
        System.out.println(val3.volume());
        System.out.println(val3.surfaceArea());
    }
    public static void main(String[] args){
        testRectangle();
    }
}