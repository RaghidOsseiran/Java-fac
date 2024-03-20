package fr.ubx.poo.td6.model;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

public class GridRepoStringRLE extends GridRepoStringMain implements GridRepoIO {
    private boolean isNumber(char c){
        return (c >= '0' && c <= '9');
    }

    private boolean checkNums(char c1, char c2){
        return (isNumber(c1) && isNumber(c2));
    }

    private boolean checkAllSizes(String[] rows){
        if (rows == null) return true;
        for(int i = 0 ; i < rows.length-1; i++){
            if(rows[i].length() != rows[i+1].length()) return true;
        }
        return false;
    }


    private Grid decompress(String string) throws GridException{
        if (string == null) throw new GridException("Cannot operate on empty string");
        String[] rows = string.split("x");
        StringBuilder buffer = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (String row : rows) {
            for (int j = 0; j < row.length(); j++) {
                char cur_c = row.charAt(j);
                if (j + 1 < row.length() && checkNums(cur_c, row.charAt(j + 1))) {
                    throw new GridException("two consecutive numbers in string");
                }
                if (isNumber(cur_c)) {
                    char prev_c = buffer.charAt(j - 1);
                    for (char n = '0'; n < cur_c - 1; n++) {
                        buffer.append(prev_c);
                    }
                } else {
                    buffer.append(row.charAt(j));
                }
            }
            res.append(buffer).append("x");
            buffer.delete(0, buffer.length());
        }
        String[] resCheck = res.toString().split("x");
        if (checkAllSizes(resCheck)) {throw new GridException("Not an even Grid");}
        return super.load(res.toString());
    }



    @Override
    public Grid load(String string) throws GridException {
        return decompress(string);
    }

    @Override
    public String export(Grid grid){
        StringBuilder res = new StringBuilder();
        int height = grid.getHeight();
        int width = grid.getWidth();
        char currentChar = EOL;
        int counter = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                char c = grid.get(j,i).getCode();
                if (c == currentChar){
                    counter++;
                    if (counter == 9){ // If counter reaches 9, append and reset for current character.
                        res.append(currentChar);
                        res.append(counter); // Append counter if it's greater than 1
                        counter = 0; // Reset counter but keep current character as the same.
                    }
                } else {
                    if (counter > 0){ // If there was a previous sequence, append it.
                        res.append(currentChar);
                        if(counter > 1) res.append(counter); // Append counter if it's greater than 1
                    }
                    currentChar = c; // Start a new character sequence.
                    counter = 1;
                }
            }
            if (counter > 0){ // Append any remaining sequence before the line ends.
                res.append(currentChar);
                if(counter > 1) res.append(counter); // Append counter if it's greater than 1 (so we don't append 1's)
            }
            res.append("x");
            currentChar = EOL;
            counter = 0;
        }
        return res.toString();
    }


    // IO Interface

    @Override
    public Grid load(Reader in) throws IOException {
        StringBuilder res = new StringBuilder();
        int data = in.read();
        while(data != -1){
            char dataChar = (char) data;
            res.append(dataChar);
            data = in.read();
        }
        return load(res.toString());
    }

    @Override
    public void export(Grid grid, Writer out) throws IOException {
        StringBuilder buffer = new StringBuilder();
        for(int i = 0 ; i < grid.getHeight(); i++){
            for(int j = 0 ; j < grid.getWidth(); j++){
                buffer.append(grid.get(j, i).getCode());
            }
            out.write(buffer.toString());
            out.write("x");
            buffer.delete(0, buffer.length());
        }
    }
}
