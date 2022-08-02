package info.zhairong.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author zhairong
 *
 */
public class MergeIntervals {
	
	public static void main(String[] args) {
		int[][] intervals = new int[][] {{1,4}, {0,2}, {3,5}};
		MergeIntervals test = new MergeIntervals();
		int[][] merged = test.mergeOneByOne(intervals);
		System.out.println("Output result: " + Arrays.deepToString(merged));
		
		
		
	}
	
//	public int[][] merge(int[][] intervals) {
//		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//		Set<int[]> merged = new HashSet<>();
//	}
	public int[][] mergeOneByOne(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Set<Integer> merged = new HashSet<>(); 
        List<int[]> result = new ArrayList<>();
        
        for(int i=0; i<intervals.length; i++) {
        	if(merged.contains(i)) {
        		continue;
        	}
        	int[] current = intervals[i];
        	for(int j=i+1; j<intervals.length; j++) {
        		if(merged.contains(j)) {
        			continue;
        		}
        		if(mergable(current, intervals[j])) {
        			current = merge(current, intervals[j]);
        			merged.add(j);
        		}
        	}
        	result.add(current);
        }
        return result.toArray(new int[][] {});
        
    }

	private boolean mergable(int[] a, int[] b) {
		
		return a[0]<=b[0] && b[0]<=a[1];
	}
	
	private int[] merge(int[] a, int[] b) {
		return new int[] {a[0], b[1]};
	}
}
