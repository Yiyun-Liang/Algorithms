package com.isa.Interviews;

import java.util.Random;

/**
 * Created by isa on 2017-11-08.
 */
public class ReservoirSampling {

    // https://en.wikipedia.org/wiki/Reservoir_sampling
    // we want to randomly select k items from n elements
    // easy if we know n, just select k with equal probablity k/n
    // if we do not know n, eg. due to memory issues
    // we use Algorithm R
    private static int[] reservoirSample(int[] input, int k) {
        if (input.length < k) {
            return input;
        }

        int[] output = new int[k];
        // fill the reservoir array
        for (int i = 0; i < k; i++) {
            output[i] = input[i];
        }

        // replace elements with gradually decreasing probability
        for (int i = k; i < input.length; i++) {
            Random rand = new Random();
            int randIndex = rand.nextInt(k+1); // inclusive [0,k]
            if (randIndex < k) {    // replace item at randIndex with the new element, else keep old element
                output[randIndex] = input[i];
            }
        }

        return output;
    }
}
