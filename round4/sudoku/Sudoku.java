import java.util.ArrayList;
import java.util.TreeMap;



public class Sudoku {
    private ArrayList<ArrayList<Character>> _sudoku;
    private ArrayList<Character> ValidChars;
    public Sudoku(){
        _sudoku = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            _sudoku.add(new ArrayList<>(){{
                for(int j = 0; j < 9; j++){
                    add(' ');
                }
            }});
        }
        ValidChars = new ArrayList<Character>(){{
            add(' ');
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
        }};
    }
    public void set(int i, int j, char c){
        if(i < 0 || j < 0 || i > 8 || j > 8){
            System.out.format("Trying to access illegal cell (%d, %d)!%n", i, j);
            return;
        }
        if(!ValidChars.contains(c)){
            System.out.format("Trying to set illegal character %c to (%d, %d)!%n", c, i, j);
            return;
        }
        _sudoku.get(i).set(j, c);
    }
    public void print(){
        System.out.println("#####################################");
        // blocks
        for(int y_block = 0; y_block  < 3; y_block ++){
            for(int y = 0; y < 3; y++){
                for(int x_block = 0; x_block < 3; x_block++){
                    char first = _sudoku.get(y_block*3+y).get(x_block*3+0);
                    char second = _sudoku.get(y_block*3+y).get(x_block*3+1);
                    char third = _sudoku.get(y_block*3+y).get(x_block*3+2);

                    System.out.format("# %c | %c | %c ", first, second, third);
                }
                System.out.format("#%n");
                if(y != 2){
                    System.out.format("#---+---+---#---+---+---#---+---+---#%n");
                } else {
                    System.out.format("#####################################%n");
                }
            }
        }
    }
    public boolean check(){
        // check rows
        for(int y = 0; y < 9; y++){
            TreeMap<Character, Integer> count = new TreeMap<>();
            for(int x = 0; x < 9; x++){
                char c = _sudoku.get(y).get(x);
                if(!count.containsKey(c)){
                    count.put(c, 0);
                }
                count.put(c, count.get(c)+1);
            }
            for (char c : count.keySet()) {
                if(c == ' '){
                    continue;
                }
                if(count.get(c) > 1){
                    System.out.format("Row %d has multiple %c's!%n", y, c );
                    return false;
                }
            }
        }

        // check colums
        for(int x = 0; x < 9; x++){
            TreeMap<Character, Integer> count = new TreeMap<>();
            for(int y = 0; y < 9; y++){
                char c = _sudoku.get(y).get(x);
                if(!count.containsKey(c)){
                    count.put(c, 0);
                }
                count.put(c, count.get(c)+1);
            }
            for (char c : count.keySet()) {
                if(c == ' '){
                    continue;
                }
                if(count.get(c) > 1){
                    System.out.format("Column %d has multiple %c's!%n", x, c );
                    return false;
                }
            }
        }

        // check blocks
        for(int y_block = 0; y_block  < 3; y_block ++){
                for(int x_block = 0; x_block < 3; x_block++){
                    TreeMap<Character, Integer> count = new TreeMap<>();
                    for(int y = 0; y < 3; y++){
                        for(int x = 0; x < 3; x++){
                            char c = _sudoku.get(y_block*3 + y).get(x_block * 3 + x);
                            if(!count.containsKey(c)){
                                count.put(c, 0);
                            }
                            count.put(c, count.get(c)+1);
                    }
                }
                for (char c : count.keySet()) {
                    if(c == ' '){
                        continue;
                    }
                    if(count.get(c) > 1){
                        System.out.format("Block at (%d, %d) has multiple %c's!%n", y_block*3, x_block*3, c);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
