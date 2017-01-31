package com.fancy.algorithm;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jackie on 2017/1/31.
 * interface Recommendation for sort Comparables
 */

@Component
public class Recommendation {

    /**
     *
     * @param comparables many no sorted comparables
     * @param sort a algoorithm for sort comparables
     * @return sorted comparables
     */

    public List<Comparable> recommendation(List<Comparable> comparables , Sort sort){

        if (null == comparables || sort == comparables)
            return sort.sort(comparables);


        return null;
    }

}
