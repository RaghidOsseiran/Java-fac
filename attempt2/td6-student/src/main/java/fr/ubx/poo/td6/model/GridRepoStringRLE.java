package fr.ubx.poo.td6.model;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class GridRepoStringRLE extends GridRepoStringMain {
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
        String[] rows = string.split("x");
        if (rows == null) throw new GridException("could split String");
        StringBuilder buffer = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < rows.length; i++){
            for(int j = 0; j < rows[i].length(); j++){
                char cur_c = rows[i].charAt(j);
                if (j+1 < rows[i].length() && checkNums(cur_c, rows[i].charAt(j+1))){
                    throw new GridException("two consecutive numbers in string");
                }
                if (isNumber(cur_c)){
                    char prev_c = buffer.charAt(j-1);
                    for(char n = '0'; n < cur_c-1; n++){
                        buffer.append(prev_c);
                    }
                } else {
                    buffer.append(rows[i].charAt(j));
                }
            }
            res.append(buffer+"x");
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
        char counter = '1';
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                char c = grid.get(j,i).getCode();
                if (c == currentChar){
                    if (counter == '8'){
                        res.append(c+""+(counter)+1);
                        counter = '1';
                    } else {
                        counter += 1;
                    }
                } else {
                    if (counter != '1'){
                        res.append(currentChar+""+counter);
                        counter = '1';
                    } else if (currentChar != EOL) {
                        res.append(c);
                    }
                }
                currentChar = c;
            }
            if (counter != '1' && counter != '0'){
                res.append(currentChar+""+counter);
                counter = '0';
            } else if (currentChar != EOL) {
                res.append(currentChar);
            }
            res.append("x");
        }
        return res.toString();
    }



}
