package com.company;

import java.util.Arrays;
import java.util.Stack;

public class State {
    private static int[][] maze;
    private static int dim;
    private static Tuple<Integer, Integer> startingPoint;
    private static Tuple<Integer, Integer> endingPoint;
    private Tuple<Integer, Integer> currentPoint;
    private Stack<Tuple> history = new Stack<>();

    public State(int[][] maze, int dim, Tuple<Integer, Integer> startingPoint, Tuple<Integer, Integer> endingPoint, Tuple<Integer, Integer> currentPoint) {
        State.maze = maze;
        State.dim = dim;
        State.startingPoint = startingPoint;
        State.endingPoint = endingPoint;
        this.currentPoint = currentPoint;
        history.push(currentPoint);
    }


    public String toString() {
        int[][] mazeCopy = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            System.arraycopy(maze[i], 0, mazeCopy[i], 0, dim);
        }
        mazeCopy[startingPoint.getX()][startingPoint.getY()] = 2;
        mazeCopy[currentPoint.getX()][currentPoint.getY()] = 3;
        mazeCopy[endingPoint.getX()][endingPoint.getY()] = 4;

        StringBuilder sb = new StringBuilder();
        for (int[] row : mazeCopy) {
            sb.append(Arrays.toString(row)).append("\n");
        }

        return sb.toString() + '\n' + "starting position: [" + startingPoint.getX() + ", " + startingPoint.getY() + "]\n" + "current position: [" + currentPoint.getX() + ", " + currentPoint.getY() + "]\n" + "ending position: [" + endingPoint.getX() + ", " + endingPoint.getY() + "]\n\n" + "0 = road 1 = wall 2 = starting position 3 = current position 4 = ending position";
    }

    public Tuple<Integer, Integer> getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Tuple<Integer, Integer> startingPoint) {
        State.startingPoint = startingPoint;
    }

    public Tuple<Integer, Integer> getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(Tuple<Integer, Integer> endingPoint) {
        State.endingPoint = endingPoint;
    }

    public Tuple<Integer, Integer> getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Tuple<Integer, Integer> currentPoint) {
        this.currentPoint = currentPoint;
    }

    // 0 up, 1 down, 2 left, 3 right
    public State makeTransition(int dir) {
        switch (dir) {
            case 0:
                currentPoint.setX(currentPoint.getX() - 1);
                break;
            case 1:
                currentPoint.setX(currentPoint.getX() + 1);
                break;
            case 2:
                currentPoint.setY(currentPoint.getY() - 1);
                break;
            default:
                currentPoint.setY(currentPoint.getY() + 1);
        }
        history.push(currentPoint);
        return this;
    }

    // 0 up, 1 down, 2 left, 3 right
    public boolean isTransitionValid(int direction) {
        boolean isOk;
        switch (direction) {
            case 0:
                isOk = currentPoint.getX() - 1 >= 0 && maze[currentPoint.getX() - 1][currentPoint.getY()] == 0;
                break;
            case 1:
                isOk = currentPoint.getX() + 1 < dim && maze[currentPoint.getX() + 1][currentPoint.getY()] == 0;
                break;
            case 2:
                isOk = currentPoint.getY() - 1 >= 0 && maze[currentPoint.getX()][currentPoint.getY() - 1] == 0;
                break;
            default:
                isOk = currentPoint.getY() + 1 < dim && maze[currentPoint.getX()][currentPoint.getY() + 1] == 0;
        }
        return isOk;
    }

    public boolean isStateFinal() {
        return currentPoint.getX().equals(endingPoint.getX()) && currentPoint.getY().equals(endingPoint.getY());
    }
}
