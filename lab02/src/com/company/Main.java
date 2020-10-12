package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public Tuple<Integer, Integer> generateValidPoint(int[][] maze, int dim) {
        Random rand = new Random();

        int x = rand.nextInt(dim);
        int y = rand.nextInt(dim);

        while (maze[x][y] != 0) {
            x = rand.nextInt(dim);
            y = rand.nextInt(dim);
        }

        return new Tuple<>(x, y);
    }

    public State initialize(int dimension) {
        MazeGenerator mazeGenerator = new MazeGenerator(dimension);
        mazeGenerator.generateMaze();

        int[][] mazeMatrix = mazeGenerator.getMaze();

        Main main = new Main();

        Tuple<Integer, Integer> startingPoint = main.generateValidPoint(mazeMatrix, dimension);
        Tuple<Integer, Integer> endingPoint = main.generateValidPoint(mazeMatrix, dimension);

        return new State(mazeMatrix, dimension, startingPoint, endingPoint, startingPoint);
    }

    public State makeTransition(State state, int i) {
        if (state.isTransitionValid(i)) {
            return state.makeTransition(i);
        }
        System.out.println("Invalid transition. Wall hit.");
        return state;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        State state = main.initialize(10);
        System.out.println(state);
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Insert direction (only w, a, s, and d are valid. w = up, a = left, s = down , d = right):");
        String line = reader.readLine();
        while (!line.equals("exit") && !(line.length() == 0)) {
            int dir;
            switch (line.charAt(0)) {
                case 'w':
                    dir = 0;
                    break;
                case 's':
                    dir = 1;
                    break;
                case 'a':
                    dir = 2;
                    break;
                case 'd':
                    dir = 3;
                    break;
                default:
                    dir = 4;
            }
            if (dir != 4) {
                state = main.makeTransition(state, dir);
                System.out.println(state);
            } else {
                System.out.println("Invalid direction");
            }
            System.out.println("Insert direction (only 0, 1, 2, and 3 are valid):");
            line = reader.readLine();
        }
        System.out.println("Have a nice day :)");
    }
}