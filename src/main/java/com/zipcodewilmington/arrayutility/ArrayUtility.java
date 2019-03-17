package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<Whatever> {
    Whatever[] stuff;

    public ArrayUtility(Whatever[] stuff) {
        this.stuff = stuff;
    }


    public Integer getNumberOfOccurrences(Whatever valueToEvaluate) {

        int count = 0;

        for (Whatever currentValue : stuff) {
            if (currentValue == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    @SuppressWarnings("unchecked")

    public Whatever getMostCommonFromMerge(Whatever[] arrayToMerge) {
        List whateverList = new ArrayList(Arrays.asList(stuff));
        whateverList.addAll(Arrays.asList(arrayToMerge));
        Whatever[] mergedStuff = (Whatever[]) Arrays.copyOf(whateverList.toArray(), whateverList.size(), arrayToMerge.getClass());

        Map<Whatever, Integer> okay = new HashMap<>();
        for (Whatever blah : mergedStuff) {
            Integer shrugs = okay.get(blah);
            okay.put(blah, shrugs == null ? 1 : shrugs + 1);
        }

        Map.Entry<Whatever, Integer> idc = null;
        for (Map.Entry<Whatever, Integer> idk : okay.entrySet()) {
            if (idc == null || idk.getValue() > idc.getValue())
                idc = idk;
        }
        return idc.getKey();

    }

    @SuppressWarnings("Duplicates")
    public Whatever[] removeValue(Whatever valueToRemove) {

        List<Whatever> blahBlah = Arrays.stream(stuff)
                .filter(anything -> anything != valueToRemove).collect(Collectors.toList());
        Whatever[] whateverIguess = (Whatever[]) Array.newInstance(stuff.getClass().getComponentType(), blahBlah.size());
        return blahBlah.toArray(whateverIguess);
    }


    @SuppressWarnings("Duplicates")
    public Integer countDuplicatesInMerge(Whatever[] arrayToMerge, Whatever valueToEvaluate) {
        List okay = new ArrayList(Arrays.asList(stuff));
        okay.addAll(Arrays.asList(arrayToMerge));
        Whatever[] merged = (Whatever[]) Arrays.copyOf(okay.toArray(), okay.size(), arrayToMerge.getClass());

        Map<Whatever, Integer> aMap = new HashMap<>();
        for (Whatever sigh : merged) {
            Integer anInteger = aMap.get(sigh);
            aMap.put(sigh, anInteger == null ? 1 : anInteger + 1);
        }
        return aMap.get(valueToEvaluate);
    }

}





