public class Pakudex {

    //Create and initialize variables
    private int SIZE = -1;
    private Pakuri[] list;

    //Create the Pakudex constructor
    public Pakudex() {
        list = new Pakuri[20];
    }

    //Create the Pakudex method
    public Pakudex(int capacity) {
        list = new Pakuri[capacity];
    }

    //Create the get size method
    public int getSize() {
        return SIZE + 1;
    }

    //Create the get capacity method
    public int getCapacity () {
        return list.length;
    }

    //Create the get species array method
    public String[] getSpeciesArray() {
        int ct;
        for (ct = 0; ct < list.length; ct++) {
            if (list[ct] == null) {
                break;
            }
        }
        String[] newList = new String [ct];
        for(int i = 0; i < newList.length; i++) {
            newList[i] = list[i].getSpecies();
        }
        if (SIZE == -1) {
            return null;
        }
        return newList;
    }

    //Create the get stats method
    public int[] getStats(String species) {
        int[] stats = new int [3];
        boolean look = false;

        for (int j = 0; j < list.length; j++)
            if ((list[j] != null) && species.equals(list[j].getSpecies())){
                look = true;
            }

        if (look) {
            for (int k = 0; k < list.length; k++) {
                if ((list[k] != null) && (list[k].getSpecies().equals(species))) {
                    stats[0] = list[k].getAttack();
                    stats[1] = list[k].getDefense();
                    stats[2] = list[k].getSpeed();
                }
            }
            return stats;
        }
        else {
            return null;
        }

    }

    //Create the sortPakuri method
    public void sortPakuri() {
        for (int i = 0; i < list.length; i++) {
            int low = i;
            for (int j = (i + 1); j < list.length; j++) {
                if ((list[j] != null) && (list[j].getSpecies().compareTo(list[low].getSpecies()) < 0)) {
                    low = j;
                }
            }
            Pakuri temp = list[i];
            list[i] = list[low];
            list[low] = temp;
        }

    }

    //Create the add Pakuri method
    public boolean addPakuri(String species) {
        SIZE++;
        boolean canAdd = true;

        if (SIZE > list.length - 1) {
            canAdd = false;
            SIZE--;
            System.out.println("Error Pakudex is full!");
        }
        if (canAdd) {
            for(int i = 0; i < list.length; i++) {
                if ((list[i] != null) && species.equals(list[i].getSpecies())) {
                    canAdd = false;
                    SIZE--;
                    System.out.println("Error: Pakudex already contains this species!");
                }
            }
        }
        if (canAdd) {
            Pakuri pakuri = new Pakuri(species);
            list[SIZE] = pakuri;
            System.out.println("Pakuri species " + species + " successfully added!");
        }
        return canAdd;
    }

    //Create the evolve species method
    public boolean evolveSpecies(String species) {
        boolean canEvolve = false;
        for(int i = 0; i < list.length; i++) {
            if ((list[i] != null) && (species.equals(list[i].getSpecies()))) {
                list[i].evolve();
                canEvolve = true;
            }
        }
        return canEvolve;
    }
}
