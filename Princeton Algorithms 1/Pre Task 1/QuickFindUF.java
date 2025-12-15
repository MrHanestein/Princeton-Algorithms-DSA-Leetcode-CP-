public class QuickFindUF {
    //1. Create array.
    private final int[] elements;

    // quick find path checks objects of all ids to itself.
    public QuickFindUF(int numbers) {
        elements = new int[numbers];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i;
        }
    }
    //check if isconnected matches.
    public boolean connected(int index1, int index2) {
        return elements[index1] == elements[index2];
    }

    // Union join method, changes all elements of firstID to secondID
    public void union (int index1, int index2) {
        int firstID = elements[index1];
        int secondID = elements[index2];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == firstID){
                elements[i] = secondID;
            }
        }

    }
}

