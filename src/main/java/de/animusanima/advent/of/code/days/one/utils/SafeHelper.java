package de.animusanima.advent.of.code.days.one.utils;

/**
 * Author: David Sgro-Hinterseber <br>
 * Created by animusanima at 01.12.2025 18:26
 */
public abstract class SafeHelper {

    private static int solutionPartOne = 0;
    private static int solutionPartTwo = 0;

    private SafeHelper() {
        // Hide implicit construction
    }

    public static int findSolutionPartOne(int currentPosition, String rotationDirection, int rotationStep) {
        int nextPosition = currentPosition;
        for (int i = rotationStep; i > 0; i--) {
            if ("L".equals(rotationDirection)) {
                nextPosition -= 1;

                if (nextPosition < 0) {
                    nextPosition = 99;
                }
            } else if ("R".equals(rotationDirection)) {
                nextPosition += 1;
                if (nextPosition > 99) {
                    nextPosition = 0;
                }
            }
        }
        if (nextPosition == 0) {
            solutionPartOne += 1;
        }

        return nextPosition;
    }

    public static int findSolutionPartTwo(int currentPosition, String rotationDirection, int rotationStep) {
        int nextPosition = currentPosition;
        for (int i = rotationStep; i > 0; i--) {
            if (nextPosition == 0) {
                solutionPartTwo += 1;
            }
            if ("L".equals(rotationDirection)) {
                nextPosition -= 1;

                if (nextPosition < 0) {
                    nextPosition = 99;
                }
            } else if ("R".equals(rotationDirection)) {
                nextPosition += 1;
                if (nextPosition > 99) {
                    nextPosition = 0;
                }
            }
        }
        return nextPosition;
    }

    public static int getSolutionPartOne() {
        return solutionPartOne;
    }

    public static int getSolutionPartTwo() {
        return solutionPartTwo;
    }
}
