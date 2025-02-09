package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
       /* try{
            int x = 5/0;
            System.out.println("Result:"+x);
        }catch(ArithmeticException e){
            System.out.println("ArithmeticException");
        }finally {
            System.out.println("finally");
        }

        try{
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<10;i++)
            {
                list.remove(11);
        }
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println("IndexOutOfBoundsException");
        }finally{
            System.out.println("second finally");
        }*/

        String result = "";
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/exceptions/source.txt"))){
            StringBuilder res = new StringBuilder();
            String line;
            while((line = br.readLine()) != null ) {
                res.append(line);
            }
            result = res.toString();
            System.out.println(result);
        }catch (FileNotFoundException e)
        {
            System.err.println("Файл source не найден"+e.getMessage());
        }
        catch (IOException e)
        {
            System.err.println("Ошибка ввода/вывода(source)"+e.getMessage());
        }

        try (BufferedWriter bw =new BufferedWriter(new FileWriter("src/main/resources/exceptions/destination.txt"))){
            bw.write(result);
        }catch (FileNotFoundException e)
        {
            System.err.println("Файл destination не найден"+e.getMessage());
        }
        catch (IOException e)
        {
            System.err.println("Ошибка ввода/вывода(destination)"+e.getMessage());
        }

    }
}