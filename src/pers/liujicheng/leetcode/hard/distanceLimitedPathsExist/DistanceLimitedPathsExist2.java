package pers.liujicheng.leetcode.hard.distanceLimitedPathsExist;

import java.util.*;
import java.util.stream.Collectors;

public class DistanceLimitedPathsExist2 {

//	public static void main(String[] args) {
//		List<String> strings = FileUtil.readLines("C:\\Users\\KEVIN-JC\\Desktop\\tttt.json", Charset.defaultCharset());
//
//		String line1 = strings.get(1);
//		String line2 = strings.get(2);
//
//		JSONArray objects1 = JSONObject.parseArray(line1);
//		int[][] arr1 = new int[objects1.size()][3];
//		for (int i = 0; i < objects1.size(); i++) {
//			JSONArray objects = (JSONArray) objects1.get(i);
//			arr1[i][0] = (Integer)objects.get(0);
//			arr1[i][1] = (Integer)objects.get(1);
//			arr1[i][2] = (Integer)objects.get(2);
//		}
//
//		JSONArray objects2 = JSONObject.parseArray(line2);
//		int[][] arr2 = new int[objects2.size()][3];
//		for (int i = 0; i < objects2.size(); i++) {
//			JSONArray objects = (JSONArray) objects2.get(i);
//			arr2[i][0] = (Integer)objects.get(0);
//			arr2[i][1] = (Integer)objects.get(1);
//			arr2[i][2] = (Integer)objects.get(2);
//		}
//
//		long start = System.currentTimeMillis();
//		boolean[] booleans = distanceLimitedPathsExist(Integer.valueOf(strings.get(0)), arr1, arr2);
//		System.out.println("spend time: " + (System.currentTimeMillis() - start));
//		System.out.println(JSONObject.toJSONString(booleans));
//
//	}

	public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
		boolean[] result = new boolean[queries.length];

		Map<String, Integer> queryIdxMap = new HashMap<>(queries.length + 1);
		for (int i = 0; i < queries.length; i++) {
			queryIdxMap.put(queries[i][0] + "-" + queries[i][1] + "-" + queries[i][2], i);
		}

		// 排序
		Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));
		Arrays.sort(queries, Comparator.comparingInt(o -> o[2]));

		// 游标
		int edgeIdx = 0;
		int areaIdx = 0;

		// 构建map
		Map<Integer, Integer> buildMap = new HashMap<>(edgeList.length + 1);
		int[] edgeP = edgeList[edgeIdx];
		for (int i = 0; i < queries.length; i++) {
			int limit = queries[i][2];
			int qStart = queries[i][0];
			int qEnd = queries[i][1];
			while (edgeP[2] < limit && edgeIdx < edgeList.length) {
				int[] ints = merge(areaIdx, buildMap, edgeP);
				areaIdx = ints[0];
				++edgeIdx;
				if (edgeIdx < edgeList.length) {
					edgeP = edgeList[edgeIdx];
				} else {
					break;
				}
			}
			result[queryIdxMap.get(qStart + "-" + qEnd + "-" + limit)] = find(qStart, qEnd, buildMap);
		}
		return result;
	}

	private static boolean find(int start, int end, Map<Integer, Integer> buildMap) {
		Integer startP = buildMap.get(start);
		Integer endP = buildMap.get(end);
		return null != startP && null != endP && startP.equals(endP);
	}

	private static int[] merge(int areaIdx, Map<Integer, Integer> buildMap, int[] edgeP) {
		Integer startArea = buildMap.get(edgeP[0]);
		Integer endArea = buildMap.get(edgeP[1]);
		// 两个点都是null
		if (null == startArea && null == endArea) {
			buildMap.put(edgeP[0], areaIdx);
			buildMap.put(edgeP[1], areaIdx);
			return new int[]{++areaIdx, areaIdx};
		}
		// 两个点都不是null
		if (null != startArea && null != endArea) {
			int lesser = startArea;
			int greater = endArea;
			if (endArea < startArea) {
				lesser = endArea;
				greater = startArea;
			}
			for (Map.Entry<Integer, Integer> entry : buildMap.entrySet()) {
				if (entry.getValue().equals(greater)) {
					entry.setValue(lesser);
				}
			}
			return new int[]{areaIdx, lesser};
		}
		// 两个点有一个null
		int[] ints = {areaIdx, 0};
		if (null != endArea) {
			buildMap.put(edgeP[0], endArea);
			ints[1] = endArea;
		}
		if (null != startArea) {
			buildMap.put(edgeP[1], startArea);
			ints[1] = startArea;
		}
		return ints;
	}

	public static  int[][] sortList(int[][] list) {
		int[] temp;
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j][2] > list[j + 1][2]) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
		return list;
	}
}
