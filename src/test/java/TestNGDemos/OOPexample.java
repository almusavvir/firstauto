package TestNGDemos;

public class OOPexample {
    public static void main(String[] args) {
        Animal tommy = new Dog();
        tommy.makeSound();
        tommy.typeOfAnimal();
        tommy.food();
        System.out.println("This animal has " + tommy.getLimb() + " limbs");
        System.out.println("This animal has " + tommy.getEye() + " eyes");

        Animal aragog = new Spider();
        aragog.makeSound();
        aragog.typeOfAnimal();
        aragog.food();
        aragog.setLimb(6);
        aragog.setEye(8);
        System.out.println("This animal has " + aragog.getLimb() + " limbs");
        System.out.println("This animal has " + aragog.getEye() + " eyes");

    }
}

class Animal {
    private int defaultLimbCount = 4;
    private int defaultEyeCount = 2;

    //getters
    public int getLimb() {
        return defaultLimbCount;
    }
    public int getEye() {
        return defaultEyeCount;
    }
    //setters
    public void setLimb(int LimbCount) {
        this.defaultLimbCount = LimbCount;
    }
    public void setEye(int EyeCount) {
        this.defaultEyeCount = EyeCount;
    }

    public void makeSound() {
        System.out.println("This animal makes some sort of sound");
    }
    public void typeOfAnimal(){
        System.out.println("Undelcared type");
    }
    public void food() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof Woof!!!");
    }
    @Override
    public void food() {
        System.out.println("This animal eats Pedigree");
    }
}

class Spider extends Animal {
    @Override
    public void makeSound() {
        System.out.println("This animal doesn't make a sound");
    }
    @Override
    public void food() {
        System.out.println("This animal eats other smaller insects");
    }
    @Override
    public void typeOfAnimal() {
        System.out.println("Both wild and household but undomesticated");
    }
}
