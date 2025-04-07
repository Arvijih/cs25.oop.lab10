import java.util.List;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
}

public class Zoo<T extends Animal> {
    private List<T> animals;

    public void addAnimal(T animal) {
        animals.add(animal);
    }

    public void transferAnimals(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static void main(String[] args) {
        Zoo<Mammal> mammalZoo = new Zoo<>();
        mammalZoo.addAnimal(new Mammal("Арслан"));
        Zoo<Bird> birdZoo = new Zoo<>();
        birdZoo.addAnimal(new Bird("Тогоруу"));
        List<Animal> generalZoo = new ArrayList<>();
        mammalZoo.transferAnimals(mammalZoo.getAnimals(), generalZoo);
        birdZoo.transferAnimals(birdZoo.getAnimals(), generalZoo);
        generalZoo.forEach(a -> System.out.println(a.getName()));
    }
}
