package Homeworks._8_classInfo;

class Fridge{
    private String name;
    private int capacity;
    private int current_сapacity = 0;
    private Grocerie[] products;

    public Fridge(String name, int capacity) {
        //класс, предназначенный для хранения объектов типа Grocerie
        this.name = name;
        this.capacity = capacity;
        this.products = new Grocerie[capacity];
    }


    public void add_grocerie(Grocerie product) {
        if (this.current_сapacity < this.capacity) {
            this.products[this.current_сapacity] = product;
            this.current_сapacity++;
        } else {
            System.out.println("Your fridge is full");
        }
    }


    public Grocerie get_grocerie(int grocerie_id) {
        return this.products[grocerie_id];
    }


    public void print() {
        System.out.println(this.name + ", " + (this.capacity - this.current_сapacity) + " places left");
        for (int i=0; i < this.current_сapacity; i++) {
            System.out.println(this.products[i].getName() + ", " + this.products[i].getCalories()
             + "(" + this.products[i].getProteins() + "p, " + this.products[i].getFats()
              + "f, " + this.products[i].getCarbohydrates() + "c)");
        }
    }


    public void remove_grocerie(Grocerie product) {
        boolean flag = false;
        for (int i=this.current_сapacity - 1; i >= 0; i++) {
            if (this.products[i].equals(product)) {
                flag = true;
            }
            if (flag) {
                this.products[i] = this.products[i+1];
            }
        }
        if (this.products[this.current_сapacity-1].equals(product)) {
            this.products[this.current_сapacity-1] = null;
        }
        if (flag == false) {
            System.out.println("The product '" + product.getName() + "' is not in the fridge '" + this.name + "'");
        }
    }
}